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
		this.cmdShellMock = new CmdShell();
	}
	
	@Test
	public void testSendCommand() {
		IpmiInterface ipmiInterface = new IpmiInterface(cmdShellMock);
		
		List<String> cmd = new ArrayList<String>();
		
		cmd.add("ipmitool");
		cmd.add("lan");
		cmd.add("print");
		cmd.add("1");
		
		when(cmdShellMock.execCmd(cmd)).thenReturn(0);
		
		ipmiInterface.sendCommand(cmd);

		
		//when(cmdShellMock.getCommandOutput()).thenReturn()
	}
}
