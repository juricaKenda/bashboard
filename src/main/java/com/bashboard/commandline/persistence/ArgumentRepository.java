package com.bashboard.commandline.persistence;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.bashboard.commandline.model.Argument;
import com.bashboard.commandline.model.RegularExpressionArgument;
import com.bashboard.commandline.model.TagArgument;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

@Repository
public class ArgumentRepository {


	private final HashMap<String,Argument> repository = initializeRepository();

	private HashMap<String, Argument> initializeRepository() {
		HashMap<String, Argument> map = new HashMap<>();
		map.put("rgx",new RegularExpressionArgument());
		map.put("tag",new TagArgument());
		return map;
	}
	
	public Argument getArgumentByAlias(String alias) {
		return repository.get(alias);
	}
}
