package org.opensrp.register.mcare.mapper;

import static ch.lambdaj.collection.LambdaCollections.with;
import java.util.List;

import org.opensrp.dto.register.HHRegisterDTO;
import org.opensrp.dto.register.HHRegisterEntryDTO;
import org.opensrp.register.mcare.HHRegisterEntry;
import org.opensrp.register.mcare.HHRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.lambdaj.function.convert.Converter;

@Component
public class HHRegisterMapper {

	private static Logger logger = LoggerFactory.getLogger(ELCORegisterMapper.class.toString());
	
	public HHRegisterDTO mapToDTO(HHRegister hhRegister)
	{

        List<HHRegisterEntryDTO> hhRegisterEntryDTOs =
                with(hhRegister.hhRegisterEntries())
                        .convert(new Converter<HHRegisterEntry, HHRegisterEntryDTO>() {
                            @Override
                            public HHRegisterEntryDTO convert(HHRegisterEntry entry) {
                                return new HHRegisterEntryDTO()
                                .withCASEID(entry.CASEID())
                                .withINSTANCEID(entry.INSTANCEID())
                                .withPROVIDERID(entry.PROVIDERID())  
                        		//.withLOCATIONID(entry.LOCATIONID())
                        		.withTODAY(entry.TODAY())
                        		.withFWNHREGDATE(entry.FWNHREGDATE())
                        		.withFWGOBHHID(entry.FWGOBHHID())
                        		.withFWJIVHHID(entry.FWJIVHHID())
                        		.withFWCOUNTRY(entry.FWCOUNTRY())
                        		.withFWDIVISION(entry.FWDIVISION())
                        		.withFWDISTRICT(entry.FWDISTRICT())
                        		.withFWUPAZILLA(entry.FWUPAZILLA())
                        		.withFWUNION(entry.FWUNION())
                        		.withFWWARD(entry.FWWARD())
                        		.withFWSUBUNIT(entry.FWSUBUNIT())
                        		.withFWMAUZA_PARA(entry.FWMAUZA_PARA())
                        		.withFWNHHHGPS(entry.FWNHHHGPS())
                        		.withform_name(entry.form_name())
                        		.withFWHOHFNAME(entry.FWHOHFNAME())
                        		.withFWHOHLNAME(entry.FWHOHLNAME())
                        		.withFWHOHBIRTHDATE(entry.FWHOHBIRTHDATE())
                        		.withFWHOHGENDER(entry.FWHOHGENDER())
                        		.withFWNHHMBRNUM(entry.FWNHHMBRNUM())
                        		.withFWNHHMWRA(entry.FWNHHMWRA())
                        		.withELCO(entry.ELCO())
                        		.withuser_type(entry.user_type())
                        		.withexternal_user_ID(entry.external_user_ID())
                        		.withELCODETAILS(entry.ELCODETAILS())
                        		.withDetails(entry.details())
                        		.withLOCATIONID(entry.LOCATIONID())
                        		.withTODAY(entry.TODAY())
                        		.withSTART(entry.START())
                        		.withEND(entry.END())
                        		/*.withFWWOMAGE(entry.FWWOMAGE())
                        		.withFWBIRTHDATE(entry.FWBIRTHDATE())
                        		.withid(entry.id())
                        		.withFWWOMLNAME(entry.FWWOMLNAME())
                        		.withFWWOMFNAME(entry.FWWOMFNAME())
                        		.withJiVitAHHID(entry.FWJIVHHID())
                        		.withFWGENDER(entry.FWGENDER())
                        		.withFWWOMBID(entry.FWWOMBID())
                        		.withFWWOMNID(entry.FWWOMNID())
                        		.withFWHUSNAME(entry.FWHUSNAME())
                        		.withFWELIGIBLE(entry.FWELIGIBLE())
                        		.withFWDISPLAYAGE(entry.FWDISPLAYAGE())*/;  
                            }
                        });
        return new HHRegisterDTO(hhRegisterEntryDTOs);   
	
	}
}