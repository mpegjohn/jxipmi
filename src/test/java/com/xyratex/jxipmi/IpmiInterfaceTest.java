package com.xyratex.jxipmi;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.xyratex.jxipmi.ipmitool.CmdShell;;

public class IpmiInterfaceTest {

	@Mock
	private CmdShell cmdShellMock;
	
	@Before
	public void initialize() {
		MockitoAnnotations.initMocks(this);
		//this.cmdShellMock = mock(CmdShell.class);
	}
	
	@Test
	public void sendCommandReserveSdrRepositoryTest() {
		IpmiInterface ipmiInterface = new IpmiInterface(cmdShellMock);
		
		List<Integer> cmd = new ArrayList<Integer>();

		List<String> ipmitoolCmd = new ArrayList<String>();
		
		ipmitoolCmd.add("ipmitool");
		ipmitoolCmd.add("raw");
		ipmitoolCmd.add("0x0a");
		ipmitoolCmd.add("0x22");
		
		
		when(cmdShellMock.execCmd(ipmitoolCmd)).thenReturn(0);
		
		List<String> mockCmdReturn = new ArrayList<String>();
		mockCmdReturn.add(" 04 00\n");
		
		when(cmdShellMock.getCommandOutput()).thenReturn(mockCmdReturn);
		
		ipmiInterface.sendCommand("storage", "reserve_sdr_repository", cmd);

		verify(cmdShellMock).execCmd(ipmitoolCmd);
		
		List<Integer> ipmiOutput = ipmiInterface.getOutput();
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(4);
		expected.add(0);
		
		assertEquals(expected, ipmiOutput);
	}
}
