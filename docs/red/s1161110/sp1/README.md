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

*In this section you should present the design solution for the requirements of this sprint.*
In terms of design there is only the need to add new methods on class SpreadsheetImpl for cell sorting with diferent configurations


## 4.1. Tests

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

Regarding tests we try to follow an approach inspired by test driven development. However it is not realistic to apply it for all the application (for instance for the UI part). Therefore we focus on the domain classes and also on the services provided by the server.

**Domain classes**

For the Domain classes i will have to test the sorting methods added to class that represents the entity **Spreadsheet**. This entity will have methods that, for the moment, will be based on the class **SpreadsheetImpl**:

  - sortAscendingNumber(Cell matrix[][])
  - sortDescendingNumber(Cell matrix[][])
  - sortAscendingText(Cell matrix[][])
  - sortDescendingText(Cell matrix[][])
  - sortAscendingDate(Cell matrix[][])
  - sortDescendingDate(Cell matrix[][])

**Test1:** I should ensure that are the cells are of the same data type(number(float)). Ascending case

	@Test(expected = IllegalArgumentException.class)
		public void ensureOnlyNumberIsAllowedOnAscending {
		System.out.println("ensureOnlyNumberIsAllowedOnAscending");
		Cell[][] instance = spreadsheet.sortAscendingNumber(matrix);
	}

**Test2:** I should ensure that are the cells are of the same data type(text(string)). Ascending case

	@Test(expected = IllegalArgumentException.class)
		public void ensureOnlyTextIsAllowedOnAscending {
		System.out.println("ensureOnlyTextIsAllowedOnAscending");
		Cell[][] instance = spreadsheet.sortAscendingText(matrix);
	}

**Test3:** I should ensure that are the cells are of the same data type(date). Ascending case

  	@Test(expected = IllegalArgumentException.class)
  		public void ensureOnlyDateIsAllowedOnAscending {
  		System.out.println("ensureOnlyDateIsAllowedOnAscending");
  		Cell[][] instance = spreadsheet.sortAscendingDate(matrix);
  	}

**Test4:** I should ensure that are the cells are of the same data type(number(float)). Descending case

    @Test(expected = IllegalArgumentException.class)
    	public void ensureOnlyNumberIsAllowedOnAscending {
    	System.out.println("ensureOnlyNumberIsAllowedOnAscending");
    	Cell[][] instance = spreadsheet.sortAscendingNumber(matrix);
    }

**Test5:** I should ensure that are the cells are of the same data type(text(string)). Descending case

    @Test(expected = IllegalArgumentException.class)
    	public void ensureOnlyTextIsAllowedOnDescending {
    	System.out.println("ensureOnlyTextIsAllowedOnDescending");
    	Cell[][] instance = spreadsheet.sortDescendingText(matrix);
    }

**Test6:** I should ensure that are the cells are of the same data type(date). Descending case

      @Test(expected = IllegalArgumentException.class)
      	public void ensureOnlyDateIsAllowedOnDescending {
      	System.out.println("ensureOnlyDateIsAllowedOnDescending");
      	Cell[][] instance = spreadsheet.sortDescendingDate(matrix);
      }



**Services/Controllers**

For the services the application already has a service specified in the interface **WorkbooksService**:

	@RemoteServiceRelativePath("workbooksService")
	public interface WorkbooksService extends RemoteService {
		ArrayList<WorkbookDescriptionDTO> getWorkbooks();
	}

This method seems to be sufficient for supporting US1 but not US2.

For US2 we need a method that can be used to create a new WorkbookDescription given a WorkbookDescriptionDTO.

The proposal is:

	@RemoteServiceRelativePath("workbooksService")
	public interface WorkbooksService extends RemoteService {
		ArrayList<WorkbookDescriptionDTO> getWorkbooks();
		WorkbookDescriptionDTO addWorkbookDescription(WorkbookDescriptionDTO wdDto) throws DataException;
	}

Tests:  
- The tests on the controllers require the presence of a database.  
- We will use the database in memory (H2).  
- We will have a *controller* from adding new WorkbookDescriptions. This controller will be invoked by the GWT RPC service.
- We will have a *controller* from listing WorkbookDescriptions. This controller will be invoked by the GWT RPC service.

Controller **AddWorkbookDescriptionController**

**Test:** Verify the normal creation of an WorkbookDescription.  

	@Test
	public void testNormalBehaviour() throws Exception {
		System.out.println("testNormalBehaviour");
		final String name = "Workbook1";
		final String description = "Description for Workbook1";
		final WorkbookDescription expected = new WorkbookDescription(name, description);
		AddWorkbookDescriptionController ctrl = new AddWorkbookDescriptionController();
		WorkbookDescription result = ctrl.addWorkbookDescription(expected.toDTO());
		assertTrue("the added WorkbookDescription does not have the same data as input", expected.sameAs(result));
	}

Controller **ListWorkbookDescriptionController**

Note: We will be using the annotation @FixMethodOrder(MethodSorters.NAME_ASCENDING) to ensure the test methods are executed in order. This is useful since the memory database will have state changing between tests.

**Test:** At the beginning of the tests the memory database should be empty, so listWorkbookDiscriptions should return an empty set.

	   @Test
	   public void testAensureGetWorkbooksEmpty() {
		   System.out.println("testAensureGetWorkbooksEmpty");
		   ListWorkbookDescriptionController ctrl=new ListWorkbookDescriptionController();
		   Iterable<WorkbookDescription> wbs=ctrl.listWorkbookDescriptions();
		   assertTrue("the list of WorkbookDescriptions is not empty", !wbs.iterator().hasNext());
	   }

**Test:** If a WorkbookDescription is created it should be present in a following invocation of getWorkbooks().

		@Test
		public void testBtestDatabaseInsertion() throws Exception {
			System.out.println("testBtestDatabaseInsertion");
			final String name = "Workbook1";
			final String description = "Description for Workbook1";
			final WorkbookDescription expected = new WorkbookDescription(name, description);
			AddWorkbookDescriptionController ctrlAdd = new AddWorkbookDescriptionController();
			WorkbookDescription result = ctrlAdd.addWorkbookDescription(expected.toDTO());
			ListWorkbookDescriptionController ctrlList=new ListWorkbookDescriptionController();
			Iterable<WorkbookDescription> wbs=ctrlList.listWorkbookDescriptions();
			assertTrue("the added WorkbookDescription is not in the database", wbs.iterator().hasNext());
		}

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

	@UiField
	MaterialButton newWorkbookButton;

We must now add the code that invokes the server to add a new workbook description when the user clicks in the button. This is an event. To implement this behavior we could use GWT Events such as the SetPageTitleEvent already used in the application. These are special type of events that GWT manages and are available to all pages in the application.

We chose to provide our click event globally but to simple use the click event handler of the button and connect it to a method in the HomePresenter.

Since Presenters should only depend on a View interface we added a new method to the HomePresenter.MyView:

	interface MyView extends View {
		void setContents(ArrayList<WorkbookDescriptionDTO> contents);
		void addClickHandler(ClickHandler ch);
	}

Then, we implemented the *addClickHandler* in the HomeView class and call this method in the constructor of the HomePresenter. In the constructor our handler class the server method that adds a new workbook description.   

**Code Organization**  

We followed the recommended organization for packages:  

The code for this sprint:  
Project **server**    


Project **shared**  


Project **NShests**


# 6. Integration/Demonstration

*In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)*

# 7. Final Remarks

*In this section present your views regarding alternatives, extra work and future work on the issue.*

Some Questions/Issues identified during the work in this feature increment:

1. The method getWorkbooks in the WorkbooksService returns an ArrayList. Maybe we should not bind the result to a specific collection implementation.

# 8. Work Log



Commits:

[Requirements Core08.1]()
[Analysis Core08.1]()
[Design Core08.1]()
[Tests (documentation) Core08.1]()
[Code Implementation Core08.1]()
