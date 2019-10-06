package com.bashboard.persistence;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bashboard.model.PageContainer;
import com.bashboard.services.PageContainerInsertingService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Repository
@AllArgsConstructor
public class PageContainerRepository implements ContainerRepository {

	@NonNull
	private List<PageContainer> mockRepository;
	
	@Override
	public List<PageContainer> getAllContainers() {
		return mockRepository;
	}

	@Override
	public void insertContainer(PageContainer container) {
		mockRepository.add(container);
		
	}

	@Override
	public boolean isEmpty() {
		return mockRepository.isEmpty();
	}
}
