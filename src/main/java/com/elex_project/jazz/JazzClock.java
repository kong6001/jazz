/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JazzClock extends JLabel {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
	private final ScheduledExecutorService executor;

	public JazzClock() {
		super();
		executor = Executors.newScheduledThreadPool(1);

		init();
	}

	private void update() {
		final LocalDate date = LocalDate.now();
		final LocalTime time = LocalTime.now();

		SwingUtilities.invokeLater(() -> {
			JazzClock.this.setToolTipText(date.format(DATE_FORMAT));
			JazzClock.this.setText(time.format(TIME_FORMAT));
		});
	}

	private void init() {
		update();
		executor.scheduleAtFixedRate(() -> update(),
				ChronoUnit.MILLIS.between(LocalTime.now(), LocalTime.now().plusSeconds(1).withNano(0)),
				1000, TimeUnit.MILLISECONDS);
	}

	public void dispose() {
		executor.shutdown();
	}
}
