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
public final class JazzBorderPanelBuilder {
	private final JPanel jPanel;

	public JazzBorderPanelBuilder() {
		jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
	}

	@Contract(" -> new")
	public static @NotNull JazzBorderPanelBuilder builder() {
		return new JazzBorderPanelBuilder();
	}

	public JPanel build() {
		return jPanel;
	}

	public JazzBorderPanelBuilder border(final Border border) {
		jPanel.setBorder(border);
		return this;
	}

	public JazzBorderPanelBuilder border(final int border) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(border, border, border, border));
		return this;
	}

	public JazzBorderPanelBuilder border(final int h, final int v) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(h, v, h, v));
		return this;
	}

	public JazzBorderPanelBuilder border(final int t, final int l, final int b, final int r) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzBorderPanelBuilder top(final JComponent child) {
		jPanel.add(child, BorderLayout.NORTH);
		return this;
	}

	public JazzBorderPanelBuilder left(final JComponent child) {
		jPanel.add(child, BorderLayout.WEST);
		return this;
	}

	public JazzBorderPanelBuilder right(final JComponent child) {
		jPanel.add(child, BorderLayout.EAST);
		return this;
	}

	public JazzBorderPanelBuilder bottom(final JComponent child) {
		jPanel.add(child, BorderLayout.SOUTH);
		return this;
	}

	public JazzBorderPanelBuilder center(final JComponent child) {
		jPanel.add(child, BorderLayout.CENTER);
		return this;
	}
}
