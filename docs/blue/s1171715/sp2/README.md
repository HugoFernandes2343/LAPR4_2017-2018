**Barbara Csonka** (1171715) - Sprint 2 - Core03.2
===============================

# 1. General Notes

At the start of Sprint 2, I had unexpected personal issues, which made me even more difficult to perform my best during this week. Since my own laptop had to be
taken to service, and plus the fact that I had to leave the city for days because of personal reasons, it took me serious amount of time to solve this temporary and unfortunate situation. Again, just like in SP1, I could always rely on my team, which was huge easement for me.


# 2. Requirements

In the light of the official document, my task was the following: 

- The user should be able to define a range of cells, doing things on the active spreadsheet
- The user should be able to define a certain column, where the formula - defined by the user - will be perfomred on
- In the light of the previous requirement, the rows what are in the ranged should be filtered, based on the previously defined boolean formula

# 3. Analysis

In order to draw up a proper solution for this task, I had to study and understand the task itself in depth, moreover, I had to get familiar with the working process of a boolean variable. As I mentioned before, I havent had any previous studies with GWT and Java either, and even though I tried my best to be better in this fields, I still have a long way to go, mainly because of the lack of time, and the problems I had to face and solve in the past days. 

In addition, because of the lack of time, I only managed to solve the following:

- It is possible for the user to select a range of cells, e.g: B2:C4 in a table which has columns from A-F, and cells from 1-6.
	- In this case, in B2, B will be the indicator column, and C4 will stand for the row that needs to be checked. 
	- This means, that all the values in column B will be checked according to the previously given formula, and according to that, the row (C4) is going to stay visible, or change to invisible.
	
Of course, if I would have more time, I would try to solve the task like how it would be expected from the side of the user/customer.

system sequence diagram: https://imgur.com/a/GlYS5jg

# 4. Design

The sequence diagram clearly shows how my part is working at the moment. 


sequence diagram: https://imgur.com/a/eKfhqgx
   

# 5. Implementation





# 6. Final Remarks

It was an interesting task to be solved, I enjoyed working on it, because it needed creativity and it was challenging to find a way to solve it somehow. 
