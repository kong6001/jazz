/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.dwarf.EnumProperty;
import com.elex_project.dwarf.IntegerProperty;
import com.elex_project.dwarf.PropertyListener;
import com.elex_project.dwarf.StringProperty;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Build a JPanel with a H-Box layout.
 */
@Slf4j
public final class JazzStatusBarBuilder {
	private final JPanel statusBar;

	public JazzStatusBarBuilder() {
		statusBar = new JPanel();
		statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.X_AXIS));
		statusBar.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
	}

	@Contract(" -> new")
	public static @NotNull JazzStatusBarBuilder builder() {
		return new JazzStatusBarBuilder();
	}

	public JPanel build() {
		return statusBar;
	}

	public JazzStatusBarBuilder border(final int padding) {
		statusBar.setBorder(BorderFactory
				.createEmptyBorder(padding, padding, padding, padding));
		return this;
	}

	public JazzStatusBarBuilder border(final int t, final int l, final int b, final int r) {
		statusBar.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzStatusBarBuilder border(final Border border) {
		statusBar.setBorder(border);
		return this;
	}

	public JazzStatusBarBuilder alignX(final float align) {
		statusBar.setAlignmentX(align);
		return this;
	}

	public JazzStatusBarBuilder alignY(final float align) {
		statusBar.setAlignmentY(align);
		return this;
	}

	public JazzStatusBarBuilder add(final JComponent child) {
		statusBar.add(child);
		return this;
	}

	public JazzStatusBarBuilder add(final String child) {
		statusBar.add(new JLabel(child));
		return this;
	}

	public JazzStatusBarBuilder addGlue() {
		statusBar.add(Box.createHorizontalGlue());
		return this;
	}

	public JazzStatusBarBuilder addStrut(final int width) {
		statusBar.add(Box.createHorizontalStrut(width));
		return this;
	}

	public JazzStatusBarBuilder addGap(final int width) {
		statusBar.add(Box.createRigidArea(new Dimension(width, 0)));
		return this;
	}

	public JazzStatusBarBuilder add(final @NotNull StringProperty property) {
		final JLabel jLabel = new JLabel();
		jLabel.setText(property.get());
		property.addListener((PropertyListener<String>) (oldValue, newValue)
				-> jLabel.setText(newValue));
		statusBar.add(jLabel);
		return this;
	}

	public JazzStatusBarBuilder add(final @NotNull IntegerProperty property) {
		final JLabel jLabel = new JLabel();
		jLabel.setText(null == property.get() ? null : String.valueOf(property.get()));
		property.addListener((PropertyListener<Integer>) (oldValue, newValue)
				-> jLabel.setText(String.valueOf(newValue)));
		statusBar.add(jLabel);
		return this;
	}

	public <T extends Enum<?>> JazzStatusBarBuilder add(final @NotNull EnumProperty<T> property) {
		final JLabel jLabel = new JLabel();
		jLabel.setText(null == property.get() ? null : property.get().toString());
		property.addListener((PropertyListener<T>) (oldValue, newValue)
				-> jLabel.setText(newValue.toString()));
		statusBar.add(jLabel);
		return this;
	}


}
