/*
 * Project Jazz!
 *
 * Copyright (c) 2021. Elex. All Rights Reserved.
 * https://www.elex-project.com/
 */

package com.elex_project.jazz;

import java.io.File;
import java.util.List;

public interface FileDropListener {
	public void onDropped(List<File> files);
}
