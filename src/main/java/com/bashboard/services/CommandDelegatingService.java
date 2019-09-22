package com.bashboard.services;

import org.springframework.stereotype.Service;

import com.bashboard.commandline.model.commands.Command;
import com.bashboard.commandline.model.commands.DisplayingCommand;
import com.bashboard.commandline.model.commands.OpenCommand;
import com.bashboard.model.usecases.DisplayPagesUseCase;
import com.bashboard.model.usecases.OpenPageUseCase;
import com.bashboard.model.usecases.UseCase;

@Service
public class CommandDelegatingService {

	public UseCase getUseCaseFor(Command command) {
		if(command instanceof OpenCommand) {
			return new OpenPageUseCase((OpenCommand)command);
		}else if(command instanceof DisplayingCommand) {
			return new DisplayPagesUseCase((DisplayingCommand)command);
		}
		return null;
	}

}
