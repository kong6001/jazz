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
import java.awt.*;
import java.awt.event.ActionListener;

@Slf4j
public final class JazzToolBarBuilder {
	private final JToolBar jToolBar;

	public JazzToolBarBuilder() {
		jToolBar = new JToolBar();
		jToolBar.setFloatable(false);
	}

	@Contract(value = " -> new", pure = true)
	public static @NotNull JazzToolBarBuilder builder() {
		return new JazzToolBarBuilder();
	}

	public JToolBar build() {
		return jToolBar;
	}

	public JazzToolBarBuilder floatable() {
		jToolBar.setFloatable(true);
		return this;
	}

	public JazzToolBarBuilder alignX(final float align) {
		jToolBar.setAlignmentX(align);
		return this;
	}

	public JazzToolBarBuilder alignY(final float align) {
		jToolBar.setAlignmentY(align);
		return this;
	}

	public JazzToolBarBuilder add(final Action action) {
		jToolBar.add(action);
		return this;
	}

	public JazzToolBarBuilder add(final JComponent component) {
		jToolBar.add(component);
		return this;
	}

	public JazzToolBarBuilder add(final JPopupMenu popupMenu) {
		jToolBar.add(popupMenu);
		return this;
	}

	public JazzToolBarBuilder separator() {
		jToolBar.addSeparator();
		return this;
	}

	public JazzToolBarBuilder separator(final int width, final int height) {
		jToolBar.addSeparator(new Dimension(width, height));
		return this;
	}

	public JazzToolBarBuilder add(final String title, final ActionListener actionListener) {
		final JButton jButton = new JButton(title);
		jButton.addActionListener(actionListener);
		jToolBar.add(jButton);
		return this;
	}

	public JazzToolBarBuilder add(final String title, final Icon icon, final ActionListener actionListener) {
		final JButton jButton = new JButton(title, icon);
		jButton.addActionListener(actionListener);
		jToolBar.add(jButton);
		return this;
	}

	public JazzToolBarBuilder add(final String title, final Icon icon, final String tooltip, final ActionListener actionListener) {
		final JButton jButton = new JButton(title, icon);
		jButton.setToolTipText(tooltip);
		jButton.addActionListener(actionListener);
		jToolBar.add(jButton);
		return this;
	}

	public JazzToolBarBuilder add(final Icon icon, final String tooltip, final ActionListener actionListener) {
		final JButton jButton = new JButton(icon);
		jButton.setToolTipText(tooltip);
		jButton.addActionListener(actionListener);
		jToolBar.add(jButton);
		return this;
	}
}
