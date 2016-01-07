package org.opensrp.common.domain;

import org.codehaus.jackson.JsonNode;

public class DashboardLocation {
	private String name;
	private String tag;
	private JsonNode parent;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public JsonNode getParent() {
		return parent;
	}
	public void setParent(JsonNode parent) {
		this.parent = parent;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

}
