package com.bashboard.controllers.usecases;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.model.PageContainer;
import com.bashboard.persistence.PageContainerRepository;
import com.bashboard.services.PageContainerInsertingService;

@Component
public class GetAllBookmarksUseCase {
	
	@Autowired
	private PageContainerRepository repository;
	
	public List<PageContainer> getAllBookmarks(){
		return repository.getAllContainers();
	}
}
