#!/bin/bash

#
# Copyright (c) 2012 Yan Pujante
#
# Licensed under the Apache License, Version 2.0 (the "License"); you may not
# use this file except in compliance with the License. You may obtain a copy of
# the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
# License for the specific language governing permissions and limitations under
# the License.
#

# locations
CURRDIR=`pwd`
BASEDIR=`cd $(dirname $0)/.. ; pwd`

LIB_DIR=$BASEDIR/lib

for file in `ls -1 $LIB_DIR/*.jar `; do
  if [ -z "$JVM_CLASSPATH" ]; then
    JVM_CLASSPATH="-classpath $JAVA_HOME/lib/tools.jar:$file"
  else
    JVM_CLASSPATH=$JVM_CLASSPATH:$file
  fi
done

OPTIONS="-f $BASEDIR/conf/static.txt"
JVM_LOG4J=-Dlog4j.configuration=file:$BASEDIR/conf/log4j.xml
JVM_DEBUG=
#JVM_DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
JAVA_OPTS="-Xmx1024m"

java $JVM_LOG4J $JVM_DEBUG $JVM_CLASSPATH $JAVA_OPTS com.pongasoft.tools.kiwidoc.static_generator.impl.StaticGenerator $OPTIONS "$@"

