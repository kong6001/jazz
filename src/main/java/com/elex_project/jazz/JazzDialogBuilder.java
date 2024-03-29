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
public final class JazzDialogBuilder {
	private final JDialog jDialog;
	private final JPanel jPanel = new JPanel();
	private JPanel buttonPanel;

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

	@Contract(" -> new")
	public static @NotNull JazzDialogBuilder builder(final JFrame owner) {
		return new JazzDialogBuilder(owner);
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
		this.buttonPanel = null;
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
	public JazzDialogBuilder bottom(final int border, final JComponent... buttons) {
		this.buttonPanel = null;
		final JPanel buttonPanel = JazzBuilders.flowLayout()
				.gap(4, 2)
				.align(JazzFlowPanelBuilder.Align.TRAILING)
				.border(border)
				.build();
		for (final Component item : buttons) {
			buttonPanel.add(item);
		}
		jPanel.add(buttonPanel, BorderLayout.SOUTH);
		jDialog.setContentPane(this.jPanel);
		return this;
	}

	public JazzDialogBuilder bottom(final JComponent... buttons) {
		return bottom(4, buttons);
	}

	public JazzDialogBuilder button(final String title, final ActionListener listener) {
		final JButton jButton = new JButton(title);
		jButton.addActionListener(listener);
		return button(jButton);
	}

	public JazzDialogBuilder buttonClose(final String title, final Icon icon) {
		return button(title, icon, e -> {
			jDialog.dispose();
		});
	}

	public JazzDialogBuilder buttonClose(final String title) {
		return button(title, e -> {
			jDialog.dispose();
		});
	}

	public JazzDialogBuilder button(final String title, final Icon icon, final ActionListener listener) {
		final JButton jButton = new JButton(title, icon);
		jButton.addActionListener(listener);
		return button(jButton);
	}

	public JazzDialogBuilder button(final JButton button) {
		if (null == this.buttonPanel) {
			this.buttonPanel = JazzBuilders.flowLayout()
					.gap(4, 2)
					.align(JazzFlowPanelBuilder.Align.TRAILING)
					.border(4)
					.build();
			jPanel.add(buttonPanel, BorderLayout.SOUTH);
			jDialog.setContentPane(this.jPanel);
		}
		buttonPanel.add(button);
		return this;
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
