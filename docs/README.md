LAPR4/NSheets Project Documentation
================================

# 1. Individual Pages

These are links for the individual pages/folders of each Student. The first two are only examples. After knowing his/her Student Team Number, each student should update the table and the folder structure of the repository accordingly.

For instance, if my name is Maria Ferreira and I have the Student Team Number 2 I should update the row number 2 in this table. I should also create a new folder in the repository, as illustrated.

| Team | Student Number     | Student Name                        | Link 							  |
|------|--------------------|-------------------------------------|------------------------------------|
| Red  | **s1122101**      			| John Doe					|[John Doe](red/s1122101/) |
| Red  |			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Red  | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Green | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |
| Blue | 			      			| 							|								 |

# 2. Planning Overview

| Team | Sprin1     | Sprint2        | Sprint 3	  |
|------|------------|----------------|-------------|
| Red  | Core   		| IPC			| Lang        |
| Green  | IPC      | Lang		    | Core		  |	
| Blue  | Lang	    | Core	  		| IPC    	  |

# 3. Detailed Planning

| Team | Student                      | Sprint1                                        | Sprint2                                      | Sprint3 							          |
|------|------------------------------|------------------------------------------------|----------------------------------------------|----------------------------------------------|
| Red  | [John Doe](red/s1122101/) | [Core01.1](red/s1122101/sp1)            | [IPC01.2](red/s1122101/sp2)           | [Lang01.3](red/s1122101/sp3) |
| Red  |			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Red  | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|	
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Green | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|
| Blue | 			      			| 							|								 |		|

# 4. Requirements


## 4.1 Core

### Core01 - Workbook View
	Core01.1 - Workbook View
	Core01.2 - Workbook and Cells Extensions (Style Extension)
	Core01.3 - Comments Extension

### Core02 - Sort
	Core02.1 - Column Sort
	Core02.2 - Sort Range of Cells
	Core03.3 - Auto-Sorting
	
### Core03 - Images
	Core03.1 - Insert Image
	Core03.2 - Overlay Image 
	Core03.3 - Persisting Images
	

- Criar tarefas que permitam associar workbooks

- Criar reminders

- Profile Edition


## 4.2 IPC

### IPC01 - Register and Login (Mandatory)
	IPC01.1 - Protect all the Pages (Except About) with a Login Page (i.e., Gatekeepers in GWTP). Define some hard-coded users to use for authentication. Define a super-user that is able to access **everything**
	IPC01.2 - Implement a Register Page
	IPC01.3 - Implement a Security Section in the Profile of the User (to change password, delete account, etc.)

### IPC02 - Search
	IPC02.1 - Workbook Search 
	IPC02.2 - Workbook Search and Replace
	IPC02.3 - Global Search (Search on All workbooks of the user)
		
### IPC03 - PDF
	IPC03.1 - Basic PDF Export (Download)
	IPC03.2 - PDF Style Export (Download)
	IPC03.3 - PDF Complete Export (Download)
	
### IPC04 - XML
	IPC04.1 - Export XML (Download)
	IPC04.2 - Import XML (Upload)
	IPC04.3 - Full XML Import/Export
	
### IPC05 - CLS/CSV Persistence
	IPC05.1 - Export to CSV (Download)
	IPC05.2 - Import/Export using the same native format as CSheets (Download/Upload)
	IPC05.3 - Import/Export using the same native format as CSheets and CSV
	
### IPC06 - Workbook Sharing				
	IPC06.1 - A Page that displays all private Workbooks (all workbooks are by default private to the user)
	IPC06.2 - A Page that displays public Workbooks. In the Workbook View it should be possible to make the Workbook public.
	IPC06.3 - A page with the workbooks that others have shared.

### IPC07 - Collaborative Workbook Editing
	IPC07.1 - Concurrent editions of the same Workbook should display updates in realtime
	IPC07.2 - The Workbook View should display other users that are editing the same Workbook and display the cells that other users are editing.
	IPC07.3 - The Workbook View should have an area to allow users to exchange small text messages 

### IPC08 - Online Chat
	IPC08.1 - Add a Page to allow for exchange text messages between all online users (a public chat room)
	IPC08.2 - Users should be able to create private chat rooms. They should invite other users (by using their email)
	IPC08.3 - Users should be able to post Images and make mentions of users (they should reveive an email if they are not online)


- Chat com outras pessoas online

- Visão online de edição de workbook

- Importar e exportar para XML PDF, etc no servidor

- Fazer segunda aplicação de administração ou apenas página de administração - permitir importar batch de utilizadores, exportar batch de workbooks, etc.


## 4.3 Lang


# 5. Domain Model

**Core**

![Core Domain Model](domain_model_image1.png)

**Formulas**

![Formulas Domain Model](domain_model_formulas_image1.png)



