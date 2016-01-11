package org.opensrp.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class AclDTO {

	@JsonProperty
	private String roleName;
	@JsonProperty
	private String roleId;
	@JsonProperty
	private String status;
	@JsonProperty
	private Map<String, String> accessTokens;

	public AclDTO(String roleName,String roleId, Map<String, String> accessTokens,String status) {
		this.roleName = roleName;
		this.roleId = roleId;
		this.accessTokens = accessTokens;
		this.status = status;	
	}
	public AclDTO(){
		
	}
	public AclDTO withRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
	public AclDTO withRoleId(String roleId) {
		this.roleId = roleId;
		return this;
	}
	public AclDTO withStatus(String status) {
		this.status = status;
		return this;
	}
	public AclDTO withAccessTokens(Map<String, String> accessTokens) {
        this.accessTokens = new HashMap<>(accessTokens);
        return this;
    }
	public String getRoleId() {
		return roleId;
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
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
