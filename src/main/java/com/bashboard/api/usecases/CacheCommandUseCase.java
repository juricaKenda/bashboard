package com.bashboard.api.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.api.persistence.CommandCache;
import com.bashboard.commandline.model.commands.Command;

@Component
public class CacheCommandUseCase {
	
	@Autowired
	private CommandCache commandCache;
	
	public void cacheCommand(Command command) {
		commandCache.setCachedCommand(command);
	}
}
