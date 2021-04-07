package model;

import java.util.Comparator;

// Interface Room from which we can benefit from loose coupling between classes
public interface IRoom extends Comparable<IRoom> {

     String getRoomNumber();
     Double getRoomPrice();
     RoomType getRoomType();
     boolean isFree();

     void setRoomNumber(String roomNumber);
     void setPrice(Double price);
     void setEnumeration(RoomType enumeration);
}

