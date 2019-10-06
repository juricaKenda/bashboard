package com.bashboard.commandline.helpers;

import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.CommandTag;

import java.util.List;

@Component
public class InputValidator {

	public boolean validateEvenCount(List<String> parts) {
		if(parts.size() % 2 == 0 && parts.size() > 0) {
			return true;
		}
		throw new InvalidNumberOfInputValuesException("Invalid number of input values!",String.join(" ",parts));
	}
	
	public boolean validateTags(List<String> parts) {
		for(int index=0; index < parts.size(); index++) {
			if(index % 2 == 0) {
				String tagElement = parts.get(index);
				if(!tagElement.startsWith("-")) {
					throw new TagsNotPresentException("Neccessary tags not present in the given input!",String.join(" ",parts));
				}
			}
		}
		return true;
	}
	
	
	class TagsNotPresentException extends RuntimeException{
		private String message;
		private String input; 
		public TagsNotPresentException(String messsage,String invalidInput) {
			super(messsage);
			this.input = invalidInput;
		}
	}
	
	class InvalidNumberOfInputValuesException extends RuntimeException{
		private String message;
		private String input; 
		public InvalidNumberOfInputValuesException(String messsage,String invalidInput) {
			super(messsage);
			this.input = invalidInput;
		}
	}
	
}
