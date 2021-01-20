/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.sphinx;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MultilineLabelTest {

	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		MultilineLabel label = new MultilineLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ultricies rhoncus magna. Pellentesque laoreet nec purus nec congue. Etiam blandit, ipsum et aliquam mollis, justo velit iaculis nunc, ac auctor tellus ligula quis tellus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus nec libero urna. Integer non tincidunt massa. Maecenas vitae ornare tellus, quis laoreet massa.");
		JLabel labelA = new JLabel("Hello: ");
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		labelA.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.add(labelA);
		contentPane.add(label);

		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}
}
