package com.bashboard.api.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bashboard.api.model.PageContainer;
import com.bashboard.api.model.PageContainer.Tag;
import com.bashboard.api.persistence.PageContainerRepository;

import lombok.NonNull;

@Service
public class PageContainerInsertingService {

	private final PageContainerRepository containerRepository;
	
	public PageContainerInsertingService(PageContainerRepository repo){
		containerRepository = repo;
		insertAllDefault();
	}
	
	public void insertPageContainer(String link,String alias,List<Tag> tags) {
		PageContainer container = PageContainer.builder()
				.alias(limitSize(alias))
				.link(link)
				.icon(link+"/favicon.ico")
				.tags(tags)
				.build();
		containerRepository.insertContainer(container);
	}
	
	private @NonNull String limitSize(String alias) {
		if(alias.length() <= 14) {
			return alias;
		}
		return alias.substring(0, 12)+"..";
	}

	private void insert(PageContainer container) {
		containerRepository.insertContainer(container);
	}

	public void insertAllDefault() {
		List<PageContainer> defaultPageContainers = getDefaultPageContainers();
		if(containerRepository.isEmpty()) {
			defaultPageContainers.forEach(container -> insertPageContainer(container.getLink(),container.getAlias(),container.getTags()));	
		}
		
	}
	
	private List<PageContainer> getDefaultPageContainers() {
		PageContainer stackOverflowContainer = new PageContainer("https://stackoverflow.com/favicon.ico","https://stackoverflow.com","Stack Overflow",Arrays.asList(Tag.LEARNING,Tag.PROGRAMMING));
		PageContainer fiverrContainer = new PageContainer("https://www.fiverr.com/favicon.ico","https://www.fiverr.com","Fiverr",Arrays.asList(Tag.BUSINESS));
		PageContainer gmailContainer = new PageContainer("https://mail.google.com/favicon.ico","https://mail.google.com/","Gmail",Arrays.asList(Tag.BUSINESS));
		PageContainer devtoContainer = new PageContainer("https://dev.to/favicon.ico","https://dev.to","Dev Community",Arrays.asList(Tag.LEARNING,Tag.BLOGS,Tag.CHILL));
		PageContainer githubContainer = new PageContainer("https://github.com/favicon.ico","https://github.com","Github",Arrays.asList(Tag.LEARNING,Tag.PROGRAMMING));
		PageContainer linkedInContainer = new PageContainer("https://www.linkedin.com/favicon.ico","https://www.linkedin.com","LinkedIn",Arrays.asList(Tag.LEARNING,Tag.BLOGS,Tag.BUSINESS));
		PageContainer mediumContainer = new PageContainer("https://medium.com/favicon.ico","https://medium.com","Medium",Arrays.asList(Tag.LEARNING,Tag.BLOGS,Tag.BUSINESS));
		PageContainer youtubeContainer = new PageContainer("https://youtube.com/favicon.ico","https://youtube.com","YouTube",Arrays.asList(Tag.LEARNING,Tag.CHILL));
		PageContainer asosContainer = new PageContainer("https://asos.com/favicon.ico","https://asos.com","ASOS",Arrays.asList(Tag.SHOPPING,Tag.CHILL));
		PageContainer facebookContainer = new PageContainer("https://www.facebook.com/favicon.ico","https://www.facebook.com","Facebook",Arrays.asList(Tag.CHILL));
		PageContainer ebayContainer = new PageContainer("https://www.ebay.com/favicon.ico","https://www.ebay.com","Ebay",Arrays.asList(Tag.SHOPPING,Tag.CHILL));
		PageContainer amazonContainer = new PageContainer("https://www.amazon.com/favicon.ico","https://www.amazon.com","Amazon",Arrays.asList(Tag.CHILL,Tag.SHOPPING));
		PageContainer zaraContainer = new PageContainer("https://www.zara.com/favicon.ico","https://www.zara.com","Zara",Arrays.asList(Tag.CHILL,Tag.SHOPPING));
		PageContainer bookDepositoryContainer = new PageContainer("https://www.bookdepository.com/favicon.ico","https://www.bookdepository.com","Book Depository",Arrays.asList(Tag.CHILL,Tag.SHOPPING,Tag.LEARNING));
		PageContainer MITtechnologyReviewContainer = new PageContainer("https://www.technologyreview.com/favicon.ico","https://www.technologyreview.com","MIT Technology Review",Arrays.asList(Tag.LEARNING,Tag.PROGRAMMING));
		PageContainer businessInsiderContainer = new PageContainer("https://www.businessinsider.com/favicon.ico","https://www.businessinsider.com","Business Insider",Arrays.asList(Tag.CHILL,Tag.BLOGS,Tag.LEARNING));
		PageContainer refactoringGuruContainer = new PageContainer("https://refactoring.guru/favicon.ico","https://refactoring.guru","Refactoring Guru",Arrays.asList(Tag.CHILL,Tag.LEARNING,Tag.PROGRAMMING));
		PageContainer googleContainer = new PageContainer("https://www.google.com/favicon.ico","https://www.google.com","Google",Arrays.asList(Tag.values()));
		
		//TODO add a method for validating and updating the length of an alias
		//TODO replace with real database and add REST end point for inputing new pages
		return Arrays.asList(stackOverflowContainer,fiverrContainer,gmailContainer,
				devtoContainer,githubContainer,linkedInContainer,
				mediumContainer,youtubeContainer,asosContainer,
				facebookContainer,ebayContainer,amazonContainer,
				zaraContainer,bookDepositoryContainer,MITtechnologyReviewContainer,
				businessInsiderContainer,refactoringGuruContainer,googleContainer);
	}
	
	
}
