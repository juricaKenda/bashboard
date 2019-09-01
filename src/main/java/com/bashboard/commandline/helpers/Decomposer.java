package com.bashboard.commandline.helpers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Decomposer {

	
	public List<String> decompose(String input){
		return Arrays.asList(input.split(" "));
	}
}
