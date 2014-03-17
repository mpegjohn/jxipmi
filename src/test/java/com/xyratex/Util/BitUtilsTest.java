package com.xyratex.Util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BitUtilsTest {

	@Test
	public void getBitsTest() {
		
		int  actual = BitUtils.getBits(0x2, 0, 2);
		
		assertEquals(0x2, actual);
		
		actual = BitUtils.getBits(0x80, 4, 4);
		assertEquals(0x8, actual);
		
		actual = BitUtils.getBits(0xA0, 5, 2);
		assertEquals(0x1, actual);
		
	}
	
	
}
