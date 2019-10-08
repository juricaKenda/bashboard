package com.bashboard.commandline.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bashboard.commandline.model.commands.ClearCommand;
import com.bashboard.commandline.model.commands.Command;
import com.bashboard.commandline.model.commands.DarkModeCommand;
import com.bashboard.commandline.model.commands.DefaultModeCommand;
import com.bashboard.commandline.model.commands.DisplayingCommand;
import com.bashboard.commandline.model.commands.OpenCommand;

@Repository
public class CommandRepository {

	private final HashMap<String,Command> repository = initializeRepository();

	private HashMap<String, Command> initializeRepository() {
		HashMap<String, Command> map = new HashMap<>();
		map.put("ls",new DisplayingCommand());
		map.put("opn", new OpenCommand());
		map.put("clear", new ClearCommand());
		map.put("darkmode", new DarkModeCommand());
		map.put("defaultmode", new DefaultModeCommand());
		return map;
	}
	
	public Command getCommandByAlias(String alias) {
		return repository.get(alias);
	}
}
