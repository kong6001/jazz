/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

@Slf4j
public class JazzAction extends AbstractAction {
	private ActionListener listener;

	public JazzAction() {
		super();
	}

	public JazzAction(final String name) {
		super(name);
	}

	public JazzAction(final String name, final Icon icon) {
		super(name, icon);
	}

	public JazzAction(final @NotNull Map<String, Object> params, final ActionListener listener) {
		super();
		this.listener = listener;
		for (String key : params.keySet()) {
			this.putValue(key, params.get(key));
		}
	}

	@Override
	public void actionPerformed(final ActionEvent actionEvent) {
		if (null != listener) listener.actionPerformed(actionEvent);
	}
}
