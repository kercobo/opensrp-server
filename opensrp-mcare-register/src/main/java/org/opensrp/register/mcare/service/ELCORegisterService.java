package org.opensrp.register.mcare.service;

import java.util.ArrayList;
import java.util.List;

import org.opensrp.register.mcare.ELCORegister;
import org.opensrp.register.mcare.ELCORegisterEntry;
import org.opensrp.register.mcare.domain.Elco;
import org.opensrp.register.mcare.repository.AllElcos;
import static org.opensrp.common.AllConstants.ELCORegistrationFields.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ELCORegisterService {
	
	private final AllElcos allElcos;
	
	@Autowired
	public ELCORegisterService(AllElcos allElcos)
	{
		this.allElcos = allElcos;
	}

	public ELCORegister getELCORegisterForProvider(String providerId)
	{
		ArrayList<ELCORegisterEntry> elcoRegisterEntries = new ArrayList<>();
        List<Elco> elcos = allElcos.allOpenELCOsForProvider(providerId);
        for (Elco ec : elcos) {
            ELCORegisterEntry ecRegisterEntry = new ELCORegisterEntry()
            		.withCASEID(ec.CASEID())
            		.withINSTANCEID(ec.INSTANCEID())
            		.withPROVIDERID(ec.PROVIDERID())
            		.withLOCATIONID(ec.LOCATIONID())
            		.withTODAY(ec.TODAY())
            		//.withSTART(ec.START())
            		//.withEND(ec.END())
            		.withGOBHHID(ec.GOBHHID())
            		.withJiVitAHHID(ec.JiVitAHHID())
            		.withFWCENDATE(ec.FWCENDATE())
            		.withFWCENSTAT(ec.FWCENSTAT())
            		.withFWWOMFNAME(ec.FWWOMFNAME())
            		.withFWWOMLNAME(ec.FWWOMLNAME())
            		.withFWWOMANYID(ec.FWWOMANYID())
            		.withFWWOMNID(ec.FWWOMNID())
            		.withFWWOMRETYPENID(ec.FWWOMRETYPENID())
            		.withFWWOMRETYPENID_CONCEPT(ec.FWWOMRETYPENID_CONCEPT())
            		.withFWWOMBID(ec.FWWOMBID())
            		.withFWWOMRETYPEBID(ec.FWWOMRETYPEBID())
            		.withFWWOMRETYPEBID_CONCEPT(ec.FWWOMRETYPEBID_CONCEPT())
            		.withFWHUSNAME(ec.FWHUSNAME())
            		.withFWBIRTHDATE(ec.FWBIRTHDATE())
            		.withFWGENDER(ec.FWGENDER())
            		.withFWWOMAGE(ec.FWWOMAGE())
            		.withFWELIGIBLE(ec.FWELIGIBLE())
            		.withFWWOMCOUNTRY(ec.FWWOMCOUNTRY())
                    .withFWWOMDIVISION(ec.FWWOMDIVISION())
                    .withFWWOMDISTRICT(ec.FWWOMDISTRICT())
                    .withFWWOMUPAZILLA(ec.FWWOMUPAZILLA())
                    .withFWWOMUNION(ec.FWWOMUNION())
                    .withFWWOMWARD(ec.FWWOMWARD())
                    .withFWWOMSUBUNIT(ec.FWWOMSUBUNIT())
                    .withFWWOMMAUZA_PARA(ec.FWWOMMAUZA_PARA())
                    .withFWWOMGOBHHID(ec.FWWOMGOBHHID())
                    .withFWWOMGPS(ec.FWWOMGPS())
            		.withDetails(ec.details())
            		.withPSRFDETAILS(ec.PSRFDETAILS())
            		.withSTART(ec.getDetail(START_DATE))
            		.withEND(ec.getDetail(END_DATE))
            		.withFWDISPLAYAGE(ec.getDetail(FW_DISPLAY_AGE))
            		.withFWWOMSTRMEN(ec.getDetail(FW_NHWOMSTRMEN))
            		.withFWWOMHUSSTR(ec.getDetail(FW_NHWOMHUSSTR))
            		.withFWWOMHUSALV(ec.getDetail(FW_NHWOMHUSALV))
            		.withFWWOMHUSLIV(ec.getDetail(FW_NHWOMHUSLIV));     
            
            elcoRegisterEntries.add(ecRegisterEntry);
        }
        return new ELCORegister(elcoRegisterEntries);
	}
}
