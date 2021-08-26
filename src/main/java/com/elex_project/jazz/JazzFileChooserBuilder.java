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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.io.File;
import java.nio.file.Path;

@Slf4j
public final class JazzFileChooserBuilder {
	@Contract(" -> new")
	public static @NotNull JazzFileChooserBuilder builder() {
		return new JazzFileChooserBuilder();
	}

	private final JFileChooser jFileChooser;

	public JazzFileChooserBuilder() {
		jFileChooser = new JFileChooser();
		jFileChooser.setMultiSelectionEnabled(false);
		jFileChooser.setAcceptAllFileFilterUsed(false);
		jFileChooser.setFileHidingEnabled(false);
	}

	public JFileChooser build() {
		return jFileChooser;
	}

	public JazzFileChooserBuilder multiSelection() {
		jFileChooser.setMultiSelectionEnabled(true);
		return this;
	}

	public JazzFileChooserBuilder acceptAllFileFilter() {
		jFileChooser.setAcceptAllFileFilterUsed(true);
		return this;
	}

	public JazzFileChooserBuilder currentDir(final File dir) {
		jFileChooser.setCurrentDirectory(dir);
		return this;
	}

	@Contract("_ -> this")
	public JazzFileChooserBuilder currentDir(final @NotNull Path dir) {
		jFileChooser.setCurrentDirectory(dir.toFile());
		return this;
	}

	public JazzFileChooserBuilder currentDir(final String dir) {
		jFileChooser.setCurrentDirectory(new File(dir));
		return this;
	}

	public JazzFileChooserBuilder fileView(final FileView fileView) {
		jFileChooser.setFileView(fileView);
		return this;
	}

	@Contract("_ -> this")
	public JazzFileChooserBuilder fileFilter(final FileFilter @NotNull ... filters) {
		jFileChooser.setFileFilter(filters[0]);
		if (filters.length > 1) {
			for (int i = 1; i < filters.length; i++) {
				jFileChooser.addChoosableFileFilter(filters[i]);
			}
		}
		return this;
	}

	public JazzFileChooserBuilder withHiddenFiles() {
		jFileChooser.setFileHidingEnabled(true);
		return this;
	}

	public JazzFileChooserBuilder filesOnly() {
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		return this;
	}

	public JazzFileChooserBuilder directoriesOnly() {
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		return this;
	}

	public JazzFileChooserBuilder filesAndDirectories() {
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		return this;
	}
}
