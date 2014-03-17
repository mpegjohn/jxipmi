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
	
	
}
