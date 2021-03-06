Liferay Portlet Property Demo
=============================

A demo of a Liferay portlet that has preferences that can be configured with Options->Configuration->Setup.

* Liferay EE 6.2 GA1 SP3
* Java 1.7
* Portlet 2.0
* Spring Framework 4.0.6
* Annotation-based controller configuration

Usage
-----
```bash
$ git clone http://github.com/psvehla/portlet-property-demo.git
$ cd portlet-property-demo
$ mvn package
```

Deploy
------
If you're using Liferay Portal with Tomcat, copy the war to the deploy directory.

```
$ cp target/liferay-spring-mvc-portlet.war $LIFERAY_HOME/deploy/
```

Configuration
-------------

Default settings are Liferay EE 6.2.10.4, Java 1.7, Portlet 2.0, and Spring 4.0.  All can be configured in [pom.xml](https://github.com/psvehla/liferay-spring-mvc-portlet/pom.xml)

```xml
	<properties>
		<liferay.version>6.2.10.4</liferay.version>
		<java-version>1.7</java-version>
		<portlet-api.version>2.0</portlet-api.version>
		<servlet-api.version>2.5</servlet-api.version>
		<jsp-api.version>2.2</jsp-api.version>
		<jstl.version>1.2</jstl.version>
		<org.springframework-version>4.0.6.RELEASE</org.springframework-version>
		<org.aspectj-version>1.8.1</org.aspectj-version>
		<org.slf4j-version>1.7.7</org.slf4j-version>
	</properties>
```

Important Points to Note When Adding Preferences to Your Own Portlet
--------------------------------------------------------------------

* Add your
```
<portlet-preferences/>
``` 
to your portlet.xml.
* Add 
```xml
<configuration-action-class>au.com.redbarn.liferay.portlet.property.ConfigurationActionImpl</configuration-action-class>
```
to liferay-portlet.xml.

* Implement the ConfigurationAction.
* Create a view for the Options->Configuration->Setup tab (configuration.jsp in this example).
* Read the preferences in your own code with 
```java
request.getPreferences().getValue(Constants.MESSAGE_PARAM, Constants.DEFAULT_MESSAGE)
```
See HomeController for an example.

Licence
-------

Copyright 2014 Red Barn Consulting

Licenced under the LGPL Licence, Version 3.0: http://www.gnu.org/licenses/lgpl.html
