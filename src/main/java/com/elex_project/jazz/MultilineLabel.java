/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import javax.swing.*;
import java.awt.*;

/**
 * 여러 줄 라벨
 */
public class MultilineLabel extends JTextArea {
	public MultilineLabel() {
		super();
		init();
	}

	public MultilineLabel(String text) {
		super(text);
		init();
	}

	public MultilineLabel(int rows, int columns) {
		super(rows, columns);
		init();
	}

	public MultilineLabel(String text, int rows, int columns) {
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
