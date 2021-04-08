package ui;

import api.AdminResource;
import api.HotelResource;
import model.*;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                case "5":
                    // Add list of rooms
                    List<IRoom> newRoom = new ArrayList<>();
                    newRoom.add(new Room("1",50d,RoomType.SINGLE));
                    newRoom.add(new Room("2",70d,RoomType.SINGLE));
                    newRoom.add(new Room("3",50d,RoomType.SINGLE));
                    newRoom.add(new Room("4",100d,RoomType.DOUBLE));
                    newRoom.add(new Room("5",120d,RoomType.DOUBLE));
                    newRoom.add(new Room("6",25d,RoomType.SINGLE));
                    newRoom.add(new FreeRoom("7", RoomType.SINGLE));
                    newRoom.add(new Room("8",199d,RoomType.DOUBLE));
                    newRoom.add(new FreeRoom("9", RoomType.SINGLE));
                    AdminResource.addRoom(newRoom);

                    // Add list of customers
                    String[] customersEmail = {"alex@gmail.com","alin@outlook.com","alin@outlook.com","maria@yahoo.com",
                            "laura@yahoo.com"};
                    HotelResource.createACustomer(customersEmail[0], "Alex", "Connor");
                    HotelResource.createACustomer(customersEmail[1], "Alin", "Daniel");
                    HotelResource.createACustomer(customersEmail[2], "Daniel", "Albu");
                    HotelResource.createACustomer(customersEmail[3], "Maria", "Melvi");
                    HotelResource.createACustomer(customersEmail[4], "Laura", "Alexandrescu");

                    // Create reservations
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String[] checkIn = {"01/01/2021", "15/01/2021", "01/02/2021", "05/12/2021"};
                    String[] checkOut = {"06/01/2021", "21/01/2021", "10/02/2021", "19/12/2021"};
                    for (int i = 0, j = 1; i < 4; i++, j++) {
                        try{
                            Date in = sdf.parse(checkIn[i]);
                            Date out = sdf.parse(checkOut[i]);
                            HotelResource.bookARoom(customersEmail[i], HotelResource.getRoom(String.valueOf(j)), in, out);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("Dummy data added!");
                    start();
                case "6": MainMenu.start();
                default:
                    System.out.println("Please select one option from the list.");
                    start();
                    }
            }

        }
    }

