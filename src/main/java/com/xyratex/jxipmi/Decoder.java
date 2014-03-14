package com.xyratex.jxipmi;

import java.util.HashMap;
import java.util.Map;

public class Decoder {

	private Map<String, Map<Integer, String>> enums;

	private String[] overlay;
	
	private int [] raw;

	public void setRaw(int[] raw) {
		this.raw = raw;
	}

	public int setOverlay(String[] overlay) {
		if (this.overlay != null) {
			return 1;
		}
		this.overlay = overlay;
		return 0;
	}

	public Decoder() {
		this.enums = new HashMap<String, Map<Integer, String>>();
	}

	public int addEnum(String name, Map<Integer, String> enum_in) {
		enums.put(name, enum_in);
		return 0;
	}
	
	public void decode() {
		
		
	}

}
