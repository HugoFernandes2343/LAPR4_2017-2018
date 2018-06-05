**Hugo Carvalho** (s1161569) - Sprint 1 - Core03.1
===============================

# 1. General Notes

# 2. Requirements

Core03.1 - Sort a range of cells. A range of cells is a rectangular area delimited by an upper left corner and a lower right corner. The sorting is based on one or more columns of the range. It should be possible to select the order: ascending or descending. Interaction with the user should be based on a popup menu. It should be possible to sort data of the following types: numeric, text or date.

Proposal:

US - As a User of the Application I want to be able to sort a range of cells so that the information on the selected cells becomes more organized. I want to choose both the upper left cell and lower right cell. I also want the application to validate the type of data it is handling and the type of ordering(ascending or descending).

# 3. Analysis


For this feature increment, since it is the first one to be developed regarding sort and dependencies in cells i need to:  

- Enable a button(MaterialButton) that will execute the sorting operation

- Enable two text fields(MaterialTextBox) where the user will choose the upper left cell and lower right cell

- Enable two configuration selection boxes (MaterialListValueBox) that will be used by the user to specify both data type(Number, Text or Date) and sort type(Ascending or Descending)

- After clicking the sort button find in the active spreadsheet the addresses of the cells chosen by the user

- Iterate all the spreadsheet´s "cell grid" in order to find all the cells between the selected range

- Order the obtained cells by updating their values according to the sorting type while also validating the type of data inside the cell.

- Update previous cells with the sorted values

- Update the UI with the new result grid

Note: For the purpose of keeping the user aware of the sorting operation a MaterialLoader will be used to block the browser until the operation is completed


## 3.1 Analysis Diagrams

![Use Cases](us.png)

- **Use Case**. Since the use case has a one-to-one correspondence with the User Story i do not add more detailed use case description in this section. I find that this use case is very simple in terms of concept and will add more specifications at a later stage.

**Domain Model (for this feature increment)**

- Since i found no specific requirements in terms of domain, i follow the Structure of the existing entities provided by Jonh Doe.

**System Sequence Diagrams**

![Analysis](analysis.png)

# 4. Design

In terms of design there is only the need to add new methods on class SpreadsheetImpl for cell sorting with diferent configurations and the necessary buttons on the user interface.


## 4.1. Tests

  Regarding tests i try to follow an approach inspired by test driven development. However it is not realistic to apply it for all the application (for instance for the UI part) but due to the problems encountered with the gwt framework, the tests will not be implemented by the time of delivery but they have been design to test all the invariants of this use case. Since the main focus of the use case is on updating the actual spreadsheet according to the user´s instructions and this spreadsheet is already located on the UI i have found no need for the implementation of both the controller and service patterns.

**Domain classes**

  For the Domain classes i will have to test the sorting method added to the class that represents the entity **Spreadsheet**. This entity will have methods that, for the moment, will be based on the class **SpreadsheetImpl** which implements the **Spreadsheet** interface:

      - public void sortCells(String address1, String address2, String dataType, String sortType)


**Test1:** I should ensure that are the cells are of the same data type(number(float)). Ascending case

	@Test(expected = IllegalValueTypeException.class)
		public void ensureOnlyNumberIsAllowedOnAscending {
		System.out.println("ensureOnlyNumberIsAllowedOnAscending");
		spreadsheet.sortCells(add1,add2,"Number","Ascending");
	}

**Test2:** I should ensure that are the cells are of the same data type(text(string)). Ascending case

	@Test(expected = IllegalValueTypeException.class)
		public void ensureOnlyTextIsAllowedOnAscending {
		System.out.println("ensureOnlyTextIsAllowedOnAscending");
		spreadsheet.sortCells(add1,add2,"Text","Ascending");
	}

**Test3:** I should ensure that are the cells are of the same data type(date). Ascending case

  	@Test(expected = IllegalValueTypeException.class)
  		public void ensureOnlyDateIsAllowedOnAscending {
  		System.out.println("ensureOnlyDateIsAllowedOnAscending");
  		spreadsheet.sortCells(add1,add2,"Date","Ascending");
  	}

**Test4:** I should ensure that are the cells are of the same data type(number(float)). Descending case

    @Test(expected = IllegalValueTypeException.class)
    	public void ensureOnlyNumberIsAllowedOnAscending {
    	System.out.println("ensureOnlyNumberIsAllowedOnAscending");
    	spreadsheet.sortCells(add1,add2,"Number","Descending");
    }

**Test5:** I should ensure that are the cells are of the same data type(text(string)). Descending case

    @Test(expected = IllegalValueTypeException.class)
    	public void ensureOnlyTextIsAllowedOnDescending {
    	System.out.println("ensureOnlyTextIsAllowedOnDescending");
    	spreadsheet.sortCells(add1,add2,"Text","Descending");
    }

**Test6:** I should ensure that are the cells are of the same data type(date). Descending case

      @Test(expected = IllegalValueTypeException.class)
      	public void ensureOnlyDateIsAllowedOnDescending {
      	System.out.println("ensureOnlyDateIsAllowedOnDescending");
      	spreadsheet.sortCells(add1,add2,"Date","Descending");
      }

**Test7...Test12:** The remaining tests reflect the sort output expectations being one for each method data type and sort type being like the previous error check methods a total of 6.

**Services/Controllers:** As refered previously in the beginning of this section there are no controllers or services to be tested.


**Test Coverage:** Due to problems regarding the use of the GWT framework it is not possible to quantify the test coverage.  

## 4.2. Requirements Realization


I envision a scenario like the following for realizing the use case for this feature increment.


![SD](design.png)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons, details such as the private sub-methods of the sortCells method and the interaction with the different GWT Material objects are not depicted in this diagram.   
- **SpreadsheetImpl** extends **Spreadsheet** making it the information expert regarding the existing cells and correponding addresses on the cell grid;  
- **CellImpl** extends **Cell** making it the information expert regarding contents of a cell;
- **Address** is the information expert regarding the positioning of a cell within the cell grid;  
- **WorkBookView** called from the **WorkBookPresenter** will be the MVP in charge of both asking the user for the necessary data and show the results of the operation;


## 4.3. Classes

All the needed classes for the use case are already implemented. The only things that have been added are the new ui elements on **WorkBookView** and the sortCells method of interface **Spreadsheet** implemented on the class **SpreadsheetImpl**.

## 4.4. Design Patterns and Best Practices


By memory I apply/use:  
- Information Expert
- MVP


# 5. Implementation


**UI: Button for sorting the active spreadsheet**

For this concern i decided to use a Material Widget called MaterialButton. This is the button that will be used to activate the sorting process.  

I updated the WorkBookView.ui.xml accordingly and declare the element with a the tags **ui:field="sortButton" text="Sort" waves="LIGHT" textColor="WHITE" iconType="POLYMER"**. In the corresponding class View (i.e., WorkBookView) i bind that button to the corresponding widget class: 	

	 @UiField
	 MaterialButton sortButton;


**UI: Text box for choosing the required cells**

For this concern i decided to use a Material Widget called MaterialTextBox. These are the two text fiels in which the user will writte the reference of the upper left cell and lower right cell.  

I updated the WorkBookView.ui.xml accordingly and declare the elements with the tags **ui:field="upperCellInfo" label="Upper left cell"** and **ui:field="lowerCellInfo" label="Lower right cell"**. In the corresponding class View (i.e., WorkBookView) i bind these text boxes to the corresponding widget class: 	

      @UiField
      MaterialTextBox upperCellInfo;

      @UiField
      MaterialTextBox lowerCellInfo;


**UI: List box for choosing the required sort parameters**

For this concern i decided to use a Material Widget called MaterialListValueBox. These are the two fiels in which the user will one of the possible configurations regarding the data type to sort and the type of sort.  

I updated the WorkBookView.ui.xml accordingly and declare the elements with the tags **ui:field="dataTypeBox" placeholder="choose data type"** and **ui:field="sortingTypeBox" placeholder="choose sorting type"**. In the corresponding class View (i.e., WorkBookView) i bind these list value boxes to the corresponding widget class and add the different values each box might take: 	

      @UiField
      MaterialListValueBox<String> dataTypeBox;
          dataTypeBox.add("Number");
          dataTypeBox.add("Text");
          dataTypeBox.add("Date");

      @UiField
      MaterialListValueBox<String> sortingTypeBox;
          sortingTypeBox.add("Ascending");
          sortingTypeBox.add("Descending");


I must now add the code that invokes the spreadsheet to find all the cells between the two specified ones by the user and sort those cells according to the user specifications. Once sorted the spreadsheet must update the content of the previous selected cells. The event that provides this function is the new sort button. For the porpuses of keeping the user aware of the operation in case it takes some time Material Widget called MaterialLoader is used to block the ui until the operation is completed with a load icon.

      // Show Loader
      MaterialLoader.loading(true);
      // Remove loader
      MaterialLoader.loading(false);


**Sort methods**

Since this process of ordering cells has many different workflows, i decided to divide it into multiple smaller methods in order to make it more easy to understand

    - public void sortCells(String address1, String address2, String dataType, String sortType)
      - private Address findAddress(String reference)
      - private void sortDescending(SortedSet<Cell> sort)
      - private void sortAscending(SortedSet<Cell> sort)
      - private void updateCells(Cell list[])


**sortCells:** This is the main method that will search the necessary addresses and decide which sort method to use according to both the data type and sorting type.

    public void sortCells(String address1, String address2, String dataType, String sortType) {
      Address add1=findAddress(address1);
      Address add2=findAddress(address2);
      if(add1==null || add2==null){
        throw new UnsupportedOperationException();
      }
      SortedSet<Cell> sort=getCells(add1,add2);

      if(sortType.equals("Ascending")){
        sortAscending(sort);
      }
      if(sortType.equals("Descending")){
        sortDescending(sort);
      }
    }



**findAddress:** Iterates all the cells in order to find an  address matching the reference provided by the user. For ease of use for the user the cell reference will not be case sensitive.

    public Address findAddress(String reference) {
      for(Address add:cells.keySet()){
  		if(add.toString().equalsIgnoreCase(reference)){
  			return add;
  		}
  	}
  	return null;
    }

**updateCells:** Updates the cells on the given addresses with the new values.

    private void updateCells(Cell list[]){
	    for(int i=0;i<list.length;i++){
	        cells.put(list[i].getAddress(),list[i]);
        }
    }

**Code Organization**  

I followed the recommended organization for packages:  
- Code should be added (when possible) inside packages that identify the group, sprint, functional area and author;
- In this case since i do not have to add new packages since i use existing classes and files;

The code for this sprint:  

Project **shared**
- Updated the interface: **pt.isep.nsheets.shared.core.Spreadsheet**: This interface as the header of the new sortCells method
- Updated the class: **pt.isep.nsheets.shared.core.SpreadsheetImpl**: This class as the new sortCells method along with all the dependent private methods   

Project **NShests**
- Updated the classe: **pt.isep.nsheets.client.application.workbook.WorkbookView**: Added new ui fields for the sorting process  
- Updated the file: **pt.isep.nsheets.client.application.workbook.WorkbookView.ui.xml**  


# 6. Integration/Demonstration

Since the spreadsheet presentation on the ui was already developed by Jonh Doe i used his implementation and added the necessary instructions to refresh the presentation of the spreadsheet once the sort was completed. Saddly due to problems regarding the GWT framework it is not possible to test the sort methods which may be also providing problems due to certain casts of data(i.e DateFormat) that are not possible to execute. This issue may lead to the change of the classes developed by Jonh Doe (class **Value** to be precise). wITH

# 7. Final Remarks

I have encountered many issues regarding gwt interactions with the implemented java classes. One of this cases is the SpreadsheetImpl located on the shared package. Because it is a class that will also be converted into javaScript, the normal application of jUnit tests is unavailable. For testing porpuses it is needed to implement a gwt testcase but it his asking for a module that i connot figure on my own. I looked on the webpages like stackOverflow and http://www.gwtproject.org/doc/latest/tutorial/JUnit.html and i did not find any reference to a [path of the class].gwt.xml that apparently is needed for the execution of the GWTTestCase. Here are the html with the results of the test run and pictures of the created test class. Also as a note the program does not recognize the shared package as a possible test holder. It only allows to build tests either on server or nsheets packages.

[TestResults](TestResults-SpreadsheetImplTest_testcheckSort.html)

![SpreadsheetImplTest](SpreadsheetImplTest.png)

Due to this issue and others regarding parse of different data types(i.e. DateFormat), i cannot assure that the sort method works. It runs in the application without crashing it but the values are not altered. Since i cannot test the method and according to firefox depuration tool the program executes the method as intended i cannot say if the problem is in the refreshing of the table or in the update of the cells on the spreadsheet.

# 8. Work Log

*Insert here a log of you daily work. This is in essence the log of your daily work. It should reference your commits as much as possible.*

Commits:
