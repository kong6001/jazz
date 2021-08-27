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
import org.jetbrains.annotations.Range;

import java.awt.*;

@Slf4j
public final class GridBagConstraintsBuilder {
	private final GridBagConstraints constraints;

	public GridBagConstraintsBuilder() {
		constraints = new GridBagConstraints();
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.gridy = GridBagConstraints.RELATIVE;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.LINE_START;
	}

	@Contract(" -> new")
	public static @NotNull GridBagConstraintsBuilder builder() {
		return new GridBagConstraintsBuilder();
	}

	public GridBagConstraints build() {
		return constraints;
	}

	public GridBagConstraintsBuilder grid(@Range(from = 0, to = Integer.MAX_VALUE) final int x,
	                                      @Range(from = 0, to = Integer.MAX_VALUE) final int y) {
		constraints.gridx = x;
		constraints.gridy = y;
		return this;
	}

	public GridBagConstraintsBuilder x(@Range(from = 0, to = Integer.MAX_VALUE) final int x) {
		constraints.gridx = x;
		return this;
	}

	public GridBagConstraintsBuilder y(@Range(from = 0, to = Integer.MAX_VALUE) final int y) {
		constraints.gridy = y;
		return this;
	}

	public GridBagConstraintsBuilder width(@Range(from = 0, to = Integer.MAX_VALUE) final int cell) {
		constraints.gridwidth = cell;
		return this;
	}

	@Contract("_ -> this")
	public GridBagConstraintsBuilder width(final @NotNull GridSize width) {
		constraints.gridwidth = width.value;
		return this;
	}

	public GridBagConstraintsBuilder height(@Range(from = 0, to = Integer.MAX_VALUE) final int cell) {
		constraints.gridheight = cell;
		return this;
	}

	@Contract("_ -> this")
	public GridBagConstraintsBuilder height(final @NotNull GridSize height) {
		constraints.gridheight = height.value;
		return this;
	}

	@Contract("_ -> this")
	public GridBagConstraintsBuilder fill(final @NotNull Fill fill) {
		constraints.fill = fill.value;
		return this;
	}

	/**
	 * internal padding
	 *
	 * @param x x
	 * @param y y
	 * @return ..
	 */
	public GridBagConstraintsBuilder padding(final int x, final int y) {
		constraints.ipadx = x;
		constraints.ipady = y;
		return this;
	}

	/**
	 * external padding
	 *
	 * @param insets insets
	 * @return ..
	 */
	public GridBagConstraintsBuilder insets(final Insets insets) {
		constraints.insets = insets;
		return this;
	}

	public GridBagConstraintsBuilder insets(final int t, final int l, final int b, final int r) {
		constraints.insets = new Insets(t, l, b, r);
		return this;
	}

	public GridBagConstraintsBuilder insets(final int hInset, final int vInset) {
		constraints.insets = new Insets(vInset, hInset, vInset, hInset);
		return this;
	}

	public GridBagConstraintsBuilder insets(final int insets) {
		constraints.insets = new Insets(insets, insets, insets, insets);
		return this;
	}

	@Contract("_ -> this")
	public GridBagConstraintsBuilder anchor(final @NotNull Anchor anchor) {
		constraints.anchor = anchor.value;
		return this;
	}

	public GridBagConstraintsBuilder weightX(final @Range(from = 0, to = 1) float x) {
		constraints.weightx = x;
		return this;
	}

	public GridBagConstraintsBuilder weightY(final @Range(from = 0, to = 1) float y) {
		constraints.weighty = y;
		return this;
	}

	public enum GridSize {
		LAST(GridBagConstraints.REMAINDER),
		NEXT_TO_LAST(GridBagConstraints.RELATIVE);
		private final int value;

		GridSize(int value) {
			this.value = value;
		}
	}

	public enum Fill {
		VERTICAL(GridBagConstraints.VERTICAL),
		HORIZONTAL(GridBagConstraints.HORIZONTAL),
		BOTH(GridBagConstraints.BOTH),
		NONE(GridBagConstraints.NONE);

		private final int value;

		Fill(int value) {
			this.value = value;
		}

	}

	public enum Anchor {
		FIRST_LINE_START(GridBagConstraints.FIRST_LINE_START),
		LINE_START(GridBagConstraints.LINE_START),
		LAST_LINE_START(GridBagConstraints.LAST_LINE_START),
		PAGE_START(GridBagConstraints.PAGE_START),
		CENTER(GridBagConstraints.CENTER),
		PAGE_END(GridBagConstraints.PAGE_END),
		FIRST_LINE_END(GridBagConstraints.FIRST_LINE_END),
		LINE_END(GridBagConstraints.LINE_END),
		LAST_LINE_END(GridBagConstraints.LAST_LINE_END);

		private final int value;

		Anchor(int value) {
			this.value = value;
		}
	}
}
