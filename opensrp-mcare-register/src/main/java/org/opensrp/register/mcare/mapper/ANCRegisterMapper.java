package org.opensrp.register.mcare.mapper;

import static ch.lambdaj.collection.LambdaCollections.with;

import java.util.List;

import org.opensrp.dto.register.ANC_RegisterDTO;
import org.opensrp.dto.register.ANC_RegisterEntryDTO;
import org.opensrp.register.mcare.ANCRegister;
import org.opensrp.register.mcare.ANCRegisterEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.lambdaj.function.convert.Converter;

@Component
public class ANCRegisterMapper {

	private static Logger logger = LoggerFactory.getLogger(ANCRegisterMapper.class.toString());
	
	public ANC_RegisterDTO mapToDTO(ANCRegister ancRegister)
	{
        List<ANC_RegisterEntryDTO> ancRegisterEntryDTOs =
                with(ancRegister.ancRegisterEntries())
                        .convert(new Converter<ANCRegisterEntry, ANC_RegisterEntryDTO>() {
                            @Override
                            public ANC_RegisterEntryDTO convert(ANCRegisterEntry entry) {
                                return new ANC_RegisterEntryDTO()
	                                .withCaseId(entry.caseId())
	                            	.withTODAY(entry.TODAY())
	                            	.withSTART(entry.START())
	                            	.withRelationalid(entry.relationalid())
	                            	.withPROVIDERID(entry.PROVIDERID())
	                            	.withLOCATIONID(entry.LOCATIONID())
	                            	.withGOBHHID(entry.GOBHHID())
	                            	.withJiVitAHHID(entry.JiVitAHHID())
	                            	.withFWWOMFNAME(entry.FWWOMFNAME())
	                            	.withFWWOMNID(entry.FWWOMNID())
	                            	.withFWWOMBID(entry.FWWOMBID())
	                            	.withIsClosed(entry.isClosed())
	                            	.withFWWOMAGE(entry.FWWOMAGE())
	                            	.withINSTANCEID(entry.INSTANCEID())
	                            	.withFWPSRLMP(entry.FWPSRLMP())
	                            	.withEND(entry.END())
	                            	.withCaseId(entry.caseId())
	                            	.withANCVisitOne(entry.ancVisitOne())
	                            	.withANCVisitTwo(entry.ancVisitTwo())
	                            	.withANCVisitThree(entry.ancVisitThree())
	                            	.withANCVisitFour(entry.ancVisitFour())
	                            	.withBNFVisitDetails(entry.bnfVisitDetails());      
                            }
                        });
        
        return new ANC_RegisterDTO(ancRegisterEntryDTOs);
    
	}
	
}
