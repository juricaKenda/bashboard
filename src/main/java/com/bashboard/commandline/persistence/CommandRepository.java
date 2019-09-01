package com.bashboard.commandline.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bashboard.commandline.model.Command;
import com.bashboard.commandline.model.DisplayingCommand;

@Repository
public class CommandRepository {

	private final HashMap<String,Command> repository = initializeRepository();

	private HashMap<String, Command> initializeRepository() {
		HashMap<String, Command> map = new HashMap<>();
		map.put("ls",new DisplayingCommand());
		return map;
	}
	
	public Command getCommandByAlias(String alias) {
		return repository.get(alias);
	}
}
