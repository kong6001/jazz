/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import javax.swing.*;

class JazzGridBagPanelBuilderTest {

	public static void main(String... args) {
		final JPanel jPanel = JazzBuilders.gridBagLayout()

				.add(new JLabel("1"), JazzBuilders.constraints()
						.grid(0, 0)
						.width(1)
						.height(1)
						.insets(4, 4)
						.build())
				.add(new JTextField(), JazzBuilders.constraints()
						.grid(1, 0)
						.width(GridBagConstraintsBuilder.GridSize.LAST)
						.fill(GridBagConstraintsBuilder.Fill.HORIZONTAL)
						.height(1)
						.weightX(1f)
						.insets(4, 4)
						.build())
				.add(new JLabel("Hmm"), JazzBuilders.constraints()
						.grid(0, 1)
						.width(1)
						.height(1)
						.insets(4, 4)
						.build())
				.add(new JComboBox<>(new String[]{"A", "B", "C"}), JazzBuilders.constraints()
						.grid(1, 1)
						.width(1)
						.height(1)
						.weightX(1f)
						.insets(4, 4)
						.build())
				.add(new JButton("Button"), JazzBuilders.constraints()
						.grid(2, 1)
						.width(1)
						.height(1)
						.insets(4, 4)
						.build())
				.build();
		//jPanel.setBackground(Color.BLUE);
		JazzBuilders.frame()
				.content(JazzBuilders.borderLayout()
						.center(jPanel)
						.build())
				.buildAndLaunch();
	}
}
