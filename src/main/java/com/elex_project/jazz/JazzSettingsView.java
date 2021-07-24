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
public class JazzSettingsView extends JPanel {

	private final JLabel lblIcon;
	private final JLabel lblTitle;
	private final JazzMultilineLabel lblDescription;

	public JazzSettingsView(final String title, final String description,
	                        final Icon icon, final JComponent component) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		lblIcon = new JLabel();
		setIcon(icon);
		lblTitle = new JLabel(title);
		lblTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		//lblTitle.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		lblDescription = new JazzMultilineLabel(description);
		//lblDescription.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		lblDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

		final JPanel box1 = new JPanel();
		box1.setLayout(new BoxLayout(box1, BoxLayout.PAGE_AXIS));
		box1.add(lblIcon);
		box1.add(Box.createVerticalGlue());
		box1.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

		final JPanel box2 = new JPanel();
		box2.setLayout(new BoxLayout(box2, BoxLayout.PAGE_AXIS));
		box2.add(lblTitle);
		box2.add(lblDescription);
		box2.add(Box.createVerticalGlue());
		box2.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

		final JPanel box3 = new JPanel();
		box3.setLayout(new BoxLayout(box3, BoxLayout.PAGE_AXIS));
		box3.add(component);
		box3.add(Box.createVerticalGlue());
		box3.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

		add(box1);
		add(box2);
		add(Box.createHorizontalGlue());
		add(box3);
	}

	public void setTitle(final String title) {
		lblTitle.setText(title);
	}

	public void setDescription(final String description) {
		lblDescription.setText(description);
	}

	public void setIcon(final Icon icon) {
		if (null == icon) {
			lblIcon.setIcon(new EmptyIcon(48, 48));
		} else {
			lblIcon.setIcon(icon);
		}
	}
}
