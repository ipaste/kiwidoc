
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

package com.pongasoft.kiwidoc.builder.model;

import com.pongasoft.kiwidoc.model.LibraryModel;
import com.pongasoft.kiwidoc.model.resource.LibraryResource;

import java.util.Collection;

/**
 * @author yan@pongasoft.com
 */
public class LibraryModelFactory implements ModelFactory<LibraryResource, LibraryModel>
{
  /**
   * Constructor
   */
  public LibraryModelFactory()
  {
  }

  /**
   * @return the model
   */
  public LibraryModel buildModel(LibraryResource resource, Collection<String> childResources)
  {
    return new LibraryModel(resource, childResources);
  }
}