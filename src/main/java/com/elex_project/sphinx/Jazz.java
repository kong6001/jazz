/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.sphinx;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;

public final class Jazz {
	private Jazz() {
	}

	@NotNull
	public static UIManager.LookAndFeelInfo[] getAvailableLookAndFeels() {
		return UIManager.getInstalledLookAndFeels();
	}

	/**
	 * 모니터의 픽셀 크기
	 *
	 * @return {가로, 세로}
	 */
	@NotNull
	public static Dimension getScreenSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	/**
	 * 모니터의 가로 크기
	 *
	 * @return 픽셀
	 */
	public static int getScreenWidth() {
		return (int) getScreenSize().getWidth();
	}

	/**
	 * 모니터의 세로 크기
	 *
	 * @return 픽셀
	 */
	public static int getScreenHeight() {
		return (int) getScreenSize().getHeight();
	}

	/**
	 * 웹 브라우저를 연다.
	 *
	 * @param uri 웹주소
	 * @throws UnsupportedOperationException 운영체제에서 지원하지 않음
	 * @throws IOException                   기본 브라우저가 없음
	 * @throws SecurityException             ..
	 * @throws IllegalArgumentException      uri 주소가 이상함. url로 변환 불가...
	 */
	public static void browse(@NotNull URI uri)
			throws UnsupportedOperationException, IOException, SecurityException, IllegalArgumentException {
		if (!Desktop.isDesktopSupported() ||
				!Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			throw new UnsupportedOperationException();
		} else {
			Desktop.getDesktop().browse(uri);
		}

	}

	public static void centering(JFrame jFrame) {
		jFrame.setLocationRelativeTo(null);
	}
}
