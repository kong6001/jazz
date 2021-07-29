/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class JazzStatusBarTest {
	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());
		JazzStatusBar statusBar = new JazzStatusBar();
		statusBar.addToLeft(new JLabel("Hello1"));
		statusBar.addToLeft(new JLabel("Hello2"));
		statusBar.addToRight(new JLabel("Hello3"));
		statusBar.addToRight(new JLabel("Hello4"));
		statusBar.addToRight(new JazzClock());
		contentPane.add(statusBar, BorderLayout.SOUTH);

		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);
	}
}
