package com.bashboard.api.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.api.persistence.CommandCache;
import com.bashboard.commandline.Parser;
import com.bashboard.commandline.model.commands.Command;


@Component
public class ParseCommandUseCase {

	@Autowired
	private Parser parser;
	
	public Command parseCommand(String commandUnparsed) {
		return parser.parse(commandUnparsed);
	}
}
