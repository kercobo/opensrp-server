package org.opensrp.register.mcare.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;

@TypeDiscriminator("doc.type === 'Child'")
public class Child extends MotechBaseDataObject {
	@JsonProperty
	private String caseId;
	@JsonProperty
	private String INSTANCEID;
	@JsonProperty
	private String LOCATIONID;
	@JsonProperty
	private String PROVIDERID;
	@JsonProperty
	private String TODAY;
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
	private Map<String, String> enccVisitOne;
	@JsonProperty
	private Map<String, String> enccVisitTwo;
	@JsonProperty
	private Map<String, String> enccVisitThree;
	
	public Child()
	{
		details = new HashMap<String, String>();
		enccVisitOne = new HashMap<String, String>();
		enccVisitTwo = new HashMap<String, String>();
		enccVisitThree = new HashMap<String, String>();
	}
	public Child withCaseId(String caseId) {
		this.caseId = caseId;
		return this;
	}
	public Child withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}

	public Child withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}

	public Child withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}

	public Child withTODAY(String lmp) {
		this.TODAY = lmp;
		return this;
	}

	public Child withSTART(String START) {
		this.START = START;
		return this;
	}

	public Child withEND(String END) {
		this.END = END;
		return this;
	}
	public Child withRelationalId(String relationalid) {
		this.relationalid = relationalid;
		return this;
	}
	public Child withENCCVisitOne(Map<String, String> enccVisitOne) {
        this.enccVisitOne = new HashMap<>(enccVisitOne);
        return this;
    }
	public Child withENCCVisitTwo(Map<String, String> enccVisitTwo) {
        this.enccVisitTwo = new HashMap<>(enccVisitTwo);
        return this;
    }
	public Child withENCCVisitThree(Map<String, String> enccVisitThree) {
        this.enccVisitThree = new HashMap<>(enccVisitThree);
        return this;
    }
	public Child setIsClosed(boolean isClosed) {
        this.isClosed = Boolean.toString(isClosed);
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

	public String getRelationalId() {
		return relationalid;
	}

	public Map<String, String> details() {
		return details;
	}
	public String getDetail(String name) {
		return details.get(name);
	}
	
	public Map<String, String> enccVisitOne() {
		return enccVisitOne;
	}
	public Map<String, String> enccVisitTwo() {
		return enccVisitTwo;
	}
	public Map<String, String> enccVisitThree() {
		return enccVisitThree;
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
