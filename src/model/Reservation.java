package model;

import service.ReservationService;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Reservation {
    // Class variables can be final because we don't have setter methods neither overloaded constructors
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Create a nice looking resume of the reservation
    @Override
    public String toString() {
        return "\n- Reservation:\n" + customer.getFirstName() + " " + customer.getLastName() +
                "\nRoom: " + room.getRoomNumber() + " - " + ReservationService.bedsNumber(room.getRoomType()) +
                "\nCheckIn Date: "+ dateFormat(checkInDate) +"\nCheckOut Date: " + dateFormat(checkOutDate);
    }



    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    private String dateFormat(Date dateToFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateToFormat);
        return sdf.format(calendar.getTime());
    }
}
