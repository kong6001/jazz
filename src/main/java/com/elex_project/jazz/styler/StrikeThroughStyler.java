/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz.styler;

import lombok.extern.slf4j.Slf4j;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

@Slf4j
public class StrikeThroughStyler extends AbsStyler {
	//public static final String MD_PATTERN = "(\\*{2}|_{2})(.*?)\\1";

	public StrikeThroughStyler() {
		this(false);
	}

	public StrikeThroughStyler(final boolean set) {
		super(new SimpleAttributeSet());
		StyleConstants.setStrikeThrough(getAttributeSet(), set);
	}
}
