package org.opensrp.register.mcare.service;

import java.util.ArrayList;
import java.util.List;

import org.opensrp.register.mcare.HHRegister;
import org.opensrp.register.mcare.HHRegisterEntry;
import org.opensrp.register.mcare.domain.HouseHold;
import org.opensrp.register.mcare.repository.AllHouseHolds;
import static org.opensrp.common.AllConstants.HHRegistrationFields.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HHRegisterService {
	
	private final AllHouseHolds allHouseHolds;
	
	@Autowired
	public HHRegisterService(AllHouseHolds allHouseHolds)
	{
		this.allHouseHolds = allHouseHolds;
	}

	public HHRegister getHHRegisterForProvider(String providerId)
	{
		ArrayList<HHRegisterEntry> hhRegisterEntries = new ArrayList<>();
        List<HouseHold> hhs = allHouseHolds.findAllHouseHolds();
        
        for (HouseHold hh : hhs) {
        	HHRegisterEntry hhRegisterEntry = new HHRegisterEntry()
        		.withCASEID(hh.caseId()) 
        		.withINSTANCEID(hh.INSTANCEID())
        		.withPROVIDERID(hh.PROVIDERID())
        		//.withLOCATIONID(hh.LOCATIONID())
        		.withTODAY(hh.TODAY())
        		.withFWNHREGDATE(hh.FWNHREGDATE())
        		.withFWGOBHHID(hh.FWGOBHHID())
        		.withFWJIVHHID(hh.FWJIVHHID())
        		.withFWCOUNTRY(hh.FWCOUNTRY())
                .withFWDIVISION(hh.FWDIVISION())
                .withFWDISTRICT(hh.FWDISTRICT())
                .withFWUPAZILLA(hh.FWUPAZILLA())
                .withFWUNION(hh.FWUNION())
                .withFWWARD(hh.FWWARD())
                .withFWSUBUNIT(hh.FWSUBUNIT())
                .withFWMAUZA_PARA(hh.FWMAUZA_PARA())
        		.withFWNHHHGPS(hh.FWNHHHGPS())
        		.withform_name(hh.form_name())
        		.withFWHOHFNAME(hh.FWHOHFNAME())
        		.withFWHOHLNAME(hh.FWHOHLNAME())
        		.withFWHOHBIRTHDATE(hh.FWHOHBIRTHDATE())
        		.withFWHOHGENDER(hh.FWHOHGENDER())
        		.withFWNHHMBRNUM(hh.FWNHHMBRNUM())
        		.withFWNHHMWRA(hh.FWNHHMWRA())
        		.withELCO(hh.ELCO())
        		.withuser_type(hh.user_type())
        		.withexternal_user_ID(hh.external_user_ID())
        		.withELCODETAILS(hh.ELCODETAILS())
        		.withDetails(hh.details())
        		.withLOCATIONID(hh.getDetail(LOCATION_NAME))
        		.withTODAY(hh.getDetail(REFERENCE_DATE))
        		.withSTART(hh.getDetail(START_DATE))
        		.withEND(hh.getDetail(END_DATE))
        		/*.withFWWOMAGE(hh.getELCODetail(FW_WOMAGE))
        		.withFWBIRTHDATE(hh.getELCODetail(FW_BIRTHDATE))
        		.withid(hh.getELCODetail(id))
        		.withFWWOMLNAME(hh.getELCODetail(FW_WOMLNAME))
        		.withFWWOMFNAME(hh.getELCODetail(FW_WOMFNAME))
        		.withJiVitAHHID(hh.getELCODetail(FW_JiVitAHHID))
        		.withFWGENDER(hh.getELCODetail(FW_GENDER))
        		.withFWWOMBID(hh.getELCODetail(FW_WOMBID))
        		.withFWWOMNID(hh.getELCODetail(FW_WOMNID))
        		.withFWHUSNAME(hh.getELCODetail(FW_HUSNAME))
        		.withFWELIGIBLE(hh.getELCODetail(FW_ELIGIBLE))
        		.withFWDISPLAYAGE(hh.getELCODetail(FW_DISPLAY_AGE))*/;
        	            
        	hhRegisterEntries.add(hhRegisterEntry);
        }
        return new HHRegister(hhRegisterEntries);
	}
}