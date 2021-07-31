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

/**
 * 그리드백 레이아웃을 사용하는 입력 폼 패널
 */
@Slf4j
public class JazzInputForm extends JPanel {
	private final GridBagLayout layout;

	public JazzInputForm(){
		super();
		this.layout = new GridBagLayout();
		init();
	}

	private void init(){

		this.setLayout(this.layout);
	}

	public void add(final int row, final String label,
	                final JComponent component, final String tooltip) {
		component.setToolTipText(tooltip);
		this.add(new JLabel(label), constraints(0, row));
		this.add(component, constraints(1, row));

	}

	public void add(final int row, final String label,
	                final JComponent component, final String tooltip,
	                final JComponent component2, final String tooltip2) {
		component.setToolTipText(tooltip);
		component2.setToolTipText(tooltip2);
		this.add(new JLabel(label), constraints(0, row));
		GridBagConstraints constraints = constraints(1, row);
		constraints.gridwidth = 1;
		this.add(component, constraints);
		constraints = constraints(2, row);
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		this.add(component2, constraints);
	}

	public void addDummy(final int row) {
		GridBagConstraints constraints = constraints(0, row);
		constraints.weighty = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		this.add(Box.createVerticalBox(), constraints);
	}

	protected static GridBagConstraints constraints(final int x, final int y) {
		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = (x == 0) ? 1 : GridBagConstraints.REMAINDER;
		constraints.gridheight = 1;//GridBagConstraints.RELATIVE;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.weightx = (x == 0) ? 0 : 1;
		constraints.weighty = 0;
		constraints.insets = new Insets(4, 4, 4, 4);
		//constraints.anchor = (x == 0) ? GridBagConstraints.LINE_START : GridBagConstraints.LINE_END;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.CENTER;
		return constraints;

	}
}
