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
	- The project is a team work. Important design decisions (e.g., with impact in the architecture or futures developments) must be discussed and taken as a group.  
	- Each Feature Increment must is to be developed individually.  
	- Features that are mandatory are required to be developed.  
	- Some features may be dependent on others. Students must make sure that dependent features are ready and, if not, develop the required functionality.    
	- When a Feature is started it must be completed, i.e., all the three functional increments must be developed.
	
## 5.1 Core

### Core01 - Workbook View (Mandatory)
	
- **Core01.1 - Partial Workbook View**
	
	The workbook page should be related to one of the workbooks displayed in the home page. It should be possible to create a new empty workbook in the home page.
	Workbooks should be persisted in the server. At this moment a workbook must only have one spreadsheet.
	
- **Core01.2 - Complete Workbook View**
	
	The application should now support complete workbooks, i.e., workbooks with several spreadsheets. It should be possible to make references between sheets in the formulas.
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

	The application should have a new menu option to launch a wizard to help the user create a bar chart. The wizard should have 2 steps. In the first step, the user should input the name of the chart and the range of cells that contains the data for the plot of the chart. The user should also select if the data is in the rows or columns of the range and if the first row or the first column are to be considered labels. In the second step the wizard should display a preview of the chart. The wizard should allow the user to move between steps 1 and 2. If the wizard is confirmed the cell in the left upper corner of the range should have a mark (e.g., icon) that indicates that the cell has a chart associated with it. A popup menu option in the cell should provide access to the chart.

- **Core04.2 - Advanced Chart Wizard**

	The previous bar chart can now be configured to display bars side by side or stacked. The application should also support a new type of charts: pie charts. The wizard should now give the user the possibility to select the type of chart. The charts can now be produced using data that is in a different spreadsheet of the workbook. The application should now include a window (or page, or section in a page) that displays the list of existing charts and that can be used to enable/disable the display of each chart as well as give access to the chart wizard so that it is possible to change the existing charts. It should also be possible the delete existing charts using this window.

- **Core04.3 - Dynamic Charts**

	The charts should now be dynamic. A dynamic chart is a chart that is automatically updated when its source data changes. The application should now graphically mark the range of cells that are source to charts (e.g., with a surrounding border). Also, when the mouse hovers over the left upper corner of a range of cells that is the source of a chart a preview of the chart should appear.
	
### Core05 - Contacts, Tasks and Reminders

- **Core05.1 - Contacts**

	Each user of the applications should have a list of contacts. A contact is another user of the application that has established a contact with the user of the application. A user of the application may establish a contact with another user by sending an invitation if he/she knows the email of the other user. A user may or not accept an invitation. A user can block/unblock invitations from other users.

- **Core05.2 - Tasks**

	It should be possible to create, edit and remove tasks. A task has a name, a description, and a list of contacts. A task also has a priority level (1 to 5) and a percentage of completion. The application should have a window to display and edit tasks. It should be possible to sort and filter the tasks using expressions based on its fields. For instance, it should be possible to only display tasks which are not completed. Tasks should be visible to all the contacts related to the task.

- **Core05.3 - Reminders**
	
	It should be possible to create, edit and remove reminders. The user is notified when the due date of the reminder arrives. A reminder has a name, a description and a time stamp (due date). The application should only allow valid time stamps. The application should list all the existing reminders. When the due date of a reminder is reached the application should automatically display an alert to the user in a popup window. This popup window should display the name, description and due date of the reminder. The window should have two buttons. One button to close the window and the other button to remind again the user in a specific elapse of time (e.g., 5 minutes).
	
### Core06 - Calendar

- **Core06.1 - Calendar**

	The application should have a calendar view to display events. An event has a title, description, time stamp and duration. Events should be displayed in the calendar ordered by their time stamp. It should be possible to create, edit and delete events. The calendar should display all events.

- **Core06.2 - Basic Agenda**
	
	The calendar view should now evolve into an agenda view that may display several calendars. It should be possible to create, edit and remove calendars. Each user can have one or more calendars. Each calendar has a name (e.g., work, birthdays, home, etc.) and a textual description. It should be possible to associate a color to a calendar (events of that calendar are displayed with the color of the calendar). It should be possible to filter what calendars are displayed in the agenda view.	The agenda view can be implemented as a simple list of events (from the calendars). The view should display only actual and future events.

- **Core06.3 - Advanced Agenda**

	The agenda view should now have a display area divided in 24 slots, one for each hour of the day. Each of the slots should have a small text displaying the hour of the day. The Events should be displayed in a size corresponding to its duration and in the color of the calendar. It should be possible to select the calendars to display in the view. When double clicking in an event its edit window should appear. It should be possible to switch between this new view and the previous view. The view should include buttons to move between days and to select the day to display. 
	
### Core07 - Notes

- **Core07.1 - Notes**

	It should be possible to create, edit and remove text notes. A user can have one or more notes. There should be a window to list the textual notes of a user. A text note should be entered as multiline text in which the first line is interpreted as the title of the text note. The time stamp of the creation of the note should be also associated with the text note. The application should maintain the history of modifications for each text note. When a text note is selected, the application should display its history. For each version, the application should display the time stamp and the first line (i.e., the title).
	
- **Core07.2 - Lists**

	It should be possible to create, edit and remove list notes. A list note is similar to a textual note but each line is displayed as a check box (that can be checked or unchecked). The first line is also interpreted as the title of the list note. It should be possible to generate a new version of a text note or list based on an old version of it. When this happens, the application should "open" the new version for edit with the same contents of the old version. This is the only "trace" that may eventually link to the old version.

- **Core07.3 - Search and Export Notes**

	It should be possible to search for notes (text and lists) within a time interval. The query expression should allow to search based on the title and/or contents of the notes. It should be possible to use regular expressions to search the contents of the notes that are within the time interval. It should be possible to open a specific note by double clicking on it in the result list. It should be possible to export the search results into a range in an spreadsheet.
	
### Core08 - Base Extensions

- **Core08.1 - Styles in Cells Extension**

	The application should have a new extension to associate styles with cells. The functionality should be similar to the one present in the desktop version of Cleansheets.

- **Core08.2 - Comments in Cells Extension**

	The application should have a new extension to associate textual comments with cells. The functionality should be similar to the one present in the desktop version of Cleansheets.

- **Core08.3 - Images in Cells Extension**

	The application should have a new extension similar to the previous one but regarding the possibility of associating images with cells.
	
## 5.2 IPC

### IPC01 - Security (Mandatory)

- **IPC01.1 - User Authentication**

	All the pages of the application should require an authenticated user (except the "About" page). The application should have a "Login" page (Hint: Gatekeepers in GWTP). Some hard-coded users should be defined to be initially used for authentication. There should also exist a super-user that is able to access **everything**.
	
- **IPC01.2 - Register User**

	The application should add the possibility of registering new users. The identification of a user should be based on his email. Each user should have an email, name, nickname and picture (i.e., face photo). The application should display the nickname and photo of the authenticated user in the top of every page. 
	
- **IPC01.3 - Security Profile**

	The application should now have a new "Profile" page to allow users to manage their accounts. The user should be able to change his information (name, nickname and photo) and also delete the account. The super-user should be able to access all the accounts and be able to enable/disable accounts. When an account is disable its user is not able to authenticate.  

### IPC02 - Search and Replace

- **IPC02.1 - Spreadsheet Search**

	The application should now allow for searching the contents of the active workbook. The new window should be composed of two parts. The first part (upper part of the window) should contain a text box for the user to enter a regular expression to be the basis for the search. This part should also contain a button to launch the search. The second part (lower part of the window) should be used to display the search results (cell coordinates and value or contents). The search should include no only the content of the cell (i.e., the text entered by the user) but also its value (that could have been calculated by a formula).

- **IPC02.2 - Workbook Search and Replace**

	The application should now have a new option for "Search and Replace". This new window should be similar to the search window but with an area to enter the replacing text. When search and replace is launched, when a match is found, the window should display "what" was found, "where" the match has occurred and how it will become after the replace. The user should then confirm the replacement or select next (to continue the search). The window should include a button to apply the replacing to all the matches without asking each time. Similarly to the search only option, this option should also have parameters to refine the search, for instance, what type of cells to include in the search (or if it should include formulas or comments). "Search" and "Search and Replace" should should include contents of all the spreadsheets of the active workbook. 

- **IPC02.3 - Global Search/Replace**

	The application should now support "Search" and "Search and Replace" to be applied for all the workbooks of the user (may they be active/open or not). It should be possible to apply the search to workbooks which name matches a specific regular expression.  
		
### IPC03 - PDF

- **IPC03.1 - Basic PDF Export**

	It should be possible to export to PDF an entire workbook, a spreadsheet or a range of cells. The contents should include only the values of the cells (and not its formulas, for instance). The user should be able to select the content to be exported and also if the document should have a table of contents with links to the sections or not. If select, sections/chapters should be generated for each spreadsheet of the workbook. The generated PDF should be downloaded to the user local file system.

- **IPC03.2 - PDF Style Export**

	The generated PDF should now mimic as far as possible the screen style of the exported contents. For instance, the formatting of the cells in the PDF should be similar to the screen. It should be also possible to configure the type of lines to use for cell delimitation, the type of line and color. This is to be applied when rendering all cells in the PDF. Note that this is different from the style used for cells borders in the screen.

- **IPC03.3 - PDF Complete Export**

	At this level, the export may include all the contents that are persisted with a workbook. For instance, all the following contents should be exported: the source of formulas, comments, images, macros, etc. However, the user should be given the possibility to select the type of contents to include in the PDF. Therefore, it is expected that the PDF includes sections that represent the visual aspect of the exported spreadsheets (as far as possible in a similar manner to how they are displayed on screen) and also new sections to include the contents that do not appear in the cells like, for instance, macros, comments or images. In each of this sections the contents should make references to the cells that are related to them (if they are related to cells).
	
### IPC04 - XML

- **IPC04.1 - Export XML**

	It should be possible to export the contents of an workbook, spreadsheet or part of a spreadsheet to a XML file. As we want to optimize as much as possible the process the solution should not rely on any third party library. The application should have a window/page to configure the XML tags to use for each type of element. The export should only include the value of the cells. The generated XML should be downloaded to the user local file system.

- **IPC04.2 - Import XML**
	
	It should be possible to import (i.e., upload) data from an XML file (this operation is the "inverse" of the previous one). Depending on the contents of the XML file, the data from the file can replace the contents of the active workbook, a spreadsheet or a range of a spreadsheet. 

- **IPC04.3 - Full XML Import/Export**

	The previous options should now include all the persisting elements of the workbooks (i.e., all the contents that are normally persisted with the workbook, such as macros, formatting styles, comments, etc.). The import should now ask the user if the file contents should replace or append the existing workbook contents.
	
### IPC05 - CLS/CSV Persistence

- **IPC05.1 - Export to CSV**

	It should be possible to export the contents of an workbook, spreadsheet or part of a spreadsheet to a CSV file. As we want to optimize as much as possible the process the solution should not rely on any third party library. The application should have a window/page to configure the CSV format (e.g, field separator or string delimiter). The export should only include the value of the cells. The generated CSV should be downloaded to the user local file system.

- **IPC05.2 - Export to CLS**

	It should be possible to export an workbook to a CLS file. The CLS format is the native format used by the desktop version of Cleansheets. It should be possible to open the exported CLS file in the desktop version of Cleansheets. The generated CLS should be downloaded to the user local file system.

- **IPC05.3 - Import/Export CSV and CLS**

	It should be possible to import and export in both formats: CLS and CSV.
	
### IPC06 - Workbook Sharing				

- **IPC06.1 - Public Workbooks**

	Workbooks should be considered public. A public workbook is a workbook that can be accessed by all users. The "Home" page should display all the workbooks. It should be possible to apply filters to this view/page to display only workbooks with specific names or descriptions (the application should accepted regular expressions to filter the workbooks). It should be possible to open, rename or delete a selected workbook in this page/view. 
	
- **IPC06.2 - Private Workbooks**

	Workbooks that are created by the user should be considered private. The "Home" page should now be able to display private and public workbooks. It should be possible to apply filters to this view/page to display only private or public workbooks with specific names or descriptions (the application should accepted regular expressions to filter the workbooks). Public and private workbooks should have some visual distinction (e.g, icon).
		 
- **IPC06.3 - Share Workbooks**

	It should be possible to apply individual sharing options to each workbook. A workbook can now be shared with only specific users. In this context, a public workbook is simply a workbook that is shared with everyone. Also, the share should have a type: view, read-only, write. View only allows the listing of the name and description of the workbook. Read-only allow to open the workbook but not to edit it. Write should allow full edition.	

### IPC07 - Collaborative Workbook Editing

- **IPC07.1 - Base Concurrent Edition**

	Concurrent editions of the same Workbook should display updates "as much as possible" in realtime. 

- **IPC07.2 - Full Concurrent Edition**

	The Workbook View should display other users that are editing the same workbook and have a visual identification for the cells that other users are editing.
	
- **IPC07.3 - Message Exchange**

	The Workbook View should have an area to allow collaborate users to exchange small text messages.

### IPC08 - Online Chat

- **IPC08.1 - Public Chat**

	Add a Page/View to allow all online users to exchange text messages (i.e., a public chat room).
	
- **IPC08.2 - Private Chat**

	Users should now be able to create private chat rooms. They should invite other users (by using their email).

- **IPC08.3 - Full Chat**

	Users should be able to post Images and make mentions of other users (they should receive a notification email if they are not online). 
 
## 5.3 Lang

### Lang01 - Formulas (Mandatory)

- **Lang01.1 - Block of Instructions**

- **Lang01.2 - Monetary Language**

- **Lang01.3 - Eval and While Loops**

### Lang02 - Variables

- **Lang02.1 - Temporary Variables**

- **Lang02.2 - Global Variables**

- **Lang02.3 - Arrays and Variable Editor**
	
### Lang03 - Tools based on Formulas
	
- **Lang03.1 - Conditional Formating of Cells**

- **Lang03.2 - Conditional Formating of Ranges**

- **Lang03.3 - Tables and Filters**

	*esta duplicado em core?*
	
### Lang04 - Function Wizard
	
- **Lang04.1 - Insert Function Basic Wizard**

- **Lang04.2 - Insert Function Intermediate Wizard**

- **Lang04.3 - Insert Function Advanced Wizard**
		
### Lang05 - Forms

- **Lang05.1 - Forms Editor**

- **Lang05.2 - Forms and Variables**

- **Lang05.3 - Advanced Forms**

### Lang06 - Macros Script Language
	
- **Lang06.1 - Macros Language Window**

- **Lang06.2 - Multiple Macros**

- **Lang06.3 - Macros with Parameters**
	
### Lang07 - Visual Basic Script Language

- **Lang07.1 - A language with a syntax similar to Visual Basic (no methods)**

- **Lang07.2 - With methods without parameters**

- **Lang07.3 - With methods with parameters**

### Lang08 - Java Script Language

- **Lang08.1 - A language with a syntax similar to Java (no methods)**

- **Lang08.2 - With methods without parameters**

- **Lang08.3 - With methods with parameters**
		
# 6. Domain Model

**Core**

![Core Domain Model](domain_model_image1.png)

**Formulas**

![Formulas Domain Model](domain_model_formulas_image1.png)



