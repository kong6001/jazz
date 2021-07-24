/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
class JazzWindowTest {

	public static void main(String... args){
		log.info("Test");
		log.info("isTraceEnabled? {}", log.isTraceEnabled());
		JPanel contentPane = new JPanel();
		contentPane.add(new JButton("Click!"));
		new JazzWindow.Builder()
				.title("Hello")
				.size(800,600)
				.content(contentPane)
				.build().start();
	}
}
