package com.bashboard.commandline.helpers;

import java.util.ArrayList;
import java.util.List;

import javax.activation.CommandMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.Argument;
import com.bashboard.commandline.model.Command;
import com.bashboard.commandline.model.Tag;
import com.bashboard.commandline.model.dto.CommandForm;
import com.bashboard.commandline.model.dto.CommandPack;
import com.bashboard.commandline.persistence.ArgumentRepository;
import com.bashboard.commandline.persistence.CommandRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CommandPackMapper {

	@Autowired
	private final CommandRepository commandRepository;
	@Autowired
	private final ArgumentRepository argumentRepository;
	
	public CommandPack mapToCommandPack(List<CommandForm> commandForms) {
		return CommandPack.builder()
				.command(mapToCommand(commandForms.get(0)))
				.arguments(mapToArguments(commandForms))
				.build();
	}

	private Command mapToCommand(CommandForm command) {
		return commandRepository.getCommandByAlias(command.getValue());
	} 
	
	private List<Argument> mapToArguments(List<CommandForm> commandForms) {
		List<Argument> arguments = new ArrayList<>();
		Command command = commandRepository.getCommandByAlias(commandForms.remove(0).getValue());
		for(int index=0; index < commandForms.size()-1; index+=2) {
			CommandForm argumentPrefixContainer = commandForms.get(index);
			CommandForm argumentContainer = commandForms.get(index+1);
			if(argumentPrefixContainer.getTag().equals(Tag.ARGPREFIX) && argumentContainer.getTag().equals(Tag.ARGUMENT)) {
				if(command.accepts(argumentPrefixContainer.getValue())) {
					Argument argument = argumentRepository.getArgumentByAlias(argumentPrefixContainer.getValue());
					argument.setArgument(argumentContainer.getValue());
					arguments.add(argument);
				}else {
//					TODO throw exception inside accepts method
				}
			}else {
//				TODO throw exception
			}
		}
		return arguments;
	}

	
}
