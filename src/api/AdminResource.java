package api;

import model.*;
import service.CustomerService;
import java.util.Collection;
import java.util.List;

import static service.CustomerService.customerService;
import static service.ReservationService.reservationService;

public class AdminResource {

    public static final AdminResource adminResource = new AdminResource();

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public IRoom createRoom(String roomNumber, String price, RoomType roomType) throws NumberFormatException{
        return reservationService.createARoom(roomNumber, price, roomType);
    }
    public void addRoom(List<IRoom> rooms){
        for (IRoom room : rooms) {
            reservationService.addRoom(room);
        }
    }
    public Collection<IRoom> getAllRooms(){
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    public void displayAllReservations(){
        reservationService.printAllReservations();
    }
}
