/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.List;

@Slf4j
public abstract class FileDropHelper implements FileDropListener {

	public FileDropHelper(final @NotNull JComponent component) {
		makeDroppable(component, this);
	}

	public static void makeDroppable(final @NotNull JComponent component, final FileDropListener listener) {
		component.setDropTarget(new DropTarget() {
			public synchronized void drop(DropTargetDropEvent event) {
				try {
					event.acceptDrop(DnDConstants.ACTION_COPY);
					listener.onDropped((List<File>) event.getTransferable()
							.getTransferData(DataFlavor.javaFileListFlavor));
				} catch (Exception ex) {
					log.warn("Unable to drop file(s).", ex);
				}
			}
		});
	}
}
