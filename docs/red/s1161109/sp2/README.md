**David Santiago** (s1161109) - Sprint 2 - IPC01.2
===============================

# 1. General Notes


# 2. Requirements

IPC01.2 - User Registration

User Email Should be valid and unique.
PassWord should be encrypted for safety reasons.
User is by defaul only user(not admin)


US1 - Understand how the application works and later the Gatekeeper.

US2 - Changed classes in Server.

* **Email**
* **Password**
* **UserType**
* **Name**
* **Nickname**
* **UserServiceImpl**
* **LoginController**
* **User**

US3 -Changed classes in shared

* **EmailDTO**
* **PasswordDTO**
* **UserTypeDTO**
* **NameDTO**
* **NicknameDTO**
* **UsersServiceAsync**
* **UsersService**
* **UserDTO**

US4 - Create classes in Web

* **CurrentMenu**

# 3. Analysis

For this feature increment i needed to:

-Understand how the application works and also understand the key aspects of GWT

-Understand how the Home Page is implemented, so i can edit menu from another modules.

-Understand how to connect JPA technology with the database;

-Understand how the UI communicates with server;

-Learn to add patterns to java;

-Learn how to encrypt passwords;


-Create a view/page that will be used for the register

-Add a button to the menu to sing up

-Add a button to logout

-Add a image of user on the top

-Add the nickname of user on the top

-Persist the user data on the server



  Special Case of Email Verification:

  Email is verified by the next pattern:

  [a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}_







## 3.1 GWT and Project Structure




**Modules**. From the pom.xml file we can see that the application is composed of 5 modules:  
- **server**. It is the "server part" of the web application.  
- **shared**. It contains code that is shared between the client (i.e., web application) and the server.   
- **nsheets**. It is the web application (i.e., Client).  
- **util**. This is the same module as the one of EAPLI.  
- **framework**. This is the same module as the one of EAPLI.   

### 3.1.1 Server

  These classes have the method need of fromDTO and toDTO that serve to convert the classes to be possible to use the shared classes.

 * **Email** - It is a class that presents a string ('email') that refers to the User's email.
 * **Password** - Is a class that has a string ('password') that refers to the User's password.
 * **Name** - This is a class that has two string ('firstName', 'seconName') that refers to the User name.
 * **Nickname** -This is a class that has a string ('nickname') that refers to the nickname of the User.
 * **UserType** - Is an enumeration that displays the type of User ('USER', 'ADMIN').

---------------------------------------------------------

 * **RegisterController** - This class presents the method that will save a user and its information to the database;

* **UserServiceImpl** - This class serves to connect the shered to server

* **User** - It is a class that presents a Email,PAssword,Name,Nickname and UserType.


### 3.1.2 Shared

* **EmailDTO** - It is a class that presents a string ('email') that refers to the User's email.
* **PasswordDTO** - Is a class that has a string ('password') that refers to the User's password.
* **NameDTO** - This is a class that has two string ('firstName', 'seconName') that refers to the User name.
* **NicknameDTO** -This is a class that has a string ('nickname') that refers to the nickname of the User.
* **UserType** - Is an enumeration that displays the type of User ('USER', 'ADMIN')
* **UsersServiceAsync/UsersService**- These classes serve to communicate with the userServiceImp

### 3.1.2 Web

* **CurrentMenur** - This class has the CurrentMenu that is beeing shown;



## 3.4 Analysis Diagrams

**Use Cases**

![Use Cases](US1.jpg)


**Domain Model (for this feature increment)**

![Domain Model](DM.jpg)

- **Domain Model**. Since we found no specific requirements for the structure of User we follow the Structure of the existing DTO (UserDTO).

**System Sequence Diagrams**

**For US1**

![Analysis SD](coiso.jpg)


# 4. Design

## 4.1. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.

**For US1**

![SD US1](SSD.jpg)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **UserServices** realizes the GWT RPC mechanism;  
- **RegisterController** is the *use case controller*;  


# 5. Implementation


**Code Organization**  

We followed the recommended organization for packages:  


- Code should be added (when possible) inside packages that identify the group, sprint, functional area and author;
- For instance, we used **lapr4.red.s2.ipc.s1161109.*



The code for this sprint:  



Project **server**    
- pt.isep.nsheets.server.**lapr4.white.s1.core.s1161109.register.application**: contains the controllers  
- pt.isep.nsheets.server.**lapr4.white.s1.core.n4567890.workbooks.persistence**: contains the persistence/JPA classes


I edited this class's:
- pt.isep.nsheets.server.**lapr4.white.s1.core.s1160570.login.domain**: contains the domain classes User,Email,Password,Name,UserType
- **pt.isep.nsheets.server.UserServiceImpl**





Project **shared**  



- Edited the classes: **pt.isep.nsheets.shared.services.UserService** and **pt.isep.nsheets.shared.services.UserServiceAsync**  

Project **NShests**


Created the classes:

-**RegisterView**
-**RegisterModule**
-**RegisterPresenter**
-**RegisterController**


# 6. Integration/Demonstration

During the implementation of my UC I helped and been helped by my team several times.


# 6. Test Class's

  The only class that deserved a test class because of the complexity of its code was the email class:

  The tests are the next:


  ![SD US1](teste.jpg)


# 8. Final Remarks

 For lack of time i didn't implemented password encryptation.
 After several tries and after asking the teacher Bragança for help for doing image upload it was not possible.
