package com.bashboard.controllers;

import java.util.HashMap;
import java.util.List;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bashboard.commandline.model.Command;
import com.bashboard.commandline.model.dto.CommandPack;
import com.bashboard.commandline.utils.Parser;
import com.bashboard.model.ErrorContainer;
import com.bashboard.model.InputContainer;
import com.bashboard.model.PageContainer;
import com.bashboard.persistence.PageContainerRepository;
import com.bashboard.services.PageContainerDelegatingService;
import com.bashboard.services.PageContainerInsertingService;
import com.bashboard.services.PageContainerLoadingService;

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
			Object result = command.execute(repository.getAllContainers());
			model.addAllAttributes(pageContainerDelegatingService.getClusters((List<PageContainer>) result));
		}catch(RuntimeException e){
			HashMap<String, List<PageContainer>> defaultClusters = pageContainerDelegatingService.getDefaultClusters();
			model.addAllAttributes(defaultClusters);
			model.addAttribute("error", new ErrorContainer(e.getMessage()));
		}
		
		model.addAttribute("inputContainer", new InputContainer());
		return "defaultCluster";
	}
}
