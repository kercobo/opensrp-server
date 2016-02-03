/**
 * @author julkar nain 
 */
package org.opensrp.register.mcare.service.scheduling;

import static java.text.MessageFormat.format;
import static org.opensrp.dto.BeneficiaryType.elco;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_ANC;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_ANC_1;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_ANC_2;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_ANC_3;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_ANC_4;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_BNF;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_DELIVERY_PLAN;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_EDD;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_HB_TEST_1;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_IFA_1;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_LAB;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.MotherScheduleConstants.SCHEDULE_TT_1;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.DateTimeDuration;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ELCOSchedulesConstants.ELCO_SCHEDULE_PSRF;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.HHSchedulesConstants.HH_SCHEDULE_CENSUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Weeks;
import org.opensrp.common.util.DateUtil;
import org.opensrp.dto.ActionData;
import org.opensrp.dto.AlertStatus;
import org.opensrp.dto.BeneficiaryType;
import org.opensrp.scheduler.Action;
import org.opensrp.scheduler.HealthSchedulerService;
import org.opensrp.scheduler.repository.AllActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ANCSchedulesService {
	
	private static Logger logger = LoggerFactory.getLogger(ANCSchedulesService.class.toString());
	private static final String[] NON_ANC_SCHEDULES = {SCHEDULE_EDD, SCHEDULE_LAB, SCHEDULE_TT_1, SCHEDULE_IFA_1,
        SCHEDULE_HB_TEST_1, SCHEDULE_DELIVERY_PLAN};
	private HealthSchedulerService scheduler;
	private AllActions allActions;
	private ScheduleLogService scheduleLogService;
	
	@Autowired
	public ANCSchedulesService(HealthSchedulerService scheduler,AllActions allActions,ScheduleLogService scheduleLogService){
		this.scheduler = scheduler;
		this.allActions = allActions;
		this.scheduleLogService = scheduleLogService;
	}

    public void enrollMother(String caseId, LocalDate referenceDateForSchedule,String provider,String instanceId,String startDate) {
        /*for (String schedule : NON_ANC_SCHEDULES) {
        	scheduler.enrollIntoSchedule(caseId, schedule, referenceDateForSchedule);
        }*/
        enrollIntoCorrectMilestoneOfANCCare(caseId, referenceDateForSchedule,provider,instanceId,startDate);
    }
    private void enrollIntoCorrectMilestoneOfANCCare(String entityId, LocalDate referenceDateForSchedule,String provider,String instanceId,String startDate) {
        String milestone=null;
        Integer duration = 0;
        DateTime ancStartDate = null;
        DateTime ancExpireDate = null;
        if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Weeks.weeks(24).toPeriod().minusDays(5))) {
            milestone = SCHEDULE_ANC_1;
            duration = DateTimeDuration.anc1;
            ancStartDate = new DateTime(referenceDateForSchedule);
            ancExpireDate = new DateTime(referenceDateForSchedule).plusDays(duration);
        } else if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Weeks.weeks(32).toPeriod().minusDays(5))) {
            milestone = SCHEDULE_ANC_2;
            duration = DateTimeDuration.anc2;
        } else if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Weeks.weeks(36).toPeriod().minusDays(5))) {
            milestone = SCHEDULE_ANC_3;
            duration = DateTimeDuration.anc3;
        } else if(DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Weeks.weeks(36).toPeriod().minusDays(0))) {
            milestone = SCHEDULE_ANC_4;
            duration = DateTimeDuration.anc4;
        } else{
        	
        }

        Date date = null;
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
			date = df.parse(startDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DateTime start = new DateTime(date);
        
        logger.info(format("Enrolling ANC with Entity id:{0} to ANC schedule, milestone: {1}.", entityId, milestone));
        scheduler.enrollIntoSchedule(entityId, SCHEDULE_ANC, milestone, referenceDateForSchedule.toString());
        List<Action> beforeNewActions = allActions.findAlertByANMIdEntityIdScheduleName(provider, entityId, SCHEDULE_ANC);
		if(beforeNewActions.size() > 0){ 
		scheduleLogService.closeSchedule(entityId,instanceId,beforeNewActions.get(0).timestamp(),SCHEDULE_ANC);
		}
		allActions.addOrUpdateAlert(new Action(entityId, provider, ActionData.createAlert(BeneficiaryType.mother, SCHEDULE_ANC, milestone, AlertStatus.upcoming, start,  new DateTime().plusHours(duration))));
		logger.info(format("create psrf from psrf to psrf..", entityId));
		List<Action> afterNewActions = allActions.findAlertByANMIdEntityIdScheduleName(provider, entityId, SCHEDULE_ANC);
		if(afterNewActions.size() > 0){ 
			scheduleLogService.saveScheduleLog(BeneficiaryType.mother, entityId, instanceId, provider, SCHEDULE_ANC, milestone, AlertStatus.upcoming, start,  new DateTime().plusHours(duration),SCHEDULE_ANC,afterNewActions.get(0).timestamp());
	
		}
    }
    public void unEnrollFromAllSchedules(String entityId) {
        scheduler.unEnrollFromAllSchedules(entityId);
    }

    private void unEnrollFromSchedule(String entityId, String anmId, String scheduleName) {
        logger.info(format("Un-enrolling ANC with Entity id:{0} from schedule: {1}", entityId, scheduleName));
        scheduler.unEnrollFromSchedule(entityId, anmId, scheduleName);
    }

}
