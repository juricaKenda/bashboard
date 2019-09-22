package com.bashboard.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bashboard.commandline.model.commands.Command;
import com.bashboard.commandline.model.commands.DisplayingCommand;
import com.bashboard.commandline.model.commands.OpenCommand;
import com.bashboard.commandline.utils.Parser;
import com.bashboard.model.ErrorContainer;
import com.bashboard.model.InputContainer;
import com.bashboard.model.PageContainer;
import com.bashboard.model.usecases.UseCase;
import com.bashboard.persistence.PageContainerRepository;
import com.bashboard.services.CommandDelegatingService;
import com.bashboard.services.PageContainerDelegatingService;
import com.bashboard.services.PageContainerInsertingService;


@Controller
public class RestRequestController {

	@Autowired
	private PageContainerDelegatingService pageContainerDelegatingService;
	@Autowired
	private PageContainerInsertingService pageContainerInsertingService;
	@Autowired
	private Parser parser;
	@Autowired
	private PageContainerRepository repository;
	@Autowired
	private CommandDelegatingService commandDelegatingService;

	private HashMap<String,Command> tempRequestStorage = new HashMap<>();
	
	
	@GetMapping("/board")
	public String welcomePage(Model model) {
		//TODO remove later and import from input
		pageContainerInsertingService.insertAllDefault();
		HashMap<String, List<PageContainer>> defaultClusters = pageContainerDelegatingService.getDefaultClusters();
		
		model.addAllAttributes(defaultClusters);
		model.addAttribute("inputContainer", new InputContainer());
		return "defaultCluster";
	}
	
	@PostMapping("/board")
	public String displayFavicon(Model model,InputContainer input) {
		//TODO remove later and import from input
		pageContainerInsertingService.insertAllDefault();
		Command command = parser.parse(input.getText());
		tempRequestStorage.put(command.toString(), command);
		UseCase useCase = commandDelegatingService.getUseCaseFor(command);
		
		return useCase.getRedirect();
	}
	
	@GetMapping("/openPage")
	public ModelAndView openPage(@RequestParam String commandHash) {
		OpenCommand command = (OpenCommand)tempRequestStorage.get(commandHash);
		List<PageContainer> allContainers = repository.getAllContainers();
		
		return new ModelAndView("redirect:"+command.execute(allContainers));
	}
	
	@GetMapping("/displayPages")
	public String displayPages(@RequestParam String commandHash,Model model) {
		DisplayingCommand command = (DisplayingCommand)tempRequestStorage.get(commandHash);
		List<PageContainer> allContainers = repository.getAllContainers();
		List<PageContainer> result = command.execute(allContainers);
		
		model.addAllAttributes(pageContainerDelegatingService.getClusters(result));
		model.addAttribute("inputContainer", new InputContainer());
		return "defaultCluster";
	}
}
