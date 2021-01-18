/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.sphinx;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OSSProjectListViewTest {

	public static void main(String... args) throws IOException {
		JFrame jFrame = new JFrame();
		JPanel contentPane = new JPanel(new BorderLayout());
		jFrame.setContentPane(contentPane);

		final OSSProject[] projects = OSSProject.read(OSSProjectListViewTest.class
				.getResourceAsStream("/licenseReport.json"));
		final OSSProjectListView listView = new OSSProjectListView(projects);
		contentPane.add(new JScrollPane(listView), BorderLayout.CENTER);
		listView.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(final ListSelectionEvent listSelectionEvent) {
				if (!listSelectionEvent.getValueIsAdjusting()) {
					System.out.println(projects[listSelectionEvent.getFirstIndex()].toString());
				}
			}
		});
		contentPane.add(new JLabel("Hello"), BorderLayout.SOUTH);
		jFrame.setSize(800, 600);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle("Test");
		jFrame.setVisible(true);
	}
}