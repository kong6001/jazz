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

	public enum Placement {
		TOP(JTabbedPane.TOP),
		LEFT(JTabbedPane.LEFT),
		RIGHT(JTabbedPane.RIGHT),
		BOTTOM(JTabbedPane.BOTTOM);
		private final int value;

		Placement(int value) {
			this.value = value;
		}
	}

	@Contract("_ -> this")
	public JazzTabbedPanelBuilder place(final @NotNull Placement placement) {
		jTabbedPane.setTabPlacement(placement.value);
		return this;
	}

	public enum Layout {
		WRAP(JTabbedPane.WRAP_TAB_LAYOUT),
		SCROLL(JTabbedPane.SCROLL_TAB_LAYOUT);
		private final int value;

		Layout(int value) {
			this.value = value;
		}
	}

	@Contract("_ -> this")
	public JazzTabbedPanelBuilder layout(@NotNull Layout layout) {
		jTabbedPane.setTabLayoutPolicy(layout.value);
		return this;
	}

}
