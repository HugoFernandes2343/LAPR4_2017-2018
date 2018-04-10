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

# 4. Planning Detail

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

The ultimate goal of this project is to develop the first version of Cleansheets for the Web. As such, it may be wise to study the previous desktop version. You may fork the desktop version available in [Bitbucket](https://bitbucket.org/lei-isep/csheets). Along with the code you may find the documentation (i.e., the manual) in 'manual/doc/lapr4_manual.pdf'. 

The requirements for this new version are similar to the ones of the previous version but some updates have been made by the Product Owner. You may find the specific requirements for this edition further down in this section. 

In this document four terms that are related to similar concepts are used: feature, functional increment, use case and user story. Although similar they are different. Features refer to the identification of a requirement in this document. Each requirement/feature is further divided into functional increments. Normally, each functional increment depends on the previous increment of the same feature. It can also depend on other features, but that is to be discovered during the normal process of analysis. Functional increments of a feature should be developed in sequence.

One can state that the functional increment is the unit of work in this project. Usually a functional increment can be specified using the formalism of "user stories". Also, a user story can be further described by the formalism of "use cases". For the most common and simpler cases we can say that one functional increment corresponds to one user story which, in turn, corresponds to one use case. That is why it is normally "safe" to use whatever term we prefer. However, one should pay attention during analysis, because sometimes that correspondence may not be true.

Requirements are classified in three functional areas:  
	- **Core**: These are requirements that are related to the architecture and common functionalities of NSheets  
	- **Languages** These are requirements that are related to the formulas of NSheets and other aspects related to languages, parsers and grammars  
	- **IPC**: These are requirements that explore interprocess communication  
	
**Rules for the Scheduling of Requirements**  
	- Features that are mandatory are required to be developed by the team.  
	- When a Feature is started it must be completed, i.e., all the three functional increments must be developed.
	
## 5.1 Core

### Core01 - Workbook View (Mandatory)
	
- **Core01.1 - Partial Workbook View**
	
	The workbook page should be related to one of the workbooks displayed in the home page. It should be possible to create a new empty workbook in the home page.
	Workbooks should be persisted in the server. At this moment a workbook must only have one worksheet.
	
- **Core01.2 - Complete Workbook View**
	
	The application should now support complete workbooks, i.e., workbooks with several worksheets. It should be possible to make references between sheets in the formulas.
	It should also be possible to delete workbooks and update their metadata (name and description).
	
- **Core01.3 - Several Active Workbooks**

	It should be possible to open several workbooks at the same time. It should be possible to make references between workbooks in the formulas.
	
### Core02 - Extensions (Mandatory)

- **Core02.1 - Basic Extension Mechanism**

	Implement an extension mechanism that can be used to add functionality to the application. For the moment it should support extensions that add cell decorators. The application should also have a new settings page with a specific section for each extension. For testing purposes a new extension should be developed that changes the background color of numeric cells according to its value being positive or negative. The color should be configured in the settings page.
	
- **Core02.2 - Full Extension Mechanism**
	
	The extensions should now contribute also with popup menus in cells, menu options in the navigator and side bars.
	
- **Core02.3 - Enable/Disable Extensions**

	It should be possible to enable and disable extensions. At least one of the extensions of Core08 should be updated to support this feature. 

### Core03 - Sort and Dependencies in Cells

- **Core03.1 - Sort Range of Cells**

	Sort a range of cells. A range of cells is a rectangular area delimited by an upper left corner and a lower right corner. The sorting is based on one or more columns of the range. It should be possible to select the order: ascending or descending. Interaction with the user should be based on a popup menu. It should be possible to sort data of the following types: numeric, text or date.

- **Core03.2 - Filter Range of Cells**

	It should be possible to filter a range of cells. The filter should be a boolean formula that is applied to each row (and a specific column of the range). If the result is true, the row is visible. If the result is false, the row should become invisible.
	
- **Core03.3 - Dependency Tree Extension**

	This feature should implement a similar functionality to the one provided by the "Dependency Tree Extension" in the Desktop version of Cleansheets.	

### Core04 - Charts

- **Core04.1 - Basic Chart Wizard**

- **Core04.2 - Advanced Chart Wizard**

- **Core04.3 - Dynamic Charts**
	
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
	IPC08.3 - Users should be able to post Images and make mentions of users (they should receive an email if they are not online)

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



