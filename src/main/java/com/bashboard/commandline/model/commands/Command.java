package com.bashboard.commandline.model.commands;

import java.util.List;

import com.bashboard.commandline.model.arguments.Argument;

import lombok.Getter;


public abstract class Command{
	@Getter
	public String signature;
	public List<Argument> arguments;
	public abstract boolean accepts(String argumentSignature);
	abstract String getSignature();
	public abstract Object execute(Object input);
	public void addArguments(List<Argument> arguments) {
		this.arguments = arguments;
	}
	
}
