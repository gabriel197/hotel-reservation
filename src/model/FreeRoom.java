package model;

// A free room with price = 0;
public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, 0d, roomType);
    }

    @Override
    public String toString() {
        return "Free Room: " + " Price: " + price + "€" + "  Room type: " + enumeration;
    }

    @Override
    public boolean isFree() {
        return true;
    }

}
