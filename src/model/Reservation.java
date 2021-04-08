package model;

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
                "\nRoom: " + room.getRoomNumber() + " - " + bedsNumber(room.getRoomType()) +
                "\nCheckIn Date: "+ checkInDate +"\nCheckOut Date: " + checkOutDate;
    }

    // Return appropriate description for bed
    private String bedsNumber(RoomType bed) {
        return switch (bed) {
            case DOUBLE -> "Double bed";
            case SINGLE -> "Single bed";
        };
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
}
