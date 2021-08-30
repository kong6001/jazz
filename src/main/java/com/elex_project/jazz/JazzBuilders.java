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

@Slf4j
public final class JazzBuilders {

	private JazzBuilders() {

	}

	@Contract(" -> new")
	public static @NotNull JazzBoxPanelBuilder boxLayout() {
		return new JazzBoxPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzFlowPanelBuilder flowLayout() {
		return new JazzFlowPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzCardPanelBuilder cardLayout() {
		return new JazzCardPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzGridPanelBuilder gridLayout() {
		return new JazzGridPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzGridBagPanelBuilder gridBagLayout() {
		return new JazzGridBagPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzBorderPanelBuilder borderLayout() {
		return new JazzBorderPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzTabbedPanelBuilder tabbedLayout() {
		return new JazzTabbedPanelBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzSplitPaneBuilder splitLayout() {
		return new JazzSplitPaneBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzScrollPaneBuilder scrollable() {
		return new JazzScrollPaneBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzStatusBarBuilder statusBar() {
		return new JazzStatusBarBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzToolBarBuilder toolBar() {
		return new JazzToolBarBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzMenuBarBuilder menuBar() {
		return new JazzMenuBarBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzMenuBuilder menu() {
		return new JazzMenuBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzPopupMenuBuilder popupMenu() {
		return new JazzPopupMenuBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzActionBuilder action() {
		return new JazzActionBuilder();
	}

	public static @NotNull JazzDialogBuilder dialog(final JFrame parent) {
		return new JazzDialogBuilder(parent);
	}

	public static @NotNull JazzOptionDialogBuilder optionDialog() {
		return new JazzOptionDialogBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzFrameBuilder frame() {
		return new JazzFrameBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzFileChooserBuilder fileChooser() {
		return new JazzFileChooserBuilder();
	}

	@Contract(" -> new")
	public static @NotNull GridBagConstraintsBuilder constraints() {
		return new GridBagConstraintsBuilder();
	}

	@Contract(" -> new")
	public static @NotNull JazzButtonBuilder button() {
		return new JazzButtonBuilder();
	}

}
