/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class JazzPopupMenuBuilderTest {

	public static void main(String... args){
		final JLabel jLabel = new JLabel("Label");

		JazzBuilders.popupMenu()
				.item("A", e->{
					System.out.println("A");
				})
				.item("B", e->{
					System.out.println("B");
				})
				.item(JazzBuilders.menu()
						.title("C")
						.item("D", e->{
							System.out.println("D");
						})
						.build())
				.hoverTriggerTo(jLabel);

		final JFrame jFrame = JazzBuilders.frame()
				.content(JazzBuilders.flowLayout()
						.add(jLabel)
						.build())
				.buildAndLaunch();
	}
}
