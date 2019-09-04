package com.bashboard.commandline.model.displaying;

import java.util.function.Predicate;

import com.bashboard.commandline.model.Argument;
import com.bashboard.model.PageContainer;

import lombok.Setter;

public abstract class DisplayingArgument implements Argument{

	@Setter
	String argument;
	
	public abstract Predicate<PageContainer> getPredicate();
}
