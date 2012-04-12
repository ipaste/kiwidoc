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

// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [html: ['text/html', 'application/xhtml+xml'],
  xml: ['text/xml', 'application/xml'],
  text: 'text/plain',
  js: 'text/javascript',
  rss: 'application/rss+xml',
  atom: 'application/atom+xml',
  css: 'text/css',
  csv: 'text/csv',
  all: '*/*',
  json: ['application/json', 'text/json'],
  form: 'application/x-www-form-urlencoded',
  multipartForm: 'multipart/form-data'
]
// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true

// set per-environment serverURL stem for creating absolute links
environments {
  production {
    def configLocations = []

    def systemPropertyConfigLocation =
    System.properties['com.pongasoft.kiwidoc.web.config.location']

    if(systemPropertyConfigLocation)
    {
      println "Detected ${systemPropertyConfigLocation} configuration"
      configLocations << systemPropertyConfigLocation
    }

    def hostConfigLocation = new File('/etc/default/kiwidoc.groovy')
    if(hostConfigLocation.exists())
    {
      println "Detected ${hostConfigLocation} configuration"
      configLocations << hostConfigLocation.toURI().toString()
    }

    grails.config.locations = configLocations
  }
  development {
    grails.serverURL = "http://localhost:8080/${appName}"
    kiwidoc.dir = 'file:///export/content/pongasoft/kiwidoc/data'
    caches.dir  = 'file:///export/content/pongasoft/kiwidoc/caches'
    log4j = {
      // Example of changing the log pattern for the default console
      // appender:
      //
      //appenders {
      //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
      //}

      error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
            'org.codehaus.groovy.grails.web.pages', //  GSP
            'org.codehaus.groovy.grails.web.sitemesh', //  layouts
            'org.codehaus.groovy.grails."web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails."web.mapping', // URL mapping
            'org.codehaus.groovy.grails.commons', // core / classloading
            'org.codehaus.groovy.grails.plugins', // plugins
            'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
            'org.springframework',
            'org.hibernate'

      info 'grails',
           'com.pongasoft'

      warn 'org.mortbay.log'

      //debug 'com.pongasoft.kiwidoc.builder.JSONContentHandler'
    }
  }

  test {
    grails.serverURL = "http://localhost:8080/${appName}"
    kiwidoc.dir = 'file:///export/content/pongasoft/kiwidoc/data'
    caches.dir  = 'file:///export/content/pongasoft/kiwidoc/caches'
    log4j = {
      // Example of changing the log pattern for the default console
      // appender:
      //
      //appenders {
      //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
      //}

      error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
            'org.codehaus.groovy.grails.web.pages', //  GSP
            'org.codehaus.groovy.grails.web.sitemesh', //  layouts
            'org.codehaus.groovy.grails."web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails."web.mapping', // URL mapping
            'org.codehaus.groovy.grails.commons', // core / classloading
            'org.codehaus.groovy.grails.plugins', // plugins
            'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
            'org.springframework',
            'org.hibernate'

      info 'grails',
           'com.pongasoft'

      warn 'org.mortbay.log'

      //debug 'com.pongasoft.kiwidoc.builder.JSONContentHandler'
    }
  }

}

     