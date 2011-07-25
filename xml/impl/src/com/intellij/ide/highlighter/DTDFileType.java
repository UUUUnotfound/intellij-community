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
package com.intellij.ide.highlighter;

import com.intellij.ide.IdeBundle;
import com.intellij.lang.dtd.DTDLanguage;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DTDFileType extends LanguageFileType {
  private static final Icon ICON = IconLoader.getIcon("/fileTypes/dtd.png");
  public static final DTDFileType INSTANCE = new DTDFileType();

  public DTDFileType() {
    super(DTDLanguage.INSTANCE);
  }

  @NotNull
  public String getName() {
    return "DTD";
  }

  @NotNull
  public String getDescription() {
    return IdeBundle.message("filetype.description.dtd");
  }

  @NotNull
  public String getDefaultExtension() {
    return "dtd";
  }

  public Icon getIcon() {
    return ICON;
  }
}