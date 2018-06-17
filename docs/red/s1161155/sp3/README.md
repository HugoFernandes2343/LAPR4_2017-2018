**Hugo Fernandes** (s1161155)
===============================

# 1. General Notes
# 2. Requirements

- **Lang01.3 - Eval and While Loops**

	Add the Eval function. This function has a single parameter that is a string. When executed, this function will "compile" the formula contained in the only parameter and execute the resulting expression. The result of Eval is the result of the execution of the compiled expression. For example, if we write the following formula "=" 2 + 3 "" we get the string "2 + 3" in the cell. However, if we write the formula "= eval (" 2 + 3 ")" the value obtained in the cell is 5. Add the following two loop functions: DoWhile and WhileDo. The DoWhile executes the first expression in loop while the second expression evaluates to true. In each iteration of the loop the the first expression is the first to be evaluated. The WhileDo executes the second expression in loop while the first evaluates to true. In each iteration of the loop the the first expression is the first to be evaluated. Example: "= {@Counter:=1; WhileDo(Eval( "A"&@Counter)> 0; {C1:=C1+Eval("B"&@Counter); @Counter:=@Counter+1 }) }" . In this example, the cell C1 will get the sum of all the values of column B in that the corresponding values in column A are greater than zero.

 Proposal:
   
   - US01 - As a user I want to use the doWhile/WhileDo and eval functions.
   
# 3. Analysis

For this feature I need to:  

- Study how to create functions, both Eval and DoWhile/WhileDo. 

- Study how to use the functions and expressions on the user interface.

- Implement the functions.

- Test the functions.

## 3.4 Analysis Diagrams

# 4. Design

## 4.1. Tests

## 4.2. Requirements Realization

## 4.3. Classes

## 4.4. Design Patterns and Best Practices

# 5. Implementation

# 6. Integration/Demonstration


# 7. Final Remarks


# 8. Work Log

  
##Commits:

