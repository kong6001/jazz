/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.io.IOException;

public class SyntaxPaneTest {
	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());

		RSyntaxTextArea editor = new RSyntaxTextArea();
		//editor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		editor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_MARKDOWN);
		try {
			Theme theme = Theme.load(SyntaxPaneTest.class.getResourceAsStream("/dark.xml"));
			theme.apply(editor);

		} catch (IOException e) {
			e.printStackTrace();
		}
		editor.setSecondaryLanguageBackground(1,Color.GREEN);
		editor.setHighlightCurrentLine(false);
		editor.setFadeCurrentLineHighlight(true);
		editor.setAnimateBracketMatching(true);
		editor.setBracketMatchingEnabled(true);
		editor.setAutoIndentEnabled(true);
		editor.setHighlightSecondaryLanguages(true);
		editor.setCodeFoldingEnabled(true);
		editor.setRoundedSelectionEdges(true);
		editor.setAntiAliasingEnabled(true);
		editor.setCloseCurlyBraces(true);
		editor.setCloseMarkupTags(true);

		JToolBar toolBar = new JToolBar();
		JButton btn1 = new JButton("Get Text");
		btn1.addActionListener(e->{
			System.out.println(editor.getText());
		});
		JButton btn2 = new JButton("Bold");
		btn2.addActionListener(e->{
			//int from = editorPane.getSelectionStart();
			//int to = editorPane.getSelectionEnd();
			//styler.bold(from, to-from);
		});

		toolBar.add(btn1);toolBar.add(btn2);
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(new RTextScrollPane(editor), BorderLayout.CENTER);


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
