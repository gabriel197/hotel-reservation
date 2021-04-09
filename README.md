# Hotel Reservation Command Line Interface App

The hotel reservation application will allow customers to find and book a hotel room based on room availability.


User Scenarios
 The application provides four user scenarios:

Creating a customer account. The user needs to first create a customer account before they can create a reservation.
Searching for rooms. The app should allow the user to search for available rooms based on provided checkin and checkout dates. 
If the application has available rooms for the specified date range, a list of the corresponding rooms will be displayed to the user for choosing.
Booking a room. Once the user has chosen a room, the app will allow them to book the room and create a reservation.
Viewing reservations. After booking a room, the app allows customers to view a list of all their reservations.



Reserving a Room 

Avoid conflicting reservations. A single room may only be reserved by a single customer per a checkin and checkout date range.
Search for recommended rooms. If there are no available rooms for the customer's date range, a search will be performed that displays recommended rooms on alternative dates.
The recommended room search will add seven days to the original checkin and checkout dates to see if the hotel has any availabilities, and then display the recommended rooms/dates to the customer.


Customer Requirements

A unique email for the customer. RegEx is used to check that the email is in the correct format (i.e, name@domain.com).
A first name and last name.
The email RegEx is simple for the purpose of this exercise and may not cover all real-world valid emails.

![alt text](https://github.com/gabriel197/hotel-reservation/blob/master/appScreenshots/mainMenu.png)


Admin Scenarios
 The application provides four administrative scenarios:

Displaying all customers accounts.
Viewing all of the rooms in the hotel.
Viewing all of the hotel reservations.
Adding a room to the hotel application.

![alt text](https://github.com/gabriel197/hotel-reservation/blob/master/appScreenshots/adminMenu.png)


Application Architecture
 The app will be separated into the following layers:

1. User interface (UI), including a main menu for the users who want to book a room, and an admin menu for administrative functions.
2. Resources will act as our Application Programming Interface (API) to our UI.
3. Services will communicate with our resources, and each other, to build the business logic necessary to provide feedback to our UI.
4. Data models will be used to represent the domain that we're using within the system (e.g., rooms, reservations, and customers).

![alt text](https://github.com/gabriel197/hotel-reservation/blob/master/appScreenshots/appLayers.png)

Layers

An important thing to notice about this architecture is how we use layers to support modularization and decoupling. 
For example, If we later decided to change our UI components to a webpage instead of a command-line interface, layering would support this.

Layering is achieved by ensuring there are no cross-communication calls from one layer to another.

This app was a required project (among others) to graduate the Java Programming Nanodegree program from Udacity.
