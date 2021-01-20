/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.sphinx;

import javax.swing.*;
import java.awt.*;

public final class EmptyIcon implements Icon {
	private final int width, height;

	public EmptyIcon(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void paintIcon(Component component, Graphics graphics, int i, int i1) {

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
