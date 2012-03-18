
/*
 * Copyright (c) 2012 Yan Pujante
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.pongasoft.kiwidoc.model.annotation;

import com.pongasoft.kiwidoc.model.resource.DependenciesCollector;
import com.pongasoft.kiwidoc.model.resource.ResolvableResource;

import java.util.Collection;

/**
 * @author yan@pongasoft.com
 */
public class AnnotationElement implements DependenciesCollector
{
  private final String _name;
  private final AnnotationValue _annotationValue;

  /**
   * Constructor
   */
  public AnnotationElement(String name, AnnotationValue annotationValue)
  {
    _name = name;
    _annotationValue = annotationValue;
  }

  public String getName()
  {
    return _name;
  }

  public AnnotationValue getAnnotationValue()
  {
    return _annotationValue;
  }

  /**
   * Collect the dependencies in the collection.
   *
   * @param dependencies to add the dependencies to it
   */
  public void collectDependencies(Collection<ResolvableResource> dependencies)
  {
    _annotationValue.collectDependencies(dependencies);
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    
    sb.append(_name).append('=');
    sb.append(_annotationValue.toString());

    return sb.toString();
  }
}
