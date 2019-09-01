package com.bashboard.commandline.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bashboard.commandline.helpers.CommandFormMapper;
import com.bashboard.commandline.helpers.CommandFormValidator;
import com.bashboard.commandline.helpers.CommandPackMapper;
import com.bashboard.commandline.helpers.Decomposer;
import com.bashboard.commandline.helpers.InputValidator;
import com.bashboard.commandline.model.Command;
import com.bashboard.commandline.model.dto.CommandForm;
import com.bashboard.commandline.model.dto.CommandPack;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class Parser {

	private final Decomposer decomposer;
	private final InputValidator inputValidator;
	private final CommandFormMapper commandFormMapper;
	private final CommandFormValidator commandFormValidator;
	private final CommandPackMapper commandPackMapper;
	
	public Command parse(String input) {
		List<String> parts = decomposer.decompose(input);
		inputValidator.validateEvenCount(parts);
		inputValidator.validateTags(parts);
		List<CommandForm> commandForms = commandFormMapper.mapToCommandForms(parts);
		commandFormValidator.validateSingleCommand(commandForms);
		commandFormValidator.validateRootCommand(commandForms);
		CommandPack commandPack = commandPackMapper.mapToCommandPack(commandForms);
		Command command = commandPack.getCommand();
		command.addArguments(commandPack.getArguments());
		return command;
	}
	
	
}
