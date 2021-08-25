/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.dwarf.IntegerProperty;
import com.elex_project.dwarf.StringProperty;

import javax.swing.*;
import java.awt.*;

class JazzStatusBarBuilderTest {

	public static void main(String... args) {
		final JMenuBar jMenuBar = JazzMenuBarBuilder.builder()
				.menu("File")
				.item("1", null)
				.and()
				.menu("Edit")
				.item("22", null)
				.separator()
				.item(new JazzMenuBuilder("Oh")
						.item("dd", null)
						.toMenu())
				.build();

		final JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(new JazzStatusBarBuilder()
				.add(new JLabel("Hello"))
				.addGap(4)
				.add("Haha")
				.addGlue()
				.add("Hihihi")
				.addGap(4)
						.addProgressBar(new IntegerProperty(10),0,100,
								60,14)
				.add(new StringProperty("Mmm.."))
				.build(), BorderLayout.SOUTH);

		new JazzFrameBuilder()
				.content(jPanel)
				.menu(jMenuBar)
				.buildAndLaunch();
	}
}
