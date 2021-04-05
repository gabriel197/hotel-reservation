package model;

import service.CustomerService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        Customer customer = new Customer("Gabriel", "Maracine", "gabriel03@gmai.com");
        Room room = new Room("3", 55d, RoomType.SINGLE);
        Date dateIn = Calendar.getInstance().getTime();

        Calendar dateOut = Calendar.getInstance();
        dateOut.set(2021,Calendar.JANUARY,1);
        Date thisDAte = dateOut.getTime();
        Reservation reservation = new Reservation(customer, room, dateIn, thisDAte);

        System.out.println(reservation);

        Collection<Customer> x = CustomerService.getAllCustomers();
    }
}
