LAPR4/NSheets Project Documentation
================================

# 1. Organization

Each **Class Section** (i.e., "Turma PL") **is a Team** in the LAPR4 Project. 

Each Team will have its one fork of the NSheets repository.

To help the management of the project each Team is further divided in 3 sub-teams named: Red, Green and Blue.

The Requirements of the Project are also divided in three functional areas: Core, IPC and Lang.

The Project will be developed during 3 Sprints. During each sprint, each sub-team works in a specific functional area. Each sub-team (and Student) must work in all three functional areas.

Sub-teams should be defined before the start of the project and should remain stable during the project.

# 2. Individual Pages

These are links for the individual pages/folders of each Student. The first one is only an example that you should delete when the team starts the project. Each student should update the table and the folder structure of the repository accordingly.

| Team | Student Number     | Student Name                        | Link 							  |
|------|--------------------|-------------------------------------|------------------------------------|
| Red  | **s1122101**      			| John Doe					|[John Doe](red/s1122101/) |
| Red  |			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |

# 3. Planning Overview

This is a table that should display the overall planning of the team. This is simply and example and you should update the table with the plan of your team. 

| Team | Sprin1     | Sprint2        | Sprint 3	  |
|------|------------|----------------|-------------|
| Red  | Core   		| IPC			| Lang        |
| Green  | IPC      | Lang		    | Core		  |	
| Blue  | Lang	    | Core	  		| IPC    	  |

# 4. Detailed Planning

| Team | Student                      | Sprint1                                        | Sprint2                                      | Sprint3 							          |
|------|------------------------------|------------------------------------------------|----------------------------------------------|----------------------------------------------|
| Red  | [John Doe](red/s1122101/) | [Core01.1](red/s1122101/sp1)            | [IPC01.2](red/s1122101/sp2)           | [Lang01.3](red/s1122101/sp3) |
| Red  |			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|	
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|

# 5. Requirements

The ultimate goal of this project is to develop the first version of Cleansheets for the Web! As such, it may be wise to study the previous desktop version. You may fork the desktop version available in [Bitbucket](https://bitbucket.org/lei-isep/csheets). Along with the code you may find the documentation (i.e., the manual) in 'manual/doc/lapr4_manual.pdf'. 

The requirements for this new version are similar to the ones of the previous version but some updates have been made by the Product Owner.

In this document four terms that are related to similar concepts are used: feature, functional increment, use case and user story. Although similar they are different. Features refer to the identification of a requirement in this document. Each requirement/feature is further divided into functional increments. Normally, each functional increment depends on the previous increment of the same feature. It can also depend on other features, but that is to be discovered during the normal process of analysis. Functional increments of a feature should be developed in sequence.

One can state that the functional increment is the unit of work in this project. Usually a functional increment can be specified using the formalism of "user stories". Also, a user story can be further described by the formalism of "use cases". For the most common and simpler cases we can say that one functional increment corresponds to one user story which, in turn, corresponds to one use case. That is why it is normally "safe" to use whatever term we prefer. However, one should pay attention during analysis, because sometimes that correspondence may not be true.

Requirements are classified in three functional areas:
- **Core**: These are requirements that are related to the architecture and common functionalities of NSheets
- **Languages** These are requirements that are related to the formulas of NSheets and other aspects related to languages, parsers and grammars
- **IPC**: These are requirements that explore interprocess communication


## 5.1 Core

### Core01 - Workbook View (Mandatory)
	Core01.1 - Partial Workbook View (only one sheet)
	Core01.2 - Complete Workbook View (support for references between sheets)
	Core01.3 - More than one active Workbook (support for references between workbooks)
	
### Core02 - Extensions (Mandatory)
	Core02.1 - Extension Mechanism supports Cells Decorators and a Configuration section in the Settings Page 
	Core02.2 - Extension Mechanism supports Popup menus in Cells and Menu Options in the Navigator 
	Core02.3 - Extension Mechanism supports enable/disable extensions

### Core03 - Sort and Cells Dependencies
	Core03.1 - Sort Range of Cells
	Core03.2 - Filter Range of Cells
	Core03.3 - Dependency Tree extension

### Core04 - Charts
	Core04.1 - Basic Chart Wizard
	Core04.2 - Advanced Chart Wizard
	Core04.3 - Dynamic Charts
	
### Core05 - Reminders and Tasks
	Core05.1 - Reminders
	Core05.2 - Task
	Core05.3 - Tasks, Reminders, Events
	
### Core06 - Calendar
	Core06.1 - Calendar Edition (the calendar of the user)
	Core06.2 - Basic Agenda View
	Core06.3 - Advanced Agenda View
	
### Core07 - Notes
	Core06.1 - Notes View
	Core06.2 - Lists
	Core06.3 - Search and Export Notes
	
### Core08 - Base Extensions
	Core08.1 - Comments in Cells Extension
	Core08.2 - Images in Cells Extension
	Core08.3 - Styles in Cells Extension
	
## 5.2 IPC

### IPC01 - Register and Login (Mandatory)
	IPC01.1 - Protect all the Pages (Except About) with a Login Page (i.e., Gatekeepers in GWTP). Define some hard-coded users to use for authentication. Define a super-user that is able to access **everything**
	IPC01.2 - Implement a Register Page
	IPC01.3 - Implement a Security Section in the Profile of the User (to change password, delete account, etc.)

### IPC02 - Search
	IPC02.1 - Workbook Search 
	IPC02.2 - Workbook Search and Replace
	IPC02.3 - Global Search (Search on All workbooks of the user)
		
### IPC03 - PDF
	IPC03.1 - Basic PDF Export (Download)
	IPC03.2 - PDF Style Export (Download)
	IPC03.3 - PDF Complete Export (Download)
	
### IPC04 - XML
	IPC04.1 - Export XML (Download)
	IPC04.2 - Import XML (Upload)
	IPC04.3 - Full XML Import/Export
	
### IPC05 - CLS/CSV Persistence
	IPC05.1 - Export to CSV (Download)
	IPC05.2 - Import/Export using the same native format as CSheets (Download/Upload)
	IPC05.3 - Import/Export using the same native format as CSheets and CSV
	
### IPC06 - Workbook Sharing				
	IPC06.1 - A Page that displays all private Workbooks (all workbooks are by default private to the user)
	IPC06.2 - A Page that displays public Workbooks. In the Workbook View it should be possible to make the Workbook public.
	IPC06.3 - A page with the workbooks that others have shared.

### IPC07 - Collaborative Workbook Editing
	IPC07.1 - Concurrent editions of the same Workbook should display updates in realtime
	IPC07.2 - The Workbook View should display other users that are editing the same Workbook and display the cells that other users are editing.
	IPC07.3 - The Workbook View should have an area to allow users to exchange small text messages 

### IPC08 - Online Chat
	IPC08.1 - Add a Page to allow for exchange text messages between all online users (a public chat room)
	IPC08.2 - Users should be able to create private chat rooms. They should invite other users (by using their email)
	IPC08.3 - Users should be able to post Images and make mentions of users (they should reveive an email if they are not online)

## 5.3 Lang

### Lang01 - Formulas (Mandatory)
	Lang01.1 - Block of Instructions
	Lang01.2 - Monetary Language
	Lang01.3 - Eval and While Loops

### Lang02 - Variables
	Lang02.1 - Temporary Variables
	Lang02.2 - Global Variables
	Lang02.3 - Arrays and Variable Editor
	
### Lang03 - Tools based on Formulas
	Lang03.1 - Conditional Formating of Cells
	Lang03.2 - Conditional Formating of Ranges
	Lang03.3 - Tables and Filters
	
### Lang04 - Function Wizard
	Lang04.1 - Insert Function Basic Wizard
	Lang04.2 - Insert Function Intermediate Wizard
	Lang04.3 - Insert Function Advanced Wizard
		
### Lang05 - Forms
	Lang05.1 - Forms Editor
	Lang05.2 - Forms and Variables
	Lang05.3 - Advanced Forms
		
### Lang06 - Macros Script Language
	Lang06.1 - Macros Language Window
	Lang06.2 - Multiple Macros
	Lang06.3 - Macros with Parameters
	
### Lang07 - Visual Basic Script Language
	Lang07.1 - A language with a syntax similar to Visual Basic (no methods)
	Lang07.2 - With methods without parameters
	Lang07.3 - With methods with parameters

### Lang08 - Java Script Language
	Lang08.1 - A language with a syntax similar to Java (no methods)
	Lang08.2 - With methods without parameters
	Lang08.3 - With methods with parameters
		

# 6. Domain Model

**Core**

![Core Domain Model](domain_model_image1.png)

**Formulas**

![Formulas Domain Model](domain_model_formulas_image1.png)



