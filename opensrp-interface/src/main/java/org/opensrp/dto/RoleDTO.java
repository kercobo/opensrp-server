package org.opensrp.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class RoleDTO {

	@JsonProperty
	private String userName;
	@JsonProperty
	private String roleName;
	@JsonProperty
	private String roleId;
	@JsonProperty
	private String status;

	public RoleDTO(String userName, String roleName,String roleId,String status) {
		this.userName = userName;
		this.roleName = roleName;
		this.roleId = roleId;
		this.status = status;
	}

	public RoleDTO() {

	}
	public RoleDTO withRoleName(String roleName){
		this.roleName = roleName;
		return this;
	}
	public RoleDTO withUserName(String userName){
		this.userName = userName;
		return this;
	}
	public RoleDTO withRoleId(String roleId){
		this.roleId = roleId;
		return this;
	}
	public RoleDTO withStatus(String status){
		this.status = status;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getRoleId() {
		return roleId;
	}
	public String getStatus() {
		return status;
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
