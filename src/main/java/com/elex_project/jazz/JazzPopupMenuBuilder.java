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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Slf4j

public final class JazzPopupMenuBuilder {
	private final JPopupMenu jPopupMenu;

	public JazzPopupMenuBuilder() {
		jPopupMenu = new JPopupMenu();
	}

	@Contract(" -> new")
	public static @NotNull JazzPopupMenuBuilder builder() {
		return new JazzPopupMenuBuilder();
	}

	public JPopupMenu build() {
		return jPopupMenu;
	}

	public JPopupMenu clickTriggerTo(final @NotNull JComponent component) {
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jPopupMenu.show(component, e.getX(), e.getY());
			}
		});
		return jPopupMenu;
	}

	public JPopupMenu hoverTriggerTo(final @NotNull JComponent component) {
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jPopupMenu.show(component, e.getX(), e.getY());
			}
		});
		return jPopupMenu;
	}

	public JazzPopupMenuBuilder item(final JMenuItem menuItem) {
		jPopupMenu.add(menuItem);

		return this;
	}

	public JazzPopupMenuBuilder item(final JMenu menu) {
		jPopupMenu.add(menu);

		return this;
	}

	public JazzPopupMenuBuilder item(final JPopupMenu menu) {
		jPopupMenu.add(menu);

		return this;
	}

	public JazzPopupMenuBuilder item(final Action menuItem) {
		jPopupMenu.add(new JMenuItem(menuItem));

		return this;
	}

	public JazzPopupMenuBuilder item(final String menuItem, final Icon icon, final ActionListener listener) {
		final JMenuItem jMenuItem = new JMenuItem(menuItem, icon);
		jMenuItem.addActionListener(listener);
		jPopupMenu.add(jMenuItem);

		return this;
	}

	public JazzPopupMenuBuilder item(final String menuItem, final ActionListener listener) {
		final JMenuItem jMenuItem = new JMenuItem(menuItem);
		jMenuItem.addActionListener(listener);
		jPopupMenu.add(jMenuItem);

		return this;
	}

	public JazzPopupMenuBuilder separator() {
		jPopupMenu.addSeparator();
		return this;
	}
}
