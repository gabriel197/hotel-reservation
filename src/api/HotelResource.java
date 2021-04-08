package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import java.util.Collection;
import java.util.Date;

import static service.CustomerService.customerService;
import static service.ReservationService.reservationService;

public class HotelResource {

    public static final HotelResource hotelResource = new HotelResource();

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){

        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate );
    }

    public Collection<Reservation> getACustomerReservations(String customerEmail){
        return reservationService.getCustomersReservation(customerService.getCustomer(customerEmail));
    }

    public Collection<IRoom> searchSomeDaysAfter(int daysAfter, Date checkInDate, Date checkOutDate, boolean freeRoom) {
       return reservationService.searchXDaysAfter(daysAfter, checkInDate, checkOutDate, freeRoom);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut, boolean freeRooms){
        return reservationService.findRooms(checkIn, checkOut, freeRooms);
    }
}
