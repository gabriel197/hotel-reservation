package model;

/**
 * Interface Room from which we can benefit from loose coupling between classes
 * extends Comparable interface in order to be able to sort rooms from collections in ascending order
 */
public interface IRoom extends Comparable<IRoom> {

     String getRoomNumber();
     Double getRoomPrice();
     RoomType getRoomType();
     boolean isFree();

}
