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
	@Contract(" -> new")
	public static @NotNull GridBagConstraintsBuilder builder() {
		return new GridBagConstraintsBuilder();
	}

	private final GridBagConstraints constraints;

	public GridBagConstraintsBuilder() {
		constraints = new GridBagConstraints();
		//constraints.gridx = GridBagConstraints.RELATIVE;
		//constraints.gridy = GridBagConstraints.RELATIVE;
	}

	public GridBagConstraints build() {
		return constraints;
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

	public GridBagConstraintsBuilder widthLast() {
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		return this;
	}

	public GridBagConstraintsBuilder widthNextToLast() {
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		return this;
	}

	public GridBagConstraintsBuilder height(@Range(from = 0, to = Integer.MAX_VALUE) final int cell) {
		constraints.gridheight = cell;
		return this;
	}

	public GridBagConstraintsBuilder heightLast() {
		constraints.gridheight = GridBagConstraints.REMAINDER;
		return this;
	}

	public GridBagConstraintsBuilder heightNextToLast() {
		constraints.gridheight = GridBagConstraints.RELATIVE;
		return this;
	}

	public GridBagConstraintsBuilder fillVertical() {
		constraints.fill = GridBagConstraints.VERTICAL;
		return this;
	}

	public GridBagConstraintsBuilder fillHorizontal() {
		constraints.fill = GridBagConstraints.HORIZONTAL;
		return this;
	}

	public GridBagConstraintsBuilder fillBoth() {
		constraints.fill = GridBagConstraints.BOTH;
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

	public GridBagConstraintsBuilder anchorToFirstLineStart() {
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		return this;
	}

	public GridBagConstraintsBuilder anchorToLineStart() {
		constraints.anchor = GridBagConstraints.LINE_START;
		return this;
	}

	public GridBagConstraintsBuilder anchorToLastLineStart() {
		constraints.anchor = GridBagConstraints.LAST_LINE_START;
		return this;
	}

	public GridBagConstraintsBuilder anchorToPageStart() {
		constraints.anchor = GridBagConstraints.PAGE_START;
		return this;
	}

	public GridBagConstraintsBuilder anchorToCenter() {
		constraints.anchor = GridBagConstraints.CENTER;
		return this;
	}

	public GridBagConstraintsBuilder anchorToPageEnd() {
		constraints.anchor = GridBagConstraints.PAGE_END;
		return this;
	}

	public GridBagConstraintsBuilder anchorToFirstLineEnd() {
		constraints.anchor = GridBagConstraints.FIRST_LINE_END;
		return this;
	}

	public GridBagConstraintsBuilder anchorToLineEnd() {
		constraints.anchor = GridBagConstraints.LINE_END;
		return this;
	}

	public GridBagConstraintsBuilder anchorToLastLineEnd() {
		constraints.anchor = GridBagConstraints.LAST_LINE_END;
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
}
