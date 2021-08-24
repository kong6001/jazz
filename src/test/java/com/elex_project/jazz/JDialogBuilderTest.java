/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JDialogBuilderTest {

	public static void main(String... args){
		JPanel jPanel = new JPanel();
		JFrame jFrame = new JazzFrameBuilder()
				.content(jPanel)
				.build();


		JButton btn = new JButton("Button");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				new JazzDialogBuilder(jFrame)
						.center(new JLabel("Hello"))
						.bottom(new JButton("Close"),
								Box.createHorizontalGlue(),
								new JButton("OK"))
						.buildAndLaunch();
			}
		});
		jPanel.add(btn);


		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				jFrame.setVisible(true);
			}
		});
		//Swin
	}
}
