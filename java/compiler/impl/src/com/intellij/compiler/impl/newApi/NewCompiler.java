/*
 * Copyright 2000-2010 JetBrains s.r.o.
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
package com.intellij.compiler.impl.newApi;

import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.Compiler;
import com.intellij.util.io.DataExternalizer;
import com.intellij.util.io.KeyDescriptor;
import org.jetbrains.annotations.NotNull;

/**
 * @author nik
 */
public abstract class NewCompiler<Key, State> implements Compiler {
  private final String myId;
  private final int myVersion;
  private final CompileOrderPlace myOrderPlace;

  protected NewCompiler(@NotNull String id, int version, @NotNull CompileOrderPlace orderPlace) {
    myId = id;
    myVersion = version;
    myOrderPlace = orderPlace;
  }

  @NotNull
  public abstract KeyDescriptor<Key> getItemKeyDescriptor();
  @NotNull
  public abstract DataExternalizer<State> getItemStateExternalizer();

  @NotNull
  public abstract CompilerInstance<?, ? extends CompileItem<Key, State>, Key, State> createInstance(@NotNull CompileContext context);

  public final String getId() {
    return myId;
  }

  public final int getVersion() {
    return myVersion;
  }

  public CompileOrderPlace getOrderPlace() {
    return myOrderPlace;
  }

  public static enum CompileOrderPlace {
    CLASS_INSTRUMENTING, CLASS_POST_PROCESSING, PACKAGING, VALIDATING
  }

}
