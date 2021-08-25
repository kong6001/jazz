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
public class JazzCardPanel extends JPanel {

	JazzCardPanel() {
		super();
	}

	public void showFirst() {
		((CardLayout) getLayout()).first(this);
	}

	public void showNext() {
		((CardLayout) getLayout()).next(this);
	}

	public void showPrevious() {
		((CardLayout) getLayout()).previous(this);
	}

	public void showLast() {
		((CardLayout) getLayout()).last(this);
	}

	public void show(String name) {
		((CardLayout) getLayout()).show(this, name);
	}
}
