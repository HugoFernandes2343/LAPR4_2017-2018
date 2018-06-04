**Daniel Fernandes** (s1150585) - Sprint 1 - Lang05.1 - Forms Editor
===============================

# 1. General Notes

- I’ve helped my erasmus colleagues as often as I had the chance to. Regarding the project configuration as well as in terms of implementation.

# 2. Requirements

Lang05.1 - Forms Editor

The application should have a new option to launch a window for editing a form. A Form is a window that is designed by the end user and is used for interacting with the user (input and output). The new window should support the creation and testing of a Form. Forms should be very simple. A Form should be composed of rows, each row can be empty or have one or two visual widgets. The supported visual widgets are: button (to invoke actions); edit box (to enter data) and static text box (to display data). It should be possible to set the core properties of these widgets (like the text to display in a static text box, for instance). In the edit form window it should be possible to: add a new row; remove an existing row; edit an existing row; "play" the form and close the edit form window. The "play" button is for testing the appearance of a form during its design (see example in the next Figure). At the moment it is only required to support a single Form for each workbook. Macros and formulas should have a new function that can be used to display the form of the current workbook. Forms should have an icon or button to close the form. When the form is closed the function (in macros or formulas) who call it returns.

![form](form1.png)

Proposal:

US1 - As the application user I want to be able to create, edit and preview a form associated with a certain workbook.

US2 - As the application user I want to be able to execute the designated actions in each form line.

# 3. Analysis

For this feature increment, since it is the first one to be developed in a new project I need to:  

- Understand how the application works and also understand the key aspects of GWT, since it is the main technology behind the application  

- As the application user I want to be able to execute the designated actions in each form line.

- Understand how the form will be associated to a workbook.

- Understand how one function (in a formula or macro) will be implemented so that the form of the current workbook can be shown.

## 3.1 Form editor
- The forms’ editor will be triggered through a button placed on the workbook view. Clicking that button will create a new form editor view. That view will check if the current workbook already has an associated form. If it has, the editor will present the previously inserted values. If it hasn’t, it will be shown an empty form.

- The form editor view will also provide a play button which will allow previewing the form before it has been saved on the database.

- To save the form, there will be a save button available. When the button is pressed the form is saved and closed. The function (in macros or formulas) who called the form returns.

![form](newFormBotao.png)

![form](FormEditor.png)


## 3.2 Form
- It will be through the form’s view that the actions will be executed. There will be a button available that will allow to run an action one by one (Future Implementations). For implementation reasons I couldn’t make two action running at the same time, hence why I chose to use checkboxes.

- Each form line will be composed by two labels (one for the action name and another for the action instructions) and a checkbox.

- The form’s preview can be done in two ways. The first through the editor, and the second one will be triggered by a function (macros and formulas).

![form](form_view.png)

## 3.3 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**

![User Cases](us.png)

**Domain Model**

![Domain Model](dm.png)


**System Sequence Diagrams**

**For US1**

![Analysis SD](analysis1.png)

**For US2**

![Analysis SD](analysis2.png)

# 4. Design

## 4.1. Tests

**Domain Classes**

- Form
		pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1150585.forms
		TestForm


- FormEditorController
		pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1150585.forms
		TestFormEditorController


## 4.2. Requirements Realization

**For US1**

![SD US1](design1.png)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **FormEditorWindow** is the window that shows the Forms Editor ;  
- **FormEditorController** is the *use case controller*;  
- **FormWindow** is the class that previews the end Form look;
- **Form** is form's domain class that will be associated with the current workbook

**For US2**

![SD US2](design2.png)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **FormWindow** is the class that previews the end Form look;
- **FormEditorController** is the *use case controller*;  
- **Form** is form's domain class that will be associated with the current workbook


## 4.3. Classes

- **FormEditorView** - Creates the forms editor window. Some widgets are created just in the class regarding the need to create the rows dynamically.
- **FormEditorView.ui** - XML scheme of the forms editor window.
-	**FormEditorController** - makes the connection between the forms editor window, the form’s domain class and persistency.
-	**FormView.java** -  Creates the forms preview window. It’s triggered through the editor or if a function is called.
-	**FormView.ui** - XML scheme of the forms view.
-	**Form** -  Domain. It contains every form’s row (name and action).



## 4.4. Design Patterns and Best Practices

By memory we apply/use:  
- Singleton  
- Repository  
- DTO  
- MVP

For UI Implementation we used the GWT Material Documentation   

# 5. Implementation

**For US1**

To trigger the forms editor, in the class WorkbookView I implemented the following button:
In WorkbookView Class:

		@UiField
    	MaterialIcon formButton;

In WorkbookView.ui Class:

	<m:MaterialIcon ui:field="formButton" iconType="FORMAT_LIST_BULLETED" tooltip="New Form" iconColor="BLUE" waves="DEFAULT" circle="true" grid="s1" />


**For US2**

In the forms viewer I chose to use a single button to trigger the actions’ forms. Besides the text fields there will be a checkbox to each line. That checkbox will select the function in use. You can never run two actions simultaneously. The labels and the checkboxes  will be created in the FormView considering that they need to be created dynamically.

	   <ma:window.MaterialWindow ui:field="formWindow" width="70%" title="Form">
            <m:MaterialPanel padding="5" textAlign="CENTER" height="50px">
                <m:MaterialIcon ui:field="executeForm" iconType="FORWARD" tooltip="Execute Form" iconColor="BLUE" waves="DEFAULT" circle="true" grid="s1" />
            </m:MaterialPanel>      
      </ma:window.MaterialWindow>


**Code Organization**  

The code for this sprint:  
Project **server**
- Controllers and Domain: **pt.isep.nsheets.shared.lapr4.blue.s1.lang.n1150585.forms**    



Project **NShests**
- Windows Creation: **pt.isep.nsheets.client.lapr4.blue.s1.s1150585.formsEditor**
**pt.isep.nsheets.client.lapr4.blue.s1.s1150585.forms**


# 6. Integration/Demonstration

My contribution to the team consisted essentially in sharing my knowledge regarding GWT and API material. Through sharing links like the following ones, I think I contributed for a better understanding in these two subjects.

	-https://dev.arcbees.com/gwtp/tutorials/
	-https://material.io/tools/icons/?style=baseline
	-https://gwtmaterialdesign.github.io/gwt-material-demo/2.0-SNAPSHOT/#window

The form function isn't called through the macros as asked on the problem statement. I've had some difficulties on the implementation. I've done LPROG last year, for that reason, had some difficulty understanding that part of the Use Case.

Furthermore, I tried my best to integrate my Erasmus teammates. I have also helped installing Maven and all the tools needed to develop this application.

Lastly, I highlight the fact that I was dependent on other functionalities, mainly Workbooks persistency. This has only delayed my Use Case implementation.


# 7. Final Remarks
----------------------------------------------------------------------------------------------------------------
# 8. Work Log

[Lang05.1 - Forms Editor Documentation (In Development).](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/b4c790c3aabcbec8735909b782ca6b2505c600e0)

[Lang05.1 - Partial implementation of the forms editor GUI.](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/9c53bce6654b4566565b1ad448a1bf61f3826c89)

[Lang05.1 - Create Forms UI and Controller (Partial).](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/36f92fbd3a895471a7714f215d9c9179634b2836)

[Lang 05.1 - Form Editor - UI](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/4ddc94f84a10f0b7bf2bea5008294cc62ad127ec)

[Lang 05.1 - Form Editor - Display the form by TextBox.](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/c5479372b10f39809e7c0157b1dd6937720fb350)

[Lang 05.1 - Done for now. I can't call the created form with "FORM" function because the form itself is not associated with the current workbook. Waiting for Core01.1.](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/50157dbfe181b7c8c108dfeff63aba94a572f1e2)

[Lang 05.1 - Form Editor Testes](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/24f4b58040d99873893fd13e9c8d65b76eebb5ea)

[Lang 05.1 - Final adjustments of documentation](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/f60255b0961e25897e3882b9456171a695afea8a)
