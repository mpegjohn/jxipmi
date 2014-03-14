package com.xyratex.jxipmi.yamlspecs;

import java.util.List;
import java.util.Map;

public class SdrHeaderSpec {
	public String name;
	
	public Map<String, Object> enums;
	
	private List<String> overlay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//public Map<String, Object> getEnums() {
	//	return enums;
	//}

	//public void setEnums(Map<String, Object> enums) {
	//	this.enums = enums;
	//}

	public List<String> getOverlay() {
		return overlay;
	}

	public void setOverlay(List<String> overlay) {
		this.overlay = overlay;
	}
	


	
}
