package com.bashboard.commandline.helpers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.Tag;
import com.bashboard.commandline.model.dto.CommandForm;

@Component
public class CommandFormValidator {

	
	public boolean validateSingleCommand(List<CommandForm> forms) {
		if(forms.stream()
				.filter(form -> form.getTag().equals(Tag.COMMAND))
				.count() == 1) {
			return true;
		}
		throw new InvalidNumberOfCommandsException("Invalid number of command tags!");
	}
	
	public boolean validateRootCommand(List<CommandForm> forms) {
		if(forms.get(0).getTag().equals(Tag.COMMAND)) {
			return true;
		}
		throw new InvalidRootCommandException("Root of the expression should be a command!");
	}
	
	
	class InvalidNumberOfCommandsException extends RuntimeException{
		private String message;
		public InvalidNumberOfCommandsException(String messsage) {
			super(messsage);
		}
	}
	
	class InvalidRootCommandException extends RuntimeException{
		private String message;
		public InvalidRootCommandException(String messsage) {
			super(messsage);
		}
	}
}
