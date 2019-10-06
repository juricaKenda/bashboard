package com.bashboard.api.usecases;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.api.model.PageContainer;
import com.bashboard.api.persistence.CommandCache;
import com.bashboard.api.persistence.PageContainerRepository;
import com.bashboard.commandline.model.commands.Command;
import com.bashboard.commandline.model.commands.OpenCommand;

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
