package org.opensrp.register.mcare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class HHRegisterEntry {

	private String CASEID;
	
	private String INSTANCEID;
	
	private String PROVIDERID;
	
	private String LOCATIONID;
	
	private String TODAY;
	
	private String START;
	
	private String END;
	
	private String FWNHREGDATE;
	
	private String FWGOBHHID; 
	
	private String FWJIVHHID;
	
	private String FWCOUNTRY;

	private String FWDIVISION;

	private String FWDISTRICT;
	
	private String FWUPAZILLA;
	
	private String FWUNION;
	
	private String FWWARD;
	
	private String FWSUBUNIT;
	
	private String FWMAUZA_PARA;
	
	private String FWNHHHGPS;
	
	private String form_name;
	
	private String FWHOHFNAME;
	
	private String FWHOHLNAME;
	
	private String FWHOHBIRTHDATE; 
	
	private String FWHOHGENDER;
	
	private String FWNHHMBRNUM;
	
	private String FWNHHMWRA;

	private String ELCO;
	
	private String user_type;

	private String external_user_ID;
	
	private List<Map<String, String>> ELCODETAILS;
	
	private Map<String, String> details;
	
	public HHRegisterEntry() {

		this.ELCODETAILS = new ArrayList<>();
	}

	public HHRegisterEntry withCASEID(String CASEID) {
		this.CASEID = CASEID;
		return this;
	}
	
	public HHRegisterEntry withINSTANCEID(String INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
		return this;
	}
	
	public HHRegisterEntry withPROVIDERID(String PROVIDERID) {
		this.PROVIDERID = PROVIDERID;
		return this;
	}

	public HHRegisterEntry withLOCATIONID(String LOCATIONID) {
		this.LOCATIONID = LOCATIONID;
		return this;
	}

	public HHRegisterEntry withTODAY(String TODAY) {
		this.TODAY = TODAY;
		return this;
	}

	public HHRegisterEntry withSTART(String START) {
		this.START = START;
		return this;
	}

	public HHRegisterEntry withEND(String END) {
		this.END = END;
		return this;
	}

	public HHRegisterEntry withFWNHREGDATE(String FWNHREGDATE) {
		this.FWNHREGDATE = FWNHREGDATE;
		return this;
	}

	public HHRegisterEntry withFWGOBHHID(String FWGOBHHID) {
		this.FWGOBHHID = FWGOBHHID;
		return this;
	}

	public HHRegisterEntry withFWJIVHHID(String FWJIVHHID) {
		this.FWJIVHHID = FWJIVHHID;
		return this;
	}

	public HHRegisterEntry withFWNHHHGPS(String FWNHHHGPS) {
		this.FWNHHHGPS = FWNHHHGPS;
		return this;
	}
	
	public HHRegisterEntry withform_name(String form_name) {
		this.form_name = form_name;
		return this;
	}

	public HHRegisterEntry withFWHOHFNAME(String FWHOHFNAME) {
		this.FWHOHFNAME = FWHOHFNAME;
		return this;
	}
	
	public HHRegisterEntry withFWCOUNTRY(String FWCOUNTRY) {
		this.FWCOUNTRY = FWCOUNTRY;
		return this;
	}
	
	public HHRegisterEntry withFWDIVISION(String FWDIVISION) {
		this.FWDIVISION = FWDIVISION;
		return this;
	}

	public HHRegisterEntry withFWDISTRICT(String FWDISTRICT) {
		this.FWDISTRICT = FWDISTRICT;
		return this;
	}

	public HHRegisterEntry withFWUPAZILLA(String FWUPAZILLA) {
		this.FWUPAZILLA = FWUPAZILLA;
		return this;
	}

	public HHRegisterEntry withFWUNION(String FWUNION) {
		this.FWUNION = FWUNION;
		return this;
	}

	public HHRegisterEntry withFWWARD(String FWWARD) {
		this.FWWARD = FWWARD;
		return this;
	}

	public HHRegisterEntry withFWSUBUNIT(String FWSUBUNIT) {
		this.FWSUBUNIT = FWSUBUNIT;
		return this;
	}

	public HHRegisterEntry withFWMAUZA_PARA(String FWMAUZA_PARA) {
		this.FWMAUZA_PARA = FWMAUZA_PARA;
		return this;
	}
	
	public HHRegisterEntry withFWHOHLNAME(String FWHOHLNAME) {
		this.FWHOHLNAME = FWHOHLNAME;
		return this;
	}

	public HHRegisterEntry withFWHOHBIRTHDATE(String FWHOHBIRTHDATE) {
		this.FWHOHBIRTHDATE = FWHOHBIRTHDATE;
		return this;
	}

	public HHRegisterEntry withFWNHHMBRNUM(String FWNHHMBRNUM) {
		this.FWNHHMBRNUM = FWNHHMBRNUM;
		return this;
	}

	public HHRegisterEntry withFWHOHGENDER(String FWHOHGENDER) {
		this.FWHOHGENDER = FWHOHGENDER;
		return this;
	}
	
	public HHRegisterEntry withFWNHHMWRA(String FWNHHMWRA) {
		this.FWNHHMWRA = FWNHHMWRA;
		return this;
	}

	public HHRegisterEntry withELCO(String ELCO) {
		this.ELCO = ELCO;
		return this;
	}
	
	public HHRegisterEntry withuser_type(String user_type) {
		this.user_type = user_type;
		return this;
	}

	public HHRegisterEntry withexternal_user_ID(String external_user_ID) {
		this.external_user_ID = external_user_ID;
		return this;
	}

	public HHRegisterEntry withELCODETAILS(List<Map<String, String>> ELCODETAILS) {
		this.ELCODETAILS = ELCODETAILS;
		return this;
	}
	
	public HHRegisterEntry withDetails(Map<String, String> details) {
        this.details = new HashMap<>(details);
        return this;
    }
	
	public String CASEID() {
		return CASEID;
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

	private String getCASEID() {
		return CASEID;
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