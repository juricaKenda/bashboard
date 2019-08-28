package com.bashboard.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bashboard.model.PageContainer;
import com.bashboard.services.PageContainerDelegatingService;
import com.bashboard.services.PageContainerInsertingService;
import com.bashboard.services.PageContainerLoadingService;

@Controller
public class RestRequestController {

	@Autowired
	private PageContainerDelegatingService pageContainerDelegatingService;
	@Autowired
	private PageContainerInsertingService pageContainerInsertingService;
	
	@GetMapping("/")
	public String displayFavicon(Model model) {
		//TODO remove later and import from input
		pageContainerInsertingService.insertAllDefault();
		
		HashMap<String, List<PageContainer>> defaultClusters = pageContainerDelegatingService.getDefaultClusters();
		model.addAllAttributes(defaultClusters);
		return "defaultCluster";
	}
}
