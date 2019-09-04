package com.bashboard.commandline.model;

import javax.annotation.Generated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.Wither;

public interface Argument {
	
	String getSignature();
	void setArgument(String argument);
}
