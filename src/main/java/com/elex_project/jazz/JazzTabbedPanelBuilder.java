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
public final class JazzTabbedPanelBuilder {
	@Contract(" -> new")
	public static @NotNull JazzTabbedPanelBuilder builder() {
		return new JazzTabbedPanelBuilder();
	}

	private final JTabbedPane jTabbedPane;

	public JazzTabbedPanelBuilder() {
		jTabbedPane = new JTabbedPane();
		jTabbedPane.setTabPlacement(JTabbedPane.TOP);
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	public JTabbedPane build() {
		return jTabbedPane;
	}

	public JazzTabbedPanelBuilder add(final String title, final JComponent child) {
		jTabbedPane.addTab(title, child);
		return this;
	}

	public JazzTabbedPanelBuilder add(final String title, final Icon icon, final JComponent child) {
		jTabbedPane.addTab(title, icon, child);
		return this;
	}

	public JazzTabbedPanelBuilder add(final String title, final Icon icon, final JComponent child, final String tooltip) {
		jTabbedPane.addTab(title, icon, child, tooltip);
		return this;
	}

	public JazzTabbedPanelBuilder top() {
		jTabbedPane.setTabPlacement(JTabbedPane.TOP);
		return this;
	}

	public JazzTabbedPanelBuilder left() {
		jTabbedPane.setTabPlacement(JTabbedPane.LEFT);
		return this;
	}

	public JazzTabbedPanelBuilder right() {
		jTabbedPane.setTabPlacement(JTabbedPane.RIGHT);
		return this;
	}

	public JazzTabbedPanelBuilder bottom() {
		jTabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
		return this;
	}

	public JazzTabbedPanelBuilder wrap() {
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		return this;
	}

	public JazzTabbedPanelBuilder scroll() {
		jTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		return this;
	}
}
