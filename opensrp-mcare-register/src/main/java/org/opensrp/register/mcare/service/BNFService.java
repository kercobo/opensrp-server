/**
 * @author julkar nain 
 */
package org.opensrp.register.mcare.service;

import static java.text.MessageFormat.format;
import static org.opensrp.common.AllConstants.ANCVisitOneFields.FWCONFIRMATION;
import static org.opensrp.common.AllConstants.ANCVisitOneFields.FWEDD;
import static org.opensrp.common.AllConstants.ANCVisitOneFields.FWGESTATIONALAGE;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFCHLDVITSTS;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFDATE;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFDTOO;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFGEN;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFLB;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFSMSRSN;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFSTS;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFWOMVITSTS;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWDISPLAYTEXT1;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.STS_WD;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.STS_LB;
import static org.opensrp.common.AllConstants.HHRegistrationFields.REFERENCE_DATE;
import static org.opensrp.common.util.EasyMap.create;

import java.util.Map;

import org.joda.time.LocalDate;
import org.opensrp.common.AllConstants;
import org.opensrp.form.domain.FormSubmission;
import org.opensrp.register.mcare.domain.Mother;
import org.opensrp.register.mcare.repository.AllElcos;
import org.opensrp.register.mcare.repository.AllMothers;
import org.opensrp.register.mcare.service.scheduling.BNFSchedulesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BNFService {
	
	private static Logger logger = LoggerFactory.getLogger(BNFService.class
			.toString());
	
	private AllElcos allElcos;
	private AllMothers allMothers;
	private BNFSchedulesService bnfSchedulesService;
	private PNCService pncService;
	
	@Autowired
	public BNFService(AllElcos allElcos, AllMothers allMothers, BNFSchedulesService bnfSchedulesService, PNCService pncService)
	{
		this.allElcos = allElcos;
		this.allMothers = allMothers;
		this.bnfSchedulesService = bnfSchedulesService;
		this.pncService = pncService;
	}
	
	public void registerBNF(FormSubmission submission)
	{
		String motherId = submission
				.getField(AllConstants.ANCFormFields.MCARE_MOTHER_ID);
		
		Mother mother = allMothers.findByCaseId(motherId);
		
		if (!allElcos.exists(submission.entityId())) {
			logger.warn(format(
					"Found mother without registered eligible couple. Ignoring: {0} for mother with id: {1} for ANM: {2}",
					submission.entityId(), motherId, submission.anmId()));
			return;
		}

		mother.withPROVIDERID(submission.anmId());
		mother.withINSTANCEID(submission.instanceId());
		mother.withTODAY(submission.getField(REFERENCE_DATE));
		allMothers.update(mother);
		
		bnfSchedulesService.enrollBNF(motherId, LocalDate.parse(submission.getField(REFERENCE_DATE)));
		
	}
	public void bnfFollowUpVisit(FormSubmission submission) {
		
		Mother mother = allMothers.findByCaseId(submission.entityId());

		if (mother == null) {
			logger.warn(format(
					"Failed to handle BNF as there is no Mother enroll with ID: {0}",
					submission.entityId()));
			return;
		}
		
		Map<String, String> bnfVisit = create(FWBNFDATE, submission.getField(FWBNFDATE))
											.put(FWCONFIRMATION, submission.getField(FWCONFIRMATION))
											.put(FWGESTATIONALAGE, submission.getField(FWGESTATIONALAGE))
											.put(FWEDD, submission.getField(FWEDD))
											.put(FWBNFSTS, submission.getField(FWBNFSTS))
											.put(FWDISPLAYTEXT1, submission.getField(FWDISPLAYTEXT1))
											.put(FWBNFWOMVITSTS, submission.getField(FWBNFWOMVITSTS))
											.put(FWBNFDTOO, submission.getField(FWBNFDTOO))
											.put(FWBNFLB, submission.getField(FWBNFLB))
											.put(FWBNFGEN, submission.getField(FWBNFGEN))
											.put(FWBNFCHLDVITSTS, submission.getField(FWBNFCHLDVITSTS))
											.put(FWBNFSMSRSN, submission.getField(FWBNFSMSRSN)).map();
		
		mother.withTODAY(submission.getField(REFERENCE_DATE));
			
		mother.bnfVisitDetails().add(bnfVisit);
		
		allMothers.update(mother);
		
		if(submission.getField(FWBNFSTS).equalsIgnoreCase(STS_LB) && submission.getField(FWBNFSTS).equalsIgnoreCase(STS_WD))
		{
			pncService.deliveryOutcome(submission);
		}
		
	}

}
