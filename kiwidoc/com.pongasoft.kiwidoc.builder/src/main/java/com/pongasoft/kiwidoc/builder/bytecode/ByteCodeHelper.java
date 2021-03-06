
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

package com.pongasoft.kiwidoc.builder.bytecode;

import com.pongasoft.kiwidoc.builder.serializer.type.TypeDecoder;
import com.pongasoft.kiwidoc.model.resource.ClassResource;
import com.pongasoft.kiwidoc.model.type.GenericType;
import com.pongasoft.kiwidoc.model.type.Type;

/**
 * @author yan@pongasoft.com
 */
public class ByteCodeHelper
{
  final static TypeDecoder TYPE_DECODER = new TypeDecoder();

  /**
   * Constructor
   */
  public ByteCodeHelper()
  {
  }

  static GenericType computeType(String internalName)
  {
    if(internalName == null)
      return null;
    else
    {
      return GenericType.create(new ClassResource(ClassResource.computeFQCNFromInternalName(internalName)));
    }
  }

  static Type decodeType(String desc)
  {
    if(desc == null)
      return null;
    else
    {
      return TYPE_DECODER.decodeType(desc);
    }
  }
}
