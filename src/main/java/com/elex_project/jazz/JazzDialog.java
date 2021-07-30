/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

@Slf4j
public class JazzDialog extends JDialog {
	private final JFrame jFrame;
	private final ContentPane contentPane;

	public JazzDialog(final JFrame parent, final String title, final boolean modal) {
		super(parent, title, modal);
		this.jFrame = parent;
		this.contentPane = new ContentPane();
		init();
	}

	public JazzDialog(final JFrame parent, final String title) {
		this(parent, title, true);
	}

	private void init() {
		this.getContentPane().add(contentPane);

		//this.setPreferredSize(new Dimension(400, 300));
		this.setSize(new Dimension(400, 300));
		//this.pack();
		this.setLocationRelativeTo(jFrame);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public void addContent(final JComponent content) {
		this.contentPane.add(content, BorderLayout.CENTER);
	}

	public void addButton(final JButton button) {
		this.contentPane.buttons.add(button);
	}

	public void addButtonSpace(final int size) {
		this.contentPane.buttons.add(Box.createHorizontalStrut(size));
	}

	public void addButtonSpace() {
		this.contentPane.buttons.add(Box.createHorizontalGlue());
	}

	private static class ContentPane extends JPanel {
		private final JPanel buttons;

		ContentPane() {
			super();
			setLayout(new BorderLayout());
			setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

			buttons = new JPanel();
			buttons.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
			buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

			this.add(buttons, BorderLayout.SOUTH);
		}
	}

	public static class Builder {
		private final JazzDialog dialog;

		public Builder(final JFrame jFrame, final String title) {
			dialog = new JazzDialog(jFrame, title);
		}

		public Builder title(final String title) {
			dialog.setTitle(title);
			return this;
		}

		public Builder size(final int width, final int height) {
			dialog.setSize(width, height);
			return this;
		}

		public Builder modal(final boolean modal) {
			dialog.setModal(modal);
			return this;
		}

		public Builder content(final JComponent content) {
			dialog.addContent(content);
			return this;
		}

		public Builder button(final JButton button, final int spaceBefore, final int spaceAfter) {
			if (spaceBefore > 0) dialog.addButtonSpace(spaceBefore);
			dialog.addButton(button);
			if (spaceAfter > 0) dialog.addButtonSpace(spaceAfter);
			return this;
		}

		public Builder button() {
			dialog.addButtonSpace();
			return this;
		}

		public Builder pack(){
			dialog.pack();
			return this;
		}

		public JazzDialog build() {
			return dialog;
		}
	}
}
