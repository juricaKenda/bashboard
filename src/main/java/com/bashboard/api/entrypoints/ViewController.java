package com.bashboard.api.entrypoints;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/board")
	public String homeBoard() {
		return "home";
	}
	
	@GetMapping("/darkmode")
	public String darkMode() {
		return "darkmode";
	}
}
