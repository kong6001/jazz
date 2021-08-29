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
public final class JazzCardPanelBuilder {
	private final JazzCardPanel jPanel;
	private final CardLayout layout;

	public JazzCardPanelBuilder() {
		layout = new CardLayout();
		jPanel = new JazzCardPanel();
		jPanel.setLayout(layout);
	}

	@Contract(" -> new")
	public static @NotNull JazzCardPanelBuilder builder() {
		return new JazzCardPanelBuilder();
	}

	public JazzCardPanel build() {
		return jPanel;
	}

	public JazzCardPanelBuilder border(final Border border) {
		jPanel.setBorder(border);
		return this;
	}

	public JazzCardPanelBuilder border(final int h, final int v) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(v, h, v, h));
		return this;
	}

	public JazzCardPanelBuilder border(final int border) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(border, border, border, border));
		return this;
	}

	public JazzCardPanelBuilder border(final int t, final int l, final int b, final int r) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzCardPanelBuilder add(final JComponent child, final String name) {
		jPanel.add(child, name);
		return this;
	}

	/*public JazzCardPanelBuilder gap(final int hGap, final int vGap) {
		layout.setHgap(hGap);
		layout.setVgap(vGap);
		return this;
	}*/
}
