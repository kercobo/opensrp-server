package org.opensrp.register.mcare.mapper;

import org.opensrp.dto.register.ELCORegisterDTO;
import org.opensrp.dto.register.ELCORegisterEntryDTO;
import org.opensrp.register.mcare.ELCORegisterEntry;
import org.opensrp.register.mcare.ELCORegister;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ch.lambdaj.function.convert.Converter;
import static ch.lambdaj.collection.LambdaCollections.with;

@Component
public class ELCORegisterMapper {
	
	private static Logger logger = LoggerFactory.getLogger(ELCORegisterMapper.class.toString());
	
	public ELCORegisterDTO mapToDTO(ELCORegister elcoRegister)
	{

        List<ELCORegisterEntryDTO> ecRegisterEntryDTOs =
                with(elcoRegister.ecRegisterEntries())
                        .convert(new Converter<ELCORegisterEntry, ELCORegisterEntryDTO>() {
                            @Override
                            public ELCORegisterEntryDTO convert(ELCORegisterEntry entry) {
                                return new ELCORegisterEntryDTO()
                                .withCASEID(entry.CASEID())
                                .withINSTANCEID(entry.INSTANCEID())
                                .withPROVIDERID(entry.PROVIDERID())
                        		.withLOCATIONID(entry.LOCATIONID())
                        		.withTODAY(entry.TODAY())
                        		//.withSTART(entry.START())
                        		//.withEND(entry.END())
                        		.withGOBHHID(entry.GOBHHID())
                        		.withJiVitAHHID(entry.JiVitAHHID())
                        		.withFWCENDATE(entry.FWCENDATE())
                        		.withFWCENSTAT(entry.FWCENSTAT())
                        		.withFWWOMFNAME(entry.FWWOMFNAME())
                        		.withFWWOMLNAME(entry.FWWOMLNAME())
                        		.withFWWOMANYID(entry.FWWOMANYID())
                        		.withFWWOMNID(entry.FWWOMNID())
                        		.withFWWOMRETYPENID(entry.FWWOMRETYPENID())
                        		.withFWWOMRETYPENID_CONCEPT(entry.FWWOMRETYPENID_CONCEPT())
                        		.withFWWOMBID(entry.FWWOMBID())
                        		.withFWWOMRETYPEBID(entry.FWWOMRETYPEBID())
                        		.withFWWOMRETYPEBID_CONCEPT(entry.FWWOMRETYPEBID_CONCEPT())
                        		.withFWHUSNAME(entry.FWHUSNAME())
                        		.withFWBIRTHDATE(entry.FWBIRTHDATE())
                        		.withFWGENDER(entry.FWGENDER())
                        		.withFWWOMAGE(entry.FWWOMAGE())
                        		.withFWELIGIBLE(entry.FWELIGIBLE())
                        		.withFWWOMCOUNTRY(entry.FWWOMCOUNTRY())
                        		.withFWWOMDIVISION(entry.FWWOMDIVISION())
                        		.withFWWOMDISTRICT(entry.FWWOMDISTRICT())
                        		.withFWWOMUPAZILLA(entry.FWWOMUPAZILLA())
                        		.withFWWOMUNION(entry.FWWOMUNION())
                        		.withFWWOMWARD(entry.FWWOMWARD())
                        		.withFWWOMSUBUNIT(entry.FWWOMSUBUNIT())
                        		.withFWWOMMAUZA_PARA(entry.FWWOMMAUZA_PARA())
                        		.withFWWOMGOBHHID(entry.FWWOMGOBHHID())
                        		.withFWWOMGPS(entry.FWWOMGPS())
                        		.withDetails(entry.details())
                        		.withPSRFDETAILS(entry.PSRFDETAILS())
                        		.withSTART(entry.START())
                        		.withEND(entry.END())
                        		.withFWDISPLAYAGE(entry.FWDISPLAYAGE())
                        		.withFWWOMSTRMEN(entry.FWWOMSTRMEN())
                        		.withFWWOMHUSSTR(entry.FWWOMHUSSTR())
                        		.withFWWOMHUSALV(entry.FWWOMHUSALV())
                        		.withFWWOMHUSLIV(entry.FWWOMHUSLIV());   
                            }
                        });
        
        return new ELCORegisterDTO(ecRegisterEntryDTOs);
    
	}
	
}