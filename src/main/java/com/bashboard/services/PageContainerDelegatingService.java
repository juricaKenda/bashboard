package com.bashboard.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bashboard.model.PageContainer;

@Service
public class PageContainerDelegatingService {

	private final int MINIMUM_CENTER_CLUSTER_SIZE = 6;
	
	@Autowired
	private PageContainerLoadingService pageContainerLoadingService;
	
	public HashMap<String, List<PageContainer>> getDefaultClusters(){
		List<PageContainer> pageContainers = new ArrayList<>(pageContainerLoadingService.loadPageContainers());
		List<PageContainer> leftSideContainers = new ArrayList<>();
		List<PageContainer> rightSideContainers = new ArrayList<>();
		List<PageContainer> centerContainers = new ArrayList<>();
		
		int currentIndex = 0;
		if(pageContainers.size() <= MINIMUM_CENTER_CLUSTER_SIZE) {
			centerContainers = pageContainers;
			currentIndex = pageContainers.size();
		}else {
			switch (pageContainers.size() % 3) {
				case 1:
					centerContainers.add(pageContainers.remove(currentIndex));
					currentIndex++;
					break;
				case 2:
					leftSideContainers.add(pageContainers.remove(currentIndex));
					currentIndex++;
					rightSideContainers.add(pageContainers.remove(currentIndex));
					currentIndex++;
					break;
			}
			
			currentIndex =0;
			while(pageContainers.size() > 0) {
				switch(currentIndex % 3) {
				case 0:
					centerContainers.add(pageContainers.remove(0));
					break;
				case 1:
					leftSideContainers.add(pageContainers.remove(0));
					break;
				case 2:
					rightSideContainers.add(pageContainers.remove(0));
					break;
				}
				currentIndex++;
			}
		}
		
		HashMap<String, List<PageContainer>> map = new HashMap<>();
		map.put("centerClusterContainers",centerContainers);
		map.put("leftClusterContainers",leftSideContainers);
		map.put("rightClusterContainers",rightSideContainers);
		
		return map;
	}
	
}
