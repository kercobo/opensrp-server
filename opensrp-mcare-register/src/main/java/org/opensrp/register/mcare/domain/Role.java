package org.opensrp.register.mcare.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ektorp.support.TypeDiscriminator;
import org.motechproject.model.MotechBaseDataObject;

@TypeDiscriminator("doc.type === 'Role'")
public class Role extends MotechBaseDataObject {
	
	@JsonProperty
	private String userName;
	@JsonProperty
	private String roleName;
	@JsonProperty
	private String status;
	
	public Role(){
		
	}
	public Role withUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public Role withRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
	public Role withStatus(String status) {
		this.status = status;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getStatus() {
		return status;
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
