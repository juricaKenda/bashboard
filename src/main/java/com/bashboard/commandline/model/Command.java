package com.bashboard.commandline.model;

import java.util.List;

public abstract class Command{
	List<Argument> arguments;
	public abstract boolean accepts(String argumentSignature);
	abstract String getSignature();
	public abstract Object execute(Object input);
	public void addArguments(List<Argument> arguments) {
		this.arguments = arguments;
	}
}
