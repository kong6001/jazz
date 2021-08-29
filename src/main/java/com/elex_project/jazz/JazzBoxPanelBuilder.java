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
public final class JazzBoxPanelBuilder {
	private final JPanel jPanel;
	private boolean isVertical = false;

	public JazzBoxPanelBuilder() {
		jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.LINE_AXIS));
	}

	@Contract(" -> new")
	public static @NotNull JazzBoxPanelBuilder builder() {
		return new JazzBoxPanelBuilder();
	}

	public JPanel build() {
		return jPanel;
	}

	public JazzBoxPanelBuilder horizontal() {
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.LINE_AXIS));
		isVertical = false;
		return this;
	}

	public JazzBoxPanelBuilder vertical() {
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
		isVertical = true;
		return this;
	}

	public JazzBoxPanelBuilder border(final Border border) {
		jPanel.setBorder(border);
		return this;
	}

	public JazzBoxPanelBuilder border(final int border) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(border, border, border, border));
		return this;
	}

	public JazzBoxPanelBuilder border(final int t, final int l, final int b, final int r) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzBoxPanelBuilder border(final int h, final int v) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(v, h, v, h));
		return this;
	}

	public JazzBoxPanelBuilder alignX(final float align) {
		jPanel.setAlignmentX(align);
		return this;
	}

	public JazzBoxPanelBuilder alignY(final float align) {
		jPanel.setAlignmentY(align);
		return this;
	}

	public JazzBoxPanelBuilder add(final JComponent child) {
		jPanel.add(child);
		return this;
	}

	public JazzBoxPanelBuilder addBox(final int width, final int height) {
		jPanel.add(Box.createRigidArea(new Dimension(width, height)));
		return this;
	}

	public JazzBoxPanelBuilder addGlue() {
		if (isVertical) {
			jPanel.add(Box.createVerticalGlue());
		} else {
			jPanel.add(Box.createHorizontalGlue());
		}
		return this;
	}

	public JazzBoxPanelBuilder addStrut(final int size) {
		if (isVertical) {
			jPanel.add(Box.createVerticalStrut(size));
		} else {
			jPanel.add(Box.createHorizontalStrut(size));
		}
		return this;
	}
}
