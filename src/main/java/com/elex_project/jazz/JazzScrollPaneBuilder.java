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
import javax.swing.border.Border;

@Slf4j
public final class JazzScrollPaneBuilder {
	@Contract(" -> new")
	public static @NotNull JazzScrollPaneBuilder builder() {
		return new JazzScrollPaneBuilder();
	}

	private final JScrollPane jScrollPane;

	public JazzScrollPaneBuilder() {
		jScrollPane = new JScrollPane();
	}

	public JScrollPane build() {
		return jScrollPane;
	}

	public JazzScrollPaneBuilder border(final Border border) {
		jScrollPane.setBorder(border);
		return this;
	}

	public JazzScrollPaneBuilder border(final int border) {
		jScrollPane.setBorder(BorderFactory
				.createEmptyBorder(border, border, border, border));
		return this;
	}

	public JazzScrollPaneBuilder border(final int h, final int v) {
		jScrollPane.setBorder(BorderFactory
				.createEmptyBorder(v, h, v, h));
		return this;
	}

	public JazzScrollPaneBuilder border(final int t, final int l, final int b, final int r) {
		jScrollPane.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzScrollPaneBuilder with(final @NotNull JComponent child) {
		jScrollPane.getViewport().setView(child);
		return this;
	}

	@Contract("_ -> this")
	public JazzScrollPaneBuilder horizontal(final @NotNull Policy policy) {
		jScrollPane.setHorizontalScrollBarPolicy(policy.getValue(true));//jScrollPane.set
		return this;
	}

	@Contract("_ -> this")
	public JazzScrollPaneBuilder vertical(final @NotNull Policy policy) {
		jScrollPane.setVerticalScrollBarPolicy(policy.getValue(false));
		return this;
	}

	public enum Policy {
		AUTO, NEVER, ALWAYS;

		int getValue(boolean isHorizontal) {
			switch (this) {
				case AUTO:
					return isHorizontal ? JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
							: JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
				case NEVER:
					return isHorizontal ? JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
							: JScrollPane.VERTICAL_SCROLLBAR_NEVER;
				case ALWAYS:
					return isHorizontal ? JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
							: JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
			}
			throw new RuntimeException("Not an Enum member.");
		}
	}
}
