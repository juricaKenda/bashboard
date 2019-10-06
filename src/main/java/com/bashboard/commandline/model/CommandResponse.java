package com.bashboard.commandline.model;

import com.bashboard.commandline.model.commands.Command;

import lombok.Data;

@Data
public class CommandResponse {

	private final Object result;
	private final Command command;
}
