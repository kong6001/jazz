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
import java.awt.*;

@Slf4j
public final class JazzOptionDialogBuilder {
	private final JOptionPane jOptionPane;

	public JazzOptionDialogBuilder() {
		jOptionPane = new JOptionPane();
	}

	@Contract(" -> new")
	public static @NotNull JazzOptionDialogBuilder builder() {
		return new JazzOptionDialogBuilder();
	}

	public JOptionPane build() {
		return jOptionPane;
	}

	/**
	 * @param parent jFrame
	 * @param title  title
	 * @return UNINITIALIZED_VALUE or null or button number or user input object
	 */
	public Object launch(final Component parent, final String title) {
		final JDialog jDialog = jOptionPane.createDialog(parent, title);
		/*jOptionPane.addPropertyChangeListener(
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						String prop = e.getPropertyName();

						if (jDialog.isVisible()
								&& (e.getSource() == jOptionPane)
								&& (prop.equals(JOptionPane.VALUE_PROPERTY))) {
							//If you were going to check something
							//before closing the window, you'd do
							//it here.
							jDialog.setVisible(false);
						}
					}
				});*/
		jDialog.pack();

		jDialog.setVisible(true);

		if (jOptionPane.getWantsInput()) {
			return jOptionPane.getInputValue();
		} else {
			return jOptionPane.getValue();
		}
	}

	public JazzOptionDialogBuilder plainType() {
		jOptionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
		return this;
	}

	public JazzOptionDialogBuilder informationType() {
		jOptionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		return this;
	}

	public JazzOptionDialogBuilder errorType() {
		jOptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
		return this;
	}

	public JazzOptionDialogBuilder warningType() {
		jOptionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
		return this;
	}

	public JazzOptionDialogBuilder questionType() {
		jOptionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		return this;
	}

	public JazzOptionDialogBuilder defaultButtons() {
		jOptionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
		return this;
	}

	public JazzOptionDialogBuilder yesNoButtons() {
		jOptionPane.setOptionType(JOptionPane.YES_NO_OPTION);
		return this;
	}

	public JazzOptionDialogBuilder yesNoCancelButtons() {
		jOptionPane.setOptionType(JOptionPane.YES_NO_CANCEL_OPTION);
		return this;
	}

	public JazzOptionDialogBuilder okCancelButtons() {
		jOptionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		return this;
	}

	public JazzOptionDialogBuilder buttons(final JComponent... buttons) {
		jOptionPane.setOptions(buttons);
		return this;
	}

	public JazzOptionDialogBuilder buttons(final String... buttons) {
		jOptionPane.setOptions(buttons);
		return this;
	}

	public JazzOptionDialogBuilder options(final Object... values) {
		jOptionPane.setSelectionValues(values);
		return this;
	}

	public JazzOptionDialogBuilder message(final String message) {
		jOptionPane.setMessage(message);
		return this;
	}

	public JazzOptionDialogBuilder icon(final Icon icon) {
		jOptionPane.setIcon(icon);
		return this;
	}

	public JazzOptionDialogBuilder value(final Object initialValue) {
		jOptionPane.setInitialValue(initialValue);
		jOptionPane.setWantsInput(true);
		return this;
	}
}
