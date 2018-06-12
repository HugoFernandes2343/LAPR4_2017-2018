**Rodrigo Soares** (s1140420) - Sprint 2 - Core04.1
===============================

# 1. General Notes

Pedro Tedim and Norberto Sousa detected the need to rework some core classes (mostly related to Workbooks)


# 2. Requirements

Core04.1 - Basic Chart Wizard

Quoting the Product Owner:
	"The application should have a new menu option to launch a wizard to help the user create a bar chart. The wizard should have 2 steps. In the first step, the user should input the name of the chart and the range of cells that contains the data for the plot of the chart. The user should also select if the data is in the rows or columns of the range and if the first row or the first column are to be considered labels. In the second step the wizard should display a preview of the chart. The wizard should allow the user to move between steps 1 and 2. If the wizard is confirmed the cell in the left upper corner of the range should have a mark (e.g., icon) that indicates that the cell has a chart associated with it. A popup menu option in the cell should provide access to the chart.""

## 2.1 What does the Client want, exactly?

 After a quick 5 minute exchange with the Client on 07-06-2018, I showed him the following demos in Excel:

 ![Lines example](Example_lines.png)

 ![Columns example](Example_columns.png)

 He said they were "pretty cool", so they will serve as a common ground for the end goal.

Dependencies:

The major dependency will be detecting the current Workbook and its Spreadsheet.

User Story - As a User of the Application I want to be able to generate bar charts based on a range of Cells, to get a visual representation of data

# 3. Analysis

## 3.0 Is there anything online to make my life easier?

 No sense in reinventing the wheel when I'm way out of my depth, and I'm betting someone already had a crack at this. Lurking online, I came across some WONDERFUL examples of bar charts implementations, with source code included:

  http://gwt-charts.appspot.com/#bar

	https://github.com/GwtMaterialDesign/gwt-material-demo/blob/master/src/main/java/gwt/material/design/demo/client/ui/charts/MaterialBarChart.ui.xml

	https://github.com/GwtMaterialDesign/gwt-material-demo/blob/master/src/main/java/gwt/material/design/demo/client/ui/charts/MaterialBarChart.java

All I need is to download "GWT Charts 0.9.10", an unofficial API for all kinds of charts. It's on Maven, here:
	https://mvnrepository.com/artifact/com.googlecode.gwt-charts/gwt-charts/0.9.10

Just have to alter the POM.xml to include this Dependency:

<!-- https://mvnrepository.com/artifact/com.googlecode.gwt-charts/gwt-charts -->
<dependency>
    <groupId>com.googlecode.gwt-charts</groupId>
    <artifactId>gwt-charts</artifactId>
    <version>0.9.10</version>
</dependency>


## 3.1 Which classes/packages am I gonna interact with (mainly)?

 Going to create a new package for my stuff: "pt.isep.nsheets.client.lapr4.blue.s2.s1140420.basicChartWizard"

## 3.1.0. Is there anything from previous Sprints I can reuse?

- Hugo Carvalho did some interesting work in Sprint 1 in "Core03.1 - Sort Cells" related to selecting a range of Cells. As stated in his docs, "shared.core.SpreadsheetImpl" contains the methods "findReference()" (which finds a Cell's Address), so I'll use that. He also did some widgets to allow the user to select a range of cells, so I'll use that too.

## 3.1.1. Shared

-

## 3.1.2 Client

- Majority of the work will be developed here, in terms of creating a new Window to act as the Wizard.

## 3.1.3 Server and RPC

. No changes here, I am not going to concern myself with persistence for now.

## 3.4 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**

- **Use Cases**. There is only one Use-Case, and that is typing in a Formula with Variables

**Domain Model (for this feature increment)**

![Domain Model](Lang02.1_CD.png)

**System Sequence Diagrams**

![SSD](Lang02.1_SSD.svg)

# 4. Design

. "CellImpl" reaches the "ExcelExpressionCompiler" after going through the more general "FormulaCompiler". This class goes through all available compilers ("Excel" being the only one available by default, additional ones will need to be added for the JavaScript and VisualBasic "inspired" languages).

. I have opted to create a new method "visitVariableReference()".

. Created "VariableReference", which is to "Variable" the same as "CellReference" is to "Cell": a kind-of "pointer" that includes a "Variable" in it.

. Altered "CellImpl.storeContent()" to copy Variable data to the FormulaCompiler

![SD](Lang02.1_SD_long.png)

## 4.1. Tests

I have used the built-in "Console.java" class in "NShared" to test functionality as I developed it.

The lack of unit-testing is the biggest flaw of my work this week and the one I am the least proud of, because my less-than-standard aptitude at LPROG means I am not really sure how to test my methods (took me a LONG time to even discern what the logical flow would be)

## 4.4. Design Patterns and Best Practices


In my opinion, the application has a potential Design issue:

public class Formula{

    //The Cell this Formula belongs to
    private Cell cell;

}

public class Cell{

    //The Formula in this Cell
    private Formula formula;

}

This reflexive association does not seem like a good practice, as most associations should be single-way whenever possible. However, I am not Mr. Einar Pehrson, so I can't imagine the issues he faced 13 years ago when building this from scratch, and this might be the best solution.
It amuses me to no end, however, to write "Cell.getFormula().getCell().getFormula().getCell()(...)" until the heat death of the Universe.

One Design flaw that I DO know is a bad practice that was introduced by me is the use of side-effects in "CellImpl.storeContent()":

private void storeContent(String content) throws FormulaCompilationException {
		// Parses formula
		Formula formula = null;

		if (content.length() > 1)
			formula = FormulaCompiler.getInstance().compile(this, content);
}

When the "compile()" method executes, it internally sets the "VariableList" in "this" Cell, and I wish I found a way to make that more transparent. The problem is that as you dig deeper into the call-stack, most methods keep a hold of that "Cell" reference, so that is the best place to store variables.

Other than the obivous "Visitor" pattern, I cannot think of any specific Patterns I might have used - no DTO for UI/UX, no Repository for persistence.


# 5. Implementation

**Code Organization**  

As stated previously, all development was done only on the "NShared" module - User Input and Persistence are not my concerns for this Sprint, so no need to deal with Client or Server.

I followed the recommended organization for packages:  
- Code should be added (when possible) inside packages that identify the group, sprint, functional area and author;
- I used **pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables** for NEW classes, and left a comment with my student number "1140420" in other classes I have made modifications to.

Here are the NEW classes:
. Variable;
. VariableReference - container for "Variable", works similarly to "CellReference";
. VariableList - contains a HashMap that maps a Variable's "name" to the actual "Variable", so you can know if a Variable already exists or not;

Here is a brief summary of changed classes:

. AbstractVisitor - created "visitVariableReference()";
. FormulaEvalVisitor.visitReference() - condition to detect "VARIABLE" tokens included;
. ExpressionVisitor - created "visitVariableReference()"";
. ExpressionBuilder - implements "visitVariableReference()";
. CellImpl.storeContent()
. CellImpl.addVariable() - adds a Variable if new, BUT returns it without adding if not.
. Formula - added a field of "VariableList"

# 6. Integration/Demonstration

*In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)*

# 7. Final Remarks and Tips for the next guy

. Big shoutout to Pedro Tedim (1091234) for helping me out with the Grammar. I came up with my rules, but having his input was a big confidence booster.

. I am positive the Grammar "Formula.g4" is correct, but an alternative I would explore would be to create a new rule for "variablereference" instead of including "VARIABLE" in "reference".

. "pt.isep.nsheets.shared.core.formula.util.ReferenceFetcher" is a class I looked at pretty late in development. I don't think there's anything to change there, but trying out an implementation of the "visitVariableReference()" method here would be my next course of action.

# 8. Work Log

I never drank an ounce of alcohol in my life, but I must have been drunk when I mentioned "[Lang03.1]" in my commits INSTEAD OF "[Lang02.1]".

I also forgot, up until the last 24h or so, to include "[fixing issue #52]" to link them to my Bitbucket Issue. A mistake that I will not be making for Sprint 2...

Important Commits:

[Updated UC distribution for Team BLUE and created default "sp1" folders and markdown files for my team Lang02.1.](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/d504dffbca27ea4db63fefb89c1243d5da39735b)

[Wrote Requirements and Analysis Lang02.1](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/b039d15a5a03c8556949bc6ff30a8d03788af3fd)

[Lang02.1 SSD](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/7d1385db958d5c294d401374297dc787f171ff55)

[Lang02.1 Introducing Variable](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/1803d0d0c1cf554a3bed2f2ee5b5fa90b7c4e6af)

[Lang02.1 - Created Variable and VariableList](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/371695642805c1349f365c088325416fec1e94cd)

[Lang02.1 - Some further insight into CellReference allows me to conclude "VariableReference" will be necessary](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/8fe729d63868259c089f6e3d2c7eff2a62c683f6)

[Lang02.1 - Added VariableList to Formula ](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/b3e1dcfef05625af98a0ff5529e5d8fa2118e041)

[Lang02.1 - Added VariableReference, which will behave similarly as a CellReference](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/ab661ec45fd478dc63b2187d8abfb27c5f34e7ed)

[Lang02.1 - Added "visitVariableReference()" to Visitor classes. I was thinking of using the existing "visitReference()", but it seems to me like it's best to split this](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/238957cc7ab43510b1aab6ee7714152346cd5d82)

[Lang02.1 - Changed VariableReference to Expression, to avoid implementing some methods that seem unnecessary for now. Also want to avoid the "visits" to use those methods (like "getCells()") because if they do, they'd throw exceptions](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/ae1d1a03a75235cbcd44aea8669bd12c8486bedc)

[Lang02.1 - Changed Assignment operator class. Pedro Tedim suspects an "instance of" is necessary to recognize a "VariableReference". The man is clearly more comfortable with this grammar mumbo-jumbo than I am. Plus, his Lang01.1 UC seems to be working.](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/8f0cabad541517a47ae55011b7d1a642033ede08)

[Lang02.1 - Editing FormulaEvalVisitor, "visitReference()". I've put "VARIABLE" in the "reference" rule in the Grammar, and this class seems to have "visits" for every single rule, so this is my best shot. Using the "Token" bullshit that I found in the "visitLiteral()" method](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/c820ce9aad519ee86116b130d58e53b0356440e5)

[Lang02.1 - Reworked VariableReference to have a Cell instead of a Formula: the processing steps have several references to "Cell", so it's basically saving VariableReferences in Cell 1st, and only AFTER the "compile()" method is done is it possible to assign Variables to a Formula](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/f7deab7db4fd65b6651fe62f1e6b731112658507)

[Lang02.1 - Reworked README.md, SSD, SD and CD to better reflect my work](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/2536ea335f40ebb29aca837ad0663e5cdf7d2657)
