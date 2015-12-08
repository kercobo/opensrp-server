package org.opensrp.dto.register;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class ANC_RegisterEntryDTO {
	
	@JsonProperty
	private String caseId;
	@JsonProperty
	private String INSTANCEID;
	@JsonProperty
	private String PROVIDERID;
	@JsonProperty
	private String LOCATIONID;
	@JsonProperty
	private String GOBHHID;
	@JsonProperty
	private String JiVitAHHID;
	@JsonProperty
	private String FWWOMFNAME;
	@JsonProperty
	private String FWWOMNID;
	@JsonProperty
	private String FWWOMBID;
	@JsonProperty
	private String FWWOMAGE;
	@JsonProperty
	private String TODAY;
	@JsonProperty
	private String FWPSRLMP;
	@JsonProperty
	private String START;
	@JsonProperty
	private String END;
	@JsonProperty
	private String relationalid;
	@JsonProperty
    private String isClosed;
	@JsonProperty
	private Map<String, String> details;
	@JsonProperty
	private Map<String, String> ancVisitOne;
	@JsonProperty
	private Map<String, String> ancVisitTwo;
	@JsonProperty
	private Map<String, String> ancVisitThree;
	@JsonProperty
	private Map<String, String> ancVisitFour;
	@JsonProperty
	private List<Map<String, String>> bnfVisitDetails;
	
	public ANC_RegisterEntryDTO() {

		this.details = new HashMap<>();
		this.ancVisitOne = new HashMap<>();
		this.ancVisitTwo = new HashMap<>();
		this.ancVisitThree = new HashMap<>();
		this.ancVisitFour = new HashMap<>();
		this.setIsClosed(false);
	}
	
	public ANC_RegisterEntryDTO withCaseId(String caseId) {
		this.caseId = caseId;
		return this;
	}

	public ANC_RegisterEntryDTO withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}

	public ANC_RegisterEntryDTO withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}

	public ANC_RegisterEntryDTO withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}

	public ANC_RegisterEntryDTO withTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}

	public ANC_RegisterEntryDTO withFWPSRLMP(String FWPSRLMP) {
		this.FWPSRLMP = FWPSRLMP;
		return this;
	}

	public ANC_RegisterEntryDTO withSTART(String START) {
		this.START = START;
		return this;
	}

	public ANC_RegisterEntryDTO withEND(String END) {
		this.END = END;
		return this;
	}
	public ANC_RegisterEntryDTO withRelationalid(String relationalid) {
		this.relationalid = relationalid;
		return this;
	}

	public ANC_RegisterEntryDTO withANCVisitOne(Map<String, String> ancVisitOne) {
        this.ancVisitOne = new HashMap<>(ancVisitOne);
        return this;
    }
	public ANC_RegisterEntryDTO withANCVisitTwo(Map<String, String> ancVisitTwo) {
        this.ancVisitTwo = new HashMap<>(ancVisitTwo);
        return this;
    }
	public ANC_RegisterEntryDTO withANCVisitThree(Map<String, String> ancVisitThree) {
        this.ancVisitThree = new HashMap<>(ancVisitThree);
        return this;
    }
	public ANC_RegisterEntryDTO withANCVisitFour(Map<String, String> ancVisitFour) {
        this.ancVisitFour = new HashMap<>(ancVisitFour);
        return this;
    }
	public ANC_RegisterEntryDTO withBNFVisitDetails(List<Map<String, String>> bnfVisitDetails) {
        this.bnfVisitDetails = bnfVisitDetails;
        return this;
    }	
	
	public ANC_RegisterEntryDTO setIsClosed(boolean isClosed) {
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
