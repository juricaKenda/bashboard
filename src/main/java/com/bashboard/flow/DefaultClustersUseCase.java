package com.bashboard.flow;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.expression.Maps;

import com.bashboard.model.PageContainer;
import com.bashboard.services.PageContainerDelegatingService;
import com.bashboard.services.PageContainerLoadingService;

@Component
public class DefaultClustersUseCase {
	
	@Autowired
	private PageContainerDelegatingService pageContainerDelegatingService;
	
	public HashMap<String, List<PageContainer>> getDefaultClusters(){
		return pageContainerDelegatingService.getDefaultClusters();
	}
	

}
