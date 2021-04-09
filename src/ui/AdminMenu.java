package ui;

import model.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static api.AdminResource.adminResource;
import static api.HotelResource.hotelResource;


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
            // Add list of rooms
            // Add list of customers
            // Create reservations
            switch (scannedToken) {
                case "1" -> {
                    for (Customer customer : adminResource.getAllCustomers()) {
                        System.out.println(customer);
                    }
                    start();
                }
                case "2" -> {
                    for (IRoom room :
                            adminResource.getAllRooms()) {
                        System.out.println(room);
                    }
                    start();
                }
                case "3" -> {
                    adminResource.displayAllReservations();
                    start();
                }
                case "4" -> {
                    boolean addOneMoreRoom = true;
                    List<IRoom> rooms = new ArrayList<>();
                    while (addOneMoreRoom) {
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
                        rooms.add(adminResource.createRoom(roomNumber, price, roomBed));
                        System.out.println("Would you like to add another room? (Y/N)");
                        scannedToken = scanner.next().toLowerCase(Locale.ROOT);
                        if (scannedToken.equals("n")) {
                            adminResource.addRoom(rooms);
                            addOneMoreRoom = false;
                            start();
                        }
                    }
                }
                case "5" -> {
                    System.out.println("\nAdd rooms...");
                    List<IRoom> newRoom = new ArrayList<>();
                    newRoom.add(new Room("1", 50d, RoomType.SINGLE));
                    newRoom.add(new Room("2", 70d, RoomType.SINGLE));
                    newRoom.add(new Room("3", 50d, RoomType.SINGLE));
                    newRoom.add(new Room("4", 100d, RoomType.DOUBLE));
                    newRoom.add(new Room("5", 120d, RoomType.DOUBLE));
                    newRoom.add(new Room("6", 25d, RoomType.SINGLE));
                    newRoom.add(new FreeRoom("7", RoomType.SINGLE));
                    newRoom.add(new Room("8", 199d, RoomType.DOUBLE));
                    newRoom.add(new FreeRoom("9", RoomType.SINGLE));
                    adminResource.addRoom(newRoom);
                    System.out.println("Add customers...");
                    String[] customersEmail = {"alex@gmail.com", "alin@outlook.com", "daniel@outlook.com", "maria@yahoo.com",
                            "laura@yahoo.com"};
                    hotelResource.createACustomer(customersEmail[0], "Alex", "Connor");
                    hotelResource.createACustomer(customersEmail[1], "Alin", "Daniel");
                    hotelResource.createACustomer(customersEmail[2], "Daniel", "Albu");
                    hotelResource.createACustomer(customersEmail[3], "Maria", "Melvi");
                    hotelResource.createACustomer(customersEmail[4], "Laura", "Alexandrescu");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String[] checkIn = {"01/01/2021", "15/01/2021", "01/02/2021", "05/12/2021"};
                    String[] checkOut = {"06/01/2021", "21/01/2021", "10/02/2021", "19/12/2021"};
                    System.out.println("Create reservations...");
                    for (int i = 0, j = 1; i < 4; i++, j++) {
                        try {
                            Date in = sdf.parse(checkIn[i]);
                            Date out = sdf.parse(checkOut[i]);
                            hotelResource.bookARoom(customersEmail[i], hotelResource.getRoom(String.valueOf(j)), in, out);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("\nTest data added!");
                    start();
                }
                case "6" -> MainMenu.start();
                default -> {
                    System.out.println("Please select one option from the list.");
                    start();
                }
            }
            }

        }
    }
