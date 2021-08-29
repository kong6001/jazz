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
public final class JazzGridPanelBuilder {
	private final JPanel jPanel;
	private final GridLayout layout;

	public JazzGridPanelBuilder() {
		jPanel = new JPanel();
		layout = new GridLayout();
		jPanel.setLayout(layout);
	}

	@Contract(" -> new")
	public static @NotNull JazzGridPanelBuilder builder() {
		return new JazzGridPanelBuilder();
	}

	public JPanel build() {
		return jPanel;
	}

	public JazzGridPanelBuilder border(final Border border) {
		jPanel.setBorder(border);
		return this;
	}

	public JazzGridPanelBuilder border(final int border) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(border, border, border, border));
		return this;
	}

	public JazzGridPanelBuilder border(final int h, final int v) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(v, h, v, h));
		return this;
	}

	public JazzGridPanelBuilder border(final int t, final int l, final int b, final int r) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzGridPanelBuilder add(final JComponent child) {
		jPanel.add(child);
		return this;
	}

	public JazzGridPanelBuilder gap(final int hGap, final int vGap) {
		layout.setHgap(hGap);
		layout.setVgap(vGap);
		return this;
	}

	public JazzGridPanelBuilder rows(final int size) {
		layout.setRows(size);
		return this;
	}

	public JazzGridPanelBuilder columns(final int size) {
		layout.setColumns(size);
		return this;
	}
}
