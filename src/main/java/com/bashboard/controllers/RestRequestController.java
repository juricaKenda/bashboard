package com.bashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bashboard.model.PageContainer;
import com.bashboard.services.PageContainerLoadingService;

@Controller
public class RestRequestController {

	@Autowired
	private PageContainerLoadingService pageContainerLoadingService;
	
	@GetMapping("/")
	public String displayFavicon(Model model) {
		List<PageContainer> pageContainers = pageContainerLoadingService.loadPageContainers();
		model.addAttribute("pageContainers",pageContainers);
		return "defaultClusters";
	}
}
