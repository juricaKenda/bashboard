package com.bashboard.commandline.model.commands;

import java.util.Arrays;
import java.util.Collections;

import com.bashboard.commandline.model.CommandResponse;

public class ClearCommand extends Command {
	
	{
		signature = "clear";
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
		return new CommandResponse(Collections.EMPTY_LIST,this);
	}

}
