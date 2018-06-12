**Paulo Magalhães** (s1160570) - Sprint 2 - LANG01.0
===============================

# 1. General Notes



# 2. Requirements

Lang01.2 - Monetary Language

Add a new formulas language (currently the application only has Excel formulas that begin with the character "="). The new language should do only calculations related to currencies. The character that begins the formula should be "#". The formula should only accept the addition, subtraction, multiplication and division operators. Operands are monetary values in which it is necessary to provide the currency (e.g., 10.21e, 1.32£ or 0.20$). All expressions are required to be contained within brackets with the currency prefix in which we want the result, e.g., "#euro{10.32$ + 12.89£}" or "#dollar{ 10.32$ + 12.89£}" or "#pound{10.32$ + 12.89£}". For the user to use this language instead of the "regular" Excel language it should start the formula by the character "#" instead of the "=" character. The application should also provide a way for setting exchange rates (by means of a configuration). The implementation should avoid the use of numbers in floating point representation (e.g., float, double) in order to avoid precision problems.

Proposal:

**US1** - Create grammar MonetaryLanguage.g4 to create new rules and operators:

Create RULES:
* **expressionMonetary**
* **expression**
* **concatenation**
* **atom**
* **literalMonetary**

Create OPERATORS:
* **START** ('#')
* **EURO_FUN** ('euro')
* **POUND_FUN** ('pound')
* **DOLLAR_FUN** ('dollar')
* **EURO_SIGN** ('e')
* **DOLLAR_SIGN** ('$')
* **POUND_SIGN** ('£')

# 3. Analysis
## 3.1 GRAMMAR ANALYSIS

### expressionMonetary
1 - The expression Monetary must start with the token Start ('#'), later it can call the rule expression.

### expression

2 - The expression should start with one of the following tokens: EURO_FUN (euro), DOLLAR_FUN (dollar), POUND_FUN (pound), then '{' so you can call concatenation and finally end with '}.

### concatenation

3- The concatenation can go to the atom rule, or it can do a concatenation of (PLUS | MINUS) or (MULTI | DIV).

### atom

4- The atom can go the literalMonetary rule or can go the expression '('expression')'.

### literalMonetary
5- The literal Monetary has one number more EURO_SIGN,POUND_SIGN or DOLLAR_SIGN.

##### Example
* #euro{80£+60$+3e}
![Example1](example1.png)

* #euro{80£+60$+(pound{30e})}
![Example2](example2.png)

* #euro{60$/30e+(pound{30e*2e})}
![Example3](example3.png)

# 4. Integration/Demonstration

During the implementation of my UC I tried to be aware of what was going on with my colleagues work. I think I tried to be as helpful as possible while organizing my time and work.

# 5. Final Remarks

This was an extremely interesting Use Case to Design and implement, I applied a lot of the knowledge obtained through the semester on LPROG course. I was also able to overcome my difficulties on the understanding of how antlr4 works and how we can use it to develop new languages that we can use in any case in the future.

# 6. Work Log

Important Commits:

[Started Documentaion]()

[Started Analysis](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/a6dda8215985214318d4e40c6a1dce59ec2b0e4e)

[Implemented new Classes to process new rules output](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/c5e6906c20715577c4853c9ff9c816bc93000b7d)This commit was the biggest one, since it contains all the code implemented. Since all my new rules were related to each other It was better for me to implement all at once and commit all the changes at once.
