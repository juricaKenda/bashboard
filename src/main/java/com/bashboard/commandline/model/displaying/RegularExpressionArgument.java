package com.bashboard.commandline.model.displaying;

import java.util.function.Predicate;

import com.bashboard.commandline.model.Argument;
import com.bashboard.model.PageContainer;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class RegularExpressionArgument extends DisplayingArgument{

	@Override
	public String getSignature() {
		return "rgx";
	}

	@Override
	public Predicate<PageContainer> getPredicate(){
		return p -> p.getLink().contains(argument);
	}
}
