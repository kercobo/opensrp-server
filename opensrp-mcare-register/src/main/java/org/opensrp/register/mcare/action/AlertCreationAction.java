package org.opensrp.register.mcare.action;

import static org.opensrp.dto.BeneficiaryType.elco;
import static org.opensrp.dto.BeneficiaryType.household;
import static org.opensrp.dto.BeneficiaryType.mother;
import static org.opensrp.dto.BeneficiaryType.child;

import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.opensrp.dto.BeneficiaryType;
import org.opensrp.register.mcare.domain.Elco;
import org.opensrp.register.mcare.domain.HouseHold;
import org.opensrp.register.mcare.domain.Mother;
import org.opensrp.register.mcare.repository.AllElcos;
import org.opensrp.register.mcare.repository.AllHouseHolds;
import org.opensrp.register.mcare.repository.AllMothers;
import org.opensrp.scheduler.HealthSchedulerService;
import org.opensrp.scheduler.HookedEvent;
import org.opensrp.scheduler.MilestoneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("AlertCreationAction")
public class AlertCreationAction implements HookedEvent {
	private HealthSchedulerService scheduler;
	private AllHouseHolds allHouseHolds;
	private AllElcos allElcos;
	private AllMothers allMothers;

	@Autowired
	public AlertCreationAction(HealthSchedulerService scheduler,
			AllHouseHolds allHouseHolds, AllElcos allElcos,
			AllMothers allMothers) {
		this.scheduler = scheduler;
		this.allHouseHolds = allHouseHolds;
		this.allElcos = allElcos;
		this.allMothers = allMothers;
	}

	@Override
	public void invoke(MilestoneEvent event, Map<String, String> extraData) {
		BeneficiaryType beneficiaryType = BeneficiaryType.from(extraData
				.get("beneficiaryType"));

		// TODO: Get rid of this horrible if-else after Motech-Platform fixes
		// the bug related to metadata in motech-schedule-tracking.
		String instanceId = null;
		String providerId = null;
		String caseID = event.externalId();
		DateTime startOfEarliestWindow = new DateTime();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		
		if (household.equals(beneficiaryType)) {
			HouseHold houseHold = allHouseHolds.findByCaseId(caseID);
			if (houseHold != null) {
				instanceId= houseHold.INSTANCEID();
				providerId = houseHold.PROVIDERID();
				startOfEarliestWindow = DateTime.parse(houseHold.TODAY(),formatter);
			}
		} else if (elco.equals(beneficiaryType)) {
			
			Elco elco = allElcos.findByCaseId(caseID);
			
			if (elco != null) {
				instanceId= elco.INSTANCEID();
				providerId = elco.PROVIDERID();
				startOfEarliestWindow = DateTime.parse(elco.TODAY(),formatter);
			}
		}
		else if(mother.equals(beneficiaryType))
		{
			Mother mother = allMothers.findByCaseId(caseID);
			
			if (mother != null) {
				instanceId= mother.INSTANCEID();
				providerId = mother.PROVIDERID();
				startOfEarliestWindow = DateTime.parse(mother.TODAY(),formatter);
			}
		}
		else if(child.equals(beneficiaryType))
		{
			Mother mother = allMothers.findByCaseId(caseID);

			if (mother != null) {
				instanceId= mother.INSTANCEID();
				providerId = mother.PROVIDERID();
				startOfEarliestWindow = DateTime.parse(mother.TODAY(),formatter);
			}
		}
		else {
			throw new IllegalArgumentException("Beneficiary Type : "
					+ beneficiaryType + " is of unknown type");
		}

		scheduler.alertFor(event.windowName(), beneficiaryType, caseID, instanceId, providerId, event.scheduleName(), event.milestoneName(),
				startOfEarliestWindow, event.startOfDueWindow(),
				event.startOfLateWindow(), event.startOfMaxWindow());
	}
}
