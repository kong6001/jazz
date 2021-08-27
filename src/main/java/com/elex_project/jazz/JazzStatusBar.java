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
@Deprecated
public class JazzStatusBar extends JPanel {
	private final JPanel leftPanel, rightPanel;

	public JazzStatusBar() {
		super();

		this.setLayout(new BorderLayout());
		this.leftPanel = new JPanel();
		this.rightPanel = new JPanel();

		init();
	}

	private void init() {
		leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 4, 4));

		this.add(leftPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);
	}

	public void addToLeft(final JComponent component) {
		this.leftPanel.add(component);
	}

	public void addToRight(final JComponent component) {
		this.rightPanel.add(component);
	}
}
