package com.bashboard.persistence;

import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.commands.Command;

import lombok.Setter;

@Component
public class CommandCache {
	@Setter
	private Command cachedCommand;

	public Command getLatestCommand() {
		return cachedCommand;
	}
}
