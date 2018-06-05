**Paulo Magalhães** (s1160570) - Sprint 1 - IPC01.1
===============================

# 1. General Notes


# 2. Requirements

IPC01.1 - All the pages of the application should require an authenticated user (except the "About" page). The application should have a "Login" page (Hint: Gatekeepers in GWTP). Some hard-coded users should be defined to be initially used for authentication. There should also exist a super-user that is able to access everything.

US1 - As Product Owner, I want users (email and password) to come from a relational database, so they are persistent and we can log in and subsequently change the email or password.

US2 - As an application user, I wish to be able to log in to access my workbooks.

# 3. Analysis

## 3.1 Analysis Diagrams

**Use Cases**

![Use Cases](Use Case Diagram1.jpg)

- **Use Cases**. Since these use cases have a one-to-one correspondence with the User Stories we do not add here more detailed use case descriptions. We find that these use cases are very simple and may eventually add more specification at a later stage if necessary.

**Domain Model (for this feature increment)**

![Domain Model](Classe diagram.jpg)

- **Domain Model**. Since we found no specific requirements for the structure of User we follow the Structure of the existing DTO (UserDTO).

**System Sequence Diagrams**

**For US1**

![Analysis SD](Sequence Diagram.jpg)


# 4. Design

## 4.1. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.

**For US1**

![SD US1](Sequence Diagram2.jpg)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **UserServices** realizes the GWT RPC mechanism;  
- **LoginController** is the *use case controller*;  


## 4.4. Design Patterns and Best Practices

*Present and explain how you applied design patterns and best practices.*

By memory we apply/use:  
- Singleton  
- Repository  
- DTO  
- MVP  

**TODO:** Exemplify the realization of these patterns using class diagrams and/or SD with roles marked as stereotypes.

# 5. Implementation


**Code Organization**  

We followed the recommended organization for packages:  
- Code should be added (when possible) inside packages that identify the group, sprint, functional area and author;
- For instance, we used **lapr4.white.s1.core.n4567890**

The code for this sprint:  
Project **server**    
- pt.isep.nsheets.server.**lapr4.white.s1.core.s1160570.login.application**: contains the controllers  
- pt.isep.nsheets.server.**lapr4.white.s1.core.s1160570.login.domain**: contains the domain classes User,Email,Password,Name,UserType
- pt.isep.nsheets.server.**lapr4.white.s1.core.n4567890.workbooks.persistence**: contains the persistence/JPA classes
- Add the class: **pt.isep.nsheets.server.UserServiceImpl**

Project **shared**  
- Added the class: **pt.isep.nsheets.shared.services.DataException**: This class is new and is used to return database exceptions from the server  
- Create the classes: **pt.isep.nsheets.shared.services.UserService** and **pt.isep.nsheets.shared.services.UserServiceAsync**  

Project **NShests**
- Updated the classes: **pt.isep.nsheets.client.lapr4.green.s1.s1150670.aplication.login.LoginView** and **pt.isep.nsheets.client.lapr4.gren.s1.s1160570.aplication.login.LoginApresenter**  
**pt.isep.nsheets.client.lapr4.gren.s1.s1160570.aplication.login.LoginModule**  
- Create the file: **pt.isep.nsheets.client.lapr4.gren.s1.s1160570.aplication.login.LoginView.ui.xml**  


# 6. Integration/Demonstration

*In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)*

# 7. Final Remarks

*In this section present your views regarding alternatives, extra work and future work on the issue.*


# 8. Work Log

*Insert here a log of you daily work. This is in essence the log of your daily work. It should reference your commits as much as possible.*

Commits:
