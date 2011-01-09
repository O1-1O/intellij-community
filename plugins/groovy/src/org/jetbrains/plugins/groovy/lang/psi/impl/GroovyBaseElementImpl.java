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
package org.jetbrains.plugins.groovy.lang.psi.impl;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.plugins.groovy.lang.psi.GroovyElementVisitor;
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile;
import org.jetbrains.plugins.groovy.lang.psi.GroovyPsiElement;

/**
 * @author ilyas
 */
public abstract class GroovyBaseElementImpl<T extends StubElement> extends StubBasedPsiElementBase<T> implements GroovyPsiElement {

  protected GroovyBaseElementImpl(final T stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public GroovyBaseElementImpl(final ASTNode node) {
    super(node);
  }

  @Override
  public abstract PsiElement getParent();

  public void accept(GroovyElementVisitor visitor) {
    visitor.visitElement(this);
  }

  public void acceptChildren(GroovyElementVisitor visitor) {
    GroovyPsiElementImpl.acceptGroovyChildren(this, visitor);
  }

  protected PsiElement getDefinitionParent() {
    final PsiElement candidate = getParentByStub();
    if (candidate instanceof GroovyFile) {
      return candidate;
    }

    return getParentByTree();
  }
}