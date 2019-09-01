package com.bashboard.commandline.helpers;

import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.Tag;

import java.util.List;

@Component
public class InputValidator {

	public boolean validateEvenCount(List<String> parts) {
		return parts.size() % 2 == 0;
	}
	
	public boolean validateTags(List<String> parts) {
		for(int index=0; index < parts.size(); index++) {
			if(index % 2 == 0) {
				String tagElement = parts.get(index);
				if(!tagElement.startsWith("-")) {
//					TODO throw exception
					return false;
				}
			}
		}
		return true;
	}
	
}
