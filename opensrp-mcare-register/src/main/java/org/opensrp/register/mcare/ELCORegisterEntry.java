package org.opensrp.register.mcare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ELCORegisterEntry {
	
	private String CASEID;
	
	private String INSTANCEID;
	
	private String LOCATIONID;
	
	private String PROVIDERID;
	
	private String TODAY;
	
	private String START;
	
	private String END;
	
	private String WomanREGDATE;
	
	private String FWNHWOMSTRMEN;

	private String FWNHWOMHUSALV;

	private String FWNHWOMHUSLIV;

	private String FWNHWOMHUSSTR;
	
	private String GOBHHID;
	
	private String JiVitAHHID;
	
	private String existing_ELCO;

	private String new_ELCO;
	
	private String ELCO;
	
	private String FWCENDATE;
	
	private String FWCENSTAT;
	
	private String FWWOMFNAME;
	
	private String FWWOMLNAME;
	
	private String FWWOMANYID;
	
	private String FWWOMNID;
	
	private String FWWOMRETYPENID;
	
	private String FWWOMRETYPENID_CONCEPT;
	
	private String FWWOMBID;
	
	private String FWWOMRETYPEBID;
	
	private String FWWOMRETYPEBID_CONCEPT;
	
	private String FWHUSNAME;
	
	private String FWBIRTHDATE;
	
	private String FWGENDER;
	
	private String FWWOMAGE;
	
	private String FWDISPLAYAGE;
	
	private String FWWOMSTRMEN;
	
	private String FWWOMHUSALV;
	
	private String FWWOMHUSSTR;
	
	private String FWWOMHUSLIV;
	
	private String FWELIGIBLE;
	
	private String FWELIGIBLE2;
	
	private String FWWOMCOUNTRY;
	
	private String FWWOMDIVISION;
	
	private String FWWOMDISTRICT;
	
	private String FWWOMUPAZILLA;
	
	private String FWWOMUNION;
	
	private String FWWOMWARD;
	
	private String FWWOMSUBUNIT;
	
	private String FWWOMMAUZA_PARA;
	
	private String FWWOMGOBHHID;
	
	private String FWWOMGPS;
	
	private String form_name;
	
	private Map<String, String> details;
	
	private List<Map<String, String>> PSRFDETAILS;

	public ELCORegisterEntry() {

	}
	
	public ELCORegisterEntry withCASEID(String CASEID) {
		this.CASEID = CASEID;
		return this;
	}
	public ELCORegisterEntry withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}
	public ELCORegisterEntry withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}
	public ELCORegisterEntry withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}
	public ELCORegisterEntry withTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}
	public ELCORegisterEntry withSTART(String START) {
		this.START = START;
		return this;
	}
	public ELCORegisterEntry withEND(String END) {
		this.END = END;
		return this;
	}
	public ELCORegisterEntry withWomanREGDATE(String WomanREGDATE) {
		this.WomanREGDATE = WomanREGDATE;
		return this;
	}
	public ELCORegisterEntry withFWNHWOMSTRMEN(String FWNHWOMSTRMEN) {
		this.FWNHWOMSTRMEN = FWNHWOMSTRMEN;
		return this;
	}
	public ELCORegisterEntry withFWNHWOMHUSALV(String FWNHWOMHUSALV) {
		this.FWNHWOMHUSALV = FWNHWOMHUSALV;
		return this;
	}
	public ELCORegisterEntry withFWNHWOMHUSLIV(String FWNHWOMHUSLIV) {
		this.FWNHWOMHUSLIV = FWNHWOMHUSLIV;
		return this;
	}
	public ELCORegisterEntry withFWNHWOMHUSSTR(String FWNHWOMHUSSTR) {
		this.FWNHWOMHUSSTR = FWNHWOMHUSSTR;
		return this;
	}
	public ELCORegisterEntry withGOBHHID(String GOBHHID) {
		this.GOBHHID = GOBHHID;
		return this;
	}
	public ELCORegisterEntry withJiVitAHHID(String JiVitAHHID) {
		this.JiVitAHHID = JiVitAHHID;
		return this;
	}	
	public ELCORegisterEntry withexisting_ELCO(String existing_ELCO) {
		this.existing_ELCO = existing_ELCO;
		return this;
	}
	
	public ELCORegisterEntry withnew_ELCO(String new_ELCO) {
		this.new_ELCO = new_ELCO;
		return this;
	}
	
	public ELCORegisterEntry withELCO(String ELCO) {
		this.ELCO = ELCO;
		return this;
	}

	public ELCORegisterEntry withFWCENDATE(String FWCENDATE) {
		this.FWCENDATE = FWCENDATE;
		return this;
	}

	public ELCORegisterEntry withFWCENSTAT(String FWCENSTAT) {
		this.FWCENSTAT = FWCENSTAT;
		return this;
	}
	public ELCORegisterEntry withFWWOMFNAME(String FWWOMFNAME) {
		this.FWWOMFNAME = FWWOMFNAME;
		return this;
	}
	public ELCORegisterEntry withFWWOMLNAME(String FWWOMLNAME) {
		this.FWWOMLNAME = FWWOMLNAME;
		return this;
	}
	public ELCORegisterEntry withFWWOMANYID(String FWWOMANYID) {
		this.FWWOMANYID = FWWOMANYID;
		return this;
	}
	public ELCORegisterEntry withFWWOMNID(String FWWOMNID) {
		this.FWWOMNID = FWWOMNID;
		return this;
	}
	public ELCORegisterEntry withFWWOMRETYPENID(String FWWOMRETYPENID) {
		this.FWWOMRETYPENID = FWWOMRETYPENID;
		return this;
	}
	public ELCORegisterEntry withFWWOMRETYPENID_CONCEPT(String FWWOMRETYPENID_CONCEPT) {
		this.FWWOMRETYPENID_CONCEPT = FWWOMRETYPENID_CONCEPT;
		return this;
	}
	public ELCORegisterEntry withFWWOMBID(String FWWOMBID) {
		this.FWWOMBID = FWWOMBID;
		return this;
	}
	public ELCORegisterEntry withFWWOMRETYPEBID(String FWWOMRETYPEBID) {
		this.FWWOMRETYPEBID = FWWOMRETYPEBID;
		return this;
	}
	public ELCORegisterEntry withFWWOMRETYPEBID_CONCEPT(String FWWOMRETYPEBID_CONCEPT) {
		this.FWWOMRETYPEBID_CONCEPT = FWWOMRETYPEBID_CONCEPT;
		return this;
	}
	public ELCORegisterEntry withFWHUSNAME(String FWHUSNAME) {
		this.FWHUSNAME = FWHUSNAME;
		return this;
	}
	public ELCORegisterEntry withFWBIRTHDATE(String FWBIRTHDATE) {
		this.FWBIRTHDATE = FWBIRTHDATE;
		return this;
	}
	public ELCORegisterEntry withFWGENDER(String FWGENDER) {
		this.FWGENDER = FWGENDER;
		return this;
	}
	public ELCORegisterEntry withFWWOMAGE(String FWWOMAGE) {
		this.FWWOMAGE = FWWOMAGE;
		return this;
	}
	public ELCORegisterEntry withFWDISPLAYAGE(String FWDISPLAYAGE) {
		this.FWDISPLAYAGE = FWDISPLAYAGE;
		return this;
	}
	public ELCORegisterEntry withFWWOMSTRMEN(String FWWOMSTRMEN) {
		this.FWWOMSTRMEN = FWWOMSTRMEN;
		return this;
	}
	public ELCORegisterEntry withFWWOMHUSSTR(String FWWOMHUSSTR) {
		this.FWWOMHUSSTR = FWWOMHUSSTR;
		return this;
	}
	public ELCORegisterEntry withFWWOMHUSALV(String FWWOMHUSALV) {
		this.FWWOMHUSALV = FWWOMHUSALV;
		return this;
	}
	public ELCORegisterEntry withFWWOMHUSLIV(String FWWOMHUSLIV) {
		this.FWWOMHUSLIV = FWWOMHUSLIV;
		return this;
	}
	public ELCORegisterEntry withFWELIGIBLE(String FWELIGIBLE) {
		this.FWELIGIBLE = FWELIGIBLE;
		return this;
	}
	public ELCORegisterEntry withFWELIGIBLE2(String FWELIGIBLE2) {
		this.FWELIGIBLE2 = FWELIGIBLE2;
		return this;
	}
	public ELCORegisterEntry withFWWOMCOUNTRY(String FWWOMCOUNTRY) {
		this.FWWOMCOUNTRY = FWWOMCOUNTRY;
		return this;
	}
	public ELCORegisterEntry withFWWOMDIVISION(String FWWOMDIVISION) {
		this.FWWOMDIVISION = FWWOMDIVISION;
		return this;
	}
	public ELCORegisterEntry withFWWOMDISTRICT(String FWWOMDISTRICT) {
		this.FWWOMDISTRICT = FWWOMDISTRICT;
		return this;
	}
	public ELCORegisterEntry withFWWOMUPAZILLA(String FWWOMUPAZILLA) {
		this.FWWOMUPAZILLA = FWWOMUPAZILLA;
		return this;
	}
	public ELCORegisterEntry withFWWOMUNION(String FWWOMUNION) {
		this.FWWOMUNION = FWWOMUNION;
		return this;
	}
	public ELCORegisterEntry withFWWOMWARD(String FWWOMWARD) {
		this.FWWOMWARD = FWWOMWARD;
		return this;
	}
	public ELCORegisterEntry withFWWOMSUBUNIT(String FWWOMSUBUNIT) {
		this.FWWOMSUBUNIT = FWWOMSUBUNIT;
		return this;
	}
	public ELCORegisterEntry withFWWOMMAUZA_PARA(String FWWOMMAUZA_PARA) {
		this.FWWOMMAUZA_PARA = FWWOMMAUZA_PARA;
		return this;
	}
	public ELCORegisterEntry withFWWOMGOBHHID(String FWWOMGOBHHID) {
		this.FWWOMGOBHHID = FWWOMGOBHHID;
		return this;
	}
	public ELCORegisterEntry withFWWOMGPS(String FWWOMGPS) {
		this.FWWOMGPS = FWWOMGPS;
		return this;
	}
	public ELCORegisterEntry withform_name(String form_name) {
		this.form_name = form_name;
		return this;
	}
	public ELCORegisterEntry withDetails(Map<String, String> details) {
        this.details = new HashMap<>(details);
        return this;
    }
	public ELCORegisterEntry withPSRFDETAILS(List<Map<String, String>> PSRFDETAILS) {
		this.PSRFDETAILS = PSRFDETAILS;
		return this;
	}
	public String CASEID() {
		return CASEID;
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
	 private String getCASEID() {
	        return CASEID;
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