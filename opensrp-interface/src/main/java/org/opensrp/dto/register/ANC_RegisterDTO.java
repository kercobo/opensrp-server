package org.opensrp.dto.register;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class ANC_RegisterDTO {
	
    @JsonProperty
    private List<ANC_RegisterEntryDTO> ancRegisterEntries;

    public ANC_RegisterDTO(List<ANC_RegisterEntryDTO> ancRegisterEntries) {
        this.ancRegisterEntries = ancRegisterEntries;
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
