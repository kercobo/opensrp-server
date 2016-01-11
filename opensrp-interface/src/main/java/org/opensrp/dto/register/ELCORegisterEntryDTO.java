package org.opensrp.dto.register;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class ELCORegisterEntryDTO {

	@JsonProperty
	private String CASEID;
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

	public ELCORegisterEntryDTO() {

	}

	public ELCORegisterEntryDTO withCASEID(String CASEID) {
		this.CASEID = CASEID;
		return this;
	}
	public ELCORegisterEntryDTO withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}
	public ELCORegisterEntryDTO withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}
	public ELCORegisterEntryDTO withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}
	public ELCORegisterEntryDTO withTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}
	public ELCORegisterEntryDTO withSTART(String START) {
		this.START = START;
		return this;
	}
	public ELCORegisterEntryDTO withEND(String END) {
		this.END = END;
		return this;
	}
	public ELCORegisterEntryDTO withWomanREGDATE(String WomanREGDATE) {
		this.WomanREGDATE = WomanREGDATE;
		return this;
	}
	public ELCORegisterEntryDTO withFWNHWOMSTRMEN(String FWNHWOMSTRMEN) {
		this.FWNHWOMSTRMEN = FWNHWOMSTRMEN;
		return this;
	}
	public ELCORegisterEntryDTO withFWNHWOMHUSALV(String FWNHWOMHUSALV) {
		this.FWNHWOMHUSALV = FWNHWOMHUSALV;
		return this;
	}
	public ELCORegisterEntryDTO withFWNHWOMHUSLIV(String FWNHWOMHUSLIV) {
		this.FWNHWOMHUSLIV = FWNHWOMHUSLIV;
		return this;
	}
	public ELCORegisterEntryDTO withFWNHWOMHUSSTR(String FWNHWOMHUSSTR) {
		this.FWNHWOMHUSSTR = FWNHWOMHUSSTR;
		return this;
	}
	public ELCORegisterEntryDTO withGOBHHID(String GOBHHID) {
		this.GOBHHID = GOBHHID;
		return this;
	}
	public ELCORegisterEntryDTO withJiVitAHHID(String JiVitAHHID) {
		this.JiVitAHHID = JiVitAHHID;
		return this;
	}
	public ELCORegisterEntryDTO withexisting_ELCO(String existing_ELCO) {
		this.existing_ELCO = existing_ELCO;
		return this;
	}
	public ELCORegisterEntryDTO withnew_ELCO(String new_ELCO) {
		this.new_ELCO = new_ELCO;
		return this;
	}
	public ELCORegisterEntryDTO withELCO(String ELCO) {
		this.ELCO = ELCO;
		return this;
	}
	public ELCORegisterEntryDTO withFWCENDATE(String FWCENDATE) {
		this.FWCENDATE = FWCENDATE;
		return this;
	}

	public ELCORegisterEntryDTO withFWCENSTAT(String FWCENSTAT) {
		this.FWCENSTAT = FWCENSTAT;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMFNAME(String FWWOMFNAME) {
		this.FWWOMFNAME = FWWOMFNAME;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMLNAME(String FWWOMLNAME) {
		this.FWWOMLNAME = FWWOMLNAME;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMANYID(String FWWOMANYID) {
		this.FWWOMANYID = FWWOMANYID;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMNID(String FWWOMNID) {
		this.FWWOMNID = FWWOMNID;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMRETYPENID(String FWWOMRETYPENID) {
		this.FWWOMRETYPENID = FWWOMRETYPENID;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMRETYPENID_CONCEPT(String FWWOMRETYPENID_CONCEPT) {
		this.FWWOMRETYPENID_CONCEPT = FWWOMRETYPENID_CONCEPT;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMBID(String FWWOMBID) {
		this.FWWOMBID = FWWOMBID;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMRETYPEBID(String FWWOMRETYPEBID) {
		this.FWWOMRETYPEBID = FWWOMRETYPEBID;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMRETYPEBID_CONCEPT(String FWWOMRETYPEBID_CONCEPT) {
		this.FWWOMRETYPEBID_CONCEPT = FWWOMRETYPEBID_CONCEPT;
		return this;
	}
	public ELCORegisterEntryDTO withFWHUSNAME(String FWHUSNAME) {
		this.FWHUSNAME = FWHUSNAME;
		return this;
	}
	public ELCORegisterEntryDTO withFWBIRTHDATE(String FWBIRTHDATE) {
		this.FWBIRTHDATE = FWBIRTHDATE;
		return this;
	}
	public ELCORegisterEntryDTO withFWGENDER(String FWGENDER) {
		this.FWGENDER = FWGENDER;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMAGE(String FWWOMAGE) {
		this.FWWOMAGE = FWWOMAGE;
		return this;
	}
	public ELCORegisterEntryDTO withFWDISPLAYAGE(String FWDISPLAYAGE) {
		this.FWDISPLAYAGE = FWDISPLAYAGE;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMSTRMEN(String FWWOMSTRMEN) {
		this.FWWOMSTRMEN = FWWOMSTRMEN;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMHUSSTR(String FWWOMHUSSTR) {
		this.FWWOMHUSSTR = FWWOMHUSSTR;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMHUSALV(String FWWOMHUSALV) {
		this.FWWOMHUSALV = FWWOMHUSALV;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMHUSLIV(String FWWOMHUSLIV) {
		this.FWWOMHUSLIV = FWWOMHUSLIV;
		return this;
	}
	public ELCORegisterEntryDTO withFWELIGIBLE(String FWELIGIBLE) {
		this.FWELIGIBLE = FWELIGIBLE;
		return this;
	}
	public ELCORegisterEntryDTO withFWELIGIBLE2(String FWELIGIBLE2) {
		this.FWELIGIBLE2 = FWELIGIBLE2;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMCOUNTRY(String FWWOMCOUNTRY) {
		this.FWWOMCOUNTRY = FWWOMCOUNTRY;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMDIVISION(String FWWOMDIVISION) {
		this.FWWOMDIVISION = FWWOMDIVISION;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMDISTRICT(String FWWOMDISTRICT) {
		this.FWWOMDISTRICT = FWWOMDISTRICT;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMUPAZILLA(String FWWOMUPAZILLA) {
		this.FWWOMUPAZILLA = FWWOMUPAZILLA;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMUNION(String FWWOMUNION) {
		this.FWWOMUNION = FWWOMUNION;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMWARD(String FWWOMWARD) {
		this.FWWOMWARD = FWWOMWARD;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMSUBUNIT(String FWWOMSUBUNIT) {
		this.FWWOMSUBUNIT = FWWOMSUBUNIT;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMMAUZA_PARA(String FWWOMMAUZA_PARA) {
		this.FWWOMMAUZA_PARA = FWWOMMAUZA_PARA;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMGOBHHID(String FWWOMGOBHHID) {
		this.FWWOMGOBHHID = FWWOMGOBHHID;
		return this;
	}
	public ELCORegisterEntryDTO withFWWOMGPS(String FWWOMGPS) {
		this.FWWOMGPS = FWWOMGPS;
		return this;
	}
	public ELCORegisterEntryDTO withform_name(String form_name) {
		this.form_name = form_name;
		return this;
	}
	public ELCORegisterEntryDTO withDetails(Map<String, String> details) {
        this.details = new HashMap<>(details);
        return this;
    }
	public ELCORegisterEntryDTO withPSRFDETAILS(List<Map<String, String>> PSRFDETAILS) {
		this.PSRFDETAILS = PSRFDETAILS;
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