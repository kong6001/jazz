/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class MarkdownEditorTest {
	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());

		JazzMarkdownEditor editorPane = new JazzMarkdownEditor();

		JToolBar toolBar = new JToolBar();
		JButton btn1 = new JButton("Get Text");
		btn1.addActionListener(e->{
			System.out.println(editorPane.getText());
		});
		JButton btn2 = new JButton("Bold");
		btn2.addActionListener(e->{
			int from = editorPane.getSelectionStart();
			int to = editorPane.getSelectionEnd();
			//styler.bold(from, to-from);
		});

		toolBar.add(btn1);toolBar.add(btn2);
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(new JScrollPane(editorPane), BorderLayout.CENTER);


		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);

		//editorPane.setText("Hello");
		//StyledDocument document = (StyledDocument) editorPane.getDocument();
		//document.

		//editorPane.styl
	}
}
