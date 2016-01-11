package org.opensrp.register.mcare.service.reporting;

import org.opensrp.common.domain.Location;
import org.opensrp.register.mcare.domain.HouseHold;
import org.opensrp.register.mcare.repository.AllHouseHolds;
import org.opensrp.service.reporting.IReporter;
import org.opensrp.util.SafeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseHoldReporter implements IReporter {
	
	private AllHouseHolds allHouseHolds;

	@Autowired
	public HouseHoldReporter(AllHouseHolds allHouseHolds) {
		this.allHouseHolds = allHouseHolds;
	}

	@Override
	public void report(String entityId, String reportIndicator,
			Location location, String serviceProvidedDate, SafeMap reportData) {
		HouseHold houseHold = allHouseHolds.findByCaseId(entityId);

	}

}
