**Hugo Carvalho** (s1161569) - Sprint 2 - IPC08.1
===============================

# 1. General Notes

Given the fact that this functionality does not have any work (documentation, code and so on) associated on sprint 1, I decided to develop this functionality instead of the IPC08.2 which was intended for development in sprint2

# 2. Requirements

IPC08.1 - Add a Page/View to allow all online users to exchange text messages (i.e., a public chat room).

Proposal:

US - As a User of the Application I want a public chat so that I can communicate with other users of the Nsheets.

# 3. Analysis


For this feature increment, since it is the first one to be developed regarding any type of chat I need to:  

- Create a view/page that will be used for the public chat

- Add a button to the menu side navigation bar to enable the public chat page

- Add a button to the chat view/page to reload the chat in order to keep the text updated

- Add a button and a text field in the chat page/view for the user to write a message in the public chat 

- Create a message entity to store the text written, the user who wrote it and the exact time of said message.

- Persist on the server the new message and fetch the actual chat (collection of all messages ordered by date) 

- Refresh the chat to accommodate the user message an other new messages that might have appeared 


## 3.1 Application Startup
	        
The **ApplicationModule** must also install the new model destined for the social chat:

		install(new ChatModule());   

This module will represent an MVP page in the application for the chat.

In this MVP pattern, the **ChatPresenter** will define a specific interface that is used to communicate with the UI (i.e., the ChatView). Therefore the presenter can will fully isolated from dependencies related to the UI. 

	interface MyView extends View {
    		void setPageTitle(String title, String description, String link, String specification);
    } 
	
## 3.2 Server and RPC

The Chat page displays what seems to be Messages that should reside in the server.

In the method **onReveal** the Chat presenter invokes a **ChatService** asynchronously.

For this purpose I will require an interface for the service. In this case:

	@RemoteServiceRelativePath("chatService")
	public interface ChatService extends RemoteService {
		ArrayList<MessageDTO> getMessages();
	}

When the RPC is invoked since it will always execute asynchronously, so I have to prove a callback: 

	// Make the call to the message service.
	chatSvc.getMessages(callback);
	
The callback will be similar to the one developed by John Doe:

	// Set up the callback object.
	AsyncCallback<ArrayList<MessageDTO>> callback = new AsyncCallback<ArrayList<MessageDTO>>() {
		public void onFailure(Throwable caught) {
			// TODO: Do something with errors.
		}
		public void onSuccess(ArrayList<MessageDTO> result) {
			refreshView(result);
		}
	}; 

Since the interface is code that must be accessed by both server and client code it will reside in the **shared** project.

The interface must be implemented in the **server** since it will be the one responsible for communicating with the data base. The **publicMessagingController** will be the assign controller for this task of implementing the interface

	@Override
	public ArrayList<MessageDTO> getMessages() {
	    ArrayList<MessageDTO> messages = new ArrayList<MessageDTO>();
	    for(Message message:messageRepository.findAllByDate()){
	        messages.add(message.toDTO());
	    }   
		return messages;
	}

Since the service is a servlet it must be declared in the **web.xml** file of the project (see file nsheets/src/main/webapp/WEB-INF/web.xml).

	<!-- Servlets for the Messages -->
	<servlet>
		<servlet-name>chatServiceServlet</servlet-name>
		<servlet-class>pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161569.application.ChatServiceImpl</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>chatServiceServlet</servlet-name>
		<!-- The first "part" of the url is the name of the GWT module as in "rename-to" in .gwt.xml -->
		<url-pattern>/nsheets/chatService</url-pattern>
	</servlet-mapping> 
	

## 3.3 Analysis Diagrams

The main idea for the "workflow" of this feature increment.

**Use Cases**

![Use Case](us.png)

- **Use Case**. Since these use case has a one-to-one correspondence with the User Story I do not add more detailed use case description in this section.

**Domain Model (for this feature increment)**

![Domain Model](dm.png)

- **Domain Model**. The message entity will be represented by the class **Message** int server side and when transitioning to the client side will be represented by the **MessageDTO**. The reverse process also occurs. In therms of already existing entities this use case requires the use of the **User** entity developed by Paulo Magalhães (s1160570)  

**System Sequence Diagrams**

![Analysis SD](analysis.png)

# 4. Design

## 4.1. Tests

*In this section you should describe the design of the tests that, as much as possibe, cover the requirements of the sprint.*

Regarding tests I try to follow an test driven development approach. I concentrate all the testing effort on the domain classes and also on the services provided by the server.

**Domain classes**

For the Domain classes I will have a class that represents the entity **Message**:
	
	- user (User)
	- name (string)
	- description (string) 

**Test:** I should ensure that a Message can be created only when all the attributes are set.  

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowedOnMessage() {
		System.out.println("ensureNullIsNotAllowedOnMessage");
		Message instance = new Message(null, null);
	}

**Services/Controllers**

For the services I must test the service specified in the interface **ChatService**:

	@RemoteServiceRelativePath("chatService")
	public interface ChatService extends RemoteService {
		ArrayList<MessageDTO> getMessages();
		MessageDTO addMessage(MessageDTO mDto) throws DataException;
	}
		
Tests:  
- The tests on the controllers require the presence of a database.  
- I will use the database in memory (H2).  
- I will have a *controller* from adding and fetching the public chat Messages. This controller will be invoked by the GWT RPC service.


Controller **PublishPublicMessageController**

**Test:** Verify the normal creation of a Message.  

	@Test
	public void testNormalBehaviour() throws Exception {
		System.out.println("testNormalBehaviour");
		final String text = "This is a public chat message";
		final Date date = new Date();
		final User user = new user();
		final MessageDTO expected = new MessageDTO(user.toDTO(), text, date);
		PublishPublicMessageController ctrl = new PublishPublicMessageController();
		MessageDTO result = ctrl.addMessage(dto);
		assertTrue("the added Message does not have the same data as input", Message.fromDTO(expected).sameAs(Message.fromDTO(result)));
	}

**Test:** At the beginning of the tests the memory database should be empty, so PublishPublicMessageController should return an empty set.

	   @Test 
	   public void testEnsureGetMessagesEmpty() {
		   System.out.println("testEnsureGetMessagesEmpty");
		   PublishPublicMessageController ctrl=new PublishPublicMessageController();
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
			PublishPublicMessageController ctrl=new PublishPublicMessageController();
			MessageDTO result = ctrl.addMessage(dto);
			Iterable<Messages> messageList=ctrl.getMessages();
			assertTrue("the added Message is not in the database", messageList.iterator().hasNext());
		}

**Test Coverage**  
- The actual coverage for domain classes: 0%
- The actual coverage for application(controller) classes: 0%
 

## 4.2. Requirements Realization

Following the guidelines for JPA from EAPLI I envision a scenario like the following for realizing the use case for this feature increment.

![SD US](design.png)

Notes:  
- The diagram only depicts the less technical details of the scenario;  
- For clarity reasons details such as the PersistenceContext or the RepositoryFactory are not depicted in this diagram.   
- **ChatServices** realizes the GWT RPC mechanism;  
- **PublishPublicMessageController** is the *use case controller*;  

## 4.3. Classes

For this functionality the most important classes are **Message** (Represents the message entity on server side), **MessageDTO** (Represents message entity on the client side), **PublishPublicMessageController** (establishes a connection between the client and the server) and the **MessageRepository** (Persistence mechanism) 

## 4.4. Design Patterns and Best Practices

By memory I apply/use:  
- Information Expert 
- Service/Controller 
- Repository  
- DTO  
- MVP  