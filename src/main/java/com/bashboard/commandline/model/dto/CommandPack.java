package com.bashboard.commandline.model.dto;

import java.util.List;

import com.bashboard.commandline.model.Argument;
import com.bashboard.commandline.model.Command;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString
public class CommandPack {

	private final Command command;
	private final List<Argument> arguments;
	
	
}
