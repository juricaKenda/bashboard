package com.bashboard.commandline.model.displaying;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bashboard.commandline.model.Argument;
import com.bashboard.model.PageContainer;

public class TagArgument extends DisplayingArgument{

	@Override
	public String getSignature() {
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
