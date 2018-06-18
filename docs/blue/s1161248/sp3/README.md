**João Oliveira** (s1161569) - Sprint 3 - IPC08.2
===============================

# 1. General Notes

Given the fact of this feature does not depend of the IPC08.1, I decide create one model made by me and independent.

# 2. Requirements

IPC08.2 - Users should now be able to create private chat rooms. They should invite other users (by using their email)..

Proposal:

US1 - As a User of the Application I want create a private chat so that I can communicate with other users of the Nsheets.
US2 - As a User of the Application I want accept a invite for a private chat.
US3 - As a User of the Application I want send a new message for a chat that I belong.

# 3. Analysis


For this feature increment, since my model is independent of feature developed in IPC08.1 I need to:  

- Create a view/page that will be used for the private chat

- Add a button to the menu side navigation bar to enable the private chat page

- Add a button to the chat view/page to reload the chat in order to keep the text updated

- Add a card for each private chat

- Add a button and a text field in the private chat's card for the user write a message in the private chat 

- Create a message entity to store the text written, the user who wrote it and the exact time of said message.

- Persist on the server the private chat with the new message and fetch the actual chat (collection of all messages ordered by date) 

- Refresh the chat to accommodate the user message an other new messages that might have appeared 


## 3.1 Application Startup
	        
The **ApplicationModule** must also install the new model destined for the private chat:

		install(new PrivateChatModule());   

This module will represent an MVP page in the application for the chat.

In this MVP pattern, the **PrivateChatPresenter** will define a specific interface that is used to communicate with the UI (i.e., the PrivateChatView). Therefore the presenter can will fully isolated from dependencies related to the UI. 

	interface MyView extends View {
    		void setContents(List<ChatDTO> contents);
    } 
	
## 3.2 Server and RPC

The PrivateChats page displays what seems to be Chats that are an atributte of users that should reside in the server.

In the method **onReveal** the PrivateChat presenter invokes a **UsersService** asynchronously.

For this purpose I will require an interface for the service. In this case:

	@RemoteServiceRelativePath("privateChatService")
	public interface UsersServiceAsync {
        void getUserByEmail(String email, AsyncCallback<UserDTO> callback);
        void getUser(String email, String password, AsyncCallback<UserDTO> callback);
        void saveUser(UserDTO user, AsyncCallback<UserDTO> callback);
        void getAllUser(AsyncCallback<List<UserDTO>> callback);
    }

When the RPC is invoked since it will always execute asynchronously, so I have to prove a callback: 

	// Make the call to the user service, to get users for get the chats of the user.
	usersSvc.getAllUser(userList, callback);
	
The callback will be similar to the one developed by John Doe:

	// Set up the callback object.
	AsyncCallback<List<UserDTO>> callback = new AsyncCallback<List<UserDTO>>() {
		public void onFailure(Throwable caught) {
			// TODO: Do something with errors.
		}
		public void onSuccess(List<UserDTO> result) {
			setContents(result.getChatList());
		}
	}; 

Since the interface is code that must be accessed by both server and client code it will reside in the **shared** project.

The interface must be implemented in the **server** since it will be the one responsible for communicating with the database. The **LoginController** (taking advantage of code already implemented) will be the assign controller for this task of implementing the interface

	    public Iterable<User> allUsers() {
            UserRepository userRepository = PersistenceContext.repositories().user();
            return userRepository.getAllUsers();
        }

Since the service is a servlet it must be declared in the **web.xml** file of the project (see file nsheets/src/main/webapp/WEB-INF/web.xml).

	    <servlet>
            <servlet-name>privateChatServiceServlet</servlet-name>
            <servlet-class>pt.isep.nsheets.server.services.PrivateChatServiceImpl</servlet-class>
        </servlet>
       
        <servlet-mapping>
            <servlet-name>privateChatServiceServlet</servlet-name>
            <url-pattern>/nsheets/privateChatService</url-pattern>
        </servlet-mapping> 
	

## 3.3 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**


![Use case Model](UseCaseDiagram.png)

**Domain Model (for this feature increment)**

![Domain Model](Domain Class.png)

- **Domain Model**. The entities represented in this domain model will be represented by the classes in server side and when transitioning to the client side will be represented by the respective DTO classes. The reverse process also occurs. In therms of already existing entities this use case requires the use of the **User** entity developed by Paulo Magalhães (s1160570)  

**System Sequence Diagrams**

![Creat new chat UC](UC_CreateChat_Analysis.png)
![Pending Invites UC](UC_PendingInvites_Analysis.png)
![New message UC](UC_NewMessage_Analysis.png)

# 4. Design

## 4.1. Tests

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

Regarding tests I try to follow an test driven development approach. I concentrate all the testing effort on the domain classes and also on the services provided by the server.

**Domain classes**

For the Domain classes I will have a class that represents the entity **Message**:
	
	- user (User)
	- name (string)
	- description (string) 
	
	
For the Domain classes I will have a class that represents the entity **Chat**:
    	
    - messages (List<Message>)
    - name (string)
    - isAccept (boolean) 

For the Domain classes I will have a class that represents the entity **User**:
    	
    - chats (List<Chat>)

**Test:** I should ensure that a Message can be created only when all the attributes are set.  

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowedOnMessageUsername() {
		System.out.println("ensureNullIsNotAllowedOnMessage");
		Message instance = new Message(null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
    		public void ensureNullIsNotAllowedOnMessageText() {
    		System.out.println("ensureNullIsNotAllowedOnMessage");
    		Message instance = new Message(null, null, null);
    }
    @Test(expected = IllegalArgumentException.class)
    		public void ensureNullIsNotAllowedOnMessageDate() {
    		System.out.println("ensureNullIsNotAllowedOnMessage");
    		Message instance = new Message(null, null, null);
    }

**Test:** I should ensure that a Chat can be created only when all the attributes are set.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowedOnChatName() {
		System.out.println("ensureNullIsNotAllowedOnChat");
		Chat instance = new Chat(null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
    		public void ensureNullIsNotAllowedOnChatMessages() {
    		System.out.println("ensureNullIsNotAllowedOnChatMessages");
    		Chat instance = new Chat(null, null, null);
    }
    @Test(expected = IllegalArgumentException.class)
    		public void ensureNullIsNotAllowedOnIsAccept() {
    		System.out.println("ensureNullIsNotAllowedOnIsAccept");
    		Chat instance = new Chat(null, null, null);
    }


**Services/Controllers**

For the services I must test the service specified in the interface **PrivateChatService**:

	@RemoteServiceRelativePath("privateChatService")
	public interface PrivateChatService extends RemoteService {
		List<ChatDTO> getChatList();
		ChatDTO addChat(ChatDTO mDto) throws DataException;
	}
		
Tests:  
- The tests on the controllers require the presence of a database.  
- I will use the database in memory (H2).  
- I will have a *controller* from adding and fetching the private chat Messages. This controller will be invoked by the GWT RPC service.


Controller **Controller**

**Test:** Verify the normal creation of a Message.  


	@Test
	public void testNormalBehaviour() throws Exception {
		System.out.println("testNormalBehaviour");
		final String text = "This is a private chat message";
		final Date date = new Date();
		final User user = new user();
		final MessageDTO expected = new MessageDTO(user.toDTO(), text, date);
		ChatController ctrl = new ChatController();
		MessageDTO result = ctrl.saveMessage(expected);
		assertTrue("the added Message does not have the same data as input", Message.fromDTO(expected).sameAs(Message.fromDTO(result)));
	}

**Test:** At the beginning of the tests the memory database should be empty, so ChatController should return an empty set.

	   @Test 
	   public void testEnsureGetMessagesEmpty() {
		   System.out.println("testEnsureGetMessagesEmpty");
		   ChatController ctrl=new ChatController();
		   Iterable<Messages> messageList=ctrl.getMessages();
		   assertTrue("the list of Messages is not empty", !messageList.iterator().hasNext());
	   } 
 
**Test:** If a Message is created it should be present in a following invocation of getMessages().

		@Test
		public void testBtestDatabaseInsertion() throws Exception {
			System.out.println("testBtestDatabaseInsertion");
			final String text = "This is a public chat message";
            final Date date = new Date();
            final User user = new user();
            final MessageDTO expected = new MessageDTO(user.toDTO(), text, date);
			ChatController ctrl=new ChatController();
			MessageDTO result = ctrl.addMessage(dto);
			Iterable<Messages> messageList=ctrl.getMessages();
			assertTrue("the added Message is not in the database", messageList.iterator().hasNext());
		}

**Test Coverage**  
- The actual coverage for domain classes: 0%
- The actual coverage for application(controller) classes: 0%
 

## 4.2. Requirements Realization

Following the guidelines for JPA from EAPLI I envision a scenario like the following for realizing the use case for this feature increment.

![SD US_NewChat](CreatChat_Design.png)
![SD US_PendingInvites](AceptChatSD_Design.png)
![SD US_NewMessage](NewMessage_Design.png)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **ChatServices** realizes the GWT RPC mechanism;  
- **PublishPublicMessageController** is the *use case controller*;  

## 4.3. Classes

For this functionality the most important classes are **Chat** (Represents the chat entity on server side), **ChatDTO** (Represents chat entity on the client side), **PrivateChatController** (establishes a connection between the client and the server) and the **PrivateChatRepository** (Persistence mechanism) 

## 4.4. Design Patterns and Best Practices

By memory I apply/use:  
- Information Expert 
- Service/Controller 
- Repository  
- DTO  
- MVP  

# 5. Implementation


**UI: View/page to support the chats**

For this concern i decided to create a new module called **PrivateChatModule** to suport the page that contains the private chats.

**UI: Cards that represent the private chats and each have Text areas for writing messages**

For this concern i decided to use a Material Widget called MaterialTextArea and MaterialCard. MaterialTextArea  has a similar structure to the MaterialTextBox but supports a larger area for text writing and MaterialCard permits separe the different private chats. 

I updated the PrivateChatView.ui.xml accordingly and declare the element with the tags **ui:field="message" label="Text Area" allowBlank='false'**. In the corresponding class View (i.e., PrivateChatView) I bind this text area to the corresponding widget class (I do the same with MaterialCard): 	

      @UiField
      MaterialTextArea textField;
      
      @UiField
      MaterialCard card;



**UI: Buttons for sending a message and refresh the chat**

For this concern i decided to use a Material Widget called MaterialButton. These are the two buttons in which the user will either send a message(send button) which also refreshes the chat or just refresh the chat(refresh button).  

I updated the PrivateChatView.ui.xml accordingly and declare the elements with the tags **ui:field="sendButton" text="Send" waves="LIGHT" textColor="WHITE" iconType="POLYMER" iconPosition="RIGHT"** and **ui:field="refreshButton" text="Refresh" waves="LIGHT" textColor="WHITE" iconType="POLYMER" size="LARGE"**. In the corresponding class View (i.e., PrivateChatView) I bind these buttons to the corresponding widget class: 	

      @UiField
      MaterialButton sendButton;

      @UiField
      MaterialButton refreshButton;

**Code Organization**  

I followed the recommended organization for packages:  
- Code should be added (when possible) inside packages that identify the group, sprint, functional area and author;
- In this case since I do not have to add new packages since i use existing classes and files;

The code for this sprint:  
Project **server**    
- pt.isep.nsheets.server.**lapr4.blue.s3.ipc.n1161248.application**: contains the PrivateChatController  
- pt.isep.nsheets.server.**lapr4.blue.s3.ipc.n1161248.domain**: Chat class 
- pt.isep.nsheets.server.**lapr4.white.s1.core.n4567890.workbooks.persistence**: contains the persistence/JPA class for the Messages  
- Created the service class: **pt.isep.nsheets.server.services.PrivateChatServiceImpl**

Project **shared**  
- Added the interface: **pt.isep.nsheets.shared.services.PrivateChatService**: Interface to be applied to the respective class(PrivateChatServiceImpl). Comply with rpc   
- Added the interface: **pt.isep.nsheets.shared.services.PrivateChatServiceAsync**: Interface that defines the async calls regarding messages fetch and commit.
- Added the Class: **pt.isep.nsheets.shared.services.ChatDTO**: UI representation of the Chat entity.  

Project **NShests** 
- Created the classes: **pt.isep.nsheets.client.lapr4.blue.s3.n1161248.PrivateChatModule**, **pt.isep.nsheets.client.lapr4.blue.s3.n1161248.PrivateChatPresenter** and **pt.isep.nsheets.client.lapr4.blue.s3.n1161248.PrivateChatView**
- Created the file: **pt.isep.nsheets.client.lapr4.blue.s3.n1161248.PrivateChatView.ui.xml**: File that orders the UI elements on the page
- Updated the class: **pt.isep.nsheets.client.application.ApplicationModule**: Add the instruction to initialize the **PrivateChatModule**


# 6. Integration/Demonstration

Since the use case involved a new page and new domain concepts there was not much need to conciliate with the team the realization of this use case. The only thing that was needed to conciliate was the structure of the user login and how the actual user was saved since I needed the username for the message so this issue was coordinated with colleague **s1161109**.

# 7. Final Remarks

I have encountered some issues regarding gwt UI elements namely on the capability to show the chat messages. With the help of **s1120608** it was possible to develop a MaterialCard capable of containing the chat message, the username who created said message and the exact time at which the message was created. 


# 8. Work Log

Commits:

[IPC08.2: Starting development of IPC08.2. Start implementing my Use Case](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/1c45250)

[IPC08.2: Updated Use Case code. Major of Use Case it is working](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/887cb8c)

[IPC08.2: Use Case are implemented](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/3a02968)

[IPC08.2: Upload the Use Case Documentation](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/)

