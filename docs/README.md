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

	Add the possibility of writing blocks (or sequences) of instructions. A block must be delimited by curly braces and its instructions must be separated by ";". The instructions of a block are executed sequentially and the block "result" is the result of the last statement of the block. For example, the formula "= {1+ 2; sum (A1:A10); B3 + 4 }" must result in the sequential execution of all expressions and the result is the value of the expression "B3 + 4". Add the assign operator (its symbol is ":="). This operator assigns to its left the result of the right expression. At the moment the left of the assign operator can only be a cell reference. The FOR loop should also be implemented based on instruction blocks. For example, the formula"= FOR {A1: = 1 ; A1<10; A2: = A2 + A1; A1: = A1 + 1 }" executes a for loop in which: the first expression is the initialization, the second term is the boundary condition, all other expressions are performed for each iteration of the loop.

- **Lang01.2 - Monetary Language**

	Add a new formulas language (currently the application only has Excel formulas that begin with the character "="). The new language should do only calculations related to currencies. The character that begins the formula should be "#". The formula should only accept the addition, subtraction, multiplication and division operators. Operands are monetary values in which it is necessary to provide the currency (e.g., 10.21e, 1.32£ or 0.20$). All expressions are required to be contained within brackets with the currency prefix in which we want the result, e.g., "#euro{10.32$ + 12.89£}" or "#dollar{ 10.32$ + 12.89£}" or "#pound{10.32$ + 12.89£}". For the user to use this language instead of the "regular" Excel language it should start the formula by the character "#" instead of the "=" character. The application should also provide a way for setting exchange rates (by means of a configuration). The implementation should avoid the use of numbers in floating point representation (e.g., float, double) in order to avoid precision problems.

- **Lang01.3 - Eval and While Loops**

	Add the Eval function. This function has a single parameter that is a string. When executed, this function will "compile" the formula contained in the only parameter and execute the resulting expression. The result of Eval is the result of the execution of the compiled expression. For example, if we write the following formula "=" 2 + 3 "" we get the string "2 + 3" in the cell. However, if we write the formula "= eval (" 2 + 3 ")" the value obtained in the cell is 5. Add the following two loop functions: DoWhile and WhileDo. The DoWhile executes the first expression in loop while the second expression evaluates to true. In each iteration of the loop the the first expression is the first to be evaluated. The WhileDo executes the second expression in loop while the first evaluates to true. In each iteration of the loop the the first expression is the first to be evaluated. Example: "= {@Counter:=1; WhileDo(Eval( "A"&@Counter)> 0; {C1:=C1+Eval("B"&@Counter); @Counter:=@Counter+1 }) }" . In this example, the cell C1 will get the sum of all the values of column B in that the corresponding values in column A are greater than zero.

### Lang02 - Variables

- **Lang02.1 - Temporary Variables**

	Add support for temporary variables. The name of temporary variables must start with the "_" sign. When a variable is referred in a formula for the first time, it is created. To set the value of a variable it must be used on the left of the assign operator (":="). Temporary variables are variables that only exist in the context of the execution of a formula. Therefore, it is possible for several formulas to use temporary variables with the same name and they will be different instances. Example: "= {_Counter:=1; WhileDo(Eval( "A"&_Counter)> 0; {C1:=C1+Eval("B"&_Counter); _Counter:=_Counter+1 }) }” . In this example, the cell C1 will get the sum of all the values of column B in that the corresponding values in column A are greater than zero.

- **Lang02.2 - Global Variables**

	Add support for global variables. Global variables are variables that exist in the context of the workbook and are persisted with the workbook. The name of global variables must start with the "@" sign. When a variable is referred in a formula for the first time it is created. To set the value of a variable it must be used on the left of the assign operator (":="). Attention should be given to synchronization problems. For an example of the use of global variables see Lang01.3.

- **Lang02.3 - Arrays and Variable Editor**

	Add support for array variables (temporary and global). Any variable can be an array. When accessing a variable only by its name it should be inferred the position 1 of the array. To explicitly access a position in a array variable the position index should be specified inside brackets (following the name of the variable). For example, the formula "=@abc[2]:=123" will set the position 2 of the global variable @abc to the value 123. Each position of an array can be of a different type. For instance it should be possible to have an array with numeric and alphanumeric values.
	There should also be a window to display and edit the value of global variables. The values that appear in this window should be automatically updated when the variables are updated.
	
### Lang03 - Tools based on Formulas
	
- **Lang03.1 - Conditional Formating of Cells**

	Update the "style" extension so that it can be used for the conditional formatting of cells based on the result of the execution of formulas. For the style of a cell to be conditional it must have an associated formula and two formatting styles. One of the styles is applied when the formula evaluates to true and the other when it evaluates to false. The editing of these settings should be done in a window.

- **Lang03.2 - Conditional Formating of Ranges**

	Enable the application to apply conditional formatting to a range of cells (also in the style extension). The idea is that a single formula could be applied to all the cells in the range (one at a time) in order to evaluate what style to apply. For that to be possible it is necessary to add a new special kind of variable to the formulas that represents the "current" cell. This special variable could be named "_cell". For instance, the formula "=_cell >= 10" could be associated to a range format. In this case, the application would evaluate the formula for each cell in the range and apply the formatting style in accordance with the result of the formula. In this example, all cell in the range with a value greater or equal to 10 would receive the style associated with the true result and the others the style associated with the false result. The window for editing the settings should also be updated so that it is clear if the format is for a single cell or for a range. Within the window it should also be possible to remove existing conditional style formatting.

- **Lang03.3 - Tables and Filters**

	Add new functionality to support the concept of "tables". A table is essentially a range of cells. The first row of this range of cells can be used as header of the table columns (the contents of these cells becomes the name of the columns). Once a table is defined it should be possible to filter its contents by using formulas. A formula that is used as a filter of a table is applied to each row of the table. If the result is true, the row is visible, if the result is false, the row should become invisible. To facilitate the writing of such formulas a new special variable should be added to formulas. This new variable should be an array variable that represents the value of the columns of the table for the current row. Lets consider, for instance, that the new variable is called "_col". For example, it should be possible to use "_col[2]" to get the value of column 2 for the current row. It should also be possible to use the name of the column instead of the index. For instance, if the header of column 2 is "cidade" it should be possible the get the value of this column for the current row by using "_col["cidade"]". An example of a filter for a table could be: "=or(_col["idade"]>10; _col[3]<123)". This extension should have a window that should be used to edit tables and its filters.
		
### Lang04 - Function Wizard
	
- **Lang04.1 - Insert Function Basic Wizard**

	The application should have an option to launch a wizard to aid the user in calling functions in formulas. This new window should display a list of possible functions. The construction of this list should be made dynamically based on the self-description of the functions. When a function is selected in the list its syntax should be displayed in a edit box. The "syntax" should include the name of the function and its parameters. For example, for the factorial function, that only has one parameter, the following text should be displayed in the edit box "= FACT(Number)". The window should also contain an area to display a text describing the selected function (i.e., help text). The window should have an "Apply" and a "Cancel" button. If the user selects the "Apply" button the text of the syntax of the function should be written in the "formula bar".

- **Lang04.2 - Insert Function Intermediate Wizard**

	The wizard window should display an edit box for each parameter of the selected function. The user should use these edit boxes to enter the values for each parameter of the function. As the user enters the values the wizard should display (in a new region of the window) the result of the execution of the formula or a message explaining the problem. The function list should now include also the operators as well as the functions that are dynamically loaded from java.lang.Math. The wizard should be now launched from an icon or button located in the "formula bar".

- **Lang04.3 - Insert Function Advanced Wizard**

	The wizard should now have an edit box where the formula is gradually constructed. The user should be able to edit the formula text freely. The functions or operators (and the values of its parameters/operands) selected from the list should now be inserted in the position of the cursor in the new edit box. The wizard should continue to have an area to display the evaluation of the formula (that should be produced dynamically, as the user edits the formula). The wizard should also have a new window that should display the structure of the formula expression like an abstract syntax tree (i.e., the structure resulting from the formula compilation). When the user clicks a tree element its respective text in the edit box should appear highlighted.
		
### Lang05 - Forms

- **Lang05.1 - Forms Editor**

	The application should have a new option to launch a window for editing a form. A Form is a window that is designed by the end user and is used for interacting with the user (input and output). The new window should support the creation and testing of a Form. Forms should be very simple. A Form should be composed of rows, each row can be empty or have one or two visual widgets. The supported visual widgets are: button (to invoke actions); edit box (to enter data) and static text box (to display data). It should be possible to set the core properties of these widgets (like the text to display in a static text box, for instance). In the edit form window it should be possible to: add a new row; remove an existing row; edit an existing row; "play" the form and close the edit form window. The "play" button is for testing the appearance of a form during its design (see example in the next Figure). At the moment it is only required to support a single Form for each workbook. Macros and formulas should have a new function that can be used to display the form of the current workbook. Forms should have an icon or button to close the form. When the form is closed the function (in macros or formulas) who call it returns.
	
![Form](form1.png)	

- **Lang05.2 - Forms and Variables**

	In order for forms to become useful in formulas or macros it is necessary to associate data with the contents of the visual widgets. The mechanism used for that will be the binding of variables (macros or formulas variables) with the contents of the visual widgets. One simple way to achieve this is by using temporary variables (from macros and formulas). The matching between widgets and variables should be done by associating the ones with the same name. When displaying a form (in the context of a macro or a formula), if the temporary variables with the same name of widgets exist, them they are used to set the content of the widgets. For widgets for which no temporary variables with the same name are found then new temporary variables should be created. The user should be able to change the contents of edit boxes. When closing the form window the contents of the temporary variables should be updated from the contents of the corresponding visual widgets.

- **Lang05.3 - Advanced Forms**

	It should now be possible to create multiple forms for each workbook. To distinguish Forms, each one should have a unique name (within its workbook). The function (in macros and formulas) that displays the forms should now have one parameter that is used to pass the name of the form to display (since there can be several forms for each workbook).
	When displaying a form it should be possible specify if it should be read only (i.e., it will display the value of the variables but does not allow any update) or writable (in this case the form should allow for the user to modify the values that are displayed). Writable forms should have a new "Update" button. When the user clicks in the update button the form closes and the current values of the widgets update the corresponding variables. If the user closes the form window by any other means the variables should not be updated. It should be also possible to specify the "mode" of the form window (when invoking the display of a form). Two modes are allowed: modal and modeless. A modal form window is a window that will block the macro or formula that call it until the user closes the form window. The macro or formula will only resume execution when the form is closed. A modeless for window is a window that will no block the calling macro or formula, i.e., the macro or formula will continue its execution in parallel with the display of the form. Modeless forms do not return anything. Model forms should return the name of the button that was used to close the window.

### Lang06 - Macros Script Language
	
- **Lang06.1 - Macros Language**

	The application should have a new option to open a window to edit and execute a single macro. Macros should be designed as a complete new language in the application. However, its initial grammar should be very simple and "inspired" in the language of the formulas. In particular, a macro is simply a sequence of formulas that are executed sequentially. The formulas are the same as those used in the cells. Each line of the macro may contain a formula or be a comment. A comment is a line that starts with the character ";". The lines of the macros must support all that is possible to do with the cell formulas that start with "=" (but in the macros the lines can not start with "="). The macro is to be associated with the current workbook. The result of executing a macro is the result of the last executed instruction. The new window should have an area to edit the text of the macro and button to run the macro. The result of the execution of the macro should also appear in the window.

- **Lang06.2 - Multiple Macros**

	The application should now support multiple macros. Each macro should have a name and should be associated with an workbook. The grammar of the macros should also have a mechanism to support the invocation of macros. It only should be possible to invoke macros of the same workbook. Special attention should be devoted to recursion (i.e., avoiding infinite recursion).

- **Lang06.3 - Macros with Parameters**

	Macros should now have parameters. The syntax for macros should now include an header that should include the name of the macro and its parameters (all parameters should have a distinct name). The parameters should be considered only input parameters. However, it should be possible to freely reference parameters inside the macro. That is to say that, inside a macro, parameters should be used like variables. Macros should support local variables that exist only in the context of a macro. This local variables should have a syntax similar to the one described for the temporary variables of formulas. The invocation of macros must now include the values for its parameters.
	
### Lang07 - Visual Basic Script Language

- **Lang07.1 - Base Visual Basic Language**  

	The application should support a language inspired in the syntax of [Visual Basic](https://en.wikipedia.org/wiki/Microsoft_Small_Basic). This language is to be an alterntive language to writing "Macros". This feature increment should have the same functionality as Lang06.1 but with the adaptations required by the syntax of the language.

- **Lang07.2 - Visual Basic with Methods without Parameters**

	This feature increment should have the same functionality as Lang06.2 but with the adaptations required by the syntax of the language.

- **Lang07.3 - Visual Basic with Methods with parameters**

	This feature increment should have the same functionality as Lang06.3 but with the adaptations required by the syntax of the language.

### Lang08 - Java Script Language

- **Lang08.1 - Base Javascript Language**

	The application should support a language inspired in the syntax of [Javascript](https://en.wikipedia.org/wiki/JavaScript#Syntax). This language is to be an alterntive language to writing "Macros". This feature increment should have the same functionality as Lang06.1 but with the adaptations required by the syntax of the language.

- **Lang08.2 - Javascript with Methods without parameters**

	This feature increment should have the same functionality as Lang06.2 but with the adaptations required by the syntax of the language.

- **Lang08.3 - Javascript with Methods with parameters**
		
	This feature increment should have the same functionality as Lang06.3 but with the adaptations required by the syntax of the language.	
		
# 6. Domain Model

**Core**

![Core Domain Model](domain_model_image1.png)

**Formulas**

![Formulas Domain Model](domain_model_formulas_image1.png)



