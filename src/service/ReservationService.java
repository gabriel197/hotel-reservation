package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ReservationService {
    // Store a list of rooms in a collection
    ArrayList<IRoom> roomList = new ArrayList<>();

    // Store rooms with their checkin and out dates
    ArrayList<Reservation> reservations = new ArrayList<>();
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
        reservations.add(reserv);
        return reserv;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {


    }
}
