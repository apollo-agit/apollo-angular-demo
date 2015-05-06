# Apollo Angular Demo

##Overview

The basic driver of this application is to demonstrate several a handful of key features and also
several secondary features, inheirient in a good application coding design. Keep in mind this is only a focused set of code
focusing on the technology and not necessarily the feature set. In-fact all presented features are only designed to provide
a look into the cohesion of each chosen approach.

http://ian-hamilton.github.io/apollo-angular-demo/project-reports.html

The following list are the major drivers of what this demo offers:

1. Google's Angular JS
  * Core Angular JS
    * Templating
    * Angular Application Module
    * Angular JS Controllers and Service Modules
    * Angular REST Implementation
  * NG Grid
  * UI Route
    * Single Page Routing
    * Parameter Provider
2. NPM (Node Package Manager)
  * Node.js
  * Grunt
    * package.json (bower)
    * GruntFile.js (build tool)
3. Twitter Bootstrap 3
  * Mobile/Web Responsiveness Fundamentals
  * Basic Grid Layout
  * Adaptive Styling
  * Mixins
4. Spring Data (JPA)
  * Mongo DB
    * Repositories
	* Entities
	* Configuration
	* AWS (Amazon Web Services)
5. Rest Service Using Spring MVC
  * RESTful Standards
    * GET, POST, PUT, DELETE, HEAD
  * Jackson Mapping
6. Application Configuration
  * Logging
    * Logging through Runtime Weave Aspects (aspectj)
    * Joinpoints and Pointcuts
    * Joinpoints with Annotations (FineGrainLogging annotation)
  * Modern Dependency Injection
    * Annotation Based Injection
    * Component Scanning for Steriotypes
7. Unit Testing Practices
  * jacoco Code Coverage Reporting
  * Seperation of Unit and Integration Tests (Failsafe and Surefire)
  * Mockito Mocking Framework
  * Dirty Context
  * mockMvc (Spring MVC Realtime HTTP Request/Reply)
  * CheckStyle
  * PIT Testing (Mutation Testing)

###Build
As the below overview section describes the "Build" steps to producing this code. Some are marked as optional and 
only needed if code change is required.

####NPM Javascript/CSS/Glyphcon building
1. Install NodeJS (https://nodejs.org/download/)
2. After NodeJS installation execute the following command ```npm install -g grunt-cli```
3. Execute the /apollo-item-mvc/src/main/web-resources/npm-install-script.sh
4. Execute the following command at /apollo-item-mvc/src/main/web-resources/npm/
  *  ```grunt```
  *  The above command will compile all the JS/CSS mixins and run an lint unit tests

###Maven Build - War File
1. Minimum maven build
  * ```mvn clean install```
2. Maven build including Integration-Tests
  * ```mvn clean install -DskipITTests=false```
3. Full Maven Build (Junit, Integration, PIT Mutation, Checkstyle, Jacoco Coverage)
  * ```mvn clean install -DskipITTests=false checkstyle:checkstyle org.pitest:pitest-maven:mutationCoverage```
4. Maven Documentation
  *  ```mvn site org.pitest:pitest-maven:mutationCoverage``` 
5. If using Apache Tomcat, the below configuration will need to be set in the <host> section of the server.xml
  *  ```<Context docBase="apollo-item-mvc-1.0-SNAPSHOT" path="/apollo-item-mvc" debug="0" reloadable="true"/>```