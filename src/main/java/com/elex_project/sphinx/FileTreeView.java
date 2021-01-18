/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.sphinx;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Vector;
@Slf4j
public class FileTreeView extends JTree {

	public FileTreeView() {
		super();
		init();
	}

	public FileTreeView(final Object[] value) {
		super(value);
		init();
	}

	public FileTreeView(final Vector<?> value) {
		super(value);
		init();
	}

	public FileTreeView(final Hashtable<?, ?> value) {
		super(value);
		init();
	}

	public FileTreeView(final TreeNode root) {
		super(root);
		init();
	}

	public FileTreeView(final TreeNode root, final boolean asksAllowsChildren) {
		super(root, asksAllowsChildren);
		init();
	}

	public FileTreeView(final TreeModel newModel) {
		super(newModel);
		init();
	}

	private void init() {
		try {
			Image icon = ImageIO
					.read(FileTreeView.class.getResourceAsStream("/person_black_18dp.png"))
					.getScaledInstance(16,16, Image.SCALE_DEFAULT);
			DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
			renderer.setOpenIcon(new ImageIcon(icon));
			renderer.setClosedIcon(new ImageIcon(icon));
			renderer.setLeafIcon(new ImageIcon(icon));

			setCellRenderer(renderer);

		} catch (IOException e) {
			log.error("IOException", e);
		}

		this.addTreeWillExpandListener(new TreeWillExpandListener() {
			@Override
			public void treeWillExpand(final TreeExpansionEvent treeExpansionEvent) throws ExpandVetoException {

				//DefaultMutableTreeNode node = (DefaultMutableTreeNode)treeExpansionEvent.getPath().getLastPathComponent();
				//Console.writeLine(node.toString());
			}

			@Override
			public void treeWillCollapse(final TreeExpansionEvent treeExpansionEvent) throws ExpandVetoException {
				//Console.writeLine(treeExpansionEvent.getPath());
			}
		});

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("");
		File[] roots = File.listRoots();
		for (int i=0; i<roots.length; i++){
			final FileTreeNode r = new FileTreeNode(roots[i].toPath());
			try {
				Files.list(roots[i].toPath())
						.filter((p) -> Files.isDirectory(p))
						.sorted(Comparator.comparing(p -> p.normalize().toString()))
						.forEachOrdered((p) -> {
							final FileTreeNode c = new FileTreeNode(p);
							r.add(c);
						});
			} catch (Throwable e) {} finally {
				this.expandPath(new TreePath(r.getPath()));
			}
			root.add(r);
			this.expandPath(new TreePath(root.getPath()));
		}
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		this.setModel(treeModel);

		this.setRootVisible(false);


	}


}
