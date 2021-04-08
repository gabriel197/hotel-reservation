package model;

import service.ReservationService;

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
                ReservationService.bedsNumber(enumeration);
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
        return this.roomNumber.compareTo(o.getRoomNumber());
    }


}
