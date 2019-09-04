package com.bashboard.commandline.model;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bashboard.model.PageContainer;

public class TagArgument extends Argument implements DisplayingArgument{

	@Override
	String getSignature() {
		return "tag";
	}

	@Override
	public Predicate<PageContainer> getPredicate(){
		return p -> p.getTags().stream()
				.map(tag->tag.toString().toLowerCase())
				.collect(Collectors.toList())
				.contains(argument);
	}
}
