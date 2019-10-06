package com.bashboard.commandline.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.CommandTag;
import com.bashboard.commandline.model.dto.CommandForm;

@Component
public class CommandFormMapper {

	public List<CommandForm> mapToCommandForms(List<String> parts){
		List<CommandForm> forms = new ArrayList<>();
		for(int index=0; index < parts.size(); index+=2) {
			CommandForm commandForm = CommandForm.builder()
					.tag(CommandTag.of(parts.get(index).trim()))
					.value(parts.get(index+1).trim())
					.build();
			forms.add(commandForm);
		}
		return forms;
	}
}
