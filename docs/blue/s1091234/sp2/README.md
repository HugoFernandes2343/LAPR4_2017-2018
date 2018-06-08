**Pedro Tedim** (s1091234) - Sprint 2 - Core01.2
===============================

# 1. General Notes

During the execution of this Use Case, me and my colleagues had to help and introduce our two Erasmus colleagues to how LAPR4 works. It was particularly difficult since their background on technologies and methodologies are not directed towards our specific ways of doing these kinds of projects.

# 2. Requirements

Core01.2 - Complete Workbook View

The application should now support complete workbooks, i.e., workbooks with several spreadsheets. It should be possible to make references between sheets in the formulas. It should also be possible to delete workbooks and update their metadata (name and description).

![Core01.2_usecasediagram](Core01.2_CD.png)

During interpretation of the use case, I was able to identify three different user stories as represented in the use case diagram above.

**US1** Edit Workbook name/description

**US2** Delete workbook

**US3** Add new Spreadsheet to Workbook

- This user story is supposed to answer to how one workbook now supports several spreadsheets.

# 3. Analysis
## 3.1 Project Structure

In this project there are 3 main modules to be mentioned:

* Client
* Shared
* Server

In this specific use case, these three modules will have the following responsibilities:

**Client**
Because we use a MVP approach, classes like WorkbookView and WorkbookPresenter, HomeView and HomePresenter should be available.

WorkbookView should have available a function to add a new spreadsheet or to select another one apart from the present one.

TODO

**Shared**
This module should wrap all the information produced by the user and send it to the server or to receive information from the server, wrap it, and present it to the user in the client module.

To be able to wrap the information mentioned above, in this module, there should be classes responsible for this action. I will apply a DTO pattern to answer to this problem.

DTO classes:

  * WorkbookDTO
  * WorkbookDescriptionDTO
  * SpreadsheetDTO

**Server**
This module should be responsible for transactions related with the database.

This module should be able to persist Workbooks, Spreadsheets and WorkbookDescriptions. To be able to do just that, entity classes like Workbook, WorkbookDescription and Spreadsheet should be available.

## 3.2 Analysis Diagrams

Because there were some mistakes in the implementation of the use case Core01.1 some modifications are in need to be implemented.

To understand how the flow of Core01.1 should be I design the following diagram:

![NewWorkbook_SD](NewWorkbook_SD.png)

To add a spreadsheet to an existing workbook I created the following diagram:

![addSpreadsheet_SD](addSpreadsheetToWorkbook_SD.png)

The application should be able to find the workbook with the same name from the database, create a DTO related to that workbook with the information gathered from the database.
Then a new SpreadsheetDTO is created, added to the workbookDTO, persisted in the database and finally the updated workbookDTO will be saved in the DB.

To be able to persist spreadsheets of a workbook, the class SpreadsheetDTO should be implemented.


# 4. Design




## 4.1. Tests

## 4.2. Design Patterns and Best Practices

By memory we apply/use:  
- DTO
-


# 5. Implementation

# 6. Integration/Demonstration

# 7. Final Remarks

This was an extremely interesting Use Case to Design and implement, I applied a lot of the knowledge obtained through the semester on LPROG course. I was also able to overcome my difficulties on the understanding of how antlr4 works and how we can use it to develop new languages that we can use in any case in the future.

# 8. Work Log

Important Commits:
