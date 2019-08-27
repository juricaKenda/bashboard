package com.bashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bashboard.model.PageContainer;
import com.bashboard.persistence.PageContainerRepository;

@Service
public class PageContainerLoadingService {

	@Autowired
	private PageContainerRepository pageContainerRepository;

	public List<PageContainer> loadPageContainers() {
		return pageContainerRepository.getAllContainers();
	}
	
}
