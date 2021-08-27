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
public final class JazzFlowPanelBuilder {
	@Contract(" -> new")
	public static @NotNull JazzFlowPanelBuilder builder() {
		return new JazzFlowPanelBuilder();
	}

	private final JPanel jPanel;
	private final FlowLayout layout;

	public JazzFlowPanelBuilder() {
		jPanel = new JPanel();
		layout = new FlowLayout(FlowLayout.LEADING, 4, 4);
		jPanel.setLayout(layout);
	}

	public JPanel build() {
		return jPanel;
	}

	public JazzFlowPanelBuilder border(final Border border) {
		jPanel.setBorder(border);
		return this;
	}

	public JazzFlowPanelBuilder border(final int border) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(border, border, border, border));
		return this;
	}

	public JazzFlowPanelBuilder border(final int t, final int l, final int b, final int r) {
		jPanel.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	/*public JazzFlowPanelBuilder alignX(final float align) {
		jPanel.setAlignmentX(align);
		return this;
	}

	public JazzFlowPanelBuilder alignY(final float align) {
		jPanel.setAlignmentY(align);
		return this;
	}*/

	public JazzFlowPanelBuilder add(final JComponent child) {
		jPanel.add(child);
		return this;
	}

	public enum Align{
		CENTER(FlowLayout.CENTER),
		LEADING(FlowLayout.LEADING),
		TRAILING(FlowLayout.TRAILING);
		private final int value;
		Align(int value){
			this.value = value;
		}
	}
	@Contract("_ -> this")
	public JazzFlowPanelBuilder align(final @NotNull Align align) {
		layout.setAlignment(align.value);
		return this;
	}

	public JazzFlowPanelBuilder alignBaseline(final boolean baselineAlign) {
		layout.setAlignOnBaseline(baselineAlign);
		return this;
	}

	public JazzFlowPanelBuilder gap(final int hGap, final int vGap) {
		layout.setHgap(hGap);
		layout.setVgap(vGap);
		return this;
	}
}
