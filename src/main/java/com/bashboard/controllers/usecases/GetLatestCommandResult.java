package com.bashboard.controllers.usecases;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.commandline.model.commands.Command;
import com.bashboard.commandline.model.commands.OpenCommand;
import com.bashboard.model.PageContainer;
import com.bashboard.persistence.CommandCache;
import com.bashboard.persistence.PageContainerRepository;

@Component
public class GetLatestCommandResult {

	@Autowired
	private PageContainerRepository repository;
	@Autowired
	private CommandCache commandCache;
	
	public Object getLatestCommandResult() {
		Command command = commandCache.getLatestCommand();
		List<PageContainer> allContainers = repository.getAllContainers();
		return command.execute(allContainers);
	}
}
