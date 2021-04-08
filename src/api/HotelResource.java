package api;

import exceptions.RoomNotFoundException;
import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName){
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomNumber) {
        return ReservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){

        return ReservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate );
    }

    public static Collection<Reservation> getACustomerReservations(String customerEmail){
        return ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail));


    }

    public static Collection<IRoom> searchSomeDaysAfter(int daysAfter, Date checkInDate, Date checkOutDate, boolean freeRoom) {
       return ReservationService.searchXDaysAfter(daysAfter, checkInDate, checkOutDate, freeRoom);
    }

    // TODO: Allow the users to input how many days out the room recommendation should
    //  search if there are no available rooms.
    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut, boolean freeRooms){
        return ReservationService.findRooms(checkIn, checkOut, freeRooms);
    }
}
