**David Maia** (s1161110) - Sprint 2 - IPC04.2
===============================

# 1. General Notes

For this sprint I will allow the import of xml files, but because in the previous sprint the other team did not completed the export of a xml file, I will create my own schema.

# 2. Requirements

IPC04.2 - Import XML

It should be possible to import (i.e., upload) data from an XML file (this operation is the "inverse" of the previous one). Depending on the contents of the XML file, the data from the file can replace the contents of the active workbook, a spreadsheet or a range of a spreadsheet.

-US1: As an user I want to be able to upload a XML file and import the data to the current workbook.

# 3. Analysis




## 3.1 Analysis Diagrams


**Use Cases**

![Use Cases](us.jpg)

- **Use Cases**.

**Domain Model (for this feature increment)**

- Since I found no specific requirements in terms of domain, I follow the Structure of the existing entitys.

**System Sequence Diagrams**

![Analysis SD](ssd.jpg)

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

![SD US1](sd.jpg)

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


Project **shared**  


Project **NSheets**
-XmlUploadView
-XmlUploadModule
-XmlUploadPresenter

# 6. Integration/Demonstration



# 7. Final Remarks



# 8. Work Log
Tuesday - June 5
Previous Sprint review

Wednesday - June 6
New Use case attributed, research on upload files and servlet builds started.

Thrusday - June 7

Friday - June 8

Saturday - June 9

Sunday - June 10

Monday- June 11

Tuesday - June 12

Commits:

[Requirements IPC04.2]()

[Analysis IPC04.2]()

[Design IPC04.2]()

[Tests (documentation) IPC04.2]()

[Code Implementation IPC04.2]()
