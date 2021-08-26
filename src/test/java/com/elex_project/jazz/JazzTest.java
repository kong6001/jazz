/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class JazzTest {

	public static void main(String... args){
		final JButton button = new JButton("Button");
		final JFrame jFrame = JazzBuilders.frame()
				.menu(JazzBuilders.menuBar()
						.menu("File")
						.and()
						.build())
				.content(JazzBuilders.borderLayout()
						.center(new JLabel("Haha"))
						.bottom(button)
						.build())
				.buildAndLaunch();

		button.addActionListener(e->{
			BufferedImage image = Jazz.capture(jFrame);
			try {
				ImageIO.write(image, "png",new File("capture.png"));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
}
