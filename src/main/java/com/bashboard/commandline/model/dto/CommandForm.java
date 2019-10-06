package com.bashboard.commandline.model.dto;

import com.bashboard.commandline.model.CommandTag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
@ToString
public class CommandForm {

	private final CommandTag tag;
	private final String value;
	
	
}
