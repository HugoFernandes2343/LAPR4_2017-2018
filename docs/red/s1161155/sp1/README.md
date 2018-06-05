**Hugo Fernandes** (s1161155)
===============================

# 1. General Notes
   Was not able to finish the implementation, due to some persisting issues,
# 2. Requirements

- **Core05.1 - Contacts**

	Each user of the applications should have a list of contacts. A contact is another user of the application that has established a contact with the user of the application. A user of the application may establish a contact with another user by sending an invitation if he/she knows the email of the other user. A user may or not accept an invitation. A user can block/unblock invitations from other users.

  Proposal:

  US1 - As the Product Owner I want to have a community icon in them menu that allows a logged in user to open the Contacts page or the requests page.

  US2 - As a User of the Application I want to be able to check my friend requests and answer that were sent to me..

  US3 - As a User of the Application I want to be able to send friend requests to emails.

  US4 - As a User of the Application I want to be able to remove friends from my contact list.(This ends both sides of the friendship).

# 3. Analysis

For this feature, since it is the first one implemented by me in this project I need to:  

- Study the existing GWT implementation to understand how to change the UI design according to my needs.

- Study the existing xml layouts.  

- Implement UI changes and the corresponding background methods.

- Coordinate with the IPC team on the User log in subject.  

## 3.4 Analysis Diagrams

**Use Cases**

![Use Cases](US.png)

 - **Use Cases**. Since all the four use stories are encompassed by the Use Case CORE05.1, and all the restrictions are pretty simple at the time no in depth description is needed in my view. I do however want to point out that the functionality of this use case is reliant on the existance of a log in system and singed up users.

**Domain Model (for this feature)**

![Domain Model](DM.png)

- **Domain Model**.

**System Sequence Diagrams**

**For US1**

![Analysis1 SD](analysis1.png)

**For US2 & US3**

![Analysis2 SD](analysis2.png)

Since both of these US are both working on the requests, they were both displayed in this diagram separated by an alt section.

**For US4**

![Analysis3 SD](analysis3.png)

# 4. Design

## 4.1. Tests

Regarding tests we try to follow an approach inspired by test driven development. However it is not realistic to apply it for all the application (for instance for the UI part). Therefore we focus on the domain classes and also on the services provided by the server.

**Domain classes**

The Domain classes this feature revolves around are the entity **User** and **Request**. These entity will have attributes (some of which are **Email**'s and **Password**'s and are validated by those class's), these attributes are.
    
   User:    
	
	- name (string)
	- pass (Password)
	- mail (Email)
	- contacts (ArrayList<Email>)
	- requests (ArrayList<Requests>)
	
   Request:    
    
    - sender (Email)
    - reciever (Email)
    

**Test:** We should ensure that a User can be created when all the attributes are set, save for the contacts and requests lists.  

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		System.out.println("ensureNullIsNotAllowed");
		User instance = new User(null,null,null);
	}

    @Test(expected = IllegalArgumentException.class)
    	public void ensureNullIsNotAllowed() {
    	System.out.println("ensureNullIsNotAllowed");
    	Request instance = new Request(null,null);
    }
    

For this funcionality we will need a **ContactsService**, which will have a method to list the contacts and remove a select contact.

**Proposal**:

        INSERT service CODE HERE.

For this funcionality we will need a **RequestsService**, which will have a method to list the requests, answer them either yes or no depending on a button on the UI, and creating and sending a new Request.
    
 **Proposal**:
    
        INSERT service CODE HERE.


Tests:  

- The tests on the controllers require the presence of a database.  

- We will use the database in memory (H2).  

- We will have a *controller* for showing and answering Requests. This controller will be invoked by the GWT RPC service.

- We will have a *controller* for sending a Request. This controller will be invoked by the GWT RPC service.

- We will have a *controller* for showing Contacts. This controller will be invoked by the GWT RPC service.

- We will have a *controller* for removing a Contact. This controller will be invoked by the GWT RPC service.


Controller **ListingAndAnsweringRequestsController**

**Test**: verify the normal listing of Requests.

	@Test
	public void testNormalListingBehaviour() throws Exception {
        //INSERT CODE HERE
    }

**Test**: verify the answering of Requests.

	@Test
     	public void testNormalAnsweringBehaviour() throws Exception {
             //INSERT CODE HERE
         }

**Test**: verify the persistence in the database.

	@Test
     	public void testDatabaseRequestRemoval() throws Exception {
             //INSERT CODE HERE
         }

Controller **SendingNewRequestController**

**Test**: verify the sending of a new Request.

	@Test
	public void testNormalSendingBehaviour() throws Exception {
        //INSERT CODE HERE
    }

**Test**: verify the persistence in the database.

	@Test
     	public void testDatabaseRequestInsertion() throws Exception {
             //INSERT CODE HERE
         }

Controller **ListingContactsController**

**Test**: verify the normal listing of Contacts.

	@Test
	public void testNormalListingBehaviour() throws Exception {
        //INSERT CODE HERE
    }

Controller **RemovingContactController**

**Test**: verify the normal removing of a contact for a user.

	@Test
     	public void testRemoveContactBehavior() throws Exception {
             //INSERT CODE HERE
         }


**Test**: verify the persistence in the database.

	@Test
     	public void testDatabaseRequestRemoval() throws Exception {
             //INSERT CODE HERE
         }

**Test Coverage**  
- The actual coverage for domain classes: 
- The actual coverage for application(controller) classes: 
 
## 4.2. Requirements Realization

Following the guidelines for JPA from EAPLI we envision a scenario like the following for realizing the use cases for this feature increment.

The diagram only depicts the less technical details of the scenario;  
For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in these diagrams.   

**For US1 & US2**

![SD US1](design1.png)

Notes:  
- **CommunityServices** realizes the GWT RPC mechanism;  
- **AnswerRequestController** is the *use case controller*;  
- **ShowRequestController** is the *use case controller*;  
- **RequestServices** is to group together all the services related to Request. 

**For US3**

![SD US3](design2.png)

Notes:     
- **CommunityServices** realizes the GWT RPC mechanism;  
- **CreateRequestController** is the *use case controller*;  
- **RequestServices** is to group together all the services related to WorkbookDescription. 

**For US4**

![SD US4](design3.png)

Notes:  
- **CommunityServices** realizes the GWT RPC mechanism;  
- **ShowContactsController** is the *use case controller*;  
- **RemoveContactsController** is the *use case controller*;  
- **ContactsServices** is to group together all the services related to WorkbookDescription. 


## 4.3. Classes

------ INSERT THE CLASSES THAT ARE CREATED FOR THIS FEATURE AND EXPLAIN THEM--------

## 4.4. Design Patterns and Best Practices

By memory we apply/use:  
- Singleton  
- Repository  
- MVP  

**TODO:** Exemplify the realization of these patterns using class diagrams and/or SD with roles marked as stereotypes. 


# 5. Implementation
# 6. Integration/Demonstration
# 7. Final Remarks
# 8. Work Log
