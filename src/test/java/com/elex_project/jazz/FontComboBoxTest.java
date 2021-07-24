/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class FontComboBoxTest {

	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());
		final JTextField textField = new JTextField("Hello 2021, 나랏말싸미 듕귁에 달아.");
		final FontComboBox fontComboBox = new FontComboBox();
		fontComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				Font font = (Font) itemEvent.getItem();
				textField.setFont(font.deriveFont(16f));
			}
		});
		contentPane.add(fontComboBox, BorderLayout.NORTH);
		contentPane.add(textField, BorderLayout.CENTER);

		jFrame.setContentPane(contentPane);
		jFrame.setSize(800, 600);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
}
