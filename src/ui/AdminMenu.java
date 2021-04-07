package ui;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AdminMenu {
    public static void start() {
        System.out.println("\nAdmin Menu");
        System.out.println("-------------------------------------------------");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Add test data");
        System.out.println("6. Back to Main Menu");
        System.out.println("-------------------------------------------------");
        System.out.println("Please select a number from the menu option ");

        try(Scanner scanner = new Scanner(System.in)) {


            String scannedToken = scanner.next();
            switch (scannedToken) {
                case "1":
                    for (Customer customer : CustomerService.getAllCustomers()) {
                        System.out.println(customer);
                    }
                    start();
                case "2":
                    for (IRoom room :
                            ReservationService.getAllRooms()) {
                        System.out.println(room);
                    }
                    start();

                case "3":
                    AdminResource.displayAllReservations();
                    start();

                case "4":
                    boolean addOneMoreRoom = true;
                    List<IRoom> rooms = new ArrayList<>();
                    while (true) {
                        String price, roomNumber, roomType;
                        System.out.println("Enter room number:");
                        roomNumber = scanner.next();
                        System.out.println("Enter room price:");
                        price = scanner.next();
                        System.out.println("Enter room type: 1 for Single Bed or 2 for Double Bed");
                        roomType = scanner.next();
                        while (!(roomType.equals("1") || roomType.equals("2"))) {
                            System.out.println("Enter only 1 or 2.");
                            roomType = scanner.next();
                        }
                        RoomType roomBed = switch (roomType) {
                            case "1" -> RoomType.SINGLE;
                            case "2" -> RoomType.DOUBLE;
                            default -> null;
                        };
                        rooms.add(AdminResource.createRoom(roomNumber, price, roomBed));
                        //TODO: add proper check for misspelling
                        System.out.println("Would you like to add another room? (Y/N)");
                        scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                        if (scannedToken.equals("n")) {
                            AdminResource.addRoom(rooms);
                            start();
                        }
                    }
//TODO: Add dummy data
//                case "5":
//                    AdminResource.a
                case "6": MainMenu.start();
                default:
                    System.out.println("Please select one option from the list.");
                    start();
                    }
            }

        }
    }

