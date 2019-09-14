package com.bashboard.commandline.model.commands;

import java.util.Arrays;
import java.util.List;

public class OpenCommand extends Command {

	
	private final List<String> acceptableArgSignatures = Arrays.asList("rgx");
	
	@Override
	public boolean accepts(String argumentSignature) {
		return acceptableArgSignatures.contains(argumentSignature);
	}

	@Override
	String getSignature() {
		return "opn";
	}

	@Override
	public String execute(Object input) {
		String href = (String)input;
		return "redirect:"+href;
	}

}
