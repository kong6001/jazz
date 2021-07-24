/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import javax.swing.*;

import java.awt.*;

class FileTreeTest {

	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());
		JazzFileTreeView fileTreeView = new JazzFileTreeView();
		contentPane.add(new JScrollPane(fileTreeView), BorderLayout.CENTER);

		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);
	}
}
