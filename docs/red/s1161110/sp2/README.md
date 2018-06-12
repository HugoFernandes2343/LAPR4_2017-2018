**David Maia** (s1161110) - Sprint 2 - IPC04.2
===============================

# 1. General Notes

For this sprint I will allow the import of xml files, but because in the previous sprint the other team did not completed the export of a xml file, I will create my own schema.

# 2. Requirements

IPC04.2 - Import XML

It should be possible to import (i.e., upload) data from an XML file (this operation is the "inverse" of the previous one). Depending on the contents of the XML file, the data from the file can replace the contents of the active workbook, a spreadsheet or a range of a spreadsheet.

-US1: As an user I want to be able to upload a XML file and import the data to the current workbook.

# 3. Analysis

For this feature increment, since it in the first sprint it wasn't developed a xml schema, and there is not any upload file system. I need to:

* Create a XML Schema for workbook;

* Create an upload file page and servlet;

* Create a file reader system;

* Understand how to change the value of the cells for the current workbook;


## 3.1 Analysis Diagrams


**Use Cases**

![Use Cases](us.jpg)

 **Use Case 1**.

**Domain Model (for this feature increment)**

- Since I found no specific requirements in terms of domain, I follow the Structure of the existing entitys.

**System Sequence Diagrams**

![Analysis SD](SSD1.jpg)

# 4. Design


## 4.1. Tests


There are not many tests possible for this use case other than the functional use of this feature.

**Domain classes**

This classes were not changed so there is no need to test anything.

**Services/Controllers**

**Test 1**



**Test Coverage**  
- There were no tests made

## 4.2. Requirements Realization



**For US1**

![SD US1](SD.jpg)

Notes:  
- 



## 4.3. Classes


## 4.4. Design Patterns and Best Practices

By memory we apply/use:  
- Singleton  
- Repository  
- DTO  
- MVP  


# 5. Implementation

**For US1**

**Workbook page style button**


**Style Window**


**Code Organization**  

I followed the recommended organization for packages:  

The code for this sprint:  

Project **server**

-XmlReadingService

Project **shared**  

-UploadService

-UploadServiceAsync

Project **NSheets**

-XmlUploadView

-XmlUploadModule

-XmlUploadPresenter

# 6. Integration/Demonstration



# 7. Final Remarks



# 8. Work Log
**Tuesday - June 5**
* Previous Sprint review

**Wednesday - June 6**
* New Use case attributed, research on upload files and servlet builds started.

**Thrusday - June 7**
* Documentation: Requirements and Analysis start.
* Implementation/ Research: UI Upload of files.

**Friday - June 8**
* Documentation: Analysis completed, short sequence diagram and user story diagram created.
* Implementation: UploadServlet creation, web.xml and pom updated.

**Saturday - June 9**
* Documentation: Design started
* Implementation: UploadServlet, UploadService and UploadServiceAsync updated

**Monday- June 11**
* Documentation: Design updated
* Implementation:Solving problems, finishing Implementation

**Tuesday - June 12**
* Documentation: Finishing Documentation
* Implementation: Attempting to solve issues

Commits:

[Requirements IPC04.2](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/aa568d2e52c9)

[Analysis IPC04.2](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/23b5d30ff1fc)

[Design IPC04.2]()

[Tests (documentation) IPC04.2]()

[Code Implementation IPC04.2 UI and UploadServlet](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/841e9fdefcd4)

[Code Implementation IPC04.2]()
