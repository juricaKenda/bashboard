package com.bashboard.commandline.model.commands;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.ResponseBody;

import com.bashboard.commandline.model.CommandResponse;
import com.bashboard.commandline.model.arguments.Argument;
import com.bashboard.model.PageContainer;

import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

public class OpenCommand extends Command {

	{
		signature = "opn";
	}
	private final List<String> acceptableArgSignatures = Arrays.asList("rgx");
	
	@Override
	public boolean accepts(String argumentSignature) {
		return acceptableArgSignatures.contains(argumentSignature);
	}

	@Override
	String getSignature() {
		return signature;
	}

	@Override
	public CommandResponse execute(Object input) {
		List<PageContainer> containers = (List<PageContainer>)input;
		@NonNull
		String link = containers.stream()
		.filter(makeRelevantPredicateChain(arguments).stream().reduce(each->true,Predicate::and))
		.map(pageContainer->pageContainer.getLink())
		.findFirst()
		.orElse("default");
		return new CommandResponse(Arrays.asList(link),this);
	}
	
	private List<Predicate<PageContainer>> makeRelevantPredicateChain(List<Argument> arguments) {
		return arguments.stream()
				.map(argument -> (Argument)argument)
				.map(argument->argument.getPredicate())
				.collect(Collectors.toList());
	}

}
