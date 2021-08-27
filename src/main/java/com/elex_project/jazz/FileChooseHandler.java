/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.io.File;

@Slf4j
public abstract class FileChooseHandler {
	private final JFileChooser jFileChooser;

	public FileChooseHandler(final JFileChooser jFileChooser) {
		this.jFileChooser = jFileChooser;
	}

	public final void showOpenDialog(final Component parent) {
		handle(jFileChooser.showOpenDialog(parent));
	}

	public final void showSaveDialog(final Component parent) {
		handle(jFileChooser.showSaveDialog(parent));
	}

	public final void showDialog(final Component parent, final String approveButtonText) {
		handle(jFileChooser.showDialog(parent, approveButtonText));
	}

	private void handle(final int result) {
		if (result == JFileChooser.APPROVE_OPTION) {
			if (jFileChooser.isMultiSelectionEnabled()) {
				onApproved(jFileChooser, jFileChooser.getSelectedFiles());
			} else {
				onApproved(jFileChooser, jFileChooser.getSelectedFile());
			}
		} else if (result == JFileChooser.CANCEL_OPTION) {
			onCancel(jFileChooser);
		} else if (result == JFileChooser.ERROR_OPTION) {
			onError(jFileChooser);
		}
	}

	/**
	 * Override this
	 *
	 * @param jFileChooser jFileChooser
	 * @param file         selected file
	 */
	public void onApproved(final JFileChooser jFileChooser, final File file) {
	}

	/**
	 * Override this
	 *
	 * @param jFileChooser jFileChooser
	 * @param files        selected files
	 */
	public void onApproved(final JFileChooser jFileChooser, final File[] files) {
	}

	/**
	 * Override this
	 *
	 * @param jFileChooser jFileChooser
	 */
	public void onCancel(final JFileChooser jFileChooser) {
	}

	/**
	 * Override this
	 *
	 * @param jFileChooser jFileChooser
	 */
	public void onError(final JFileChooser jFileChooser) {
	}
}
