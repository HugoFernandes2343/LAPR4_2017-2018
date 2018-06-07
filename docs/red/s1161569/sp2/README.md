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


