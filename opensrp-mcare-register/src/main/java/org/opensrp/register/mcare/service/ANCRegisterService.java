package org.opensrp.register.mcare.service;

import java.util.ArrayList;
import java.util.List;

import org.opensrp.register.mcare.ANCRegister;
import org.opensrp.register.mcare.ANCRegisterEntry;
import org.opensrp.register.mcare.domain.Mother;
import org.opensrp.register.mcare.repository.AllMothers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ANCRegisterService {

	private final AllMothers allMothers;
	
	@Autowired
	public ANCRegisterService(AllMothers allMothers)
	{
		this.allMothers = allMothers;
	}

	public ANCRegister getANCRegisterForProvider(String providerId)
	{
		ArrayList<ANCRegisterEntry> ancRegisterEntries = new ArrayList<>();
        List<Mother> mothers = allMothers.allOpenMothers();
        for (Mother anc : mothers) {
        	ANCRegisterEntry ancRegisterEntry = new ANCRegisterEntry()
        	.withCaseId(anc.caseId())
        	.withTODAY(anc.TODAY())
        	.withSTART(anc.START())
        	.withRelationalid(anc.relationalid())
        	.withPROVIDERID(anc.PROVIDERID())
        	.withLOCATIONID(anc.LOCATIONID())
        	.withINSTANCEID(anc.INSTANCEID())
        	.withFWPSRLMP(anc.FWPSRLMP())
        	.withFWWOMFNAME(anc.FWWOMFNAME())
        	.withGOBHHID(anc.GOBHHID())
        	.withJiVitAHHID(anc.JiVitAHHID())
        	.withFWWOMNID(anc.FWWOMNID())
        	.withFWWOMBID(anc.FWWOMBID())
        	.withFWWOMAGE(anc.FWWOMAGE())
        	.withIsClosed(anc.isClosed())
        	.withEND(anc.END())        	
        	.withCaseId(anc.caseId())
        	.withANCVisitOne(anc.ancVisitOne())
        	.withANCVisitTwo(anc.ancVisitTwo())
        	.withANCVisitThree(anc.ancVisitThree())
        	.withANCVisitFour(anc.ancVisitFour())
        	.withBNFVisitDetails(anc.bnfVisitDetails());     
            
        	ancRegisterEntries.add(ancRegisterEntry);
        }
        return new ANCRegister(ancRegisterEntries);
	}

}
