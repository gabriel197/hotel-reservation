package service;

import model.*;

import java.util.*;

public class ReservationService {

    // Store a list of rooms in a collection
    static List<IRoom> roomList = new ArrayList<>();

//    public static HashMap<String, Reservation> bookedRooms = new HashMap<>();


    // Store rooms with their checkin and out dates
    public static ArrayList<Reservation> reservations = new ArrayList<>();
    
    public static void addRoom(IRoom room){
        roomList.add(room);
        Collections.sort(roomList);
    }

    // Get a room from Collections
    public IRoom getARoom(String roomId){
        // TODO: fix this
        List<IRoom> allRooms = new ArrayList<>(roomList);
        for (Reservation reservedRoom :
                reservations) {
            allRooms.add(reservedRoom.getRoom());
        }
        // Sort by room number in ascending order
        Collections.sort(allRooms);

        // Store the index of required room
        int id = -1;
        try {
             id = Integer.parseInt(roomId);
        } catch (NumberFormatException ex) {
            ex.getLocalizedMessage();
        }
        return allRooms.get(id);
    }

    public static Collection<IRoom> getAllRooms() {
        List<IRoom> allRooms = new ArrayList<>(roomList);
        for (Reservation reservedRoom :
                reservations) {
            allRooms.add(reservedRoom.getRoom());
        }
        // Sort by room number in ascending order
        Collections.sort(allRooms);
        return allRooms;
    }


    public static IRoom getRoom(String roomNumber) {
        for (IRoom room :
                roomList) {
            try {
                if (room.getRoomNumber().equals(roomNumber)) return room;
                else throw new ClassNotFoundException("Room not found");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
        return null;
    }

    public static Room createARoom(String roomNumber, String roomPrice, RoomType roomType) throws NumberFormatException {

        double doublePrice = Double.parseDouble(roomPrice);

        return new Room(roomNumber, doublePrice, roomType);
    }


    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservedRoom = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservedRoom);
//        bookedRooms.put(customer.getEmail(), reservedRoom);
        return reservedRoom;
    }

    // Find rooms that are not reserved
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        // Store in set so it not allow duplicates
        ArrayList<IRoom> availableRooms = new ArrayList<>(roomList);

        // Add rooms that are not reserved to @availableRooms
        for (Reservation reserved :
                reservations) {
            // In/Out dates of @reserved represented by 1 respective 2
            // If in/out dates are between 1&2 || in before 1 & out after 1 || in before 2 & out after 2 ...
            if (checkInDate.after(reserved.getCheckInDate()) && checkOutDate.before(reserved.getCheckOutDate()) ||
            checkInDate.before(reserved.getCheckInDate()) &&  checkOutDate.after(reserved.getCheckInDate()) ||
            checkInDate.before(reserved.getCheckOutDate()) && checkOutDate.after(reserved.getCheckOutDate())) {
                // ... remove room because is reserved ...
                availableRooms.remove(reserved.getRoom());
                // ...otherwise add it.
            } else availableRooms.add(reserved.getRoom());
        }
        // TODO: Might not be needed
        Collections.sort(availableRooms);
        return availableRooms;
    }

    // Return the rooms reserved by a customer
    public static Collection<Reservation> getCustomersReservation(Customer customer){
        Set<Reservation> customersReservation = new HashSet<>();
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
}
