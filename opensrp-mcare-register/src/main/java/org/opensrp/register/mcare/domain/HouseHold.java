package org.opensrp.register.mcare.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;

@TypeDiscriminator("doc.type === 'HouseHold'")
public class HouseHold extends MotechBaseDataObject {
	@JsonProperty
	private String caseId;
	@JsonProperty
	private String INSTANCEID;
	@JsonProperty
	private String PROVIDERID;
	@JsonProperty
	private String LOCATIONID;
	@JsonProperty
	private String TODAY;
	@JsonProperty
	private String START;
	@JsonProperty
	private String END;
	@JsonProperty
	private String FWNHREGDATE;
	@JsonProperty
	private String FWGOBHHID; 
	@JsonProperty
	private String FWJIVHHID;
	@JsonProperty
	private String FWCOUNTRY;
	@JsonProperty
	private String FWDIVISION;
	@JsonProperty
	private String FWDISTRICT;
	@JsonProperty
	private String FWUPAZILLA;
	@JsonProperty
	private String FWUNION;
	@JsonProperty
	private String FWWARD;
	@JsonProperty
	private String FWSUBUNIT;
	@JsonProperty
	private String FWMAUZA_PARA;
	@JsonProperty
	private String FWNHHHGPS;
	@JsonProperty
	private String form_name;
	@JsonProperty
	private String FWHOHFNAME;
	@JsonProperty
	private String FWHOHLNAME;
	@JsonProperty
	private String FWHOHBIRTHDATE; 
	@JsonProperty
	private String FWHOHGENDER;
	@JsonProperty
	private String FWNHHMBRNUM;
	@JsonProperty
	private String FWNHHMWRA;
	@JsonProperty
	private String ELCO;
	@JsonProperty
	private String user_type;
	@JsonProperty
	private String external_user_ID;
	@JsonProperty
	private List<Map<String, String>> ELCODETAILS;
	@JsonProperty
	private Map<String, String> details;

	public HouseHold() {

		this.ELCODETAILS = new ArrayList<>();
	}
	
	public HouseHold withCASEID(String caseId) {
		this.caseId = caseId;
		return this;
	}

	public HouseHold withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}

	public HouseHold withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}

	public HouseHold withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}

	public HouseHold withTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}

	public HouseHold withSTART(String START) {
		this.START = START;
		return this;
	}

	public HouseHold withEND(String END) {
		this.END = END;
		return this;
	}

	public HouseHold withFWNHREGDATE(String FWNHREGDATE) {
		this.FWNHREGDATE = FWNHREGDATE;
		return this;
	}

	public HouseHold withFWGOBHHID(String FWGOBHHID) {
		this.FWGOBHHID = FWGOBHHID;
		return this;
	}

	public HouseHold withFWJIVHHID(String FWJIVHHID) {
		this.FWJIVHHID = FWJIVHHID;
		return this;
	}

	public HouseHold withFWNHHHGPS(String FWNHHHGPS) {
		this.FWNHHHGPS = FWNHHHGPS;
		return this;
	}
	
	public HouseHold withform_name(String form_name) {
		this.form_name = form_name;
		return this;
	}

	public HouseHold withFWCOUNTRY(String FWCOUNTRY) {
		this.FWCOUNTRY = FWCOUNTRY;
		return this;
	}

	public HouseHold withFWDIVISION(String FWDIVISION) {
		this.FWDIVISION = FWDIVISION;
		return this;
	}

	public HouseHold withFWDISTRICT(String FWDISTRICT) {
		this.FWDISTRICT = FWDISTRICT;
		return this;
	}

	public HouseHold withFWUPAZILLA(String FWUPAZILLA) {
		this.FWUPAZILLA = FWUPAZILLA;
		return this;
	}

	public HouseHold withFWUNION(String FWUNION) {
		this.FWUNION = FWUNION;
		return this;
	}

	public HouseHold withFWWARD(String FWWARD) {
		this.FWWARD = FWWARD;
		return this;
	}

	public HouseHold withFWSUBUNIT(String FWSUBUNIT) {
		this.FWSUBUNIT = FWSUBUNIT;
		return this;
	}
	
	public HouseHold withFWMAUZA_PARA(String FWMAUZA_PARA) {
		this.FWMAUZA_PARA = FWMAUZA_PARA;
		return this;
	}

	public HouseHold withFWHOHFNAME(String FWHOHFNAME) {
		this.FWHOHFNAME = FWHOHFNAME;
		return this;
	}

	
	public HouseHold withFWHOHLNAME(String FWHOHLNAME) {
		this.FWHOHLNAME = FWHOHLNAME;
		return this;
	}

	public HouseHold withFWHOHBIRTHDATE(String FWHOHBIRTHDATE) {
		this.FWHOHBIRTHDATE = FWHOHBIRTHDATE;
		return this;
	}

	public HouseHold withFWNHHMBRNUM(String FWNHHMBRNUM) {
		this.FWNHHMBRNUM = FWNHHMBRNUM;
		return this;
	}

	public HouseHold withFWHOHGENDER(String FWHOHGENDER) {
		this.FWHOHGENDER = FWHOHGENDER;
		return this;
	}
	
	public HouseHold withFWNHHMWRA(String FWNHHMWRA) {
		this.FWNHHMWRA = FWNHHMWRA;
		return this;
	}

	public HouseHold withELCO(String ELCO) {
		this.ELCO = ELCO;
		return this;
	}
	
	public HouseHold withuser_type(String user_type) {
		this.user_type = user_type;
		return this;
	}

	public HouseHold withexternal_user_ID(String external_user_ID) {
		this.external_user_ID = external_user_ID;
		return this;
	}

	public HouseHold withELCODETAILS(List<Map<String, String>> ELCODETAILS) {
		this.ELCODETAILS = ELCODETAILS;
		return this;
	}
	
	public HouseHold withDetails(Map<String, String> details) {
        this.details = new HashMap<>(details);
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

	public String FWNHREGDATE() {
		return FWNHREGDATE;
	}

	public String FWGOBHHID() {
		return FWGOBHHID;
	}

	public String FWJIVHHID() {
		return FWJIVHHID;
	}

	public String FWNHHHGPS() {
		return FWNHHHGPS;
	}
	
	public String form_name() {
		return form_name;
	}

	public String FWCOUNTRY() {
		return FWCOUNTRY;
	}
	
	public String FWDIVISION() {
		return FWDIVISION;
	}
	
	public String FWDISTRICT() {
		return FWDISTRICT;
	}
	
	public String FWUPAZILLA() {
		return FWUPAZILLA;
	}
	
	public String FWUNION() {
		return FWUNION;
	}
	
	public String FWWARD() {
		return FWWARD;
	}
	
	public String FWSUBUNIT() {
		return FWSUBUNIT;
	}
	
	public String FWMAUZA_PARA() {
		return FWMAUZA_PARA;
	}

	public String FWHOHFNAME() {
		return FWHOHFNAME;
	}
	public String FWHOHLNAME() {
		return FWHOHLNAME;
	}

	public String FWHOHBIRTHDATE() {
		return FWHOHBIRTHDATE;
	}

	public String FWNHHMBRNUM() {
		return FWNHHMBRNUM;
	}

	public String FWHOHGENDER() {
		return FWHOHGENDER;
	}

	public String FWNHHMWRA() {
		return FWNHHMWRA;
	}

	public String ELCO() {
		return ELCO;
	}
	
	public String user_type() {
		return user_type;
	}

	public String external_user_ID() {
		return external_user_ID;
	}

	public List<Map<String, String>> ELCODETAILS() {
		if (ELCODETAILS == null) {
			ELCODETAILS = new ArrayList<>();
		}
		return ELCODETAILS;
	}

	private String getCaseId() {
		return caseId;
	}

	public Map<String, String> details() {
		return details;
	}

	public String getDetail(String name) {
		return details.get(name);
	}
	
	public String getELCODetail(String name) {	
		/*int size = ELCODETAILS.size();
		String elems = "";
		for (int i = 0; i < size; i++)
			elems = elems + ELCODETAILS.get(i).get(name) + " " ;
		return elems;	*/	

		return ELCODETAILS.get(0).get(name);
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