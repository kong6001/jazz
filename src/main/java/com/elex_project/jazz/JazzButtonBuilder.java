/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionListener;

@Slf4j
public final class JazzButtonBuilder {
	private String title, tooltip;
	private Icon icon;
	private ActionListener listener;
	private ButtonGroup group;
	private Action action;
	private String actionCommand;

	public JazzButtonBuilder() {

	}

	@Contract(value = " -> new", pure = true)
	public static @NotNull JazzButtonBuilder builder() {
		return new JazzButtonBuilder();
	}

	private void build(final AbstractButton button) {
		if (null != title) button.setText(title);
		if (null != tooltip) button.setToolTipText(tooltip);
		if (null != icon) button.setIcon(icon);
		if (null != listener) button.addActionListener(listener);
		if (null != group) group.add(button);
		if (null != actionCommand) button.setActionCommand(actionCommand);
		if (null != action) button.setAction(action);
	}

	public JazzButtonBuilder title(final String title) {
		this.title = title;
		return this;
	}

	public JazzButtonBuilder tooltip(final String tooltip) {
		this.tooltip = tooltip;
		return this;
	}

	public JazzButtonBuilder icon(final Icon icon) {
		this.icon = icon;
		return this;
	}

	public JazzButtonBuilder listener(final ActionListener listener) {
		this.listener = listener;
		return this;
	}

	public JazzButtonBuilder group(final ButtonGroup group) {
		this.group = group;
		return this;
	}

	public JazzButtonBuilder action(final Action action) {
		this.action = action;
		return this;
	}

	public JazzButtonBuilder actionCommand(final String actionCommand) {
		this.actionCommand = actionCommand;
		return this;
	}

	public @NotNull JButton buildButton() {
		final JButton jButton = new JButton();
		build(jButton);
		return jButton;
	}

	public @NotNull JCheckBox buildCheckBox() {
		final JCheckBox jCheckBox = new JCheckBox();
		build(jCheckBox);
		return jCheckBox;
	}

	public @NotNull JRadioButton buildRadioButton() {
		final JRadioButton jRadioButton = new JRadioButton();
		build(jRadioButton);
		return jRadioButton;
	}
}
