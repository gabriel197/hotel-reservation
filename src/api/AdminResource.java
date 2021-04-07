package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static Room createRoom(String roomNumber, String price, RoomType roomType) throws NumberFormatException{
        return ReservationService.createARoom(roomNumber, price, roomType);
    }
    public static void addRoom(List<IRoom> rooms){
        for (IRoom room : rooms) {
            ReservationService.addRoom(room);
        }
    }
    public static Collection<IRoom> getAllRooms(){
        return ReservationService.getAllRooms();
    }

    public static Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }
    public static void displayAllReservations(){
        ReservationService.printAllReservations();
    }
}
