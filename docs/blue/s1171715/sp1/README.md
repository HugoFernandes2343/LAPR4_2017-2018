**Barbara Csonka** (s1171715) - Sprint 1 - Lang03.1
===============================

# 1. General Notes

In my part of the project (Conditional Formatting Cell), I spent significant time to get the specification clear, even for myself. Since I have never used Java programming neither GWT until now, I needed help to be a bit more familiar with the language - therefore, each person of my team was really helping and patient with me, and they helped me everyday to get on track with the project. 


# 2. Requirements

Lang03.1 - The "Style" extension should be updated, so it can be used for conditional formatting of cells, based on the result of the execution of formulas. For the style of the cell to be conditional, it must have:

- an associated formula and 2 formatting styles
	- one of the styles is:
		* applied when the formula evaluets to true,
		* and the other when it evalutes to false

- the editing of these settings should be done in a sidebar window.

In the best case scenario, from the users perspective, the usage of the application should work like the following:

The user is able to select cells, and start formatting with the extension itself by defining a formula. Therefore, the application provides several formatting options for the user.

2) The user can select from the previously mentioned options.

3) After that, the system alters cells styling, based on the condition given by the user. 

 

# 3. Analysis


For this feature increment, since it is the first to be developed in a new project, I had to:  

- Analyize the whole project itself and understand the needed processes and tasks separateley as well

- Get to know the NetBeans environment and structure

- Understand the working mechanishm of GWT

Because of the lack of time, and because I had to get to know numerous new technologies to use, unfortunately I haven't been able to solve the whole task properly, and I couldn't manage the actual color-changing method. Of course, in order to fill this gap, I would spend time to go deeper in the actual business logic, and to be more familiar using GWT. 

 

# 4. Design


To make it clear for the user and for the developer team, I created different diagrams with all the essential parts.

Sequence diagram: https://imgur.com/a/RCB0sGI


## 4.1. Tests

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

In order to test the features of this part, the following was done:

- Two cells with different numbers (5 and 10) were being chosen, so as a condition (2 * 5) and colors. (It can be known that the cell with number 10 will be the right result.)

- Another two cells were being chosen, one is the text "aprovado", and other is with "reprovado". "Aprovado" has the same color just like the correct answer (would be done in future also).




@author  Barbara Csonka


 








