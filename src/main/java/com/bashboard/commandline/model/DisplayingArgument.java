package com.bashboard.commandline.model;

import java.util.function.Predicate;

import com.bashboard.model.PageContainer;

public interface DisplayingArgument {

	Predicate<PageContainer> getPredicate();
}
