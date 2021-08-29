/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.dwarf.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.NoSuchElementException;

/**
 * Build a JPanel with a H-Box layout.
 */
@Slf4j
public final class JazzStatusBarBuilder {
	private final JPanel statusBar;

	public JazzStatusBarBuilder() {
		statusBar = new JPanel();
		statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.X_AXIS));
		statusBar.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
	}

	@Contract(" -> new")
	public static @NotNull JazzStatusBarBuilder builder() {
		return new JazzStatusBarBuilder();
	}

	public JPanel build() {
		return statusBar;
	}

	public JazzStatusBarBuilder border(final int padding) {
		statusBar.setBorder(BorderFactory
				.createEmptyBorder(padding, padding, padding, padding));
		return this;
	}

	public JazzStatusBarBuilder border(final int t, final int l, final int b, final int r) {
		statusBar.setBorder(BorderFactory
				.createEmptyBorder(t, l, b, r));
		return this;
	}

	public JazzStatusBarBuilder border(final int h, final int v) {
		statusBar.setBorder(BorderFactory
				.createEmptyBorder(v, h, v, h));
		return this;
	}

	public JazzStatusBarBuilder border(final Border border) {
		statusBar.setBorder(border);
		return this;
	}

	public JazzStatusBarBuilder alignX(final float align) {
		statusBar.setAlignmentX(align);
		return this;
	}

	public JazzStatusBarBuilder alignY(final float align) {
		statusBar.setAlignmentY(align);
		return this;
	}

	public JazzStatusBarBuilder add(final JComponent child) {
		statusBar.add(child);
		return this;
	}

	public JazzStatusBarBuilder add(final String child) {
		statusBar.add(new JLabel(child));
		return this;
	}

	public JazzStatusBarBuilder addGlue() {
		statusBar.add(Box.createHorizontalGlue());
		return this;
	}

	public JazzStatusBarBuilder addStrut(final int width) {
		statusBar.add(Box.createHorizontalStrut(width));
		return this;
	}

	public JazzStatusBarBuilder addGap(final int width) {
		statusBar.add(Box.createRigidArea(new Dimension(width, 0)));
		return this;
	}

	public JazzStatusBarBuilder addProgress(final int width, final int height,
	                                        @NotNull final IntegerProperty property) {
		final JProgressBar jProgressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		jProgressBar.setPreferredSize(new Dimension(width, height));
		PropertyHelper.link(jProgressBar, property);
		statusBar.add(jProgressBar);
		return this;
	}

	public JazzStatusBarBuilder add(final @NotNull StringProperty property) {
		final JLabel jLabel = new JLabel();
		jLabel.setText(property.get());
		property.addListener((PropertyListener<String>) (oldValue, newValue)
				-> jLabel.setText(newValue));
		statusBar.add(jLabel);
		return this;
	}

	public <T> JazzStatusBarBuilder add(final @NotNull ObjectProperty<T> property) {
		final JLabel jLabel = new JLabel();
		try {
			jLabel.setText(property.optional().orElseThrow().toString());
		} catch (NoSuchElementException e) {
			jLabel.setText(null);
		}
		property.addListener((PropertyListener<T>) (oldValue, newValue)
				-> jLabel.setText(newValue.toString()));
		statusBar.add(jLabel);
		return this;
	}

	public JazzStatusBarBuilder add(final @NotNull IntegerProperty property) {
		final JLabel jLabel = new JLabel();
		jLabel.setText(null == property.get() ? null : String.valueOf(property.get()));
		property.addListener((PropertyListener<Integer>) (oldValue, newValue)
				-> jLabel.setText(String.valueOf(newValue)));
		statusBar.add(jLabel);
		return this;
	}

	public <T extends Enum<?>> JazzStatusBarBuilder add(final @NotNull EnumProperty<T> property) {
		final JLabel jLabel = new JLabel();
		try {
			jLabel.setText(property.optional().orElseThrow().toString());
		} catch (NoSuchElementException e) {
			jLabel.setText(null);
		}
		property.addListener((PropertyListener<T>) (oldValue, newValue)
				-> jLabel.setText(newValue.toString()));
		statusBar.add(jLabel);
		return this;
	}

	public JazzStatusBarBuilder add(final String child, final @NotNull JPopupMenu popupMenu) {
		final JLabel jLabel = new JLabel(child);
		statusBar.add(jLabel);

		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popupMenu.show(jLabel, e.getX(), e.getY());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel.setFont(jLabel.getFont().deriveFont(Font.BOLD));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jLabel.setFont(jLabel.getFont().deriveFont(Font.PLAIN));
			}
		});
		return this;
	}

	public JazzStatusBarBuilder add(final @NotNull StringProperty property,
	                                final @NotNull JPopupMenu popupMenu) {
		final JLabel jLabel = new JLabel();
		jLabel.setText(property.get());
		property.addListener((PropertyListener<String>) (oldValue, newValue)
				-> {
			jLabel.setText(newValue);
		});
		statusBar.add(jLabel);
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popupMenu.show(jLabel, e.getX(), e.getY());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel.setFont(jLabel.getFont().deriveFont(Font.BOLD));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jLabel.setFont(jLabel.getFont().deriveFont(Font.PLAIN));
			}
		});
		return this;
	}

	public <T> JazzStatusBarBuilder add(final @NotNull ObjectProperty<T> property,
	                                    final @NotNull JPopupMenu popupMenu) {
		final JLabel jLabel = new JLabel();
		try {
			jLabel.setText(property.optional().orElseThrow().toString());
		} catch (NoSuchElementException e) {
			jLabel.setText(null);
		}
		property.addListener((PropertyListener<T>) (oldValue, newValue)
				-> {
			if (null != newValue) {
				jLabel.setText(newValue.toString());
			} else {
				jLabel.setText(null);
			}
		});
		statusBar.add(jLabel);
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popupMenu.show(jLabel, e.getX(), e.getY());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel.setFont(jLabel.getFont().deriveFont(Font.BOLD));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jLabel.setFont(jLabel.getFont().deriveFont(Font.PLAIN));
			}
		});
		return this;
	}

	public <T extends Enum<?>> JazzStatusBarBuilder add(final @NotNull EnumProperty<T> property,
	                                                    final @NotNull JPopupMenu popupMenu) {
		final JLabel jLabel = new JLabel();
		try {
			jLabel.setText(property.optional().orElseThrow().toString());
		} catch (NoSuchElementException e) {
			jLabel.setText(null);
		}
		property.addListener((PropertyListener<T>) (oldValue, newValue)
				-> {
			if (null != newValue) {
				jLabel.setText(newValue.toString());
			} else {
				jLabel.setText(null);
			}
		});
		statusBar.add(jLabel);
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popupMenu.show(jLabel, e.getX(), e.getY());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel.setFont(jLabel.getFont().deriveFont(Font.BOLD));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jLabel.setFont(jLabel.getFont().deriveFont(Font.PLAIN));
			}
		});
		return this;
	}
}
