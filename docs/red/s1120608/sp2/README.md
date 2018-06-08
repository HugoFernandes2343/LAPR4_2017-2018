**Norberto Sousa** (s1120608) - Sprint 2 - IPC06.2
===============================

# 1. General Notes

Given the fact that this UC sprint 1 functionalities are not necessary for this sprint, they will not be considered.
Only after finishing this sprint requirements will there be an attempt made in finishing the last sprint requirements.

# 2. Requirements

IPC06.2 - Workbooks that are created by the user should be considered private. The "Home" page should now be able to display private and public workbooks. It should be possible to apply filters to this view/page to display only private or public workbooks with specific names or descriptions (the application should accepted regular expressions to filter the workbooks). Public and private workbooks should have some visual distinction (e.g., icon).

Proposal:

US1 - As a User I want to be able to create public and private Workbooks.
US2 - As a User I want to be able to filter my workbooks with keywords and/or regular expressions.

# 3. Analysis


For this feature increment, since I'm building on top of what was made in the first sprint I need to:

- Alter workbooks so that there is distinction between Private and Public ones.

- Change the HomePage UI so that that there is a Graphic difference between the two types of Workbooks.

- Add a button/switch so that it is possible to change the Workbook listing to only show private/all workbooks.

- Alter the existing search bar so that it allows the user to search Workbooks by keywords/regex.


## 3.1 Application Startup


## 3.2 Server and RPC


## 3.3 Analysis Diagrams
