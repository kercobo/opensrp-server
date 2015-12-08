package org.opensrp.register.mcare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ANCRegisterEntry {

	private String caseId;
	
	private String INSTANCEID;
	
	private String PROVIDERID;
	
	private String LOCATIONID;
	
	private String GOBHHID;
	
	private String JiVitAHHID;
	
	private String FWWOMFNAME;
	
	private String FWWOMNID;
	
	private String FWWOMBID;
	
	private String FWWOMAGE;
	
	private String TODAY;
	
	private String FWPSRLMP;
	
	private String START;
	
	private String END;
	
	private String relationalid;
	
    private String isClosed;
	
	private Map<String, String> details;
	
	private Map<String, String> ancVisitOne;
	
	private Map<String, String> ancVisitTwo;
	
	private Map<String, String> ancVisitThree;
	
	private Map<String, String> ancVisitFour;
	
	private List<Map<String, String>> bnfVisitDetails;
	
	public ANCRegisterEntry() {

		this.details = new HashMap<>();
		this.ancVisitOne = new HashMap<>();
		this.ancVisitTwo = new HashMap<>();
		this.ancVisitThree = new HashMap<>();
		this.ancVisitFour = new HashMap<>();
		this.setIsClosed(false);
	}
	
	public ANCRegisterEntry withCaseId(String caseId) {
		this.caseId = caseId;
		return this;
	}

	public ANCRegisterEntry withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}

	public ANCRegisterEntry withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}

	public ANCRegisterEntry withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}

	public ANCRegisterEntry withTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}

	public ANCRegisterEntry withFWPSRLMP(String FWPSRLMP) {
		this.FWPSRLMP = FWPSRLMP;
		return this;
	}

	public ANCRegisterEntry withSTART(String START) {
		this.START = START;
		return this;
	}

	public ANCRegisterEntry withEND(String END) {
		this.END = END;
		return this;
	}
	public ANCRegisterEntry withRelationalid(String relationalid) {
		this.relationalid = relationalid;
		return this;
	}

	public ANCRegisterEntry withANCVisitOne(Map<String, String> ancVisitOne) {
        this.ancVisitOne = new HashMap<>(ancVisitOne);
        return this;
    }
	public ANCRegisterEntry withANCVisitTwo(Map<String, String> ancVisitTwo) {
        this.ancVisitTwo = new HashMap<>(ancVisitTwo);
        return this;
    }
	public ANCRegisterEntry withANCVisitThree(Map<String, String> ancVisitThree) {
        this.ancVisitThree = new HashMap<>(ancVisitThree);
        return this;
    }
	public ANCRegisterEntry withANCVisitFour(Map<String, String> ancVisitFour) {
        this.ancVisitFour = new HashMap<>(ancVisitFour);
        return this;
    }
	public ANCRegisterEntry withBNFVisitDetails(List<Map<String, String>> bnfVisitDetails) {
        this.bnfVisitDetails = bnfVisitDetails;
        return this;
    }

	public String caseId() {
		return caseId;
	}

	public String INSTANCEID() {
		return INSTANCEID;
	}

	public String PROVIDERID() {
		return PROVIDERID;
	}

	public String LOCATIONID() {
		return LOCATIONID;
	}
	
	public String TODAY() {
		return TODAY;
	}
	public String FWPSRLMP() {
		return FWPSRLMP;
	}	
	public String START() {
		return START;
	}

	public String END() {
		return END;
	}
	
	public String relationalid() {
		return relationalid;
	}

	private String getCaseId() {
		return caseId;
	}

	public String getRelationalid() {
		return relationalid;
	}

	public Map<String, String> details() {
		return details;
	}
	public String getDetail(String name) {
		return details.get(name);
	}
	
	public Map<String, String> ancVisitOne() {
		return ancVisitOne;
	}
	public Map<String, String> ancVisitTwo() {
		return ancVisitTwo;
	}
	public Map<String, String> ancVisitThree() {
		return ancVisitThree;
	}
	public Map<String, String> ancVisitFour() {
		return ancVisitFour;
	}
	public List<Map<String, String>> bnfVisitDetails() {
		if (bnfVisitDetails == null) {
			bnfVisitDetails = new ArrayList<>();
		}
		return bnfVisitDetails;
	}
    public ANCRegisterEntry setIsClosed(boolean isClosed) {
        this.isClosed = Boolean.toString(isClosed);
        return this;
    }
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o, "id", "revision");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "revision");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
