**David Maia** (s1161110) - Sprint 3 - LANG2.2
===============================

# 1. General Notes


# 2. Requirements

LANG 02.2

Add support for global variables. Global variables are variables that exist in the context of the workbook and are persisted with the workbook. The name of global variables must start with the "@" sign. When a variable is referred in a formula for the first time it is created. To set the value of a variable it must be used on the left of the assign operator (":="). Attention should be given to synchronization problems. For an example of the use of global variables see Lang01.3.

# 3. Analysis




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



**Test Coverage**  
- There was not any change in the domain so there was nothing to test.

## 4.2. Requirements Realization

**For US1**

![SD US1](SD.jpg)

Notes:  


## 4.3. Classes

## 4.4. Design Patterns and Best Practices

In this sprint I used:  
- Singleton
- MVP  


# 5. Implementation

**For US1**



**Code Organization**  

I followed the recommended organization for packages:  

The code for this sprint:  

Project **server**


Project **shared**  



Project **NSheets**




# 6. Integration/Demonstration


# 7. Final Remarks


# 8. Work Log
**Wednesday - June 13**
* Previous Sprint review

**Thursday - June 14**
* Research and Requirements started.
* Analysis started.


Commits:

[Documentation Start](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/1514ceb2a44e)

[Requirements]()

[Analysis]()

[Design]()

[Code Implementation ]()
