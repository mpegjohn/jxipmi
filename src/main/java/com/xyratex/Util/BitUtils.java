package com.xyratex.Util;

public class BitUtils {

	public static int getBits(int data, int offset, int length) {
		
		int mask = 0xFFFFFFFF << (offset + length);
		
		mask = mask & 0xFFFFFFFF;
		mask = ~mask;
		
		int retData = data & mask;
		
		retData = retData >> offset;
		
		return retData;
	}
	
	public static int byteArrayToInt(byte [] byteArrayIn) {

		int value = 0;
		int mask = 0xFFFFFFFF;
		
		for (byte b: byteArrayIn) {
			b &= 0xff;
			value = (value << 8) + b;
			mask = mask << 8;
		}
		mask = ~mask;
		
		value &= mask;
		return value;
	}
	
	
}
