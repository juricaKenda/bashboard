package com.bashboard.persistence;

import java.util.List;

import com.bashboard.model.PageContainer;

public interface ContainerRepository {

	boolean isEmpty();
	List<PageContainer> getAllContainers();
	void insertContainer(PageContainer container);
}
