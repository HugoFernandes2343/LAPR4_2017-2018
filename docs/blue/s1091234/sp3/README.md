**Pedro Tedim** (s1091234) - Sprint 3 - IPC01.3
===============================

# 1. General Notes

With the help of my team mates I was able to almost implement 100% of this UC.

# 2. Requirements

IPC01.3 - Security Profile

The application should now have a new "Profile" page to allow users to manage their accounts. The user should be able to change his information (name, nickname and photo) and also delete the account. The super-user should be able to access all the accounts and be able to enable/disable accounts. When an account is disable its user is not able to authenticate.

![user/superuser_classDiagram](IPC01.3 - user UCD.png)

During interpretation of the use case, I was able to identify two different user stories as represented in the use case diagram above for both the user and the superUser.

**US1** Edit Firstname/Lastname/Nickname

**US2** Delete Account

I was also able to identify one user story for the SuperUser.

![superuser_classDiagram](IPC01.3 - SuperUser UCD.png)

**US3** Activate/Deactivate Accounts

# 3. Analysis
## 3.1 Project Structure

I should be able to user classes like User, UserDTO and all it's attributes. Analysing the current state of the application I was able to identify that the LoginController Class made By Paulo of team Green, already has methods that I would have to use for this UC.

These methods are responsible for returning one user by it's email. Based on this method I was able to create methods like updateUser(UserDTO), deleteUser(Email), and getUsers().

getUsers() wil be used to list all users to the admin so he can be able to activate and deactivate account according to it's information of activation persisted in the database.

## 3.2 Analysis Diagrams

For a user to edit it's information (Firstname, Lastname, Nickname) I created the following SD:

For a user to to delete it's account I created the following SD:

For a superUser to be able to activate/deactivate an account I created the following diagram:


# 4. Design

For a user to edit it's information (Firstname, Lastname, Nickname) I created the following SSD:

For a user to to delete it's account I created the following SSD:

For a superUser to be able to activate/deactivate an account I created the following SSD:

## 4.1. Tests

## 4.2. Design Patterns and Best Practices


# 5. Implementation


# 6. Integration/Demonstration

# 7. Final Remarks

This sprint was extremely difficult to complete, since the use case I was assigned with was dependent on the good execution on the previous one. To be able to partially implement Core01.2, I had to completely reconstruct our project structure an integrate it with the already completed use cases. With the help of my colleague Norberto, we were able to do so.

# 8. Work Log

Important Commits:

[Core01.2 - Start of Documentation](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/d2472487d8b649c81bbd5665b69b20195ce06a2f)

[Core01.1 - Project restructuring](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/c009c497f74a76675fcf4297fb71809c2dec42ca)This was an huge commit

[Core01.1 - Project pesistence.xml updated to accept new entity classes and entities](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/99299130eeddafce59028b3d6ea084ddaae97ddb)

[Core01.1 - Project pesistence.xml updated to accept new entity classes and entities](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/8baa2b1f3af7f80a4cb121e62bb112b39603c625)

[Core01.1 - Project pesistence.xml more updates](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/27d83711ac83d8251d7d22f9d590b65cb6bb2562)

[Core01.2 - Delete workbook implementation](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/708a73da9b4c9185cd8feae2770d00b8ccb7271b)

[Core01.2 - Rename and adding spreadsheet to workbook implementation](https://bitbucket.org/lei-isep/lapr4-18-2dl/commits/98e8ae16ba7e378f875259cd5a8a0ff8cafc1aa7)
