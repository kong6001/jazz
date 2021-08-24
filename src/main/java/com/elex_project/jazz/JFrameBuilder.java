/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

@Slf4j
public final class JFrameBuilder {
	private final JFrame jFrame;

	public JFrameBuilder() {
		this.jFrame = new JFrame();
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jFrame.setSize(800, 600);
		Jazz.centering(jFrame);
	}

	public JFrameBuilder title(final String title) {
		jFrame.setTitle(title);
		return this;
	}

	public JFrameBuilder size(final int w, final int h) {
		jFrame.setSize(w, h);
		return this;
	}

	public JFrameBuilder size(final Dimension size) {
		jFrame.setSize(size);
		return this;
	}

	public JFrameBuilder location(final int x, final int y) {
		jFrame.setLocation(x, y);
		return this;
	}

	public JFrameBuilder centering() {
		Jazz.centering(jFrame);
		return this;
	}

	public JFrameBuilder content(final JComponent contentPane) {
		jFrame.setContentPane(contentPane);
		return this;
	}

	public JFrameBuilder menu(final JMenuBar menuBar) {
		jFrame.setJMenuBar(menuBar);
		return this;
	}

	public JFrameBuilder icons(final java.util.List<Image> icons) {
		jFrame.setIconImages(icons);
		return this;
	}

	public JFrame build() {
		return jFrame;
	}
}
