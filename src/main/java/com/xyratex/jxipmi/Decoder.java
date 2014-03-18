package com.xyratex.jxipmi;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;

public class Decoder {
	
	private List<Integer> decodedData;

	public List<Integer> getDecodedData() {
		return decodedData;
	}

	private Map<String, Map<Integer, String>> enums;

	private String[] overlay;
	
	private byte [] raw;

	public void setRaw(byte[] raw) {
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
		this.decodedData =  new ArrayList<Integer>();
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
				
				byte [] rawSlice = ArrayUtils.subarray(raw, rawByteOffset, rawByteOffset + numFields);
				ByteBuffer bb = ByteBuffer.wrap(rawSlice);
				
				
				int result = bb.getInt();
				this.decodedData.add(result);

			}
		}
	}
}
