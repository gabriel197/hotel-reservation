package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;


public class CustomerService {

    // Store the customers in a collection
    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void addCustomer(String email, String firstName, String lastName){
        customers.add(new Customer(firstName, lastName, email));
    }

    public static Customer getCustomer(String customerEmail){
        Customer customer = null;
        for (Customer person :
                customers) {
            if (person.getEmail().equals(customerEmail)) customer = person;
        }
        return customer;
    }

    public  static Collection<Customer> getAllCustomers(){
        return customers;
    };
}
