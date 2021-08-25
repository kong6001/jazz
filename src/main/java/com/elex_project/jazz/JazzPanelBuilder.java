/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Slf4j
public final class JazzPanelBuilder {

	private JazzPanelBuilder() {

	}

	@Contract(" -> new")
	public static @NotNull JazzBorderPanelBuilder borderLayout() {
		return new JazzBorderPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzTabbedPanelBuilder tabbedLayout() {
		return new JazzTabbedPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzStatusBarBuilder statusBar() {
		return new JazzStatusBarBuilder();
	}


}
