/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class EditorPaneTest {
	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditorKit(new StyledEditorKit());
		//editorPane.getDocument().
		contentPane.add(new JScrollPane(editorPane), BorderLayout.CENTER);


		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);
	}
}
