package model;

import service.CustomerService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class Tester {
    public static void main(String[] args) {
//        Customer customer = new Customer("Gabriel", "Maracine", "gabriel03@gmai.com");
//        Room room = new Room("3", 55d, RoomType.SINGLE);
//        Date dateIn = Calendar.getInstance().getTime();
//
//        Calendar dateOut = Calendar.getInstance();
//        dateOut.set(2021,Calendar.JANUARY,1);
//        Date thisDAte = dateOut.getTime();
//        Reservation reservation = new Reservation(customer, room, dateIn, thisDAte);

//        System.out.println(reservation);
        Object object = new FreeRoom("2", RoomType.DOUBLE);
        FreeRoom freeRoom = new FreeRoom("2", RoomType.DOUBLE);
        System.out.println(object.equals(freeRoom));
        int x = object.hashCode();
        int y = freeRoom.hashCode();
        Object customer = new Customer("a", "b", "a@a.com");
        x = customer.hashCode();
        Customer customer1 = new Customer("a", "b", "a@a.com");
        y = customer1.hashCode();

        System.out.println(x + " " + y);



    }
}
