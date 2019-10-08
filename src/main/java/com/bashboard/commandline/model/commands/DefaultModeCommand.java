package com.bashboard.commandline.model.commands;

import java.util.Arrays;

import com.bashboard.commandline.model.CommandResponse;

public class DefaultModeCommand extends Command {

	{
		signature = "defaultmode";
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
		return new CommandResponse(Arrays.asList("/"),this);
	}

}
