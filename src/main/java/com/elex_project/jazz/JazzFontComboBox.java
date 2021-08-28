/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.dwarf.ObjectProperty;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@Slf4j
public class JazzFontComboBox extends JComboBox<Font> {
	public JazzFontComboBox() {
		this(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts());
	}

	public JazzFontComboBox(final Font[] fonts) {
		super(fonts);

		this.setRenderer(new FontLabel());
	}

	public void linkProperty(@NotNull final ObjectProperty<Font> fontProperty) {
		this.addItemListener(itemEvent
				-> fontProperty.set((Font) getSelectedItem()));
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
