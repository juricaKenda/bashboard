package com.bashboard.commandline.helpers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.Tag;
import com.bashboard.commandline.model.dto.CommandForm;

@Component
public class CommandFormValidator {

	
	public boolean validateSingleCommand(List<CommandForm> forms) {
		return forms.stream()
				.filter(form -> form.getTag().equals(Tag.COMMAND))
				.count() == 1;
	}
	
	public boolean validateRootCommand(List<CommandForm> forms) {
		return forms.get(0).getTag().equals(Tag.COMMAND);
	}
}
