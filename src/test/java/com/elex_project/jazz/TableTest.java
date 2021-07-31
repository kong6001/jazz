/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class TableTest {
	public static void main(String... args){
		JFrame jFrame = new JFrame("Test");

		JPanel contentPane = new JPanel(new BorderLayout());
		final DefaultTableModel model = new DefaultTableModel(new String[]{"A", "B"}, 0);
		final JTable table = new JTable(model);

		model.addRow(new Object[]{true, "12a"});
		model.addRow(new Object[]{false, "f12f"});
		//model.add

		final JToolBar toolBar = new JToolBar();
		final JButton btn1 = new JButton("Button");
		btn1.addActionListener(e->{
			int row = table.getSelectedRow();
			model.moveRow(row,row,row+1);
		});
		toolBar.add(btn1);
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		jFrame.setContentPane(contentPane);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);
	}

	private static class Model extends DefaultTableModel{
		public Model(Object[] columnNames, int rowCount) {
			super(columnNames, rowCount);
		}
	}
}
