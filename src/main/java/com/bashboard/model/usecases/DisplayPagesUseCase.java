package com.bashboard.model.usecases;

import com.bashboard.commandline.model.commands.DisplayingCommand;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class DisplayPagesUseCase extends UseCase{

	private DisplayingCommand displayCommand;
	
	@Override
	public String getRedirect() {
		return "redirect:displayPages?commandHash="+displayCommand;
	}

}
