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

To build type:

	mvn clean verify

To execute type:

	mvn gwt:run

To generate plantuml diagrams type:

	mvn plantuml:generate

# 2. Integration of ANTLR4 and GWT

See [https://github.com/aranega/antlr4-gwt](https://github.com/aranega/antlr4-gwt)

**Notes**
- The antlr4-gwt only works with antlr4 version 4.2.2!

# 3. LAPR4 Project Documentation

[Project Documentation](docs/)


# 4. How to Use These README.md Type of Files

All documentation about the project should be included in readme.MD files in the repository.

Every student will work on his/her own folder in the repository. The folder should have a name following the pattern **student-**<student registration number>. For instance, for "Maria Ferreira" the folder should be **student-113324**.

Inside the student folder there should be a subfolder for each Sprint. Their names should be **sp1** through **sp5**. Inside these folder there should be a file named **readme.MD** with documentation about the Sprint. All the files/artifacts used for the Sprint should be inside these folders (or in subfolders of theses folders).

**Images and PlantUml**

This repository includes a **build.gradle** file that can be used to generated images for PlantUML diagrams.

For processing all **.puml** files in the repository simply type in the root:

	gradle

For instance, the next image was generated with this command. The PlantUml file is **net.puml** (located in the root of the repository) and the resulting image is **net.png** (also located in the root of the repository).

![Image generated with PlantUML](net.png)

**Note:** You will need to have **gradle** installed in your system to execute the command.

Images with gravizo (this is not a good choice since it requires changes in the source of Plantuml!)

![Alt text](http://g.gravizo.com/source?https%3A%2F%2Fbitbucket.org%2FTLmaK0%2Fgravizo-example%2Fraw%2Fmaster%2Fsource.uml)


