package com.bashboard.commandline.model.commands;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bashboard.commandline.model.arguments.Argument;
import com.bashboard.model.PageContainer;

import lombok.NonNull;

public class OpenCommand extends Command {

	
	private final List<String> acceptableArgSignatures = Arrays.asList("rgx");
	
	@Override
	public boolean accepts(String argumentSignature) {
		return acceptableArgSignatures.contains(argumentSignature);
	}

	@Override
	String getSignature() {
		return "opn";
	}

	@Override
	public String execute(Object input) {
		List<PageContainer> containers = (List<PageContainer>)input;
		return containers.stream()
		.filter(makeRelevantPredicateChain(arguments).stream().reduce(each->true,Predicate::and))
		.map(pageContainer->pageContainer.getLink())
		.findFirst()
		.orElse("default");
	}
	
	private List<Predicate<PageContainer>> makeRelevantPredicateChain(List<Argument> arguments) {
		return arguments.stream()
				.map(argument -> (Argument)argument)
				.map(argument->argument.getPredicate())
				.collect(Collectors.toList());
	}

}
