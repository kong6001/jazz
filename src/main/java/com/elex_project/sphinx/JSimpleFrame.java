/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.sphinx;

import javax.swing.*;
import java.awt.*;

public class JSimpleFrame extends JFrame {
	public JSimpleFrame() throws HeadlessException {
		super();
		init();
	}

	public JSimpleFrame(GraphicsConfiguration gc) {
		super(gc);
		init();
	}

	public JSimpleFrame(String title) throws HeadlessException {
		super(title);
		init();
	}

	public JSimpleFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}

	private void init() {

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
