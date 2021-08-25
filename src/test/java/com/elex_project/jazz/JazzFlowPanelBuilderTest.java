/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class JazzFlowPanelBuilderTest {

	public static void main(String... args){
		JazzBuilders.frame()
				.content(JazzBuilders.flowLayout()
						.add(new JButton("A0"))
						.add(new JButton("A1"))
						.add(new JButton("A2"))
						.add(new JButton("A3"))
						.add(new JButton("A4"))
						.add(new JButton("A5"))
						.add(new JButton("A6"))
						.add(new JButton("A7"))
						.add(new JButton("A8"))
						.add(new JButton("A9"))
						.add(new JButton("A10"))
						.alignTrailing()
						.gap(4,2)
						.build())
				.buildAndLaunch();
	}
}
