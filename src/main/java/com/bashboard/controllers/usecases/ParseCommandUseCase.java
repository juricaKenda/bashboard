package com.bashboard.controllers.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.commandline.Parser;
import com.bashboard.commandline.model.commands.Command;
import com.bashboard.persistence.CommandCache;


@Component
public class ParseCommandUseCase {

	@Autowired
	private Parser parser;
	
	public Command parseCommand(String commandUnparsed) {
		return parser.parse(commandUnparsed);
	}
}
