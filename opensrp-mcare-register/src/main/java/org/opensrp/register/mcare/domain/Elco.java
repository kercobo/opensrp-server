/**
 * @author julkar nain 
 */
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

@TypeDiscriminator("doc.type === 'Elco'")
public class Elco extends MotechBaseDataObject {

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
	private String WomanREGDATE;
	@JsonProperty
	private String FWNHWOMSTRMEN;
	@JsonProperty
	private String FWNHWOMHUSALV;
	@JsonProperty
	private String FWNHWOMHUSLIV;
	@JsonProperty
	private String FWNHWOMHUSSTR;
	@JsonProperty
    private String isClosed;
	@JsonProperty
	private String GOBHHID;
	@JsonProperty
	private String JiVitAHHID;
	@JsonProperty
	private String existing_ELCO;
	@JsonProperty
	private String new_ELCO;
	@JsonProperty
	private String ELCO;
	@JsonProperty
	private String FWCENDATE;
	@JsonProperty
	private String FWCENSTAT;
	@JsonProperty
	private String FWWOMFNAME;
	@JsonProperty
	private String FWWOMLNAME;
	@JsonProperty
	private String FWWOMANYID;
	@JsonProperty
	private String FWWOMNID;
	@JsonProperty
	private String FWWOMRETYPENID;
	@JsonProperty
	private String FWWOMRETYPENID_CONCEPT;
	@JsonProperty
	private String FWWOMBID;
	@JsonProperty
	private String FWWOMRETYPEBID;
	@JsonProperty
	private String FWWOMRETYPEBID_CONCEPT;
	@JsonProperty
	private String FWHUSNAME;
	@JsonProperty
	private String FWBIRTHDATE;
	@JsonProperty
	private String FWGENDER;
	@JsonProperty
	private String FWWOMAGE;
	@JsonProperty
	private String FWDISPLAYAGE;
	@JsonProperty
	private String FWWOMSTRMEN;
	@JsonProperty
	private String FWWOMHUSALV;
	@JsonProperty
	private String FWWOMHUSSTR;
	@JsonProperty
	private String FWWOMHUSLIV;
	@JsonProperty
	private String FWELIGIBLE;
	@JsonProperty
	private String FWELIGIBLE2;
	@JsonProperty
	private String FWWOMCOUNTRY;
	@JsonProperty
	private String FWWOMDIVISION;
	@JsonProperty
	private String FWWOMDISTRICT;
	@JsonProperty
	private String FWWOMUPAZILLA;
	@JsonProperty
	private String FWWOMUNION;
	@JsonProperty
	private String FWWOMWARD;
	@JsonProperty
	private String FWWOMSUBUNIT;
	@JsonProperty
	private String FWWOMMAUZA_PARA;
	@JsonProperty
	private String FWWOMGOBHHID;
	@JsonProperty
	private String FWWOMGPS;
	@JsonProperty
	private String form_name;
	@JsonProperty
	private Map<String, String> details;
	
	@JsonProperty
	private List<Map<String, String>> PSRFDETAILS;

	public Elco() {

	}

	public Elco withCASEID(String caseId) {
		this.caseId = caseId;
		return this;
	}
	
	public Elco withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}

	public Elco withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}
	public Elco withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}
	public Elco withTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}
	public Elco withSTART(String START) {
		this.START = START;
		return this;
	}
	public Elco withEND(String END) {
		this.END = END;
		return this;
	}
	public Elco withWomanREGDATE(String WomanREGDATE) {
		this.WomanREGDATE = WomanREGDATE;
		return this;
	}
	public Elco withFWNHWOMSTRMEN(String FWNHWOMSTRMEN) {
		this.FWNHWOMSTRMEN = FWNHWOMSTRMEN;
		return this;
	}
	public Elco withFWNHWOMHUSALV(String FWNHWOMHUSALV) {
		this.FWNHWOMHUSALV = FWNHWOMHUSALV;
		return this;
	}
	public Elco withFWNHWOMHUSLIV(String FWNHWOMHUSLIV) {
		this.FWNHWOMHUSLIV = FWNHWOMHUSLIV;
		return this;
	}
	public Elco withFWNHWOMHUSSTR(String FWNHWOMHUSSTR) {
		this.FWNHWOMHUSSTR = FWNHWOMHUSSTR;
		return this;
	}
	public Elco withGOBHHID(String GOBHHID) {
		this.GOBHHID = GOBHHID;
		return this;
	}
	public Elco withJiVitAHHID(String JiVitAHHID) {
		this.JiVitAHHID = JiVitAHHID;
		return this;
	}
	public Elco withexisting_ELCO(String existing_ELCO) {
		this.existing_ELCO = existing_ELCO;
		return this;
	}
	public Elco withnew_ELCO(String new_ELCO) {
		this.new_ELCO = new_ELCO;
		return this;
	}
	public Elco withELCO(String ELCO) {
		this.ELCO = ELCO;
		return this;
	}
	public Elco withFWCENDATE(String FWCENDATE) {
		this.FWCENDATE = FWCENDATE;
		return this;
	}
	public Elco withFWCENSTAT(String FWCENSTAT) {
		this.FWCENSTAT = FWCENSTAT;
		return this;
	}
	public Elco withFWWOMFNAME(String FWWOMFNAME) {
		this.FWWOMFNAME = FWWOMFNAME;
		return this;
	}
	public Elco withFWWOMLNAME(String FWWOMLNAME) {
		this.FWWOMLNAME = FWWOMLNAME;
		return this;
	}
	public Elco withFWWOMANYID(String FWWOMANYID) {
		this.FWWOMANYID = FWWOMANYID;
		return this;
	}
	public Elco withFWWOMNID(String FWWOMNID) {
		this.FWWOMNID = FWWOMNID;
		return this;
	}
	public Elco withFWWOMRETYPENID(String FWWOMRETYPENID) {
		this.FWWOMRETYPENID = FWWOMRETYPENID;
		return this;
	}
	public Elco withFWWOMRETYPENID_CONCEPT(String FWWOMRETYPENID_CONCEPT) {
		this.FWWOMRETYPENID_CONCEPT = FWWOMRETYPENID_CONCEPT;
		return this;
	}
	public Elco withFWWOMBID(String FWWOMBID) {
		this.FWWOMBID = FWWOMBID;
		return this;
	}
	public Elco withFWWOMRETYPEBID(String FWWOMRETYPEBID) {
		this.FWWOMRETYPEBID = FWWOMRETYPEBID;
		return this;
	}
	public Elco withFWWOMRETYPEBID_CONCEPT(String FWWOMRETYPEBID_CONCEPT) {
		this.FWWOMRETYPEBID_CONCEPT = FWWOMRETYPEBID_CONCEPT;
		return this;
	}
	public Elco withFWHUSNAME(String FWHUSNAME) {
		this.FWHUSNAME = FWHUSNAME;
		return this;
	}
	public Elco withFWBIRTHDATE(String FWBIRTHDATE) {
		this.FWBIRTHDATE = FWBIRTHDATE;
		return this;
	}
	public Elco withFWGENDER(String FWGENDER) {
		this.FWGENDER = FWGENDER;
		return this;
	}
	public Elco withFWWOMAGE(String FWWOMAGE) {
		this.FWWOMAGE = FWWOMAGE;
		return this;
	}
	public Elco withFWDISPLAYAGE(String FWDISPLAYAGE) {
		this.FWDISPLAYAGE = FWDISPLAYAGE;
		return this;
	}
	public Elco withFWWOMSTRMEN(String FWWOMSTRMEN) {
		this.FWWOMSTRMEN = FWWOMSTRMEN;
		return this;
	}
	public Elco withFWWOMHUSSTR(String FWWOMHUSSTR) {
		this.FWWOMHUSSTR = FWWOMHUSSTR;
		return this;
	}
	public Elco withFWWOMHUSALV(String FWWOMHUSALV) {
		this.FWWOMHUSALV = FWWOMHUSALV;
		return this;
	}
	public Elco withFWWOMHUSLIV(String FWWOMHUSLIV) {
		this.FWWOMHUSLIV = FWWOMHUSLIV;
		return this;
	}
	public Elco withFWELIGIBLE(String FWELIGIBLE) {
		this.FWELIGIBLE = FWELIGIBLE;
		return this;
	}
	public Elco withFWELIGIBLE2(String FWELIGIBLE2) {
		this.FWELIGIBLE2 = FWELIGIBLE2;
		return this;
	}
	public Elco withFWWOMCOUNTRY(String FWWOMCOUNTRY) {
		this.FWWOMCOUNTRY = FWWOMCOUNTRY;
		return this;
	}
	public Elco withFWWOMDIVISION(String FWWOMDIVISION) {
		this.FWWOMDIVISION = FWWOMDIVISION;
		return this;
	}
	public Elco withFWWOMDISTRICT(String FWWOMDISTRICT) {
		this.FWWOMDISTRICT = FWWOMDISTRICT;
		return this;
	}
	public Elco withFWWOMUPAZILLA(String FWWOMUPAZILLA) {
		this.FWWOMUPAZILLA = FWWOMUPAZILLA;
		return this;
	}
	public Elco withFWWOMUNION(String FWWOMUNION) {
		this.FWWOMUNION = FWWOMUNION;
		return this;
	}
	public Elco withFWWOMWARD(String FWWOMWARD) {
		this.FWWOMWARD = FWWOMWARD;
		return this;
	}
	public Elco withFWWOMSUBUNIT(String FWWOMSUBUNIT) {
		this.FWWOMSUBUNIT = FWWOMSUBUNIT;
		return this;
	}
	public Elco withFWWOMMAUZA_PARA(String FWWOMMAUZA_PARA) {
		this.FWWOMMAUZA_PARA = FWWOMMAUZA_PARA;
		return this;
	}
	public Elco withFWWOMGOBHHID(String FWWOMGOBHHID) {
		this.FWWOMGOBHHID = FWWOMGOBHHID;
		return this;
	}
	public Elco withFWWOMGPS(String FWWOMGPS) {
		this.FWWOMGPS = FWWOMGPS;
		return this;
	}
	public Elco withform_name(String form_name) {
		this.form_name = form_name;
		return this;
	}
	public Elco withDetails(Map<String, String> details) {
        this.details = new HashMap<>(details);
        return this;
    }
	public Elco withPSRFDETAILS(List<Map<String, String>> PSRFDETAILS) {
		this.PSRFDETAILS = PSRFDETAILS;
		return this;
	}
	public String caseId() {
		return caseId;
	}
	public String INSTANCEID()
	{
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
		return  END;
	}
	public String WomanREGDATE() {
		return  WomanREGDATE;
	}
	public String FWNHWOMSTRMEN() {
		return  FWNHWOMSTRMEN;
	}
	public String FWNHWOMHUSALV() {
		return  FWNHWOMHUSALV;
	}
	public String FWNHWOMHUSLIV() {
		return  FWNHWOMHUSLIV;
	}
	public String FWNHWOMHUSSTR() {
		return  FWNHWOMHUSSTR;
	}
	public String GOBHHID() {
		return GOBHHID;
	}
	public String JiVitAHHID() {
		return JiVitAHHID;
	}
	public String existing_ELCO() {
		return existing_ELCO;
	}
	public String new_ELCO() {
		return new_ELCO;
	}
	public String ELCO() {
		return ELCO;
	}
	public String FWCENDATE() {
		return FWCENDATE;
	}
	public String FWCENSTAT() {
		return FWCENSTAT;
	}
	public String FWWOMFNAME() {
		return FWWOMFNAME;
	}
	public String FWWOMLNAME() {
		return FWWOMLNAME;
	}
	public String FWWOMANYID() {
		return FWWOMANYID;
	}
	public String FWWOMNID() {
		return FWWOMNID;
	}
	public String FWWOMRETYPENID() {
		return FWWOMRETYPENID;
	}
	public String FWWOMRETYPENID_CONCEPT() {
		return FWWOMRETYPENID_CONCEPT;
	}
	public String FWWOMBID() {
		return FWWOMBID;
	}
	public String FWWOMRETYPEBID() {
		return FWWOMRETYPEBID;
	}
	public String FWWOMRETYPEBID_CONCEPT() {
		return FWWOMRETYPEBID_CONCEPT;
	}
	public String FWHUSNAME() {
		return FWHUSNAME;
	}
	public String FWBIRTHDATE() {
		return FWBIRTHDATE;
	}
	public String FWGENDER() {
		return FWGENDER;
	}
	public String FWWOMAGE() {
		return FWWOMAGE;
	}
	public String FWDISPLAYAGE() {
		return FWDISPLAYAGE;
	}
	public String FWWOMSTRMEN() {
		return FWWOMSTRMEN;
	}
	public String FWWOMHUSSTR() {
		return FWWOMHUSSTR;
	}
	public String FWWOMHUSALV() {
		return FWWOMHUSALV;
	}
	public String FWWOMHUSLIV() {
		return FWWOMHUSLIV;
	}
	public String FWELIGIBLE() {
		return FWELIGIBLE;
	}
	public String FWELIGIBLE2() {
		return FWELIGIBLE2;
	}
	public String FWWOMCOUNTRY() {
		return FWWOMCOUNTRY;
	}
	public String FWWOMDIVISION() {
		return FWWOMDIVISION;
	}
	public String FWWOMDISTRICT() {
		return FWWOMDISTRICT;
	}
	public String FWWOMUPAZILLA() {
		return FWWOMUPAZILLA;
	}
	public String FWWOMUNION() {
		return FWWOMUNION;
	}
	public String FWWOMWARD() {
		return FWWOMWARD;
	}
	public String FWWOMSUBUNIT() {
		return FWWOMSUBUNIT;
	}
	public String FWWOMMAUZA_PARA() {
		return FWWOMMAUZA_PARA;
	}
	public String FWWOMGOBHHID() {
		return FWWOMGOBHHID;
	}
	public String FWWOMGPS() {
		return FWWOMGPS;
	}
	public String form_name() {
		return form_name;
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

	public List<Map<String, String>> PSRFDETAILS() {
		if (PSRFDETAILS == null) {
			PSRFDETAILS = new ArrayList<>();
		}
		return PSRFDETAILS;
	}
	 public Elco setIsClosed(boolean isClosed) {
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