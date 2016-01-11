package org.opensrp.register.mcare.service.reporting;

import static org.opensrp.common.AllConstants.FormEntityTypes.ELCO_TYPE;
import static org.opensrp.common.AllConstants.FormEntityTypes.HOUSE_HOLD_TYPE;

import org.opensrp.common.domain.Location;
import org.opensrp.register.mcare.domain.HouseHold;
import org.opensrp.register.mcare.repository.AllElcos;
import org.opensrp.register.mcare.repository.AllHouseHolds;
import org.opensrp.service.reporting.ILocationLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationLoader implements ILocationLoader {
	private AllHouseHolds allHouseHolds;
	private AllElcos allElcos;

    @Autowired
    public LocationLoader(AllHouseHolds allHouseHolds, AllElcos allElcos) {
        this.allHouseHolds = allHouseHolds;
        this.allElcos = allElcos;
    }

    @Override
    public Location loadLocationFor(String bindType, String caseId) {
        if (bindType.equalsIgnoreCase(HOUSE_HOLD_TYPE))
            return loadLocationForHouseHold(caseId);
        if (bindType.equalsIgnoreCase(ELCO_TYPE))
            return loadLocationForElco(caseId);
       
        return null;
    }
    
    private Location loadLocationForHouseHold(String caseId) {
        HouseHold houseHold = allHouseHolds.findByCaseId(caseId);
        //return couple.location();
        return new Location(houseHold.LOCATIONID(), houseHold.LOCATIONID(), houseHold.LOCATIONID());
    }
    private Location loadLocationForElco(String caseId) {
        HouseHold houseHold = allHouseHolds.findByCaseId(caseId);
        //return couple.location();
        return new Location(houseHold.LOCATIONID(), houseHold.LOCATIONID(), houseHold.LOCATIONID());
    }

   /* private Location loadLocationForEC(String caseId) {
        EligibleCouple couple = allEligibleCouples.findByCaseId(caseId);
        //return couple.location();
        return new Location(couple.locationId(), couple.locationId(), couple.locationId());
    }

    private Location loadLocationForMother(String caseId) {
        Mother mother = allMothers.findByCaseId(caseId);
        return loadLocationForEC(mother.ecCaseId());
    }

    private Location loadLocationForChild(String caseId) {
        Child child = allChildren.findByCaseId(caseId);
        return loadLocationForMother(child.motherCaseId());
    }*/
}
