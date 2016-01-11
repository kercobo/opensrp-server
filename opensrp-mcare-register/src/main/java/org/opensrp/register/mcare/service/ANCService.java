/**
 * @author julkar nain 
 */
package org.opensrp.register.mcare.service;

import static java.text.MessageFormat.format;
import static org.opensrp.common.AllConstants.HHRegistrationFields.ELCO_REGISTRATION_SUB_FORM_NAME;
import static org.opensrp.common.AllConstants.HHRegistrationFields.MOTHER_REFERENCE_DATE;
import static org.opensrp.common.AllConstants.ANCVisitOneFields.*;
import static org.opensrp.common.AllConstants.ANCVisitTwoFields.*;
import static org.opensrp.common.AllConstants.ANCVisitThreeFields.*;
import static org.opensrp.common.AllConstants.ANCVisitFourFields.*;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.*;
import static org.opensrp.common.util.EasyMap.create;

import java.util.Map;

import org.joda.time.LocalDate;
import org.opensrp.common.AllConstants;
import org.opensrp.form.domain.FormSubmission;
import org.opensrp.form.domain.SubFormData;
import org.opensrp.register.mcare.domain.Mother;
import org.opensrp.register.mcare.repository.AllElcos;
import org.opensrp.register.mcare.repository.AllMothers;
import org.opensrp.register.mcare.service.scheduling.ANCSchedulesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ANCService {

	private static Logger logger = LoggerFactory.getLogger(ANCService.class
			.toString());
	private AllElcos allElcos;
	private AllMothers allMothers;
	private ANCSchedulesService ancSchedulesService;
	private PNCService pncService;

	@Autowired
	public ANCService(AllElcos allElcos, AllMothers allMothers,
			ANCSchedulesService ancSchedulesService, PNCService pncService) {
		this.allElcos = allElcos;
		this.allMothers = allMothers;
		this.ancSchedulesService = ancSchedulesService;
		this.pncService = pncService;
	}

	public void registerANC(FormSubmission submission) {

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
		mother.withTODAY(submission.getField(MOTHER_REFERENCE_DATE));
		allMothers.update(mother);

		ancSchedulesService.enrollMother(motherId,
				LocalDate.parse(submission.getField(MOTHER_REFERENCE_DATE)));
	}

	public void ancVisitOne(FormSubmission submission) {
		Mother mother = allMothers.findByCaseId(submission.entityId());

		if (mother == null) {
			logger.warn(format(
					"Failed to handle ANC-1 as there is no Mother enroll with ID: {0}",
					submission.entityId()));
			return;
		}
		Map<String, String> ancVisitOne = create(FWANC1DATE, submission.getField(FWANC1DATE))
											.put(FWCONFIRMATION, submission.getField(FWCONFIRMATION))
											.put(FWGESTATIONALAGE, submission.getField(FWGESTATIONALAGE))
											.put(FWEDD, submission.getField(FWEDD))
											.put(FWANC1REMSTS, submission.getField(FWANC1REMSTS))
											.put(FWANC1INT, submission.getField(FWANC1INT))
											.put(FWANC1KNWPRVDR, submission.getField(FWANC1KNWPRVDR))
											.put(FDPSRANM, submission.getField(FDPSRANM))
											.put(FDPSRHBP, submission.getField(FDPSRHBP))
											.put(FDPSRDBT, submission.getField(FDPSRDBT))
											.put(FDPSRTHY, submission.getField(FDPSRTHY))
											.put(FWANC1PROB, submission.getField(FWANC1PROB))
											.put(FWANC1DNGRSIGN, submission.getField(FWANC1DNGRSIGN))
											.put(FWBPC1LOCOFDEL, submission.getField(FWBPC1LOCOFDEL))
											.put(FWBPC1ASSTLAB, submission.getField(FWBPC1ASSTLAB))
											.put(FWBPC1TRNSPRT, submission.getField(FWBPC1TRNSPRT))
											.put(FWBPC1BLDGRP, submission.getField(FWBPC1BLDGRP))
											.put(FWBPC1BLDDNR, submission.getField(FWBPC1BLDDNR))
											.put(FWBPC1FINARGMT, submission.getField(FWBPC1FINARGMT))
											.map();											
		
		mother.withANCVisitOne(ancVisitOne);
		allMothers.update(mother);
	}

	public void ancVisitTwo(FormSubmission submission) {
		Mother mother = allMothers.findByCaseId(submission.entityId());

		if (mother == null) {
			logger.warn(format(
					"Failed to handle ANC-2 as there is no Mother enroll with ID: {0}",
					submission.entityId()));
			return;
		}
		Map<String, String> ancVisitTwo = create(FWANC2DATE, submission.getField(FWANC2DATE))
											.put(FWCONFIRMATION, submission.getField(FWCONFIRMATION))
											.put(FWGESTATIONALAGE, submission.getField(FWGESTATIONALAGE))
											.put(FWEDD, submission.getField(FWEDD))
											.put(FWANC2REMSTS, submission.getField(FWANC2REMSTS))
											.put(FWANC2INT, submission.getField(FWANC2INT))
											.put(FWANC2KNWPRVDR, submission.getField(FWANC2KNWPRVDR))
											.put(FWANC2PREGCOND, submission.getField(FWANC2PREGCOND))
											.put(FWANC2PROB, submission.getField(FWANC2PROB))
											.put(FWANC2DNGRSIGN, submission.getField(FWANC2DNGRSIGN))
											.put(FWBPC2LOCOFDEL, submission.getField(FWBPC2LOCOFDEL))
											.put(FWBPC2ASSTLAB, submission.getField(FWBPC2ASSTLAB))
											.put(FWBPC2TRNSPRT, submission.getField(FWBPC2TRNSPRT))
											.put(FWBPC2BLDGRP, submission.getField(FWBPC2BLDGRP))
											.put(FWBPC2BLDDNR, submission.getField(FWBPC2BLDDNR))
											.put(FWBPC2FINARGMT, submission.getField(FWBPC2FINARGMT))
											.map();	
		
		mother.withANCVisitTwo(ancVisitTwo);
		allMothers.update(mother);

	}

	public void ancVisitThree(FormSubmission submission) {
		Mother mother = allMothers.findByCaseId(submission.entityId());

		if (mother == null) {
			logger.warn(format(
					"Failed to handle ANC-3 as there is no Mother enroll with ID: {0}",
					submission.entityId()));
			return;
		}
		Map<String, String> ancVisitThree = create(FWANC3DATE, submission.getField(FWANC3DATE))
											.put(FWCONFIRMATION, submission.getField(FWCONFIRMATION))
											.put(FWGESTATIONALAGE, submission.getField(FWGESTATIONALAGE))
											.put(FWEDD, submission.getField(FWEDD))
											.put(FWANC3REMSTS, submission.getField(FWANC3REMSTS))
											.put(FWANC3INT, submission.getField(FWANC3INT))
											.put(FWANC3KNWPRVDR, submission.getField(FWANC3KNWPRVDR))
											.put(FWANC3PREGCOND, submission.getField(FWANC3PREGCOND))
											.put(FWANC3PROB, submission.getField(FWANC3PROB))
											.put(FWANC3DNGRSIGN, submission.getField(FWANC3DNGRSIGN))
											.put(FWBPC3LOCOFDEL, submission.getField(FWBPC3LOCOFDEL))
											.put(FWBPC3ASSTLAB, submission.getField(FWBPC3ASSTLAB))
											.put(FWBPC3TRNSPRT, submission.getField(FWBPC3TRNSPRT))
											.put(FWBPC3BLDGRP, submission.getField(FWBPC3BLDGRP))
											.put(FWBPC3BLDDNR, submission.getField(FWBPC3BLDDNR))
											.put(FWBPC3FINARGMT, submission.getField(FWBPC3FINARGMT))
											.map();	
		
		mother.withANCVisitThree(ancVisitThree);

		allMothers.update(mother);
	}

	public void ancVisitFour(FormSubmission submission) {
		Mother mother = allMothers.findByCaseId(submission.entityId());

		if (mother == null) {
			logger.warn(format(
					"Failed to handle ANC-4 as there is no Mother enroll with ID: {0}",
					submission.entityId()));
			return;
		}
		
		Map<String, String> ancVisitFour = create(FWANC4DATE, submission.getField(FWANC4DATE))
											.put(FWCONFIRMATION, submission.getField(FWCONFIRMATION))
											.put(FWGESTATIONALAGE, submission.getField(FWGESTATIONALAGE))
											.put(FWEDD, submission.getField(FWEDD))
											.put(FWANC4REMSTS, submission.getField(FWANC4REMSTS))
											.put(FWANC4INT, submission.getField(FWANC4INT))
											.put(FWANC4KNWPRVDR, submission.getField(FWANC4KNWPRVDR))
											.put(FWANC4PREGCOND, submission.getField(FWANC4PREGCOND))
											.put(FWANC4PROB, submission.getField(FWANC4PROB))
											.put(FWANC4DNGRSIGN, submission.getField(FWANC4DNGRSIGN))
											.put(FWBPC4LOCOFDEL, submission.getField(FWBPC4LOCOFDEL))
											.put(FWBPC4ASSTLAB, submission.getField(FWBPC4ASSTLAB))
											.put(FWBPC4TRNSPRT, submission.getField(FWBPC4TRNSPRT))
											.put(FWBPC4BLDGRP, submission.getField(FWBPC4BLDGRP))
											.put(FWBPC4BLDDNR, submission.getField(FWBPC4BLDDNR))
											.put(FWBPC4FINARGMT, submission.getField(FWBPC4FINARGMT))
											.map();	
			
		mother.withANCVisitFour(ancVisitFour);
		allMothers.update(mother);
	}

	public void pregnancyVerificationForm(FormSubmission submission)
	{
		
	}
	
	public void ancClose(String entityId) {
		
		Mother mother = allMothers.findByCaseId(entityId);
		
		 if (mother == null) {
	            logger.warn("Tried to close case without registered mother for case ID: " + entityId);
	            return;
	        }

		 allMothers.close(entityId);
		
		 ancSchedulesService.unEnrollFromAllSchedules(entityId);
	}

}
