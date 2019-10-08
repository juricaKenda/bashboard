package com.bashboard.api.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.api.persistence.CommandCache;
import com.bashboard.commandline.model.commands.Command;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CacheCommandUseCase {
		
	private final CommandCache commandCache;
	
	public void cacheCommand(Command command) {
		commandCache.setCachedCommand(command);
	}
}
