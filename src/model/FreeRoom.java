package model;

import service.ReservationService;

// A free room with price = 0;
public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, 0d, roomType);
    }

    @Override
    public String toString() {
        return "Free Room - " + "Number: " + roomNumber + " Price: " + price + "€" + "  Room type: " + ReservationService.bedsNumber(enumeration);
    }

    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public int compareTo(IRoom o) {
        return super.compareTo(o);
    }
}
