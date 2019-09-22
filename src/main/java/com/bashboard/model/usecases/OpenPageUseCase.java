package com.bashboard.model.usecases;

import com.bashboard.commandline.model.commands.Command;
import com.bashboard.commandline.model.commands.OpenCommand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OpenPageUseCase extends UseCase{

	private OpenCommand openCommand;
	
	@Override
	public String getRedirect() {
		return "redirect:openPage?commandHash="+openCommand;
	}

	
}
