LAPR4/NSheets Project Repository
================================

# 1. Introduction
	
This project aims at building a web version of Cleansheets, a Desktop worksheet application available at [Bitbucket](https://bitbucket.org/lei-isep/csheets). 	

This project already has some startup functionalities partially implemented. 

Similarly to the desktop version, this new web version will use Java as the base programming language. The solution is based on GWT [GWT Project](http://www.gwtproject.org).

*"GWT is a development toolkit for building and optimizing complex browser-based applications. Its goal is to enable productive development of high-performance web applications without the developer having to be an expert in browser quirks, XMLHttpRequest, and JavaScript."*

# 2. Quick Startup

This project uses Maven.

The default Maven lifecycle comprises of the following phases:

	validate - validate the project is correct and all necessary information is available
	compile - compile the source code of the project
	test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
	package - take the compiled code and package it in its distributable format, such as a JAR.
	verify - run any checks on results of integration tests to ensure quality criteria are met
	install - install the package into the local repository, for use as a dependency in other projects locally
	deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects. 

To build type (in the root folder):

	mvn clean verify

To execute type (in the root folder):

	mvn gwt:run
	
# 3. Requirements
	
These are the requirements for the project:  
- Git  
- JDK, version 8  
- Maven  
- Gradle (for generating technical diagrams with Plantuml, such as UML diagrams)  
- An IDE (Eclipse or other)  
- We recommend using a front end for Git, such as Sourcetree

The project uses some tools/frameworks. Some are declared as dependencies in Maven, so they are automatically setup. Others you may need to install as plugins in the IDE. These are the tools/frameworks:  
- [GWT](http://www.gwtproject.org) (Java to Javascript transpiler and other related tools). You may download and install the GWT SDK although it is not mandatory.  
  - **It is recommended to install the GWT plugin for the IDE**. In Eclipse select "Help/Eclipse Marketplace" and search for "GWT". Install "GWT Eclipse Plugin".     
- [Plantuml](http://plantuml.com) (for building diagrams). You should download the Plantuml manual as a reference to learn its syntax.  
- [Antlr4](http://www.antlr.org) (for building parsers and lexers). You may install Antlr plugins for the IDE but they are not mandatory.  
- [GWTP](http://dev.arcbees.com/gwtp/) (*"The goal of GWTP is to offer an easy-to-use MVP architecture with minimal boilerplate, without compromising GWT's best features"*. GWTP uses dependency injection. See [Guice](https://github.com/google/guice))    
  - **It is recommended to install the GWTP plugin for the IDE**. In Eclipse select "Help/Eclipse Marketplace" and search for "GWTP". Install "GWTP Plugin".      
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


