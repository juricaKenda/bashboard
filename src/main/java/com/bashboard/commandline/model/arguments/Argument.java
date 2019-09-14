package com.bashboard.commandline.model.arguments;

import java.util.function.Predicate;

import com.bashboard.model.PageContainer;

import lombok.Setter;

public abstract class Argument{

	abstract String getSignature();
	public void setArgument(String argument) {
		this.argument = argument;
	}
	
	@Setter
	String argument;
	
	public abstract Predicate<PageContainer> getPredicate();
}
