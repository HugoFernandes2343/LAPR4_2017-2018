**Paulo Magalhães** (s1160570) - Sprint 2 - LANG01.0
===============================

# 1. General Notes



# 2. Requirements

Lang01.2 - Monetary Language

Add a new formulas language (currently the application only has Excel formulas that begin with the character "="). The new language should do only calculations related to currencies. The character that begins the formula should be "#". The formula should only accept the addition, subtraction, multiplication and division operators. Operands are monetary values in which it is necessary to provide the currency (e.g., 10.21e, 1.32£ or 0.20$). All expressions are required to be contained within brackets with the currency prefix in which we want the result, e.g., "#euro{10.32$ + 12.89£}" or "#dollar{ 10.32$ + 12.89£}" or "#pound{10.32$ + 12.89£}". For the user to use this language instead of the "regular" Excel language it should start the formula by the character "#" instead of the "=" character. The application should also provide a way for setting exchange rates (by means of a configuration). The implementation should avoid the use of numbers in floating point representation (e.g., float, double) in order to avoid precision problems.

Proposal:

**US1** - Update grammar Formula.g4 to include new rules and operators:
Proposal:

**US1** - Update grammar Formula.g4 to include new rules and operators:

RULES:

* **assignment** (reference ASSIGN comparison)
* **block**
* **loopfor**
* **atom** (added loopfor, block and assignment)

OPERATORS:

* **FOR** ('FOR')
* **LCBRA** ('{')
* **RCBRA** ('}')
* **ASSIGN** (':=')

**US2** - Understand how the application works when inserting a new formula on the worksheet:
  * Is it supposed to generate visitor and listener code automatically?

# 3. Analysis
## 3.1 GRAMMAR ANALYSIS

1 - A block must be delimited by curly braces and its instructions must be separated by ";". The instructions of a block are executed sequentially and the block "result" is the result of the last statement of the block.

  * 1.1 - "= {1+ 2; sum (A1:A10); B3 + 4 }"

  ![block_Analysis](block_analysis.PNG)

2 - The FOR loop should also be implemented based on instruction blocks. For example, the formula"= FOR {A1: = 1 ; A1<10; A2: = A2 + A1; A1: = A1 + 1 }" executes a for loop in which: the first expression is the initialization, the second term is the boundary condition, all other expressions are performed for each iteration of the loop.

  * 2.1 - "=FOR{A1:=1;A1<10;A2:=A2+A1;A1:=A1+1}"

  ![loopfor_analysis](loopfor_analysis.PNG)

3 - Add the assign operator (its symbol is ":="). This operator assigns to its left the result of the right expression. At the moment the left of the assign operator can only be a cell reference.

  * 3.1 - "=A2:=sum(A1;A4)"

  ![assignment_analysis](assignment_analysis.PNG)

## 3.2 Analysis Diagrams

1 - Interpreting the already existing Classes and application flow I realized that to  travel between ParserTree nodes new methods were needed to visit new grammar rule nodes in class ExpressionEvalVisitor.

![ExpressionEvalVisitor_analysis](CD-FormulaEvalVisitor.png)

**CD-FormulaEvalVisitor-** methods in red are the ones created to visitLoopFor node and visitAssignment node of the ParserTree.


2 - After creating the methods mentioned in point 1 of 3.2 section new Classes were needed to process the terminal nodes visited in the visitLoopFor(LoopForContext ctx) and visitAssignment(AssignmentContext ctx) visits.

**Assignment()**
Because an Assignment had binary characteristics (left and right operands), implementing the already existing BinaryOperator interface in Class Assignment was the solution I implemented.

Since Assignment implements BinaryOperator, it's class should have the following methods available:

![AssignmentClass_analysis](AssignmentClass.png)

**CD-Assignment-** Method applyTo(Expression leftOperand, Expression rightOperand), is one the two methods refered in point 2 that are responsible for the processing of  the terminalNodes at the end of the visit and to return the result of the Expression.


**For()**
For this specific class I realized that it's behaviour would be that of a function. Since the for cicle should visit more than one rule, an array of Expressions should be created in order to process the for cicle and its result.
Because the Fuction interface had an existing method to process the applyTo(Expressions[]arguments), the class For should implement said interface.

![loopFor_analysis](loopFor.png)

**CD-For-** Method applyTo(Expression[] arguments), is the one responsible for the processing of the BinaryOperators received in the arguments array. The binaryOperators for the expression **=FOR{A1:=1;A1<10;A2:=A2+A1;A1:=A1+1}** would be related to the following grammar rules:

  * arguments[0]-->Assignment
  * arguments[1]-->Comparison
  * arguments[2]-->Assignment
  * arguments[3]-->Assignment


# 4. Design

1 - Interpreting the application flow, in this section I will show some Sequence Diagrams to explain how a formula will be processed and interpreted in Java.

![FormulaCompiler_analysis](FormulaCompilerSD.png)

2 - After the creation of the ParserTree, there's a need to visit each context of the formula and process the terminal nodes of each rule using the abstract method applyTo(). On section #5. Implementation, there's some implementations of the vist methods as well as the implementations of the applyTo() methods for classes For, Assignment and Block.



## 4.1. Tests

Because it was the first Use Case implemented in this edition of LAPR4, a lot of time was focused on interpreting, understanding and designing the solution for these new feature. Because the deadline was near I was unable to implement tests for the classes and methods created.

The test methods for these classes and methods would be around these lines:

  **For**

  * testGetIdentifier()
  * testApplyTo()
  * testIsVarArg()
  * testGetParameters()

  **Block**

  * testGetIdentifier()
  * testApplyTo()
  * testIsVarArg()
  * testGetParameters()

  **Assignment**

  * testGetIdentifier()
  * testApplyTo()
  * testIsVarArg()
  * testGetParameters()

  **FormulaEvalVisitor**

  * testvisitBlock()
  * visitAssignment()
  * visitLoopfor()

## 4.2. Design Patterns and Best Practices

By memory we apply/use:  
- Visitor  

**TODO:** Exemplify the realization of these patterns using class diagrams and/or SD with roles marked as stereotypes.

# 5. Implementation

To travel through the nodes of the parse tree, new visit methods were created for the new grammar rules contexts:

  * visitBlock(BlockContext)

![visitBlock](visitBlock.PNG)

  * visitAssignment(AssignmentContext)

![FormulaCompiler_analysis](visitassignment.PNG)

  * visitLoopfor(LoopForContext)

![FormulaCompiler_analysis](visitloopFor.PNG)

To process result of the formulas these applyTo() methods were implemented:

  * For

![applytofor](applytofor.PNG)

  * Assignment

![FormulaCompiler_analysis](applytoassignment.PNG)

  * Block

![FormulaCompiler_analysis](applytoblock.PNG)

# 6. Integration/Demonstration

During the implementation of my UC I tried to be aware of what was going on with my colleagues work. I think I tried to be as helpful as possible while organizing my time and work.

# 7. Final Remarks

This was an extremely interesting Use Case to Design and implement, I applied a lot of the knowledge obtained through the semester on LPROG course. I was also able to overcome my difficulties on the understanding of how antlr4 works and how we can use it to develop new languages that we can use in any case in the future.

# 8. Work Log

Important Commits:

[Started Documentaion](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/03919a57e9249f966f000a7a889d43562f729d43)

[Started Analysis](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/03919a57e9249f966f000a7a889d43562f729d43)

[Started implementing new grammar rules and tokens](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/ac00c5f28a71bb5bbf598e2fa87f71e3a30ead2e)

[Implemented new Classes to process new rules output](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/407a09222a536bb286fc34f4afd1b83edd559172)This commit was the biggest one, since it contains all the code implemented. Since all my new rules were related to each other It was better for me to implement all at once and commit all the changes at once.

[Important change in grammar design](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/ab8048e90a1eefd66df636b52275dc16e7605db2)This commit was extremely important since there was a flaw on my grammar design. The loopfor rule was only able to recognize one or more assignments after the boundary condition, with this commit the loopfor is now able to recognize one or more comparisons/assignments.
