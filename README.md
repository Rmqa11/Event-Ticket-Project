# Event-Ticket-Project
This is the backend component of the Event Ticket application, responsible for managing event tickets and users. It provides a RESTful API for interacting with the system.

API Endpoints

1- AdminController
/admin: get admin.
/create: create admin.
/update/{adminId}: update admin by id.
/delete/{adminId}: delete admin by id.

2- EventController
/allEvents: get all events.
/event/{eventId}: update event by id.

3- RegisterUserController
/create/user: create user.
/user/{userId}: get user by id.

4- TicketController
/ticket: get all ticket.
/create/ticket: create ticket.
/ticket/delete/{ticketId}: delete ticket by id.





Testing

The application includes Integration tests ( MocMvc ) to ensure its functionality.



![image](https://github.com/Rmqa11/Event-Ticket-Project/assets/129896223/15bd9b68-c97b-4c83-b836-c857065b5061)




