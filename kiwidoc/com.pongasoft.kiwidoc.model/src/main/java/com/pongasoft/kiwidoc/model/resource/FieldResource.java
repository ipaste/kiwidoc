
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

package com.pongasoft.kiwidoc.model.resource;

/**
 * @author yan@pongasoft.com
 */
public class FieldResource extends FieldOrMethodResource<FieldResource>
{
  private static final long serialVersionUID = 1L;

  /**
   * Constructor
   */
  public FieldResource(ClassResource classResource, String fieldName)
  {
    super(classResource, fieldName);
  }

  public String getFieldName()
  {
    return getName();
  }

  /**
   * Clones this resource using the parent provided.
   *
   * @param parent the parent to use
   * @return a new resource using the parent provided
   */
  public FieldResource clone(ClassResource parent)
  {
    return new FieldResource(parent, getFieldName());
  }
}