/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.dwarf.IntegerProperty;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import javax.swing.*;
import javax.swing.border.Border;

@Slf4j
public final class JazzSplitPaneBuilder {
	private final JSplitPane jSplitPane;

	public JazzSplitPaneBuilder() {
		jSplitPane = new JSplitPane();
	}

	@Contract(" -> new")
	public static @NotNull JazzSplitPaneBuilder builder() {
		return new JazzSplitPaneBuilder();
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

	public JazzSplitPaneBuilder border(final int h, final int v) {
		jSplitPane.setBorder(BorderFactory
				.createEmptyBorder(v, h, v, h));
		return this;
	}

	public JazzSplitPaneBuilder border(final int t, final int l, final int b, final int r) {
		jSplitPane.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzSplitPaneBuilder dividerLocation(final int pos) {
		jSplitPane.setDividerLocation(pos);
		return this;
	}

	/**
	 * after visible
	 *
	 * @param pos 0 ~ 1
	 * @return ..
	 */
	public JazzSplitPaneBuilder dividerLocation(final @Range(from = 0, to = 1) float pos) {
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

	public JazzSplitPaneBuilder dividerLocation(final @NotNull IntegerProperty property) {
		jSplitPane.setDividerLocation(property.optional().orElse(0));
		jSplitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY,
				propertyChangeEvent -> property.set(jSplitPane.getDividerLocation()));
		return this;
	}

}
