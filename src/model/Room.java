package model;

import static service.ReservationService.reservationService;

public class Room implements IRoom{
    String roomNumber;
    Double price;
    RoomType enumeration;


    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    @Override
    public String toString() {
        return "Room number: " + roomNumber + "  Price: " + price + "€" + "  Room type: " +
                reservationService.bedsNumber(enumeration);
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }


    // Method used to sort rooms in ascending order
    @Override
    public int compareTo(IRoom o) {
        Integer thisInteger = Integer.parseInt(roomNumber);
        Integer integerObj = Integer.parseInt(o.getRoomNumber());
        return thisInteger.compareTo(integerObj);
    }
}
