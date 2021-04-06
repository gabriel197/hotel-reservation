package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService extends model.Reservation{

    // Store a list of rooms in a collection
    static ArrayList<IRoom> roomList = new ArrayList<>();

    // Store rooms with their checkin and out dates
    static ArrayList<Reservation> reservations = new ArrayList<>();
    
    public void addRoom(IRoom room){
        roomList.add(room);
    }

    // Get a room from Collections
    public IRoom getARoom(String roomId){
        int id = -1;
        try {
             id = Integer.parseInt(roomId);
        } catch (NumberFormatException ex) {
            ex.getLocalizedMessage();
        }
        return roomList.get(id);
    }


    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reserv = new Reservation(customer, room, checkInDate, checkOutDate);
        roomList.remove(room);
        reservations.add(reserv);
        return reserv;
    }

    // Find rooms that are not reserved
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        // Store available rooms in array and return it as Collection<IRoom>
        ArrayList<IRoom> availableRooms = new ArrayList<>(roomList);

        // Add rooms that are not reserved to @availableRooms
        for (Reservation reserved :
                reservations) {
            if (checkInDate.before(reserved.getCheckInDate()) && checkOutDate.before(reserved.getCheckInDate()) ||
            checkInDate.after(reserved.getCheckOutDate()) &&  checkOutDate.after(checkInDate)) {
                availableRooms.add(reserved.getRoom());
            }
        }
        return availableRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer){
        Set<Reservation> customersReservation = new HashSet<>();
        // TODO: compare customer and override hashcode
        for (Reservation reserved :
                reservations) {
            if(reserved.getCustomer().equals(customer)) customersReservation.add(reserved);
        }
        return customersReservation;
    }

    public void printAllReservations(){
        Iterator<Reservation> iterator = reservations.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}
