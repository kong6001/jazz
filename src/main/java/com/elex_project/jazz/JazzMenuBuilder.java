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
public final class JazzMenuBuilder {
	private final JazzMenuBarBuilder parent;
	private final JMenu jMenu;

	JazzMenuBuilder(final String name, final JazzMenuBarBuilder parent, final @NotNull JMenuBar jMenuBar) {
		this.parent = parent;
		jMenu = new JMenu(name);
		jMenuBar.add(jMenu);
	}

	JazzMenuBuilder(final Action action, final JazzMenuBarBuilder parent, final @NotNull JMenuBar jMenuBar) {
		this.parent = parent;
		jMenu = new JMenu(action);
		jMenuBar.add(jMenu);
	}

	public JazzMenuBuilder(final String name) {
		this.parent = null;
		jMenu = new JMenu(name);
	}

	public JazzMenuBuilder() {
		this.parent = null;
		jMenu = new JMenu();
	}

	public JazzMenuBuilder(final Action action) {
		this.parent = null;
		jMenu = new JMenu(action);
	}

	public JazzMenuBarBuilder and() {
		if (null == parent) throw new IllegalStateException("This builder wasn't called from MenuBar builder.");

		return parent;
	}

	public JMenuBar buildMenuBar() {
		if (null == parent) throw new IllegalStateException("This builder wasn't called from MenuBar builder.");

		return parent.build();
	}

	public JMenu build() {
		return jMenu;
	}

	public JazzMenuBuilder title(final String title) {
		jMenu.setText(title);

		return this;
	}

	public JazzMenuBuilder icon(final Icon icon) {
		jMenu.setIcon(icon);

		return this;
	}

	public JazzMenuBuilder mnemonic(final int key) {
		jMenu.setMnemonic(key);

		return this;
	}

	public JazzMenuBuilder accelerator(final KeyStroke keyStroke) {
		jMenu.setAccelerator(keyStroke);

		return this;
	}

	public JazzMenuBuilder item(final JMenuItem menuItem) {
		jMenu.add(menuItem);

		return this;
	}

	public JazzMenuBuilder item(final JMenu menu) {
		jMenu.add(menu);

		return this;
	}

	public JazzMenuBuilder item(final Action menuItem) {
		jMenu.add(new JMenuItem(menuItem));

		return this;
	}

	public JazzMenuBuilder item(final String menuItem, final Icon icon, final ActionListener listener) {
		final JMenuItem jMenuItem = new JMenuItem(menuItem, icon);
		jMenuItem.addActionListener(listener);
		jMenu.add(jMenuItem);

		return this;
	}

	public JazzMenuBuilder item(final String menuItem, final ActionListener listener) {
		final JMenuItem jMenuItem = new JMenuItem(menuItem);
		jMenuItem.addActionListener(listener);
		jMenu.add(jMenuItem);

		return this;
	}
	@Contract("_ -> this")
	public JazzMenuBuilder item(final @NotNull JazzMenuItemBuilder menuItem) {
		jMenu.add(menuItem.build());

		return this;
	}
	public JazzMenuBuilder separator() {
		jMenu.addSeparator();
		return this;
	}
}
