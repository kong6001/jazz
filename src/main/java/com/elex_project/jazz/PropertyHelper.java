/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.dwarf.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.util.Optional;

@Slf4j
public final class PropertyHelper {
	private PropertyHelper() {
	}

	public static void link(final @NotNull JLabel jLabel,
	                        final @NotNull StringProperty stringProperty) {
		jLabel.setText(stringProperty.get());
		stringProperty.addListener((PropertyListener<String>) (oldValue, newValue) -> jLabel.setText(newValue));
	}

	public static void link(final @NotNull AbstractButton checkBox,
	                        final @NotNull BooleanProperty booleanProperty) {
		checkBox.setSelected(Optional.ofNullable(booleanProperty.get()).orElse(false));
		booleanProperty.addListener((PropertyListener<Boolean>) (oldValue, newValue) -> checkBox.setSelected(newValue));
		checkBox.addChangeListener(changeEvent -> booleanProperty.set(checkBox.isSelected()));

	}

	public static void link(final @NotNull AbstractButton checkBox,
	                        final @NotNull StringProperty stringProperty) {
		checkBox.setText(stringProperty.get());
		stringProperty.addListener((PropertyListener<String>) (oldValue, newValue) -> checkBox.setText(newValue));

	}

	public static void link(final @NotNull JTextComponent textField,
	                        final @NotNull StringProperty stringProperty) {
		textField.setText(stringProperty.get());
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent documentEvent) {
				stringProperty.set(textField.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent documentEvent) {
				stringProperty.set(textField.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent documentEvent) {
				stringProperty.set(textField.getText());
			}
		});

	}

	public static void link(final @NotNull JProgressBar jProgressBar,
	                        final @NotNull IntegerProperty integerProperty) {
		setProgress(jProgressBar, integerProperty);
		integerProperty.addListener((PropertyListener<Integer>) (oldValue, newValue)
				-> setProgress(jProgressBar, integerProperty));
	}

	public static void link(final @NotNull JComboBox<String> jComboBox,
	                            final @NotNull StringProperty property) {
		jComboBox.setSelectedItem(property.get());
		jComboBox.addItemListener(itemEvent
				-> property.set((String) jComboBox.getSelectedItem()));
	}

	public static <T> void link(final @NotNull JComboBox<T> jComboBox,
	                            final @NotNull ObjectProperty<T> property) {
		jComboBox.setSelectedItem(property.get());
		jComboBox.addItemListener(itemEvent
				-> property.set((T) jComboBox.getSelectedItem()));
	}

	public static <T extends Enum<?>> void link(final @NotNull JComboBox<T> jComboBox,
	                                            final @NotNull EnumProperty<T> property) {
		jComboBox.setSelectedItem(property.get());
		jComboBox.addItemListener(itemEvent
				-> property.set((T) jComboBox.getSelectedItem()));
	}

	private static void setProgress(final @NotNull JProgressBar jProgressBar,
	                                final @NotNull IntegerProperty integerProperty) {
		Optional.ofNullable(integerProperty.get())
				.ifPresentOrElse(integer -> {
					jProgressBar.setIndeterminate(false);
					jProgressBar.setValue(integer);
				}, () -> {
					jProgressBar.setIndeterminate(true);
				});
	}
}
