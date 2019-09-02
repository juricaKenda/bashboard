package com.bashboard.model;

import java.util.ArrayList;
import java.util.List;

import com.bashboard.model.PageContainer.PageContainerBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
public class PageContainer{
	@NonNull
	private final String icon;
	@NonNull
	private final String link; 
	@NonNull
	private final String alias;
	@NonNull
	private final List<Tag> tags;
	
}