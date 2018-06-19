**Barbara Csonka** (s1171715) - Sprint 3 - IPC04.2
===============================

# 1. General Notes

This recent sprint required the deep understand of server-client communication in the first place, and using GWT as well. Since IPC04.2 has similarities with IPC04.1, I used my teammate, Rodrigo Fontes's help and knowledge during my work. 


# 2. Requirements

It should be possible to export the contents of an workbook, spreadsheet or part of a spreadsheet to a XML file. As we want to optimize as much as possible the process the solution should not rely on any third party library. The application should have a window/page to configure the XML tags to use for each type of element. The export should only include the value of the cells. The generated XML should be downloaded to the user local file system.

I am  using an external library called XStream, which can: 
 make the code more maintanable,
 make it more scalable, already has stuff that can be used,

Since it is cheap as well, and saves us time to this particular feature, it also allows us to move on to the next feature, which makes the whole program itself more valuable eventually. 

# 3. Analysis

The solution of this problem consist of three main parts, such as the Client, Server, and the Shared modules. 

## 3.1 Analysis diagrams

Class diagram

![cd](cd.jpg)

![cd2](cd2.jpg)

Use cases

![us](us.jpg)

![us1](us1.jpg)

System Sequence Diagram

![ssd](ssd.jpg)

US

![us](us.jpg)

For US1
![us1sd](us1sd.jpg)

For US2

![us2sd](us2sd.jpg)

For US3

![us3sd](us3sd.jpg)

##Server part
	
	DownloadXMLImpl class

##Client part

 	ExportToXMLView class

##Shared part

	DownloadToXMLServiceAsync interface

# 4. Design

## 4.1. Used classes

During this sprint, I used the following packages:

pt.isep.nsheets.shared.services contains interfaces of the services
pt.isep.nsheets.server.services contains all the servlets thats needed

# 5. Implementation

# 6. Final Remarks




@author  Barbara Csonka


 








