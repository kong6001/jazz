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
import java.util.HashMap;
import java.util.Map;

@Slf4j
public final class JazzActionBuilder {
	private final Map<String, Object> map;
	private ActionListener actionListener;

	public JazzActionBuilder() {
		map = new HashMap<>();
	}

	@Contract(value = " -> new", pure = true)
	public static @NotNull JazzActionBuilder builder() {
		return new JazzActionBuilder();
	}

	@Contract(" -> new")
	public @NotNull Action build() {
		return new JazzAction(map, actionListener);
	}

	public @NotNull Action build(final ActionListener listener) {
		return new JazzAction(map, listener);
	}

	/**
	 * @return map
	 * @see JazzAction#JazzAction(Map, ActionListener)
	 */
	public Map<String, Object> toMap() {
		return map;
	}

	public JazzActionBuilder title(final String title) {
		map.put(Action.NAME, title);
		return this;
	}

	public JazzActionBuilder icon(final ImageIcon icon) {
		map.put(Action.SMALL_ICON, icon);
		return this;
	}

	public JazzActionBuilder icon(final Icon icon) {
		map.put(Action.LARGE_ICON_KEY, icon);
		return this;
	}

	public JazzActionBuilder desc(final String desc) {
		map.put(Action.SHORT_DESCRIPTION, desc);
		return this;
	}

	public JazzActionBuilder description(final String desc) {
		map.put(Action.LONG_DESCRIPTION, desc);
		return this;
	}

	/**
	 * @param keyStroke keyStroke
	 * @return ..
	 * @see KeyStroke
	 */
	public JazzActionBuilder accelerator(final KeyStroke keyStroke) {
		map.put(Action.ACCELERATOR_KEY, keyStroke);
		return this;
	}

	/**
	 * @param key key
	 * @return ..
	 * @see java.awt.event.KeyEvent
	 */
	public JazzActionBuilder mnemonic(final int key) {
		map.put(Action.MNEMONIC_KEY, key);
		return this;
	}

	public JazzActionBuilder command(final String command) {
		map.put(Action.ACTION_COMMAND_KEY, command);
		return this;
	}

	public JazzActionBuilder listener(final ActionListener listener) {
		this.actionListener = listener;
		return this;
	}

}
