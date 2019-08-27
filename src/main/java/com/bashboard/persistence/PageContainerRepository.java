package com.bashboard.persistence;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bashboard.model.PageContainer;

@Repository
public class PageContainerRepository {

	public List<PageContainer> getAllPageContainers() {
		PageContainer stackOverflowContainer = new PageContainer("https://stackoverflow.com/favicon.ico","https://stackoverflow.com","Stack Overflow");
		PageContainer fiverrContainer = new PageContainer("https://www.fiverr.com/favicon.ico","https://www.fiverr.com","Fiverr");
		PageContainer gmailContainer = new PageContainer("https://mail.google.com/favicon.ico","https://mail.google.com/mail","Gmail");
		PageContainer devtoContainer = new PageContainer("https://dev.to/favicon.ico","https://dev.to","Dev Community");
		PageContainer githubContainer = new PageContainer("https://github.com/favicon.ico","https://github.com","Github");
		PageContainer linkedInContainer = new PageContainer("https://www.linkedin.com/favicon.ico","https://www.linkedin.com","LinkedIn");
		PageContainer mediumContainer = new PageContainer("https://medium.com/favicon.ico","https://medium.com","Medium");
		PageContainer youtubeContainer = new PageContainer("https://youtube.com/favicon.ico","https://youtube.com","YouTube");
		PageContainer asosContainer = new PageContainer("https://asos.com/favicon.ico","https://asos.com","ASOS");
		PageContainer facebookContainer = new PageContainer("https://www.facebook.com/favicon.ico","https://www.facebook.com","Facebook");
		PageContainer ebayContainer = new PageContainer("https://www.ebay.com/favicon.ico","https://www.ebay.com","Ebay");
		PageContainer amazonContainer = new PageContainer("https://www.amazon.com/favicon.ico","https://www.amazon.com","Amazon");
		
		
		//TODO replace with real database and add REST end point for inputing new pages
		return Arrays.asList(stackOverflowContainer,fiverrContainer,gmailContainer,
				devtoContainer,githubContainer,linkedInContainer,
				mediumContainer,youtubeContainer,asosContainer,
				facebookContainer,ebayContainer,amazonContainer);
	}
}
