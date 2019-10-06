package com.bashboard.commandline.model.commands;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.bashboard.api.model.PageContainer;
import com.bashboard.api.persistence.PageContainerRepository;
import com.bashboard.commandline.model.CommandResponse;
import com.bashboard.commandline.model.arguments.Argument;

import lombok.ToString;
import lombok.experimental.Wither;

public class DisplayingCommand extends Command{

	{
		signature = "ls";
	}
	private final List<String> acceptableArgSignatures = Arrays.asList("rgx","tag");
	
	@Override
	public boolean accepts(String argumentSignature) {
		return acceptableArgSignatures.contains(argumentSignature);
	}

	@Override
	String getSignature() {
		return signature;
	}

	@Override
	public CommandResponse execute(Object input){
		List<PageContainer> containers = (List<PageContainer>)input;
		List<PageContainer> list = containers 
				.stream()
				.filter(makeRelevantPredicateChain(arguments).stream().reduce(each->true,Predicate::and))
				.collect(Collectors.toList());
		return new CommandResponse(list,this);
	}

	private List<Predicate<PageContainer>> makeRelevantPredicateChain(List<Argument> arguments) {
		return arguments.stream()
				.map(argument -> (Argument)argument)
				.map(argument->argument.getPredicate())
				.collect(Collectors.toList());
	}
	
	
	
}
