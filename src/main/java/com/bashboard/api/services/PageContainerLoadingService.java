package com.bashboard.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bashboard.api.model.PageContainer;
import com.bashboard.api.persistence.PageContainerRepository;

@Service
public class PageContainerLoadingService {

	@Autowired
	private PageContainerRepository pageContainerRepository;

	public List<PageContainer> loadPageContainers() {
		return pageContainerRepository.getAllContainers();
	}
	
}
