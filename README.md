COGSI Project Repository
========================

# 1. General Notes about the Project of COGSI

COGSI has a project that runs during all the semester. The project is divided into 5 Sprints. Each Sprint has an average duration of 2 weeks.

The goals for each Sprint will be published in Moodle, in a specific document.

Each and every student should develop his/her work for each sprint in his/her own individual repository (that should be similar to this one).

By the end of each Sprint the teacher will select a small set of students to submit and present their developments for the Sprint.

The selected students should submit their work to the common repository of the lab class.

The selected students must present and discuss their work during a Sprint Review session (usually scheduled to a lecture).

Students get feedback from their work during the Sprint Review. They may improve their work and present the improvements at a special session by the end of the semester.

In the Sprint Review students (presenting and attending) should compare the different presented solutions and select one of the them as the "team solution".  

**Each student must present one Sprint during the semester!**

# 2. Notes on the Organization of the Repositories

**Common repository**

Each lab class (i.e., "Turma PL") will have one common repository. The class will have a number that will be used to identify the repository. For instance, the class number **1** will have a common repository with the name: **cogsi-rep-17-18-g1**. The class with number **2** will have a common repository with the name: **cogsi-rep-17-18-g2**

The common repository is used to submit each sprint delivery (only the selected students!). Students do not work on the common repository, it is only used for sprint submissions!

**individual repository**

Each student will have an individual repository. Students should use this repository for their development.

Each student will have a Student Team Number. The number of the lab class and the Student Team Number will be used to identify the student individual repository. For instance, for the student with Student Team Number 3 of the lab class 2 the individual repository will have the name: **cogsi-rep-17-18-g2-s3**

Students should use Bitbucket Issues to reference their work/commits in the repository. They should commit regularly.

**Students should not use the Bitbucket Wiki for documentation. All documentation should be done in the repository using markdown and the suggested MD files, following the structure that is exemplified here.**

**Both repositories must have the same structure of folders!**


[//]: # (Os links para outras paginas markdown devem ser sempre relativos a pasta actual)

# 3. Individual Pages

These are links for the individual pages/folders of each Student. The first two are only examples. After knowing his/her Student Team Number, each student should update the table and the folder structure of the repository accordingly.

For instance, if my name is Maria Ferreira and I have the Student Team Number 2 I should update the row number 2 in this table. I should also create a new folder in the repository, as illustrated.

|Student Team Number |Student Name                         |Link         											  |
|--------------------|-------------------------------------|------------------------------------|
| **1**      				 | Joao Amaral 												 |[Joao Amaral](student-1122334/) |
| **2**    					 | Maria Ferreira											 |[Maria Ferreira](student-1133224/) |
| **3**    					 | 																		 |																	  |
| **4**    					 | 																		 |																	  |
| **5**    					 | 																		 |																	  |
| **6**    					 | 																		 |																	  |
| **7**    					 | 																		 |																	  |
| **8**    					 | 																		 |																	  |
| **9**    					 | 																		 |																	  |
| **10**    				 | 																		 |																	  |
| **11**    				 | 																		 |																	  |
| **12**    				 | 																		 |																	  |
| **13**    				 | 																		 |																	  |
| **14**    				 | 																		 |																	  |
| **15**    				 | 																		 |																	  |
| **16**    				 | 																		 |																	  |
| **17**    				 | 																		 |																	  |
| **18**    				 | 																		 |																	  |
| **19**    				 | 																		 |																	  |
| **20**    				 | 																		 |																	  |
| **21**    				 | 																		 |																	  |
| **22**    				 | 																		 |																	  |
| **23**    				 | 																		 |																	  |
| **24**    				 | 																		 |																	  |
| **25**    				 | 																		 |																	  |


# 4. Sprints

The following table is used to register the work of the students that are selected to present at each Sprint Review. For instance, if I am Student "Maria Ferreira" (1133224) and I was selected to make the second presentation for Sprint 1 then I should update this table as illustrated.

**Documentation for each Sprint**

|Sprint  | Sprint Presentation 1                  |  Sprint Presentation 2                |  Sprint Presentation 3                |  Sprint Presentation 4                |  Sprint Presentation 5                |
|--------|----------------------------------------|---------------------------------------|---------------------------------------|---------------------------------------|---------------------------------------|
| **1**  |[Joao Amaral](student-1122334/sp1)  |[Maria Ferreira](student-1133224/sp1) |                                       |                                       |																				|
| **2**  |																				|																				|																				|																				|  																			|
| **3**  |																				|																				|																				|																				|  																			|
| **4**  |																				|																				|																				|																				|  																			|
| **5**  |																				|																				|																				|																				|  																			|


# 5. How to Use These README.md Type of Files

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
