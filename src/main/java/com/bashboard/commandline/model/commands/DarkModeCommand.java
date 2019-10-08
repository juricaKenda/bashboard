package com.bashboard.commandline.model.commands;

import java.util.Arrays;

import com.bashboard.commandline.model.CommandResponse;

public class DarkModeCommand extends Command{

	{
		signature = "darkmode";
	}
	@Override
	public boolean accepts(String argumentSignature) {
		return false;
	}

	@Override
	String getSignature() {
		return signature;
	}

	@Override
	public Object execute(Object input) {
		return new CommandResponse(Arrays.asList("/darkmode"),this);
	}

}
