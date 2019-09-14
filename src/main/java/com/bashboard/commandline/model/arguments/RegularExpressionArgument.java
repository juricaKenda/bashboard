package com.bashboard.commandline.model.arguments;

import java.util.function.Predicate;

import com.bashboard.model.PageContainer;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class RegularExpressionArgument extends Argument{

	@Override
	public String getSignature() {
		return "rgx";
	}

	@Override
	public Predicate<PageContainer> getPredicate(){
		return p -> p.getLink().contains(argument);
	}

}
