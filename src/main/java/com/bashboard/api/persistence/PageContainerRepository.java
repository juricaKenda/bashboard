package com.bashboard.api.persistence;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bashboard.api.model.PageContainer;
import com.bashboard.api.services.PageContainerInsertingService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Repository
@AllArgsConstructor
public class PageContainerRepository{

	@NonNull
	private List<PageContainer> mockRepository;
	
	
	public List<PageContainer> getAllContainers() {
		return mockRepository;
	}

	
	public void insertContainer(PageContainer container) {
		mockRepository.add(container);
		
	}

	
	public boolean isEmpty() {
		return mockRepository.isEmpty();
	}
}
