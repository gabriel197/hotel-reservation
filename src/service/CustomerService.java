package service;

import exceptions.CustomerNotFoundException;
import model.Customer;

import java.util.*;


public class CustomerService {

    // Store the customers in a collection
    static Map<String, Customer> customerMap = new HashMap<>();

    public static void addCustomer(String email, String firstName, String lastName){
        try {
            customerMap.put(email, new Customer(firstName, lastName, email));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public static Customer getCustomer(String customerEmail){
        try {
            if (!customerMap.containsKey(customerEmail)) throw new CustomerNotFoundException("Customer not found.");
        } catch (CustomerNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return customerMap.get(customerEmail);
    }


    public  static Collection<Customer> getAllCustomers(){
        return customerMap.values();
    }

}
