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
import javax.swing.border.Border;
import java.awt.*;

@Slf4j
public final class JazzGridBagPanelBuilder {
	@Contract(" -> new")
	public static @NotNull JazzGridBagPanelBuilder builder() {
		return new JazzGridBagPanelBuilder();
	}

	private final JPanel jPanel;
	private final GridBagLayout layout;

	public JazzGridBagPanelBuilder() {
		jPanel = new JPanel();
		layout = new GridBagLayout();
		jPanel.setLayout(layout);
	}

	public JPanel build() {
		return jPanel;
	}

	public JazzGridBagPanelBuilder border(final Border border) {
		jPanel.setBorder(border);
		return this;
	}

	public JazzGridBagPanelBuilder border(final int border) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(border, border, border, border));
		return this;
	}

	public JazzGridBagPanelBuilder border(final int t, final int l, final int b, final int r) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzGridBagPanelBuilder add(final JComponent child, final GridBagConstraints constraints) {
		layout.setConstraints(child, constraints);
		jPanel.add(child);
		return this;
	}
}
