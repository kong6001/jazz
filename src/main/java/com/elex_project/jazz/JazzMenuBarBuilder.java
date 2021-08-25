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

import javax.swing.*;

@Slf4j

public final class JazzMenuBarBuilder {
	@Contract(" -> new")
	public static @NotNull JazzMenuBarBuilder builder() {
		return new JazzMenuBarBuilder();
	}

	private final JMenuBar jMenuBar;

	public JazzMenuBarBuilder() {
		jMenuBar = new JMenuBar();
	}

	public JMenuBar build() {
		return jMenuBar;
	}

	@Contract("_ -> new")
	public @NotNull JazzMenuBuilder menu(final String menu) {
		return new JazzMenuBuilder(menu, this, jMenuBar);
	}

	@Contract("_ -> new")
	public @NotNull JazzMenuBuilder menu(final Action menu) {
		return new JazzMenuBuilder(menu, this, jMenuBar);
	}
}
