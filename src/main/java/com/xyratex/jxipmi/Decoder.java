package com.xyratex.jxipmi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;

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
		
		int rawByteOffset = 0;
		int rawBitOffset = 7;
		
		for(int i = 0; i < overlay.length;) {
			
			String fieldInfo = overlay[i++];
			String fieldName = overlay[i++];
			
			int numFields = 1;
			String decodeType = fieldInfo;
			
			Pattern pattern = Pattern.compile("^(.*?)(\\d+)$");
			Matcher matcher = pattern.matcher(fieldInfo);
			
			if(matcher.find())
			{
				decodeType = matcher.group(1);
				numFields = Integer.parseInt(matcher.group(2));
			}
			
			if(decodeType.equals("byte")) {
				
				int [] rawSlice = Arrays.copyOfRange(raw, rawByteOffset, numFields -1);
				
				ArrayUtils.reverse(raw);
			}
		}
		
		
	}

}
