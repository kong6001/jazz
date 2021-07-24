/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.*;

@Slf4j
public class App implements WindowListener, WindowStateListener, WindowFocusListener, ComponentListener {
	protected final JFrame jFrame;

	protected App(final JFrame jFrame) {
		this.jFrame = jFrame;

		this.jFrame.addWindowListener(this);
		this.jFrame.addWindowStateListener(this);
		this.jFrame.addWindowFocusListener(this);
		this.jFrame.addComponentListener(this);
	}

	public void start() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				log.trace("started");
				jFrame.setVisible(true);
			}
		});
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
		private final JFrame jFrame;

		public Builder() {
			jFrame = new JFrame();
			jFrame.setSize(800, 600);
			jFrame.setLocationRelativeTo(null);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

		public Builder title(final String title) {
			jFrame.setTitle(title);
			return this;
		}

		public Builder size(final int w, final int h) {
			jFrame.setSize(w, h);
			return this;
		}

		public Builder location(final int x, final int y) {
			jFrame.setLocation(x, y);
			return this;
		}

		public Builder content(final JComponent contentPane) {
			jFrame.setContentPane(contentPane);
			return this;
		}

		public App build() {
			return new App(jFrame);
		}
	}
}
