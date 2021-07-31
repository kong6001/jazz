/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz.styler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyledDocument;
import java.util.regex.Matcher;

@Slf4j
abstract class AbsStyler implements Styler {
	/*
	public static $rules = array (

'/(#+)(.*)/' => 'self::header', // headers

'/\[([^\[]+)\]\(([^\)]+)\)/' => '
\1
', // links

'/(\*\*|__)(.*?)\1/' => '
\2
', // bold

'/(\*|_)(.*?)\1/' => '
\2
', // emphasis

'/\~\~(.*?)\~\~/' => '
\1
', // del

'/\:\"(.*?)\"\:/' => '
\1
', // quote

'/`(.*?)`/' => '
\1
', // inline code

'/\n\*(.*)/' => 'self::ul_list', // ul lists

'/\n[0-9]+\.(.*)/' => 'self::ol_list', // ol lists

'/\n(>|\>)(.*)/' => 'self::blockquote ', // blockquotes

'/\n-{5,}/' => "\n
", // horizontal rule

'/\n([^\n]+)\n/' => 'self::para', // add paragraphs

'/<\/ul>\s?
/' => '', // fix extra ul

'/<\/ol>\s?
/' => '', // fix extra ol

'/<\/blockquote>
/' => "\n" // fix extra blockquote
);
	 */
	@Getter(AccessLevel.PROTECTED)
	private final MutableAttributeSet attributeSet;

	protected AbsStyler(final MutableAttributeSet attributeSet){
		this.attributeSet = attributeSet;
	}

	@Override
	public void apply(StyledDocument document, @NotNull Matcher matcher, boolean override) {
		int offset = matcher.start();
		int length = matcher.end() - offset - 1;

		apply(document, offset, length, override);
	}

	@Override
	public void apply(StyledDocument document, int offset, int length, boolean override) {
		SwingUtilities.invokeLater(() -> {
			document.setCharacterAttributes(offset, length, attributeSet, override);
		});
	}

	@Override
	public final void apply(StyledDocument document, int offset, int length) {
		apply(document, offset, length, false);
	}

	@Override
	public final void apply(StyledDocument document, Matcher matcher) {
		apply(document, matcher, false);
	}
}
