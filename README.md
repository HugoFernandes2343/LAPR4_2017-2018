LAPR4/NSheets Project Repository
================================

# 1. General Notes about the Project

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

# 2. Integration of ANTLR4 and GWT

See [https://github.com/aranega/antlr4-gwt](https://github.com/aranega/antlr4-gwt)

**Notes**
- The antlr4-gwt only works with antlr4 version 4.2.2!

# 3. LAPR4 Project Technical Documentation

[Link to the Project Technical Documentation](docs/)

# 4. How to Generate the Technical Documentation 

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


