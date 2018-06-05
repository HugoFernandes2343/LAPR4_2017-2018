**David Maia** (s1161110) - Sprint 1 - Core08.1
===============================

# 1. General Notes

This sprint was full of problems, it was hard to understand the design of the application. My Use Case depends on the Core02.1 so I helped my colleague, but with little success.

# 2. Requirements

Core08.1 - Styles in Cells Extension

The application should have a new extension to associate styles with cells. The functionality should be similar to the one present in the desktop version of Cleansheets.
It adds the option to change colour (text or background), text formatting, alignments and fonts of each cell on a spreadsheet.

-US1: As an user I want to be able to stylish the spreadsheet cells.

# 3. Analysis

For this feature creation, since it is the first one to be developed regarding style in cells I need to:  

- Enable a button that allows to pop a menu for the user to choose one cell and select the caracteristic to change: colour, text formatting or alignments (example: background colour);

- After choosing the caracteristic I want to change, I may choose one change option (example: Black);


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

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

Regarding tests we try to follow an approach inspired by test driven development. However it is not realistic to apply it for all the application (for instance for the UI part). Therefore we focus on the domain classes and also on the services provided by the server.

**Domain classes**

For the Domain classes i will have to test the sorting methods added to class that represents the entity **Spreadsheet**. This entity will have methods that, for the moment, will be based on the class **SpreadsheetImpl**:

**Test1:** I should ensure that are the cells are of the same data type(number(float)). Ascending case


**Test2:** I should ensure that are the cells are of the same data type(text(string)). Ascending case



**Test3:** I should ensure that are the cells are of the same data type(date). Ascending case



**Test4:** I should ensure that are the cells are of the same data type(number(float)). Descending case



**Test5:** I should ensure that are the cells are of the same data type(text(string)). Descending case



**Test6:** I should ensure that are the cells are of the same data type(date). Descending case




**Services/Controllers**

For the services the application already has a service specified in the interface **WorkbooksService**:

This method seems to be sufficient for supporting US1 but not US2.

For US2 we need a method that can be used to create a new WorkbookDescription given a WorkbookDescriptionDTO.

The proposal is:



Tests:  
-

Controller **AddWorkbookDescriptionController**

**Test:** Verify the normal creation of an WorkbookDescription.  


Controller **ListWorkbookDescriptionController**


**Test:** At the beginning of the tests the memory database should be empty, so listWorkbookDiscriptions should return an empty set.


**Test:** If a WorkbookDescription is created it should be present in a following invocation of getWorkbooks().

**Test Coverage**  
- The actual coverage for domain classes: 61%
- The actual coverage for application(controller) classes: 100%

- TODO: Add more tests to increase the coverage of the domain class.

## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.

**For US1**

![SD US1](design1.png)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **WorkbookServices** realizes the GWT RPC mechanism;  
- **ListWorkbookDescriptionController** is the *use case controller*;  
- **ListWorkbookDescriptionServices** is to group together all the services related to WorkbookDescription.


## 4.3. Classes

*Present and describe the major classes of you solution.*

## 4.4. Design Patterns and Best Practices

*Present and explain how you applied design patterns and best practices.*

By memory we apply/use:  
- Singleton  
- Repository  
- DTO  
- MVP  

**TODO:** Exemplify the realization of these patterns using class diagrams and/or SD with roles marked as stereotypes.

# 5. Implementation

*If required you should present in this section more details about the implementation. For instance, configuration files, grammar files, etc. You may also explain the organization of you code. You may reference important commits.*

**For US1**

The UI for this US was already implemented. We simply implemented the server as described previously.

**For US2**

**UI: Button for adding a new Workbook Description**

For this concern we decided to use a Material Widget called Material FAB (Floating Action Button). This is a kind of button that usually appears at the left bottom part of the screen and contains actions available for the elements of the page.  

We updated the HomeView.ui.xml accordingly and declare the element with a tag *ui:field="newWorkbookButton"*. In the corresponding class View (i.e., HomeView) we bind that button to the corresponding widget class: 	


We must now add the code that invokes the server to add a new workbook description when the user clicks in the button. This is an event. To implement this behavior we could use GWT Events such as the SetPageTitleEvent already used in the application. These are special type of events that GWT manages and are available to all pages in the application.

We chose to provide our click event globally but to simple use the click event handler of the button and connect it to a method in the HomePresenter.

Since Presenters should only depend on a View interface we added a new method to the HomePresenter.MyView:


Then, we implemented the *addClickHandler* in the HomeView class and call this method in the constructor of the HomePresenter. In the constructor our handler class the server method that adds a new workbook description.   

**Code Organization**  

We followed the recommended organization for packages:  

The code for this sprint:  


Project **shared**  


Project **NShests**


# 6. Integration/Demonstration

I worked 2 days with my colleague on the Core02.1, we had little success but we tried to interact to design a program that make sense.
My use Case functional idea is shown in this picture:
![Functional](image.png)

# 7. Final Remarks

In conclusion, I wasn't able o finish this Use Case,

Some Questions/Issues identified during the work in this feature increment:

1. Do this styles need to be persisted?
2. How to interact client and shared, when shared needs to save gwt objects?


# 8. Work Log
Tuesday - May 29
First day of work, I started by clonning the Repository. There was when the problems started: Intellij configurations errors, missing maven dependencies and some other errors.

Wednesday - May 30
On this day I solved all the problems and the team finally started the work together. I first analysed my Use Case and started to understand how would be the building of a plugin/extension on this project in particular. I started to understand that it would be a lot harder and I decided to help Core02.1 because that was the extension manager to see if I could understand more about extensions.

Thursday (Holiday)- May 31
I spent the day trying to help my colleague on the Core 02.1, research on plugin and extension use on java code was not very easy, and we spent a lot of time in the wrong path.
One post on the moodle forum (https://moodle.isep.ipp.pt/mod/forum/discuss.php?d=16860) made us understand what was the right path to work on. Later that day I decided to go back to my use case, with some ideas of how it would work.

Friday - June 1
This day was dedicated for gwt research, I never used it so there were too many problems in understanding the use of this framework and the interation with other parts of the code.

Saturday - June 2
I started the day by making the requirements and analysis of the use case.
Decided to try to create an UI to test my knowledge in gwt, I made a button in the workbook page, and start the popup window to select the changes (more about the fucntionality on the documentation above).

Sunday -  June 3
Several problems on the UI implementation, as I already started the design and I wasn't sure it would work I tried more research.

Monday - June 4
The popup window started working, but the dropdown was causing several problems that wouldn't allow me to finish on time. After the meeting I decided to focus on the documentation.

Tuesday - Delivery Day -  June 5


Commits:

[Requirements Core08.1]()
[Analysis Core08.1]()
[Design Core08.1]()
[Tests (documentation) Core08.1]()
[Code Implementation Core08.1]()
