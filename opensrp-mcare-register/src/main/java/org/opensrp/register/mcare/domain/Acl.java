package org.opensrp.register.mcare.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;

@TypeDiscriminator("doc.type === 'Acl'")
public class Acl extends MotechBaseDataObject {
	
	@JsonProperty
	private String roleName;
	@JsonProperty
	private String status;
	@JsonProperty
	private Map<String, String> accessTokens;

	public Acl()
	{
		accessTokens = new HashMap<String, String>();
	}
	public Acl withRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
	public Acl withStatus(String status) {
		this.status = status;
		return this;
	}
	
	public Acl withAccessTokens(Map<String, String> accessTokens) {
        this.accessTokens = new HashMap<>(accessTokens);
        return this;
    }
	
	public String getRoleName() {
		return roleName;
	}
	public String getStatus() {
		return status;
	}

	public Map<String, String> getAccessTokens() {
		return accessTokens;
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
