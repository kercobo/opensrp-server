/**
 * @author julkar nain
 */

package org.opensrp.register.mcare.service;

import static java.text.MessageFormat.format;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFDTOO;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.FWBNFSTS;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.STS_WD;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.STS_LB;
import static org.opensrp.common.AllConstants.BnfFollowUpVisitFields.STS_SB;
import static org.opensrp.common.AllConstants.ANCVisitOneFields.FWCONFIRMATION;
import static org.opensrp.common.AllConstants.PNCVisitOneFields.*;
import static org.opensrp.common.AllConstants.PNCVisitTwoFields.*;
import static org.opensrp.common.AllConstants.PNCVisitThreeFields.*;
import static org.opensrp.common.util.EasyMap.create;

import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.opensrp.form.domain.FormSubmission;
import org.opensrp.register.mcare.domain.Elco;
import org.opensrp.register.mcare.domain.Mother;
import org.opensrp.register.mcare.repository.AllElcos;
import org.opensrp.register.mcare.repository.AllMothers;
import org.opensrp.register.mcare.service.scheduling.ChildSchedulesService;
import org.opensrp.register.mcare.service.scheduling.PNCSchedulesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PNCService {

	private static Logger logger = LoggerFactory.getLogger(ANCService.class
			.toString());
	private AllElcos allElcos;
	private AllMothers allMothers;
	private PNCSchedulesService pncSchedulesService;
	private ChildSchedulesService childSchedulesService;

	@Autowired
	public PNCService(AllElcos allElcos, AllMothers allMothers,
			PNCSchedulesService pncSchedulesService,
			ChildSchedulesService childSchedulesService) {
		this.allElcos = allElcos;
		this.allMothers = allMothers;
		this.pncSchedulesService = pncSchedulesService;
		this.childSchedulesService = childSchedulesService;
	}

	public void deliveryOutcome(FormSubmission submission) {
		String pattern = "yyyy-MM-dd";
		//DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
		
		DateTime dateTime = DateTime.parse(submission
				.getField(FWBNFDTOO));
		DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
		String referenceDate = fmt.print(dateTime);

		if (submission.getField(FWBNFDTOO) != null) {
			
			Mother mother = allMothers.findByCaseId(submission.entityId());

			if (mother == null) {
				logger.warn(format(
						"Failed to handle PNC as there is no Mother enroll with ID: {0}",
						submission.entityId()));
				return;
			}

			if (submission.getField(FWBNFSTS).equals(STS_WD)) {
				logger.info("Closing Mother as the mother died during delivery. Mother Id: "
						+ mother.caseId());
				closeMother(mother);
			} else if (submission.getField(FWBNFSTS).equals(STS_LB)) {
				logger.info("Generating schedule for Mother when Child is Live Birth. Mother Id: "
						+ mother.caseId());
				pncSchedulesService.enrollPNCRVForMother(submission.entityId(), LocalDate.parse(referenceDate));
				logger.info("Generating schedule for Child when Child is Live Birth. Mother Id: "
						+ mother.caseId());
				childSchedulesService.enrollENCCForChild(submission.entityId(),  LocalDate.parse(referenceDate));
			} else if (submission.getField(FWBNFSTS).equals(STS_SB)) {
				logger.info("Generating schedule for Mother when Child is Still Birth. Mother Id: "
						+ mother.caseId());
				pncSchedulesService.enrollPNCRVForMother(submission.entityId(),  LocalDate.parse(referenceDate));
			}
		}
	}

	public void pncVisitOne(FormSubmission submission) {

		Mother mother = allMothers.findByCaseId(submission.entityId());

		if (mother == null) {
			logger.warn(format(
					"Failed to handle PNC-1 as there is no Mother enroll with ID: {0}",
					submission.entityId()));
			return;
		}

		Map<String, String> pncVisitOne = create(FWPNC1DATE,
				submission.getField(FWPNC1DATE))
				.put(FWCONFIRMATION, submission.getField(FWCONFIRMATION))
				.put(FWPNC1REMSTS, submission.getField(FWPNC1REMSTS))
				.put(FWPNC1INT, submission.getField(FWPNC1INT))
				.put(FWPNC1KNWPRVDR, submission.getField(FWPNC1KNWPRVDR))
				.put(FWPNC1FVR, submission.getField(FWPNC1FVR))
				.put(FWPNC1TEMP, submission.getField(FWPNC1TEMP))
				.put(FWPNC1DNGRSIGN, submission.getField(FWPNC1DNGRSIGN))
				.put(FWPNC1DELTYPE, submission.getField(FWPNC1DELTYPE))
				.put(FWPNC1DELCOMP, submission.getField(FWPNC1DELCOMP)).map();

		mother.withPNCVisitOne(pncVisitOne);

		allMothers.update(mother);
	}

	public void pncVisitTwo(FormSubmission submission) {
		Mother mother = allMothers.findByCaseId(submission.entityId());

		if (mother == null) {
			logger.warn(format(
					"Failed to handle PNC-2 as there is no Mother enroll with ID: {0}",
					submission.entityId()));
			return;
		}

		Map<String, String> pncVisitTwo = create(FWPNC2DATE,
				submission.getField(FWPNC2DATE))
				.put(FWCONFIRMATION, submission.getField(FWCONFIRMATION))
				.put(FWPNC2REMSTS, submission.getField(FWPNC2REMSTS))
				.put(FWPNC2INT, submission.getField(FWPNC2INT))
				.put(FWPNC2KNWPRVDR, submission.getField(FWPNC2KNWPRVDR))
				.put(FWPNC2FVR, submission.getField(FWPNC2FVR))
				.put(FWPNC2TEMP, submission.getField(FWPNC2TEMP))
				.put(FWPNC2DNGRSIGN, submission.getField(FWPNC2DNGRSIGN))
				.put(FWPNC2DELCOMP, submission.getField(FWPNC2DELCOMP)).map();

		mother.withPNCVisitTwo(pncVisitTwo);

		allMothers.update(mother);

	}

	public void pncVisitThree(FormSubmission submission) {

		Mother mother = allMothers.findByCaseId(submission.entityId());

		if (mother == null) {
			logger.warn(format(
					"Failed to handle PNC-3 as there is no Mother enroll with ID: {0}",
					submission.entityId()));
			return;
		}

		Map<String, String> pncVisitThree = create(FWPNC3DATE,
				submission.getField(FWPNC3DATE))
				.put(FWCONFIRMATION, submission.getField(FWCONFIRMATION))
				.put(FWPNC3REMSTS, submission.getField(FWPNC3REMSTS))
				.put(FWPNC3INT, submission.getField(FWPNC3INT))
				.put(FWPNC3KNWPRVDR, submission.getField(FWPNC3KNWPRVDR))
				.put(FWPNC3FVR, submission.getField(FWPNC3FVR))
				.put(FWPNC3TEMP, submission.getField(FWPNC3TEMP))
				.put(FWPNC3DNGRSIGN, submission.getField(FWPNC3DNGRSIGN))
				.put(FWPNC3DELCOMP, submission.getField(FWPNC3DELCOMP)).map();

		mother.withPNCVisitThree(pncVisitThree);

		allMothers.update(mother);
	}

	private void closeMother(Mother mother) {

		mother.setIsClosed(true);
		pncSchedulesService.unEnrollFromSchedules(mother.caseId());

		Elco elco = allElcos.findByCaseId(mother.relationalid());
		logger.info("Closing EC case along with PNC case. Ec Id: "+ elco.caseId());
		elco.setIsClosed(true);
		allElcos.update(elco);
	}
}
