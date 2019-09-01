package com.bashboard.commandline.model;

import javax.annotation.Generated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.Wither;

@ToString
public abstract class Argument {
	@Setter
	String argument;
	abstract String getSignature();
	
}
