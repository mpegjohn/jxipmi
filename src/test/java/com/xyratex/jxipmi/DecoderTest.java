package com.xyratex.jxipmi;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DecoderTest {

	Decoder decoder;
	
	@Before
	public void setup() {
		this.decoder = new Decoder();
	}
	
	@Test
	public void addEnumTest() {
		
		Map<Integer, String> anEnum = new HashMap<Integer, String>();
		anEnum.put(1, "zero");
		anEnum.put(22, "one");
		
		this.decoder.addEnum("first enum", anEnum);
	}

	@Test
	public void setOverlayTest() {
		
		String [] overlay = {
				"byte", "status",
				"enum2", "something"
				};
		
		int rc = this.decoder.setOverlay(overlay);
		
		assertEquals(0, rc);
	}

	@Test
	public void setOverlayTwiceTest() {
		
		String [] overlay = {
				"byte", "status",
				"enum2", "something"
				};
		
		this.decoder.setOverlay(overlay);
		int rc =this.decoder.setOverlay(overlay);
		assertEquals(1, rc);
	}
	
	@Test
	public void setRawTest() {
		
		int [] raw = {
				1, 2, 4, 5
		};
		
		this.decoder.setRaw(raw);
	}
	
	@Test
	public void decodeByteTest() {

		String [] overlay = {
				"byte", "status",
				};
		this.decoder.setOverlay(overlay);
		
		int [] raw = {
				1, 2, 4, 5
		};
		
		this.decoder.setRaw(raw);
		
		this.decoder.decode();
	}	

}
