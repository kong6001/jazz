/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;


import javax.swing.*;
import javax.swing.tree.TreePath;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class JazzDirTreeViewTest {

	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		final JazzDirTreeView view = new JazzDirTreeView();
		final JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(new JScrollPane(view), BorderLayout.CENTER);

		final JButton btn = new JButton("Test");
		btn.addActionListener(e->{
			//System.out.println(view.getLastSelectedPathComponent().toString());
			/*view.expandPath(new TreePath(new JazzDirTreeView.Node[]{
					new JazzDirTreeView.Node("/"),
					new JazzDirTreeView.Node("/media"),
					new JazzDirTreeView.Node("/media/elex")
			}));*/
		});
		contentPane.add(btn, BorderLayout.NORTH);

		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);
	}
}
