package com.bashboard.commandline.model.commands;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.bashboard.commandline.model.arguments.Argument;
import com.bashboard.model.PageContainer;
import com.bashboard.persistence.PageContainerRepository;

import lombok.ToString;
import lombok.experimental.Wither;


@ToString
public class DisplayingCommand extends Command{

	private final List<String> acceptableArgSignatures = Arrays.asList("rgx","tag");
	
	@Override
	public boolean accepts(String argumentSignature) {
		return acceptableArgSignatures.contains(argumentSignature);
	}

	@Override
	String getSignature() {
		return "ls";
	}

	@Override
	public List<PageContainer> execute(Object input){
		List<PageContainer> containers = (List<PageContainer>)input;
		return containers 
				.stream()
				.filter(makeRelevantPredicateChain(arguments).stream().reduce(each->true,Predicate::and))
				.collect(Collectors.toList());
	}

	private List<Predicate<PageContainer>> makeRelevantPredicateChain(List<Argument> arguments) {
		return arguments.stream()
				.map(argument -> (Argument)argument)
				.map(argument->argument.getPredicate())
				.collect(Collectors.toList());
	}
	
	
	
}
