/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Vector;

@Slf4j
@Deprecated
public class JazzFileTreeView extends JTree {

	public JazzFileTreeView() {
		super();
		init();
	}

	public JazzFileTreeView(final Object[] value) {
		super(value);
		init();
	}

	public JazzFileTreeView(final Vector<?> value) {
		super(value);
		init();
	}

	public JazzFileTreeView(final Hashtable<?, ?> value) {
		super(value);
		init();
	}

	public JazzFileTreeView(final TreeNode root) {
		super(root);
		init();
	}

	public JazzFileTreeView(final TreeNode root, final boolean asksAllowsChildren) {
		super(root, asksAllowsChildren);
		init();
	}

	public JazzFileTreeView(final TreeModel newModel) {
		super(newModel);
		init();
	}

	public static DefaultTreeCellRenderer generateRenderer(
			final InputStream imgOpen, final InputStream imgClosed, final InputStream imgLeaf
			) throws IOException {
		final DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setOpenIcon(new ImageIcon(ImageIO
				.read(Objects.requireNonNull(imgOpen))
				.getScaledInstance(16,16, Image.SCALE_DEFAULT)));
		renderer.setClosedIcon(new ImageIcon(ImageIO
				.read(Objects.requireNonNull(imgClosed))
				.getScaledInstance(16,16, Image.SCALE_DEFAULT)));
		renderer.setLeafIcon(new ImageIcon(ImageIO
				.read(Objects.requireNonNull(imgLeaf))
				.getScaledInstance(16,16, Image.SCALE_DEFAULT)));

		return renderer;
	}

	private void init() {

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
		for (File file : roots) {
			final JazzFileTreeNode r = new JazzFileTreeNode(file.toPath());
			try {
				Files.list(file.toPath())
						.filter((p) -> Files.isDirectory(p))
						.sorted(Comparator.comparing(p -> p.normalize().toString()))
						.forEachOrdered((p) -> {
							final JazzFileTreeNode c = new JazzFileTreeNode(p);
							r.add(c);
						});
			} catch (Throwable e) {
			} finally {
				this.expandPath(new TreePath(r.getPath()));
			}
			root.add(r);
			this.expandPath(new TreePath(root.getPath()));
		}
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		this.setModel(treeModel);

		this.setRootVisible(false);
		//this.expandRow(0);


	}


}
