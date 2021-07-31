/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.jazz.styler.BoldStyler;
import com.elex_project.jazz.styler.ItalicStyler;
import com.elex_project.jazz.styler.Styler;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated //기존에 지정된 스타일을 해제시킬 방법이 필요함.
@Slf4j
public class JazzMarkdownEditor extends JTextPane {

	private final Map<Pattern, Styler> stylerMap;

	public JazzMarkdownEditor() {
		super();
		stylerMap = new HashMap<>();
		init();
	}

	private void init() {
		setEditorKit(new StyledEditorKit());
		getStyledDocument().addStyle("DEFAULT", null);
		stylerMap.put(Pattern.compile(BoldStyler.MD_PATTERN), new BoldStyler());
		stylerMap.put(Pattern.compile(ItalicStyler.MD_PATTERN), new ItalicStyler());

		log.debug("Hello~");
		//this.add
		this.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent documentEvent) {
				log.debug("insertUpdate");
				updateStyles();
			}

			@Override
			public void removeUpdate(DocumentEvent documentEvent) {
				log.debug("removeUpdate");
				updateStyles();
			}

			@Override
			public void changedUpdate(DocumentEvent documentEvent) {
				log.debug("changedUpdate");
				//updateStyles();
			}
		});
	}

	private void updateStyles() {

		for (final Pattern pattern : stylerMap.keySet()) {
			final Matcher matcher = pattern.matcher(getText());
			while (matcher.find()) {
				log.debug("Found: {}.", matcher.group());
				stylerMap.get(pattern).apply(getStyledDocument(), matcher);
			}
		}

	}

}
