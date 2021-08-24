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
import java.awt.event.*;

@Slf4j
public class JazzWindow extends JazzFrame
		implements WindowListener, WindowStateListener, WindowFocusListener, ComponentListener {

	protected JazzWindow() {
		super();

		this.addWindowListener(this);
		this.addWindowStateListener(this);
		this.addWindowFocusListener(this);
		this.addComponentListener(this);
	}

	@Override
	public void windowOpened(WindowEvent windowEvent) {
		log.trace("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent windowEvent) {
		log.trace("windowClosing");
	}

	@Override
	public void windowClosed(WindowEvent windowEvent) {
		log.trace("windowClosed");
	}

	@Override
	public void windowIconified(WindowEvent windowEvent) {
		log.trace("windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent windowEvent) {
		log.trace("windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent windowEvent) {
		log.trace("windowActivated");
	}

	@Override
	public void windowDeactivated(WindowEvent windowEvent) {
		log.trace("windowDeactivated");
	}

	@Override
	public void windowStateChanged(WindowEvent windowEvent) {
		log.trace("windowStateChanged");
	}

	@Override
	public void windowGainedFocus(WindowEvent windowEvent) {
		log.trace("windowGainedFocus");
	}

	@Override
	public void windowLostFocus(WindowEvent windowEvent) {
		log.trace("windowLostFocus");
	}

	@Override
	public void componentResized(ComponentEvent componentEvent) {
		log.trace("componentResized: {}, {}", componentEvent.getComponent().getSize().width, componentEvent.getComponent().getSize().height);
	}

	@Override
	public void componentMoved(ComponentEvent componentEvent) {
		log.trace("componentMoved: {}, {}", componentEvent.getComponent().getLocation().x, componentEvent.getComponent().getLocation().y);
	}

	@Override
	public void componentShown(ComponentEvent componentEvent) {
		log.trace("componentShown");
	}

	@Override
	public void componentHidden(ComponentEvent componentEvent) {
		log.trace("componentHidden");
	}

	public static class Builder {
		private final JazzWindow window;

		public Builder() {
			window = new JazzWindow();

		}

		public Builder title(final String title) {
			window.setTitle(title);
			return this;
		}

		public Builder size(final int w, final int h) {
			window.setSize(w, h);
			return this;
		}

		public Builder location(final int x, final int y) {
			window.setLocation(x, y);
			return this;
		}

		public Builder centering(){
			window.setLocationRelativeTo(null);
			return this;
		}

		public Builder content(final JComponent contentPane) {
			window.setContentPane(contentPane);
			return this;
		}

		public Builder menu(final JMenuBar menuBar) {
			window.setJMenuBar(menuBar);
			return this;
		}

		public Builder icons(final java.util.List<Image> icons) {
			window.setIconImages(icons);
			return this;
		}

		public JazzWindow build() {
			return window;
		}
	}
}
