package model;

public class Room implements IRoom{
    String roomNumber;
    Double price;
    RoomType enumeration;


    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

//    public Room(Double price, RoomType roomType) {
//        this.price = price;
//        enumeration = roomType;
//    }



    @Override
    public String toString() {
        return "Room number: " + roomNumber + "  Price: " + price + "€" + "  Room type: " + enumeration;
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
        System.out.println("doing somethig");
        return false;
    }

    @Override
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void setPrice(Double price) {
this.price = price;
    }

    @Override
    public void setEnumeration(RoomType enumeration) {
this.enumeration = enumeration;
    }

    // Method used to sort rooms in asccending order
    @Override
    public int compareTo(IRoom o) {
        return roomNumber.compareTo(o.getRoomNumber());
    }


}
