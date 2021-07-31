/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import javax.swing.*;
import java.awt.*;

class JazzInputFormPaneTest {
	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());

		JazzInputForm inputFormPane = new JazzInputForm();
		inputFormPane.add(0,"이름", new JTextField(),"이름을 입력");
		inputFormPane.add(1,"나이", new JSpinner(),"나이 입력");
		inputFormPane.add(2,"아무말이나", new JTextField(),"아무 말이나 입력");
		inputFormPane.addDummy(3);

		contentPane.add(new JScrollPane(inputFormPane), BorderLayout.CENTER);

		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(400, 300);
		jFrame.setVisible(true);
	}
}
