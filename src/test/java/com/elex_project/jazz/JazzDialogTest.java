/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class JazzDialogTest {
	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());

		final JButton button = new JButton("Test");
		button.addActionListener(e->{
			final JazzDialog dlg = new JazzDialog(jFrame,"Hello");
			dlg.addContent(new JLabel("Hahaha"));
			dlg.addButton(new JButton("A"));
			dlg.addButtonSpace(4);
			dlg.addButton(new JButton("B"));
			dlg.addButtonSpace();
			dlg.addButton(new JButton("C"));
			dlg.setVisible(true);
		});
		contentPane.add(button, BorderLayout.CENTER);

		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);
	}
}
