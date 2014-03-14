package com.xyratex.jxipmi;

import com.xyratex.jxipmi.ipmitool.CmdShell;

import java.io.IOException;
import java.util.List;

public class IpmiInterface {
	
	private final CmdShell cmdShell;
	
	public IpmiInterface(CmdShell cmdShell) {
		this.cmdShell = cmdShell;
	}
	

	public void sendCommand(List<String> cmd) {
		
		int status = cmdShell.execCmd(cmd);
		
	}
	
	
}
