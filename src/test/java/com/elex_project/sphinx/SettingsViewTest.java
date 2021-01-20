/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.sphinx;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SettingsViewTest {

	public static void main(String... atgs){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		SettingsView settingsView1 = new SettingsView(
				"Title 1", "Desc 1", null, new JButton("Click"));
		SettingsView settingsView2 = new SettingsView(
				"Title 2", "Desc 2", null, new JComboBox<String>(new String[]{"A", "B", "C"}));
		SettingsView settingsView3 = new SettingsView(
				"Title 3", "Desc 3", null, new JCheckBox("haha"));

		contentPane.add(settingsView1);
		contentPane.add(new JSeparator());
		contentPane.add(settingsView2);
		contentPane.add(new JSeparator());
		contentPane.add(settingsView3);

		jFrame.setContentPane(new JScrollPane(contentPane));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setLocationRelativeTo(null);
		jFrame.pack();
		jFrame.setVisible(true);
	}
}
