/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.abraxas.Console;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class JazzOptionDialogBuilderTest {

	public static void main(String... args){
		final JButton button1 = new JButton("Button 1");
		final JButton button2 = new JButton("Button 2");
		final JButton button3 = new JButton("Button 3");
		final JButton button4 = new JButton("Button 4");

		final JFrame jFrame = JazzBuilders.frame()
				.content(JazzBuilders.flowLayout()
						.gap(4,4)
						.add(button1)
						.add(button2)
						.add(button3)
						.add(button4)
						.build())
				.buildAndLaunch();

		button1.addActionListener(e->{
			Object result = JazzBuilders.optionDialog()
					.questionType()
					.message("Are you sure?")
					.yesNoButtons()
					.launch(jFrame, "Simple Dialog");
			Console.writeLine("Result: {}", result.toString());
		});
		button2.addActionListener(e->{
			Object result = JazzBuilders.optionDialog()
					.plainType()
					.message("Are you sure?")

					.buttons("B1", "B2", "B3")
					.launch(jFrame, "Simple Dialog 2");
			Console.writeLine("Result: {}", result.toString());
		});
		button3.addActionListener(e->{
			Object result = JazzBuilders.optionDialog()
					.plainType()
					.message("Pick?")
					.options("A", "B", "C")
					.okCancelButtons()
					.launch(jFrame, "Simple Dialog 3");
			Console.writeLine("Result: {}", result.toString());
		});
		button4.addActionListener(e->{
			Object result = JazzBuilders.optionDialog()
					.questionType()
					.message("Type?")
					.value(300)
					.okCancelButtons()
					.launch(jFrame, "Simple Dialog 4");
			Console.writeLine("Result: {}", result.toString());
		});
	}
}
