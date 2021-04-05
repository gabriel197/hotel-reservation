package model;

import java.util.Date;

public class Reservation {
    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

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
}
