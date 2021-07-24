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

/**
 * 여러 줄 라벨
 */
@Slf4j
public class JazzMultilineLabel extends JTextArea {
	public JazzMultilineLabel() {
		super();
		init();
	}

	public JazzMultilineLabel(String text) {
		super(text);
		init();
	}

	public JazzMultilineLabel(int rows, int columns) {
		super(rows, columns);
		init();
	}

	public JazzMultilineLabel(String text, int rows, int columns) {
		super(text, rows, columns);
		init();
	}

	private void init() {
		setEditable(false);
		setCursor(null);
		setOpaque(false);
		setFocusable(false);
		setFont(UIManager.getFont("Label.font"));
		setWrapStyleWord(true);
		setLineWrap(true);

		//setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		//setAlignmentY(JLabel.CENTER_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
	}
}
