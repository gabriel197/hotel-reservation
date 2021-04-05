package model;

// Interface Room from which we can benefit from loose coupling between artifacts
public interface IRoom {

     String getRoomNumber();
     Double getRoomPrice();
     RoomType getRoomType();
     boolean isFree();
}
