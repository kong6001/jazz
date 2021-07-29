/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JazzClock extends JLabel {
	private ScheduledExecutorService executor;

	private static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
	public JazzClock() {
		super();
		init();
	}

	private void update(){
		final LocalDate date = LocalDate.now();
		final LocalTime time = LocalTime.now();

		JazzClock.this.setToolTipText(date.format(DATE_FORMAT));
		JazzClock.this.setText(time.format(TIME_FORMAT));
	}
	private void init() {
		update();
		executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				update();
			}
		}, 0,1, TimeUnit.SECONDS);
	}
}
