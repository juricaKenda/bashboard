package com.bashboard.persistence;

import java.util.List;

import com.bashboard.model.PageContainer;

public interface ContainerRepository {

	List<PageContainer> getAllContainers();
	void insertContainer(PageContainer container);
}
