
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

package test.util.core.net

import com.pongasoft.util.core.net.URIPath

/**
 * @author yan@pongasoft.com
*/
public class TestURIPath extends GroovyTestCase
{
  void testURIPath()
  {
    assertEquals('', URIPath.createFromPath('').toString())
    assertEquals('/', URIPath.createFromPath('/').toString())
    assertEquals('a/b/c', URIPath.createFromPath('a/b/c').toString())
    assertEquals('a/b/c/', URIPath.createFromPath('a/b/c/').toString())
  }
}