LAPR4/NSheets Project Repository
================================

# 1. Introduction
	
This project aims at building a web version of Cleansheets, a Desktop worksheet application available at [Bitbucket](https://bitbucket.org/lei-isep/csheets). 	

This project already has some startup functionalities partially implemented. 

Similarly to the desktop version, this new web version will use Java as the base programming language. The solution is based on GWT [GWT Project](http://www.gwtproject.org).

*"GWT is a development toolkit for building and optimizing complex browser-based applications. Its goal is to enable productive development of high-performance web applications without the developer having to be an expert in browser quirks, XMLHttpRequest, and JavaScript."*

# 2. Quick Startup

This project uses Maven. It will run the web application using Tomcat.

The default Maven lifecycle comprises of the following phases:

	validate - validate the project is correct and all necessary information is available
	compile - compile the source code of the project
	test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
	package - take the compiled code and package it in its distributable format, such as a JAR.
	verify - run any checks on results of integration tests to ensure quality criteria are met
	install - install the package into the local repository, for use as a dependency in other projects locally
	deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects. 

To build type (in the root folder):

	mvn clean install

To execute type (in the root folder):

	mvn tomcat7:run-war-only

Your application is now deployed at [http://127.0.0.1:8082/nsheets](http://127.0.0.1:8082/nsheets).
	
To start GWT Dev Mode, type in another shell/terminal/console:

	mvn gwt:run -pl nsheets

On success, the GWT Dev Mode window opens. Click *Launch Default Browser* to open it in GWT Dev Mode.

With GWT Dev Mode You can now make changes to your client Java code. Changes become immediately available as soon as you reloaded your page in the browser.

**Important Note**: You should always do a "mvn clean" before doing a production compile so you can be sure you start from a clean state without anything Dev Mode  might has produced.

###How to Debug in Eclipse###
	
You should start by opening the project in Eclipse. Select "File/Import...", then "Existing Projects into Workspace" and then select the folder where the clone of the project is located .

**Debug the server code**

To debug the server code (i.e., java code that is not transpiled to javascript and runs in the server) you should use mvnDebug instead of mvn when starting tomcat. For example: 

	mvnDebug tomcat7:run-war-only

In Eclipse create a new debug configuration using "Run/Debug Configurations..." and then create a new "Remote Java Application" configuration. Select "nsheets" for project and leave the other fields unchanged. You may now click "Debug".  

You may set breakpoints in the server code of the project and Eclipse will stop in that location.

**Debug the client code**

Make sure you have started Tomcat either using mvn or mvnDebug (if you also wish to debug the server code).

Then, in another terminal/console, make sure you start GWT Dev Mode. For example:

	mvn gwt:run -pl nsheets

In Eclipse create a new debug configuration using "Run/Debug Configurations..." and then create a new "Launch Chrome" configuration. In the url enter "http://127.0.0.1:8082/nsheets/" and in the project select "nsheets". Finish by clicking in the "Debug" button to start the debug session.

You may set breakpoints in the client code of the project and Eclipse will stop in that location.
		
# 3. Requirements
	
These are the requirements for the project:  
- Git  
- JDK, version 8  
- Maven  
- Gradle (for generating technical diagrams with Plantuml, such as UML diagrams)  
- An IDE (Eclipse or other)  
- We recommend using a front end for Git, such as Sourcetree

The project uses some tools/frameworks. Some are declared as dependencies in Maven, so they are automatically setup. Others you may need to install as plugins in the IDE. These are the tools/frameworks:  
- [GWT](http://www.gwtproject.org) (Java to Javascript transpiler and other related tools). You may download and install the GWT SDK although it is not mandatory. **It is recommended to install the GWT plugin for the IDE**. In Eclipse select "Help/Eclipse Marketplace" and search for "GWT". Install "GWT Eclipse Plugin".     
- [Plantuml](http://plantuml.com) (for building diagrams). You should download the Plantuml manual as a reference to learn its syntax.  
- [Antlr4](http://www.antlr.org) (for building parsers and lexers). You may install Antlr plugins for the IDE but they are not mandatory.  
- [GWTP](http://dev.arcbees.com/gwtp/) (*"The goal of GWTP is to offer an easy-to-use MVP architecture with minimal boilerplate, without compromising GWT's best features"*. GWTP uses dependency injection. See [Guice](https://github.com/google/guice)). **It is recommended to install the GWTP plugin for the IDE**. In Eclipse select "Help/Eclipse Marketplace" and search for "GWTP". Install "GWTP Plugin".      
- [GWT Material Design](https://github.com/GwtMaterialDesign/gwt-material) (*"A Google Material Design wrapper for GWT"*. You may find further information about material design in [Google Material Design](https://material.io)). These are basically design guidelines that the UI of the application should follow.  

# 4. LAPR4 Project Technical Documentation

**For details of the LAPR4 project such as requirements to implement and rules to follow please visit**
[Project Technical Documentation](docs/)

# 5. Integration of ANTLR4 and GWT

See [https://github.com/aranega/antlr4-gwt](https://github.com/aranega/antlr4-gwt)

**Notes**
- The antlr4-gwt only works with antlr4 version 4.2.2!

# 6. How to Generate the Technical Documentation 

All documentation about the project should be included in **README.md** files inside the "docs" folder in the repository.

The documentation should be written using [Markdown](https://en.wikipedia.org/wiki/Markdown).

These files are automatically processed and displayed by Bitbucket.

You should follow the example of documentation presented for the "John Doe" student. You should remove the documentation of "John Doe" after understanding the documentation structure you should follow.

Every Student should have a specific README.md for each sprint.

**Images and PlantUml**

Technical diagrams can be generated for [PlantUML](http://plantuml.com). The description of the diagrams should be include in text files with the puml extension. 
 
This repository includes a **build.gradle** file that can be used to generated images for PlantUML diagrams.

For processing all **.puml** files inside the docs folder simply type in the root folder:

	gradle

# 7. Deployment with Docker and Ngrok

To simulate a production like environment for deployment the project uses Docker (more specifically, docker-compose) and ngrok.

To use this feature you need to install in your computer Docker ([Docker Community Edition](https://www.docker.com/community-edition)) as well as [ngrok](https://ngrok.com).

The project includes the files *Dockerfile* and *docker-compose.yml* that are used to build the running environment.

After building the **war** file of the project with *mvn clean install* you can execute the following commands (in the root directory of the project) to run a production like environment:

	docker-compose build
	docker-compose up -d 

This will start the nsheets web application inside a container (running the Tomcat server) and exposing the application in port **8090**

Simple use the url **http://localhost:8090/nsheets** in a browser to access the application.

When you wish to stop the container type:

	docker-compose down

To make the application available to be accessed anywhere in the Internet start ngrok using:

	ngrok http 8090
	
This command will provide a dynamic global url that can be used to access the application. For instance, if ngrok provides the url **http://97b418d3.ngrok.io** you can access the application from anywhere by using **http://97b418d3.ngrok.io/nsheets**

###Deployment Alternatives###

Alternative cloud deployments like Microsoft Azure, Amazon Web Services or Heroku can be used. Feel free to explore these services.


 
 
