/**
 * @author julkar nain 
 */
package org.opensrp.register.mcare.service.scheduling;

import static java.text.MessageFormat.format;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_BNF;

import org.joda.time.LocalDate;
import org.opensrp.scheduler.HealthSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BNFSchedulesService {
	private static Logger logger = LoggerFactory
			.getLogger(BNFSchedulesService.class.toString());
	private HealthSchedulerService scheduler;

	@Autowired
	public BNFSchedulesService(HealthSchedulerService scheduler) {
		this.scheduler = scheduler;
	}

	public void enrollBNF(String caseId, LocalDate referenceDateForSchedule) {
		logger.info(format("Enrolling Mother into BNF schedule. Id: {0}",
				caseId));

		scheduler.enrollIntoSchedule(caseId, SCHEDULE_BNF,
				referenceDateForSchedule);
	}

}
