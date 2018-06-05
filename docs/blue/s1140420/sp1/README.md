**Rodrigo Soares** (s1140420) - Sprint 1 - Lang02.1
===============================

# 1. General Notes

The first 2 days (Tuesday and Wednesday) were dedicated to making sure everyone on Team BLUE was properly setup (sucks to be the Scrum Master :P). Barbara and Pietro in particular required a bit of extra care since they are not familiar with Java development at all - installing and configuring the IDE, giving them some pointers on Java, and promoting their integration into the group, as they were a bit left out during the skills module of LAPR4.

TL;DR: No time for myself until Friday.

Started exploring the app on Friday, stumbling around like a drunken sailor.


# 2. Requirements

Lang02.1 - Temporary Variables should be recognized within the scope of an input formula.

Quoting the Product Owner:
"Add support for temporary variables. The name of temporary variables must start with the "\_" sign. When a variable is referred in a formula for the first time, it is created. To set the value of a variable it must be used on the left of the assign operator (":="). Temporary variables are variables that only exist in the context of the execution of a formula. Therefore, it is possible for several formulas to use temporary variables with the same name and they will be different instances. Example: "= {\_Counter:=1; WhileDo(Eval( "A"&\_Counter)> 0; {C1:=C1+Eval("B"&\_Counter); \_Counter:=\_Counter+1 }) }” . In this example, the cell C1 will get the sum of all the values of column B in that the corresponding values in column A are greater than zero."

Instead of the previous example, which uses artefacts that will supposedly only be implemented in Sprints 2 or 3 (like "WhileDo" and "Eval", Lang01.3), let's use a simpler one:

  *"= {\_Counter:=1; \_Counter:=\_Counter+1 }*

If that block goes into a Cell, and in conjunction with the specs for Lang01.1, the result must be "2" because a "Counter" variable is set to "1" and then incremented by "1".

This behavior therefore seems to be a very basic acceptance criteria. Note, however, that the requirements state VARIABLES (plural), which means a given Formula can include declarations for multiple ones.

Also, semantically speaking a Variable can be of any of the pre-defined "NUMERIC", "LITERAL" or "DATE" types. I must confess, however, that I will be looking at it as a "NUMERIC" type, as that seems to be the more realistic goal given my limited grasp of LPROG. In other words, I will try to ensure proper behavior as a "NUMERIC" and functional tests will assume as much, and if enough time remains I will try to make it work as "LITERAL" and/or "DATE"

Dependencies:

Lang01.1 is a critical dependency, because if NSheets is not capable of processing Blocks of Instructions as a Formula, then there is really no User-side way to check if the Variables are actually storing their value.

US - As a User of the Application I want to be able to use Variables in my Blocks of Instructions

# 3. Analysis

Things that concern this Sprint:

- Understand how a Cell content is passed from the Client side over to the Core part of the app. This is already being done, so I just need to make sure I know where to capture the input String (I'm guessing it's a String) and then use parse it accordingly

Things that do NOT concern this Sprint:

- Understand how GWT works. The app is already capable of accepting input values and passing them to the Core section, so I probably won't have to dabble in the UI itself (based on GWT).  

- Understand how persistence is done. "Temporary Variables", as stated, only exist in the scope of a Formula, so they will not need to be Saved with the Workbook, which means I should ignore database/persistence concerns (Lang02.2 and/or Lang02.3 might have to, though)

## 3.1 Which classes/packages am I gonna interact with (mainly)?

I've determined that I am probably going to spend my time in the "shared" Module of NSheets - that's where the "core", "formula" and "lang" packages are, after all.

After some mind-numbing debugging, here's the notes I came up with:

- "pt.isep.nsheets.shared.core.CellImpl.storeContent()" is triggered whenever I press "ENTER" after typing something in a Cell. More importantly, the "Content" parameter IS the String to be parsed, which confirms my suspicion that the UI part is done.
- Still on "storeContent()":

private void storeContent(String content) throws FormulaCompilationException {
		// Parses formula
		Formula formula = null;
		if (content.length() > 1)
			formula = FormulaCompiler.getInstance().compile(this, content);

		// Stores content and formula
		this.content = content;
		this.formula = formula;
		updateDependencies();
	}

It starts by creating a "null" Formula and THEN, by calling "FormulaCompiler.getInstance().compile(this, content);". Judging by the already existing comment of "//Parses formula", this is the stuff right here. I'm going to have to go into the "compile()" method, because that's all it takes for Formula to have all its attributes properly set.

-Analysing the "compile()" method, it seems like it goes through a list of "compilers" that might be able to parse the formula if it makes sense to them. The only one added to that list is an "ExcelExpressionCompiler" (careful with that trademark), so let's dig into that.

- Digging into "ExcelExpressionCompiler", I see that it's already taking care of defining and instantiating a basic Excel language.

## 3.2 Grammar and Language  

- Managed to find the Grammar "formula" for this "Excel Language" in "Other Sources", specifically "pt.isep.nsheets.shared.core.formula.compiler". Several definitions for "expression", "assignment", "comparison", but nothing for variables. I'll have to add rules for them here.

- Almost everything in this Grammar has a 1-to-1 match with "core" Java classes, so I'm probably gonna have to create one for "Variable", and maybe one for "VariableList" to ensure cases where someone inputs more than 1 Variable (I could do it as "List<Variable>", but I presume this will be crucial for further Sprints, so promoting it to Class)

- With Pedro Tedim's help (1091234), I've been able to see in IntelliJ ANTLR plugin (I use NetBeans, FML) that ANTLR only recognizes a Variable IF it is made part of the "REFERENCE" rule in the Grammar. We thought it could be an Atom, but not so. It makes sense, given that a VARIABLE should behave just like a CELL_REF (e.g. "A1" or "B2"): they're both references.

- There is indeed a "CellReference" class in "pt.isep.nsheets.shared.core.formula.lang", which implements "Reference". I'm probably gonna have to create a "VariableReference" in similar manner.

- Here are the proposed changes to "Formula.g4":

reference
	:	CELL_REF
		( ( COLON ) CELL_REF )?
                | VARIABLE
	;

  VARIABLE
          : UND LETTER ( NUMBER | LETTER) *
          ;

UND             : '\_';

## 3.3 Server and RPC

. No changes here, this only affects the "core" in "NShared"

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

*Insert here a log of you daily work. This is in essence the log of your daily work. It should reference your commits as much as possible.*

Commits:

[Started new example documentation for John Doe Core00.0.](https://bitbucket.org/lei-isep/nsheets/commits/7d9ae99772cce77627454021ea814867a8ef3223)

[Started UI code for Core00.0](https://bitbucket.org/lei-isep/nsheets/commits/88cd76f001939c0fd49ac124a258a3d6ee3dc087) This commit contains some experimental code for studying how the application works. Since it was done in a feature branch no harm to others.  

[Core00.0 Added Analysis SD](https://bitbucket.org/lei-isep/nsheets/commits/e98286e5dbaf11bdd363d0228008acd86f4155c1)

[Core00.0 - Added user stories](https://bitbucket.org/lei-isep/nsheets/commits/5238a88d01a46b4dd10e3d99c8977ac3950c4ea2)

[Core00.0 - Added analysis how GWT and the application work](https://bitbucket.org/lei-isep/nsheets/commits/cbd2bf4669e9b781657ad909aaa27a425c5cbdfd)

[Core00.0 - Analysis: explain GWTP and MVP](https://bitbucket.org/lei-isep/nsheets/commits/0c3e56339fbd7fc8a421770ce041dc29b2b1af40)

[Core00.0 - Analysis: Explain Server and the RPC mechanism](https://bitbucket.org/lei-isep/nsheets/commits/a11f952fd69f03d45cbb804bbad98f7feabfe30e)

[Core00.0 Worklog update](https://bitbucket.org/lei-isep/nsheets/commits/24c168ba5a7da770461fbebe566414ab98c90338)

[Core00.0 Analysis: update to the analysis sequence diagram with vision for integrating database/JPA.](https://bitbucket.org/lei-isep/nsheets/commits/30fbbeb02fa4a705eef213f30e0f7cd430550de9)

[Core00.0 - Analysis: Added Use Cases, Domain Model and more detailed "Analysis" Sequence Diagrams.](https://bitbucket.org/lei-isep/nsheets/commits/ec2e2a5ad8b9a7bf1cfa49cf5d464811e365f7b2)

[Updated some meta-descriptions in the example readme-md of Core00.0.](https://bitbucket.org/lei-isep/nsheets/commits/e2ad8d831bc730181e07af37651a814d245fe3e9)

[Core00.0: Analysis - Added system sequence diagrams / Design - SD moved to design section of documentation.](https://bitbucket.org/lei-isep/nsheets/commits/2e7873a1c56ab2c7844e19919fe13156edfcc332)

[Core00.0: Design/Tests- First draft for tests.](https://bitbucket.org/lei-isep/nsheets/commits/42411adda325fbab58c7d770ddc8fbe2b962d8aa)

[Core00.0 - Design/Tests: Added test for domain class WorkbookDescription.](https://bitbucket.org/lei-isep/nsheets/commits/fc5831bc452d4b69c0c9f568849e7aeddae329d1)

[Core00.0: Design/Implementation - Added design/implementation for list WorkbookDescriptions. Updated the documentation.](https://bitbucket.org/lei-isep/nsheets/commits/cd7ef6dec31a7b7b95b01b16f4cc82fd8c9b0d66)

[Core00.0 - Test/Design/Implementation: Added first draft for AddWorkbookDescription.](https://bitbucket.org/lei-isep/nsheets/commits/0fee8bbc971593596e23b5e4b5132f25f575e93e)

[Core00.0 - Tests/Design/Implementation: The server code is completed.](https://bitbucket.org/lei-isep/nsheets/commits/414db8752df3ba7af3233470408486de57afda11)

[Core00.0: Design - Updated SD for US add workbook description.](https://bitbucket.org/lei-isep/nsheets/commits/c5207e99c74b82209f46a123a93b9d0498efbe4e)

[Core00.0: Implementation - Added documentation about implementation of US2 (Add Workbook Description)](https://bitbucket.org/lei-isep/nsheets/commits/323b1199ba277f063502e6e7bc9b13ccb59a2147)

[Core00.0: Implementation - Added documentation.](https://bitbucket.org/lei-isep/nsheets/commits/48167bcfcc8c4bdd26f3352d16e41ca9eab072c1)

[Core00.0: Implementation: Updated Presenter implementation for add new workbook description.](https://bitbucket.org/lei-isep/nsheets/commits/7fb703f3718178e6ffde4a49d0b959064585f209)
