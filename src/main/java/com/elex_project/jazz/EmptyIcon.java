/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

@Slf4j
public final class EmptyIcon implements Icon {
	private final int width, height;

	public EmptyIcon(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void paintIcon(Component component, Graphics graphics, int i, int i1) {
		// do nothing, cause it's empty.
	}

	@Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public int getIconHeight() {
		return height;
	}
}
