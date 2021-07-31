/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz.styler;

import javax.swing.text.StyledDocument;
import java.util.regex.Matcher;

public interface Styler {

	public void apply(final StyledDocument document, final Matcher matcher, final boolean override);
	public void apply(final StyledDocument document, final Matcher matcher);
	public void apply(final StyledDocument document, final int offset, final int length, final boolean override);
	public void apply(final StyledDocument document, final int offset, final int length);

}
