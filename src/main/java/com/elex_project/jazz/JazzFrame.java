/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

@Slf4j
public class JazzFrame extends JFrame {
	public JazzFrame() throws HeadlessException {
		super();
		init();
	}

	public JazzFrame(GraphicsConfiguration gc) {
		super(gc);
		init();
	}

	public JazzFrame(String title) throws HeadlessException {
		super(title);
		init();
	}

	public JazzFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}

	private void init() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void start() {
		SwingUtilities.invokeLater(() -> {
			log.trace("started");
			JazzFrame.this.setVisible(true);
		});
	}
}
