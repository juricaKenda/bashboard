package com.bashboard.controllers;

import java.util.HashMap;
import java.util.List;

import com.bashboard.commandline.model.commands.Command;
import com.bashboard.commandline.model.commands.OpenCommand;
import com.bashboard.commandline.utils.Parser;
import com.bashboard.model.ErrorContainer;
import com.bashboard.model.InputContainer;
import com.bashboard.model.PageContainer;
import com.bashboard.persistence.PageContainerRepository;
import com.bashboard.services.PageContainerDelegatingService;
import com.bashboard.services.PageContainerInsertingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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
		try {
			Command command = parser.parse(input.getText());
//			TODO delegator for different command types
			Object result = command.execute(repository.getAllContainers());
			if(command instanceof OpenCommand) {
				return "redirect:open?href="+(String)result;
			}
			model.addAllAttributes(pageContainerDelegatingService.getClusters((List<PageContainer>) result));
		}catch(RuntimeException e){
			HashMap<String, List<PageContainer>> defaultClusters = pageContainerDelegatingService.getDefaultClusters();
			model.addAllAttributes(defaultClusters);
			model.addAttribute("error", new ErrorContainer(e.getMessage()));
		}
		
		model.addAttribute("inputContainer", new InputContainer());
		return "defaultCluster";
	}
	
	@GetMapping("/open")
	public ModelAndView redirect(@RequestParam String href) {
		return new ModelAndView("redirect:"+href);
	}
}
