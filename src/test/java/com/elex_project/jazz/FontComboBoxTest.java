/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
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
		final JazzFontComboBox fontComboBox = new JazzFontComboBox();
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
