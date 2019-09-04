package com.bashboard.commandline.model;

import java.util.function.Predicate;

import com.bashboard.model.PageContainer;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class RegularExpressionArgument extends Argument implements DisplayingArgument{

	@Override
	String getSignature() {
		return "rgx";
	}

	@Override
	public Predicate<PageContainer> getPredicate(){
		return p -> p.getLink().contains(argument);
	}
}
