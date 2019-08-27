package com.bashboard.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bashboard.model.PageContainer;
import com.bashboard.services.PageContainerDelegatingService;
import com.bashboard.services.PageContainerLoadingService;

@Controller
public class RestRequestController {

	@Autowired
	private PageContainerDelegatingService pageContainerDelegatingService;

	
	@GetMapping("/")
	public String displayFavicon(Model model) {
		HashMap<String, List<PageContainer>> defaultClusters = pageContainerDelegatingService.getDefaultClusters();
		model.addAttribute("centerClusterContainers",defaultClusters.get("centerClusterContainers"));
		model.addAttribute("leftClusterContainers",defaultClusters.get("leftClusterContainers"));
		model.addAttribute("rightClusterContainers",defaultClusters.get("rightClusterContainers"));
		
		return "defaultCluster";
	}
}
