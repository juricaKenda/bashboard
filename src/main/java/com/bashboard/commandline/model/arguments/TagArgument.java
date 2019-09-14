package com.bashboard.commandline.model.arguments;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.bashboard.model.PageContainer;

public class TagArgument extends Argument{

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
