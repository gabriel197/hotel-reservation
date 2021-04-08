package service;

import exceptions.CustomerNotFoundException;
import model.Customer;
import java.util.*;


public class CustomerService {
    // Singleton object for calling this class methods without the need to mark all of them static
    public static final CustomerService customerService = new CustomerService();


    // Store the customers in a collection
    private Map<String, Customer> customerMap = new HashMap<>();

    public void addCustomer(String email, String firstName, String lastName){
        try {
            customerMap.put(email, new Customer(firstName, lastName, email));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public Customer getCustomer(String customerEmail){
        try {
            if (!customerMap.containsKey(customerEmail)) throw new CustomerNotFoundException("Customer not found.");
        } catch (CustomerNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return customerMap.get(customerEmail);
    }


    public Collection<Customer> getAllCustomers(){
        return customerMap.values();
    }

}
