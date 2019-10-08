package com.bashboard.api.usecases;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashboard.api.model.PageContainer;
import com.bashboard.api.persistence.PageContainerRepository;
import com.bashboard.api.services.PageContainerInsertingService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetAllBookmarksUseCase {
	
	private final PageContainerRepository repository;
	
	public List<PageContainer> getAllBookmarks(){
		return repository.getAllContainers();
	}
}
