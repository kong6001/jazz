/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.ActionListener;

@Slf4j
public final class JazzMenuItemBuilder {
	private final JMenuItem jMenuItem;

	public JazzMenuItemBuilder() {
		jMenuItem = new JMenuItem();
	}

	public static JazzMenuItemBuilder builder() {
		return new JazzMenuItemBuilder();
	}

	public JMenuItem build() {
		return jMenuItem;
	}

	public JazzMenuItemBuilder title(final String title) {
		jMenuItem.setText(title);

		return this;
	}

	public JazzMenuItemBuilder icon(final Icon icon) {
		jMenuItem.setIcon(icon);

		return this;
	}

	public JazzMenuItemBuilder mnemonic(final int key) {
		jMenuItem.setMnemonic(key);

		return this;
	}

	public JazzMenuItemBuilder accelerator(final KeyStroke keyStroke) {
		jMenuItem.setAccelerator(keyStroke);

		return this;
	}

	public JazzMenuItemBuilder listener(final ActionListener listener) {
		jMenuItem.addActionListener(listener);

		return this;
	}
}
