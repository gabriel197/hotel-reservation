package service;

import exceptions.RoomNotFoundException;
import model.*;

import java.util.*;

public class ReservationService {

    // Store a list of rooms in a collection
    private static List<IRoom> roomList = new ArrayList<>();

    // Store rooms with their checkIn and out dates
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    
    public static void addRoom(IRoom room){
        roomList.add(room);
        Collections.sort(roomList);
    }

    // Get a room from Collections
    public static IRoom getARoom(String roomId) {
        for (IRoom room : roomList) {
                if (room.getRoomNumber().equals(roomId)) return room;
        }
        System.out.println("Room non-existent.");
        return null;
    }

    public static Collection<IRoom> getAllRooms() {
//        List<IRoom> allRooms = new ArrayList<>(roomList);
//        for (Reservation reservedRoom :
//                reservations) {
//            allRooms.add(reservedRoom.getRoom());
//        }
//        // Sort by room number in ascending order
        Collections.sort(roomList);
        return roomList;
    }


    public static IRoom createARoom(String roomNumber, String roomPrice, RoomType roomType) throws NumberFormatException {

        double doublePrice = Double.parseDouble(roomPrice);

        return new Room(roomNumber, doublePrice, roomType);
    }


    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservedRoom = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservedRoom);
//        bookedRooms.put(customer.getEmail(), reservedRoom);
        return reservedRoom;
    }

    // Find rooms that are not reserved & show only paid || only free rooms list
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate, boolean searchFreeRooms) {
        Set<IRoom> freeRooms = new HashSet<>();

        // Store in set so it not allow duplicates
        Set<IRoom> availableRooms = new HashSet<>(roomList);

        // Add rooms that are not reserved to @availableRooms
        for (Reservation reserved :
                reservations) {
            // In/Out dates of @reserved represented by 1 respective 2
            // If in/out dates are between 1&2 || in before 1 & out after 1 || in before 2 & out after 2 ||
            // in equals 1 & out equals 2...
            if (checkInDate.after(reserved.getCheckInDate()) && checkOutDate.before(reserved.getCheckOutDate()) ||
            checkInDate.before(reserved.getCheckInDate()) &&  checkOutDate.after(reserved.getCheckInDate()) ||
            checkInDate.before(reserved.getCheckOutDate()) && checkOutDate.after(reserved.getCheckOutDate()) ||
            checkInDate.equals(reserved.getCheckInDate()) && checkOutDate.equals(reserved.getCheckOutDate())) {
                // ... remove room because is reserved ...
                availableRooms.remove(reserved.getRoom());
                // ...otherwise add it.
            } else availableRooms.add(reserved.getRoom());
        }
        if(searchFreeRooms) {
            // Return either free rooms...
            for (IRoom room : availableRooms) {
                if(room.isFree()) {
                    freeRooms.add(room);
                }
            }
            availableRooms.clear();
            availableRooms.addAll(freeRooms);
        } else {
            //...or paid roms.
            availableRooms.removeIf(room -> room.getClass().equals(FreeRoom.class));
        }

        List<IRoom> sortableList = new ArrayList<>(availableRooms);
        Collections.sort(sortableList);
        return sortableList;
    }

    public static Collection<IRoom> searchXDaysAfter(int daysAhead, Date checkInDate, Date checkOutDate, boolean searchFreeRooms) {
        Date checkInDateIncremented, checkOutDateIncremented;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkInDate);
        calendar.add(Calendar.DATE, daysAhead);
        checkInDateIncremented = calendar.getTime();
        calendar.setTime(checkOutDate);
        calendar.add(Calendar.DATE, daysAhead);
        checkOutDateIncremented = calendar.getTime();
        return findRooms(checkInDateIncremented, checkOutDateIncremented, searchFreeRooms);
    }

    // Return the rooms reserved by a customer
    public static Collection<Reservation> getCustomersReservation(Customer customer){
        ArrayList<Reservation> customersReservation = new ArrayList<>();
        for (Reservation reserved :
                reservations) {
            if(reserved.getCustomer().equals(customer)) customersReservation.add(reserved);
        }
        return customersReservation;
    }

    // Print to console all reservations
    public static void printAllReservations(){
        Iterator<Reservation> iterator = reservations.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }

    // Return appropriate description for bed
    public static String bedsNumber(RoomType bed) {
        return switch (bed) {
            case DOUBLE -> "Double bed";
            case SINGLE -> "Single bed";
        };
    }
}
