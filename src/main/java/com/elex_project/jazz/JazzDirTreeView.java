/*
 * Project Jazz!
 *
 * Copyright (c) 2021-2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import com.elex_project.dwarf.ObjectProperty;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

@Slf4j
public class JazzDirTreeView extends JTree {

	public JazzDirTreeView() {
		super();
		init();
	}

	/**
	 * link with tree selection event
	 *
	 * @param pathProperty property
	 */
	public void linkProperty(@NotNull final ObjectProperty<Path> pathProperty) {

		this.addTreeSelectionListener(treeSelectionEvent -> {
			final Node node = (Node) getLastSelectedPathComponent();
			pathProperty.set(node.getPathObject());
		});

	}

	private void init() {
		final File[] roots = File.listRoots();
		Node root;
		if (roots.length == 1) {
			root = new Node(roots[0].toPath());
			this.setRootVisible(true);
		} else { // for fucking windows os.
			root = new Node(); // virtual root
			this.setRootVisible(false);
			for (File f : roots) {
				root.add(new Node(f.toPath()));
			}
		}

		this.setModel(new DefaultTreeModel(root));

		final DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(renderer.getDefaultClosedIcon());
		this.setCellRenderer(renderer);

		this.addTreeWillExpandListener(new TreeWillExpandListener() {
			@Override
			public void treeWillExpand(final TreeExpansionEvent treeExpansionEvent) throws ExpandVetoException {

				/*final DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) treeExpansionEvent.getPath().getLastPathComponent();
				log.debug(currentNode.toString());
				final Path path = (Path) currentNode.getUserObject();
				try {
					Files.list(path)
							.filter((p) -> Files.isDirectory(p))
							.sorted(Comparator.comparing(p -> p.normalize().toString()))
							.forEachOrdered((p) -> {
								currentNode.add(new Node(p));
							});
				} catch (IOException e) {
					log.warn("", e);
				}*/
			}

			@Override
			public void treeWillCollapse(final TreeExpansionEvent treeExpansionEvent) throws ExpandVetoException {
				//Console.writeLine(treeExpansionEvent.getPath());
			}
		});
	}

	public static class Node extends DefaultMutableTreeNode {
		Node(final Path path) {
			super(path);
		}

		Node(final String path) {
			this(Paths.get(path));
		}

		Node() {
			super();
		}

		public Path getPathObject() {
			return (Path) getUserObject();
		}


		@Override
		public int getChildCount() {
			try {
				return (int) Files.list(getPathObject())
						.filter((p) -> Files.isDirectory(p))
						.count();
			} catch (Throwable e) {
				return 0;

			}
		}

		@Override
		public TreeNode getChildAt(final int i) {
			try {
				return new Node((Path) Files.list(getPathObject())
						.filter((p) -> Files.isDirectory(p))
						.sorted(Comparator.comparing(p -> p.normalize().toString()))
						.toArray()[i]);
			} catch (Throwable e) {
				return null;

			}
		}

		@Override
		public int getIndex(final TreeNode treeNode) {
			try {
				Path[] children = (Path[]) Files.list(getPathObject())
						.filter((p) -> Files.isDirectory(p))
						.sorted(Comparator.comparing(p -> p.normalize().toString()))
						.toArray();
				for (int i = 0; i < children.length; i++) {
					if (children[i].equals(((Node) treeNode).getPathObject())) {
						return i;
					}
				}
			} catch (Throwable e) {
				//return 0;

			}
			return 0;
		}

		@Override
		public String toString() {
			if (null == getPathObject()) return "";
			if (null == getPathObject().getFileName()) return "/";
			return getPathObject().getFileName().toString();
		}
	}
}
