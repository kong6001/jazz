/*
 * Project Sphinx
 *
 * Copyright (c) 2021. Elex
 * All Rights Reserved.
 */

package com.elex_project.jazz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

@Slf4j
@Deprecated
public class JazzFileTreeNode extends DefaultMutableTreeNode {
	private final Path path;

	public JazzFileTreeNode(@NotNull final File file) {
		this(file.toPath());
	}

	public JazzFileTreeNode(@NotNull final Path path) {
		super();
		this.path = path;
	}

	public Path getFilePath(){
		return path;
	}

	@Override
	public String toString() {
		try {
			String[] n = path.normalize().toString().split("/");
			return n[n.length - 1];
		} catch (Throwable e) {
			return "/";
		}
	}

	@Override
	public TreeNode getChildAt(final int i) {
		try {
			return new JazzFileTreeNode((Path) Files.list(path)
					.filter((p) -> Files.isDirectory(p))
					.sorted(Comparator.comparing(p -> p.normalize().toString()))
					.toArray()[i]);
		} catch (Throwable e){
			return null;

		}
	}

	@Override
	public int getChildCount() {
		try {
			return (int)Files.list(path)
					.filter((p) -> Files.isDirectory(p))
					.count();
		} catch (Throwable e){
			return 0;

		}
	}


	@Override
	public int getIndex(final TreeNode treeNode) {
		try {

			Path[] children = (Path[]) Files.list(path)
					.filter((p) -> Files.isDirectory(p))
					.sorted(Comparator.comparing(p -> p.normalize().toString()))
					.toArray();
			for (int i=0; i<children.length; i++) {
				if (children[i].equals(((JazzFileTreeNode)treeNode).path)){
					return i;
				}
			}
		} catch (Throwable e){
			//return 0;

		}
		return 0;
	}


}
