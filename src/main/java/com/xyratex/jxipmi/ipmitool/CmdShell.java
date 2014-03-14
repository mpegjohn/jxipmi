package com.xyratex.jxipmi.ipmitool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CmdShell {

	List<String> commandOutput;

	public List<String> getCommandOutput() {
		return commandOutput;
	}

	public CmdShell() {
		this.commandOutput = new ArrayList<String>();
	}

	public int execCmd(List<String> commandList) {

		this.commandOutput.clear();

		ProcessBuilder pb = new ProcessBuilder(commandList);
		pb.redirectErrorStream(true);

		Process process = null;
		try {
			process = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream()));

			String line;
			while ((line = br.readLine()) != null) {
				this.commandOutput.add(line);
			}

			return process.exitValue();
		} catch (IOException e) {
			this.commandOutput.add(e.getMessage());
			return 255;
		}
	}
}
