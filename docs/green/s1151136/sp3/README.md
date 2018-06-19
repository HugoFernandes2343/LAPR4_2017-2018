**Carlos Rodrigues** (s1151136) - Sprint 3 - Core02.2
===============================

# 1. General Notes

At the beginning of the sprint, i lost a bit time to help a colleague in the improvement of the delivery of the sprint 2.
I also had some doubts about what i was supposed to do in concrete  regarding this use case.

# 2. Requirements

- **Core02.2 - Full Extension Mechanism**

The extensions should now contribute also with popup menus in cells, menu options in the navigator and side bars.

Proposal:

US1 - Create/add a popup menu

US2 - Create/add a new menu in the main side bar

US3 - Create side bars

# 3. Analysis

For this feature increment, since it is the first one to be developed in a new project I need to:  

- Understand how the application works and also understand the key aspects of GWT, since it is the main technology behind the application  

- Understand how the Home Page is implemented (for instance, how the UI gets the Workbook Descriptions that are displayed)    

## 3.4 Analysis Diagrams

**Use Cases**

![Use Cases](UseCaseDiagramSP3.jpg)

**System Sequence Diagrams**

**For US1**

![SSD_US1](sequenceDiagramSP3_US1.png)

**For US2**

![SSD_US2](sequenceDiagramSP3_US2.png)

**For US3**

![SSD_US3](sequenceDiagramSP3_US3.png)

# 4. Design

## 4.1. Tests

No tests were developed, no need.

## 4.3. Classes

- ExtensionModule
- ExtensionPresenter
- ExtensionView
- ExtensionView.ui

## 4.4. Design Patterns and Best Practices

No design patterns were used.

# 5. Implementation

**For US1**

**For US2**

**For US3**

# 6. Integration/Demonstration

![ExtensionView](extensionMenu.png)

![ExtensionContent](extensionContent.png)

**For US1**

![popupMenu](popupMenu.png)

![setPopupMenu](setPopupMenu.png)

![resultPopupMenu](resultPopupMenu.png)

**For US2**

![menu](menu.png)

![setMenu](setMenu.png)

![resultMenu](resultMenu.png)

# 8. Work Log

Commits:

[Core 02.2 - (Documentation and implementation) - Initial documentation, added extension window and configurate buttons  ](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/875da4aa99d4)

[Core 02.2 - Implementation - Create popup menu in cells and a new menu in the main side bar ](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/e06ffa03f8ee)
