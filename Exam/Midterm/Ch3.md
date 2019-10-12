# CH3 BASING SOFTWARE DEVELOPMENT ON REUSABLE TECHNOLOGY 

Key:   
framework, library, product line, hook, slot,
client-server, fat client, thin client, API, TCP, sockets, and OCSF, IP protocol (very general).

TYPES OF REUSE
EXPERTISE LIBRARIES
COMMANDSSTANDARD DESIGN
FRAMEWORKS
APPLICATIONS

**FRAMEWORKS: REUSABLE SUBSYSTEMS**
Web Frameworks   they do different things, but related  
Authentication Frameworks   Applications are different, but all need  some way to authorize / authenticate its users

FRAMEWORKS TO PROMOTE REUSE
INCOMPLETE HOOKS
EXTENSION POINTSSLOTS
SERVICES
APIS

OBJECT-ORIENTED FRAMEWORKS
PAYROLL E-COMMERCE 
FREQUENT BUYER CLUBSUNIVERSITY 
A framework is composed of a library of classes. 
The API is deﬁned by the set of all public methods of these classes. 
Some of the classes will normally be abstract and there are often many interfaces 

TYPES OF FRAMEWORKS
HORIZONTAL GENERAL FACILITIES
“COMPLETE” APPLICATIONSVERTICAL 

EXAMPLES OF CLIENT-SERVER SYSTEMS
▸ The World Wide Web ▸ Network File System ▸ Transaction Processing System ▸ Remote Display System
▸ Communication System ▸ Database System
▸ Email ▸ DNS 

**THIN- VERSUS FAT-CLIENT SYSTEMS**
Light computation->simple commands-<results for display Heavy computation  
Heavy computation->requests for services-<results of requests Light computation  

**ADVANTAGES OF CLIENT-SERVER SYSTEMS**
DISTRIBUTION SIMPLER
DATA STORAGE OPTIONSDISTANCE
CONCURRENCY
MULTI-TENANT

**TECHNOLOGY NEEDED TO BUILD CLIENT-SERVER SYSTEMS** 
INTERNET PROTOCOL (IP)
TRANSMISSION CONTROL PROTOCOL (TCP)
CONNECTIONS AND DELIVERY ASSURANCE
MESSAGE ROUTING AND PACKETS
IP / HOSTNAME
ADDRESS AND MAILBOX

**OCSF**
SUBCLASS CALL PUBLIC METHOD
PROVIDED BY FRAMEWORK
DON’T EDIT THOSE CLASSES
OVERRIDE SLOTS AND HOOKS
EXPLICITLY DESIGNED TO BE OVERWRITTEN
THE CLIENT SIDE
▸ Must be subclassed ▸ Must implement handleMessageFromServer ▸ Could overwrite hooks ▸ Implements the Runnable interface (run method to loop forever*) 
USING ABSTRACTCLIENT
▸ Create a subclass of AbstractClient  ▸ Implement handleMessageFromServer slot method  ▸ Write code that: ▸ Instantiate subclass ▸ Calls openConnection  ▸ Sends messages using the sendToServer ▸ Implement callbacks ▸ connectionClosed  ▸ connectionException
INTERNALS OF ABSTRACT CLIENT ▸ A Socket which keeps all the information about the connection to the server  ▸ Two streams, an ObjectOutputStream and an ObjectInputStream  ▸ A Thread that runs using AbstractClient’s run method  ▸ Two variables storing the host and port of the server
THE SERVER SIDE ▸ AbstractServer to listen to new connections ▸ Must implement handleMessageFromC lient ▸ Could overwrite hooks ▸ ConnectionToClient threads that handle connections to clients

NEED FOR ADAPTIVE MAINTENANCE ▸ Ensure that all software is  ▸ forward proof and  ▸ backward compatible  ▸ with other versions of clients and servers

**Protocol**
SYNC-ACK+SYNC-SYNC

**TCP/IP model**
Application-Transport-Internet-Link





















