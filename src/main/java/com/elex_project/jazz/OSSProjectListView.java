/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.StringJoiner;

@Slf4j
public class OSSProjectListView extends JList<OSSProject> {
	public OSSProjectListView(final OSSProject[] projects) {
		super();

		this.setModel(new OSSProjectListModel(projects));
		init();
	}

	public OSSProjectListView(final java.util.List<OSSProject> projects) {
		super();

		this.setModel(new OSSProjectListModel(projects));
		init();
	}

	private void init() {
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setLayoutOrientation(JList.VERTICAL);
		this.setVisibleRowCount(-1);
		this.setCellRenderer(new OSSProjectCellRenderer());

	}

	static class OSSProjectListModel extends DefaultListModel<OSSProject> {

		private OSSProjectListModel(final java.util.@NotNull List<OSSProject> projects) {
			super();
			for (final OSSProject item : projects) {
				this.addElement(item);
			}
		}

		private OSSProjectListModel(final OSSProject @NotNull [] projects) {
			super();
			for (final OSSProject item : projects) {
				this.addElement(item);
			}
		}
	}

	static class OSSProjectCellRenderer extends JPanel implements ListCellRenderer<OSSProject> {

		//private final JPanel vBox, line1, line2;
		private final JLabel lblTitle, lblDeveloper, lblLicense, lblVersion;

		OSSProjectCellRenderer() {
			super(new GridBagLayout());

			this.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
			this.setOpaque(true);

			/*this.vBox = new JPanel();
			this.vBox.setLayout(new BoxLayout(vBox, BoxLayout.PAGE_AXIS));
			this.vBox.setOpaque(true);

			this.line1 = new JPanel();
			this.line1.setLayout(new BoxLayout(line1, BoxLayout.LINE_AXIS));
			this.line1.setOpaque(true);

			this.line2 = new JPanel();
			this.line2.setLayout(new BoxLayout(line2, BoxLayout.LINE_AXIS));
			this.line2.setOpaque(true);*/

			this.lblTitle = new JLabel();
			this.lblVersion = new JLabel();
			lblVersion.setFont(lblVersion.getFont().deriveFont(Font.PLAIN));
			this.lblDeveloper = new JLabel();
			lblDeveloper.setFont(lblDeveloper.getFont().deriveFont(Font.ITALIC));
			this.lblLicense = new JLabel();

			add(lblTitle, JazzBuilders.constraints()
					.grid(0, 0)
					//.weightX(.5f)
					.insets(2)
					.build());
			add(lblVersion, JazzBuilders.constraints()
					.grid(1, 0)
					//.anchor(GridBagConstraintsBuilder.Anchor.LINE_END)
					.insets(2)
					.build());
			add(lblDeveloper, JazzBuilders.constraints()
					.grid(0, 1)
					.width(GridBagConstraintsBuilder.GridSize.LAST)
					//.anchor(GridBagConstraintsBuilder.Anchor.LINE_END)
					.insets(2)
					.build());
			add(lblLicense, JazzBuilders.constraints()
					.grid(0, 2)
					.width(GridBagConstraintsBuilder.GridSize.LAST)
					.insets(2)
					.weightX(1f)
					.build());
			/*this.line1.add(lblTitle);
			this.line1.add(Box.createRigidArea(new Dimension(12, 8)));
			this.line1.add(lblVersion);
			this.line1.add(Box.createHorizontalGlue());
			//this.line1.add(Box.createRigidArea(new Dimension(16,16)));

			this.line2.add(lblDeveloper);
			this.line2.add(Box.createHorizontalGlue());
			//this.line2.add(Box.createRigidArea(new Dimension(16,16)));

			this.vBox.add(line1);
			this.vBox.add(line2);

			this.add(vBox, BorderLayout.CENTER);
			this.add(lblLicense, BorderLayout.EAST);*/

		}

		@Override
		public Component getListCellRendererComponent(final @NotNull JList<? extends OSSProject> jList,
		                                              final @NotNull OSSProject ossProject, final int index, final boolean isSelected, final boolean hasFocus) {

			this.setEnabled(jList.isEnabled());
			StringJoiner joiner;
			this.lblTitle.setText(ossProject.getProject());
			joiner = new StringJoiner(", ");
			for (String item : ossProject.getDevelopers()) {
				joiner.add(item);
				if (joiner.length() > 100) {
					joiner.add("...");
					break;
				}
			}
			this.lblVersion.setText(ossProject.getVersion());
			this.lblDeveloper.setText(joiner.toString());
			joiner = new StringJoiner(", ");
			for (OSSProject.License license : ossProject.getLicenses()) {
				joiner.add(license.getLicense());
			}
			this.lblLicense.setText(joiner.toString());

			this.setToolTipText(ossProject.getDescription());

			if (isSelected) {
				this.lblTitle.setForeground(jList.getSelectionForeground());
				this.lblDeveloper.setForeground(jList.getSelectionForeground());
				this.lblLicense.setForeground(jList.getSelectionForeground());
				this.lblVersion.setForeground(jList.getSelectionForeground());

				this.setBackground(jList.getSelectionBackground());
				/*this.vBox.setBackground(jList.getSelectionBackground());
				this.line1.setBackground(jList.getSelectionBackground());
				this.line2.setBackground(jList.getSelectionBackground());*/

			} else {
				this.lblTitle.setForeground(jList.getForeground());
				this.lblDeveloper.setForeground(jList.getForeground());
				this.lblLicense.setForeground(jList.getForeground());
				this.lblVersion.setForeground(jList.getForeground());

				this.setBackground(jList.getBackground());
				/*this.vBox.setBackground(jList.getBackground());
				this.line1.setBackground(jList.getBackground());
				this.line2.setBackground(jList.getBackground());*/

			}

			return this;
		}

	}
}
