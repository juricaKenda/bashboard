package com.bashboard.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bashboard.model.PageContainer;
import com.bashboard.persistence.ContainerRepository;
import com.bashboard.persistence.PageContainerRepository;

import lombok.NonNull;

@Service
public class PageContainerInsertingService {

	@Autowired
	private ContainerRepository containerRepository;
	
	public void insertPageContainer(String link,String alias) {
		PageContainer container = PageContainer.builder()
				.alias(limitSize(alias))
				.link(link)
				.icon(link+"/favicon.ico")
				.build();
		containerRepository.insertContainer(container);
	}
	
	private @NonNull String limitSize(String alias) {
		if(alias.length() <= 10) {
			return alias;
		}
		return alias.substring(0, 8)+"..";
	}

	private void insert(PageContainer container) {
		containerRepository.insertContainer(container);
	}

	public void insertAllDefault() {
		List<PageContainer> defaultPageContainers = getDefaultPageContainers();
		if(containerRepository.isEmpty()) {
			defaultPageContainers.forEach(container -> insertPageContainer(container.getLink(),container.getAlias()));	
		}
		
	}
	
	private List<PageContainer> getDefaultPageContainers() {
		PageContainer stackOverflowContainer = new PageContainer("https://stackoverflow.com/favicon.ico","https://stackoverflow.com","Stack Overflow");
		PageContainer fiverrContainer = new PageContainer("https://www.fiverr.com/favicon.ico","https://www.fiverr.com","Fiverr");
		PageContainer gmailContainer = new PageContainer("https://mail.google.com/favicon.ico","https://mail.google.com/","Gmail");
		PageContainer devtoContainer = new PageContainer("https://dev.to/favicon.ico","https://dev.to","Dev Community");
		PageContainer githubContainer = new PageContainer("https://github.com/favicon.ico","https://github.com","Github");
		PageContainer linkedInContainer = new PageContainer("https://www.linkedin.com/favicon.ico","https://www.linkedin.com","LinkedIn");
		PageContainer mediumContainer = new PageContainer("https://medium.com/favicon.ico","https://medium.com","Medium");
		PageContainer youtubeContainer = new PageContainer("https://youtube.com/favicon.ico","https://youtube.com","YouTube");
		PageContainer asosContainer = new PageContainer("https://asos.com/favicon.ico","https://asos.com","ASOS");
		PageContainer facebookContainer = new PageContainer("https://www.facebook.com/favicon.ico","https://www.facebook.com","Facebook");
		PageContainer ebayContainer = new PageContainer("https://www.ebay.com/favicon.ico","https://www.ebay.com","Ebay");
		PageContainer amazonContainer = new PageContainer("https://www.amazon.com/favicon.ico","https://www.amazon.com","Amazon");
		
		//TODO add a method for validating and updating the length of an alias
		//TODO replace with real database and add REST end point for inputing new pages
		return Arrays.asList(stackOverflowContainer,fiverrContainer,gmailContainer,
				devtoContainer,githubContainer,linkedInContainer,
				mediumContainer,youtubeContainer,asosContainer,
				facebookContainer,ebayContainer,amazonContainer);
	}
	
	
}
