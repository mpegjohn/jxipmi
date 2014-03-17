package com.xyratex.jxipmi;

import com.xyratex.jxipmi.ipmitool.CmdShell;
import com.google.common.base.*;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IpmiInterface {

	private final CmdShell cmdShell;
	private Map<String, String> netFn;
	private Map<String, String> cmdRef;
	private List<Integer> ipmiNumbers;
	private List<String> lastErrorString;

	public List<String> getLastErrorString() {
		return lastErrorString;
	}

	public IpmiInterface(CmdShell cmdShell) {
		this.cmdShell = cmdShell;

		// setup network function codes
		this.netFn = ImmutableMap.of("storage", "0x0a", "sensor", "0x04",
				"app", "0x06", "chassis", "0x00", "transport", "0x0c");

		// setup command codes
		this.cmdRef = ImmutableMap.of("get_sdr", "0x23",
				"get_sdr_repository_info", "0x20", "reserve_sdr_repository",
				"0x22", "get_sensor_reading", "0x2d");

		this.ipmiNumbers = new ArrayList<Integer>();

	}

	public void sendCommand(String netFn, String cmdRef, List<Integer> cmd_in) {

		List<String> cmd_out = new ArrayList<String>();
		cmd_out.add("ipmitool");
		cmd_out.add("raw");
		cmd_out.add(this.netFn.get(netFn));
		cmd_out.add(this.cmdRef.get(cmdRef));

		for (int cmd : cmd_in) {
			cmd_out.add(String.format("0x%02x", cmd));
		}

		int status = cmdShell.execCmd(cmd_out);

		if (status == 0) {

			for (String line : cmdShell.getCommandOutput()) {
				Iterable<String> numStringIterable = Splitter.on(" ")
						.omitEmptyStrings().trimResults().split(line);
				for (String numString : numStringIterable) {
					int value = Integer.parseInt(numString, 16);
					this.ipmiNumbers.add(value);
				}
			}
		}
		else {
			this.lastErrorString = cmdShell.getCommandOutput();
		}
	}

	public List<Integer> getOutput() {
		return this.ipmiNumbers;
	}
}
