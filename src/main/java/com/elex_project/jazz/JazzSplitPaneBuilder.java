/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Range;

import javax.swing.*;
import javax.swing.border.Border;

@Slf4j
public final class JazzSplitPaneBuilder {
	public static JazzSplitPaneBuilder builder() {
		return new JazzSplitPaneBuilder();
	}

	private final JSplitPane jSplitPane;

	public JazzSplitPaneBuilder() {
		jSplitPane = new JSplitPane();
	}

	public JSplitPane build() {
		return jSplitPane;
	}

	public JazzSplitPaneBuilder border(final Border border) {
		jSplitPane.setBorder(border);
		return this;
	}

	public JazzSplitPaneBuilder border(final int border) {
		jSplitPane.setBorder(BorderFactory
				.createEmptyBorder(border, border, border, border));
		return this;
	}

	public JazzSplitPaneBuilder border(final int t, final int l, final int b, final int r) {
		jSplitPane.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzSplitPaneBuilder location(final int pos) {
		jSplitPane.setDividerLocation(pos);
		return this;
	}

	/**
	 * after visible
	 *
	 * @param pos 0 ~ 1
	 * @return ..
	 */
	public JazzSplitPaneBuilder location(final @Range(from = 0, to = 1) float pos) {
		jSplitPane.setDividerLocation(pos);
		return this;
	}

	public JazzSplitPaneBuilder expandable() {
		jSplitPane.setOneTouchExpandable(true);
		return this;
	}

	public JazzSplitPaneBuilder horizontal() {
		jSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		return this;
	}

	public JazzSplitPaneBuilder vertical() {
		jSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		return this;
	}

	public JazzSplitPaneBuilder first(final JComponent component) {
		jSplitPane.setLeftComponent(component);
		return this;
	}

	public JazzSplitPaneBuilder second(final JComponent component) {
		jSplitPane.setRightComponent(component);
		return this;
	}
}
