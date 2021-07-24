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
public class JazzSimpleFrame extends JFrame {
	public JazzSimpleFrame() throws HeadlessException {
		super();
		init();
	}

	public JazzSimpleFrame(GraphicsConfiguration gc) {
		super(gc);
		init();
	}

	public JazzSimpleFrame(String title) throws HeadlessException {
		super(title);
		init();
	}

	public JazzSimpleFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}

	private void init() {

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
