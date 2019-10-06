package com.bashboard.controllers.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.commands.Command;
import com.bashboard.persistence.CommandCache;

@Component
public class CacheCommandUseCase {
	
	@Autowired
	private CommandCache commandCache;
	
	public void cacheCommand(Command command) {
		commandCache.setCachedCommand(command);
	}
}
