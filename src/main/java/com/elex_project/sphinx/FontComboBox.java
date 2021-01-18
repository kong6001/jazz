/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.sphinx;

import javax.swing.*;
import java.awt.*;

public class FontComboBox extends JComboBox<Font> {
	public FontComboBox() {
		this(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts());
	}

	public FontComboBox(final Font[] fonts) {
		super(fonts);

		this.setRenderer(new FontLabel());
	}

	private static class FontLabel extends JLabel implements ListCellRenderer<Font> {
		private FontLabel() {
			super();
			this.setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Font> jList, Font font, int index, boolean isSelected, boolean hasFocus) {
			this.setEnabled(jList.isEnabled());

			if (font.canDisplay('a')) {
				setFont(font.deriveFont(16f));
			}
			setText(font.getFontName());

			/*if (isSelected){
				this.setForeground(jList.getSelectionForeground());
				this.setBackground(jList.getSelectionBackground());
			} else {
				this.setForeground(jList.getForeground());
				this.setBackground(jList.getBackground());
			}*/

			return this;
		}
	}
}
