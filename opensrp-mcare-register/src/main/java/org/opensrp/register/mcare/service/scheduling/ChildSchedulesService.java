package org.opensrp.register.mcare.service.scheduling;

import static java.text.MessageFormat.format;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ChildScheduleConstants.SCHEDULE_ENCC;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ChildScheduleConstants.SCHEDULE_ENCC_1;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ChildScheduleConstants.SCHEDULE_ENCC_2;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ChildScheduleConstants.SCHEDULE_ENCC_3;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.opensrp.common.util.DateUtil;
import org.opensrp.scheduler.HealthSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildSchedulesService {
	
	private static Logger logger = LoggerFactory.getLogger(ChildSchedulesService.class.toString());
	private HealthSchedulerService scheduler;
	
	@Autowired
	public ChildSchedulesService(HealthSchedulerService scheduler){
		this.scheduler = scheduler;
	}
	 public void enrollENCCForChild(String caseId, LocalDate referenceDateForSchedule) {
	       
		 enrollIntoCorrectMilestoneOfENCCCare(caseId, referenceDateForSchedule);
	    }
	    private void enrollIntoCorrectMilestoneOfENCCCare(String entityId, LocalDate referenceDateForSchedule) {
	        String milestone=null;

	        if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Days.ONE.toPeriod())) {
	            milestone = SCHEDULE_ENCC_1;
	        } else if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Days.FIVE.toPeriod())) {
	            milestone = SCHEDULE_ENCC_2;
	        } else if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Days.SIX.toPeriod().plusDays(2))) {
	            milestone = SCHEDULE_ENCC_3;
	        } else{
	        	
	        }

	        logger.info(format("Enrolling ENCC with Entity id:{0} to ENCC schedule, milestone: {1}.", entityId, milestone));
	        scheduler.enrollIntoSchedule(entityId, SCHEDULE_ENCC, milestone, referenceDateForSchedule.toString());
	    }
}
