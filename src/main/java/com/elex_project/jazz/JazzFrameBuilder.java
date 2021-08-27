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
public final class JazzFrameBuilder {
	private final JFrame jFrame;

	public JazzFrameBuilder() {
		this.jFrame = new JFrame();
		this.jFrame.setTitle("Jazz!");
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jFrame.setSize(800, 600);
		this.jFrame.setLocationByPlatform(true);
	}

	@Contract(" -> new")
	public static @NotNull JazzFrameBuilder builder() {
		return new JazzFrameBuilder();
	}

	public JazzFrameBuilder title(final String title) {
		jFrame.setTitle(title);
		return this;
	}

	public JazzFrameBuilder size(final int w, final int h) {
		jFrame.setSize(w, h);
		return this;
	}

	public JazzFrameBuilder size(final Dimension size) {
		jFrame.setSize(size);
		return this;
	}

	public JazzFrameBuilder location(final int x, final int y) {
		jFrame.setLocation(x, y);
		return this;
	}

	public JazzFrameBuilder location(final Point location) {
		jFrame.setLocation(location);
		return this;
	}

	public JazzFrameBuilder centering() {
		Jazz.centering(jFrame);
		return this;
	}

	public JazzFrameBuilder content(final JComponent contentPane) {
		jFrame.setContentPane(contentPane);
		return this;
	}

	public JazzFrameBuilder menu(final JMenuBar menuBar) {
		jFrame.setJMenuBar(menuBar);
		return this;
	}

	public JazzFrameBuilder icons(final java.util.List<Image> icons) {
		jFrame.setIconImages(icons);
		return this;
	}

	public JFrame build() {
		return jFrame;
	}

	public JFrame buildAndLaunch() {
		SwingUtilities.invokeLater(() -> jFrame.setVisible(true));
		return jFrame;
	}
}
