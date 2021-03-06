/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.platform;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author yole
 */
public class ProjectBaseDirectory {
  public static ProjectBaseDirectory getInstance(@NotNull Project project) {
    return ServiceManager.getService(project, ProjectBaseDirectory.class);
  }

  private VirtualFile BASE_DIR;

  public VirtualFile getBaseDir(final VirtualFile baseDir) {
    if (getBaseDir() != null) {
      return getBaseDir();
    }
    return baseDir;
  }

  public VirtualFile getBaseDir() {
    return BASE_DIR;
  }

  public void setBaseDir(final VirtualFile baseDir) {
    BASE_DIR = baseDir;
  }
}
