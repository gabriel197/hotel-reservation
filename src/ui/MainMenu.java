package ui;

import api.HotelResource;

import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static api.HotelResource.hotelResource;

public class MainMenu {
    public static void start() {
        System.out.println("\n Welcome to the Hotel Reservation Application!");
        System.out.println("-------------------------------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("-------------------------------------------------");
        System.out.println("Please select a number from the menu option ");

        try(Scanner scanner = new Scanner(System.in)) {
            String scannedToken = scanner.next();
            String first, last, email, roomNumber;
            switch (scannedToken) {
                case "1" -> {
                    System.out.println("Do you have an account with us? (Y/N)");
                    scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                    while (!(scannedToken.equals("y") || scannedToken.equals("n"))) {
                        System.out.println("Please type \"Y\" (yes) or \"N\" (no).");
                    scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                    }
                    if(scannedToken.equals("y")) {

                        System.out.println("Please enter your email:");

                        email = scanner.next();
                        // If no email found, create a customer account
                         if(hotelResource.getCustomer(email)== null) {
                             System.out.println("Would you like to create an account in order to make a reservation? (Y/N)");
                             scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                             if (!(scannedToken.equals("y") || scannedToken.equals("n")))
                                 System.out.println("Enter Y (yes) or N (no).");
                                 switch (scannedToken) {
                                     case "y":

                                         System.out.println("Enter your email. Example: yourname@domain.com");
                                         email = scanner.next();
                                         System.out.println("First Name:");
                                         first = scanner.next();
                                         System.out.println("Last Name");
                                         last = scanner.next();
                                         hotelResource.createACustomer(email, first, last);
                                         start();

                                     case "n":
                                         start();

                                 }

                             //If customer has an account, allow him to make a reservation
                         } else {
                             System.out.println("Enter CheckIn Date (dd/MM/yyyy) Example: 30/04/2021");
                             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                             Collection<IRoom> availableRooms;
                             Date dateIn = null, dateOut = null;

                             while (dateIn==null) {
                                 try {
                                     dateIn = sdf.parse(scanner.next());
                                 } catch (ParseException ex) {
                                     System.out.println("Invalid date format");
                                 }
                             }
                             System.out.println("Enter CheckOut Date (dd/MM/yyyy) Example: 03/05/2021");

                             while (dateOut==null) {
                                 try{
                                     dateOut = sdf.parse(scanner.next());
                                 } catch (ParseException ex) {
                                     System.out.println("Invalid date format");
                                 }
                             }
                             System.out.println("Search for paid or free rooms? (P/F)");
                             scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                             while (!(scannedToken.equals("p") || scannedToken.equals("f"))) {
                                 System.out.println("Enter 'P' for paid or 'F' for free rooms.");
                                 scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                             }
                             boolean freeRooms;
                             switch (scannedToken) {
                                 case "p" -> freeRooms = false;
                                 case "f" -> freeRooms = true;
                                 // Suppress 'freeRoms might not been initialized' compiler error
                                 default -> freeRooms = false;
                             }

                             availableRooms = hotelResource.findARoom(dateIn, dateOut, freeRooms);

                             // This block of code check for others rooms in a timeframe incremented by user if their
                             // current reservation period has no available rooms
                             if (availableRooms.size() == 0) {
                                 System.out.println("No available rooms found. Would you like to search ahead");
                                 System.out.println("of current reservation period for available room? (Y/N)");
                                 scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                                 while (!(scannedToken.equals("y") || scannedToken.equals("n")))
                                     System.out.println("Please enter Y (YES) or N (NO)");
                                 if(scannedToken.equals("n")) start();
                                 System.out.println("How many days out?");
                                 int days = 0;
                                 while (days == 0) {
                                     try {
                                         scannedToken = scanner.next();
                                         days = Integer.parseInt(scannedToken);
                                     } catch (NumberFormatException ex) {
                                         System.out.println("Enter only digits");
                                     }
                                 }
                                 availableRooms = hotelResource.searchSomeDaysAfter(days, dateIn, dateOut, freeRooms);
                             }
                             for (IRoom room : availableRooms) {
                                 System.out.println(room);
                             }
                             if (availableRooms.size() == 0) {
                                 System.out.println("Sorry, no rooms available in this period either");
                                 start();
                                 break;
                             }
                             System.out.println("Would you like to book a room? (Y/N)");
                             scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                             switch (scannedToken.toLowerCase(Locale.ROOT)){
                                 case "y":
                                     System.out.println("What room number you will like to reserve?");
                                     roomNumber = scanner.next();
                                     if(hotelResource.getRoom(roomNumber) != null)
                                     System.out.println(hotelResource.bookARoom(email, hotelResource.getRoom(roomNumber), dateIn, dateOut));
                                     start();
                                 case "n":
                                     start();
                                     break;
                             }
                         }
                    } else if (scannedToken.equals("n")) {
                        System.out.println("Create an account form option 3. in Main Menu in order to continue.");
                        start();
                    }
                    }
                case "2" -> {
                    System.out.println("Enter your email address:");
                    scannedToken = scanner.next();
                    for (Reservation reservation : hotelResource.getACustomerReservations(scannedToken)) {
                        System.out.println(reservation);
                    }
                    start();
                }


                case "3" -> {
                    System.out.println("Enter your email. Example: yourname@domain.com");
                    email = scanner.next();
                    System.out.println("First Name:");
                    first = scanner.next();
                    System.out.println("Last Name:");
                    last = scanner.next();
                    hotelResource.createACustomer(email, first, last);
                    start();
                }

                case "4" -> AdminMenu.start();

                case "5" -> {break;}
                default -> {
                    System.out.println("Please select one option from the list.");
                    start();
                }
            }
        }
    }
}
