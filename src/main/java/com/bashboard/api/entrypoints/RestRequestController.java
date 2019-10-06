package com.bashboard.api.entrypoints;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bashboard.api.model.PageContainer;
import com.bashboard.api.usecases.CacheCommandUseCase;
import com.bashboard.api.usecases.GetAllBookmarksUseCase;
import com.bashboard.api.usecases.GetLatestCommandResult;
import com.bashboard.api.usecases.ParseCommandUseCase;
import com.bashboard.commandline.model.commands.Command;


@RestController
public class RestRequestController {

	@Autowired
	private GetAllBookmarksUseCase getAllBookmarksUseCase;
	@Autowired
	private GetLatestCommandResult getLatestCommandResult;
	@Autowired
	private ParseCommandUseCase parseCommandUseCase;
	@Autowired
	private CacheCommandUseCase cacheCommandUseCase;

	
	@GetMapping("/allBookmarks")
	public ResponseEntity<List<PageContainer>> getAllBookmarks(Model model) {
		List<PageContainer> allBookmarks = getAllBookmarksUseCase.getAllBookmarks();
		return new ResponseEntity<List<PageContainer>>(allBookmarks,HttpStatus.OK);
	}
	
	@GetMapping("/latestCommandResult")
	public ResponseEntity<Object> getLatestCommandResult() {
		Object commandResult = getLatestCommandResult.getLatestCommandResult();
		return new ResponseEntity<Object>(commandResult,HttpStatus.OK);
	}
	
	@PostMapping(value="/newCommand",produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> newCommand(@RequestBody String commandJson) {
		JSONObject object = new JSONObject(commandJson);
		String commandUnparsed = (String)object.get("command");
		try{
			Command command = parseCommandUseCase.parseCommand(commandUnparsed);
			cacheCommandUseCase.cacheCommand(command);
			return new ResponseEntity<>(command,HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
}
