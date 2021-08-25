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

@Slf4j
public final class JazzDialogBuilder {
	@Contract(" -> new")
	public static @NotNull JazzDialogBuilder builder(final JFrame owner) {
		return new JazzDialogBuilder(owner);
	}

	private final JDialog jDialog;
	private final JPanel jPanel = new JPanel();

	public JazzDialogBuilder(final JFrame owner) {
		this.jDialog = new JDialog(owner);
		init();
	}

	public JazzDialogBuilder(final JWindow owner) {
		this.jDialog = new JDialog(owner);
		init();
	}

	public JazzDialogBuilder(final JDialog owner) {
		this.jDialog = new JDialog(owner);
		init();
	}

	private void init() {
		jDialog.setModal(true);
		jDialog.setTitle("Jazz Dialog");
		jDialog.setSize(400, 600);
		jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jDialog.setLocationRelativeTo(null);
		jPanel.setLayout(new BorderLayout());
	}

	public JDialog build() {
		return jDialog;
	}

	public JDialog buildAndLaunch() {
		jDialog.setVisible(true);
		return jDialog;
	}

	public JazzDialogBuilder title(final String title) {
		jDialog.setTitle(title);
		return this;
	}

	public JazzDialogBuilder icon(final Image image) {
		jDialog.setIconImage(image);
		return this;
	}

	public JazzDialogBuilder menu(final JMenuBar menuBar) {
		jDialog.setJMenuBar(menuBar);
		return this;
	}

	public JazzDialogBuilder size(final int width, final int height) {
		jDialog.setSize(width, height);
		return this;
	}

	public JazzDialogBuilder size(final Dimension size) {
		jDialog.setSize(size);
		return this;
	}

	public JazzDialogBuilder modal(final boolean modal) {
		jDialog.setModal(modal);
		return this;
	}

	public JazzDialogBuilder location(final int x, final int y) {
		jDialog.setLocation(x, y);
		return this;
	}

	public JazzDialogBuilder location(final Point location) {
		jDialog.setLocation(location);
		return this;
	}

	public JazzDialogBuilder centering() {
		jDialog.setLocationRelativeTo(null);
		return this;
	}

	public JazzDialogBuilder contentPane(final JComponent contentPane) {
		jDialog.setContentPane(contentPane);
		return this;
	}

	public JazzDialogBuilder top(final JComponent content) {
		jPanel.add(content, BorderLayout.NORTH);
		jDialog.setContentPane(this.jPanel);
		return this;
	}

	public JazzDialogBuilder left(final JComponent content) {
		jPanel.add(content, BorderLayout.WEST);
		jDialog.setContentPane(this.jPanel);
		return this;
	}

	public JazzDialogBuilder right(final JComponent content) {
		jPanel.add(content, BorderLayout.EAST);
		jDialog.setContentPane(this.jPanel);
		return this;
	}

	public JazzDialogBuilder bottom(final JComponent content) {
		jPanel.add(content, BorderLayout.SOUTH);
		jDialog.setContentPane(this.jPanel);
		return this;
	}

	/**
	 * Add buttons within Flow layout. And with 8px paddings.
	 *
	 * @param buttons JButton or Box.createHorizontalGlue() ...
	 * @return builder
	 */
	public JazzDialogBuilder bottom(final int border, final Component... buttons) {
		final JPanel buttonPanel = JazzBuilders.flowLayout()
				.gap(4,2)
				.alignTrailing()
				.border(border)
				.build();
		for (final Component item : buttons) {
			buttonPanel.add(item);
		}
		jPanel.add(buttonPanel, BorderLayout.SOUTH);
		jDialog.setContentPane(this.jPanel);
		return this;
	}

	public JazzDialogBuilder bottom(final Component... buttons) {
		return bottom(4, buttons);
	}

	public JazzDialogBuilder center(final JComponent content) {
		jPanel.add(content, BorderLayout.CENTER);
		jDialog.setContentPane(this.jPanel);
		return this;
	}

	public JazzDialogBuilder pack() {
		jDialog.pack();
		return this;
	}

}
