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
import java.io.File;
import java.util.List;

public class FileDropHelperTest {
	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());

		JPanel dropFileHere = new JPanel();
		dropFileHere.add(new JLabel("Drop here"));

		FileDropHelper.makeDroppable(dropFileHere,files->{
			for (File file : files){
				System.out.println(file.toString());
			}
		});

		contentPane.add(dropFileHere, BorderLayout.CENTER);


		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);


	}
}
