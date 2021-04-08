package model;

import java.util.regex.Pattern;

// Customer class
public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    // Email pattern
    private static final String regEx = "^(.+)@(.+).(.+)$";

    // Compile the pattern
    private static final Pattern pattern = Pattern.compile(regEx);

    // Create new Customer
    public Customer(String firstName, String lastName, String email) throws IllegalArgumentException {

        this.firstName = firstName;
        this.lastName = lastName;
            if (pattern.matcher(email).matches()) this.email = email;
            else throw new IllegalArgumentException("Invalid email format, account creation failed.");
    }


    @Override
    public String toString() {
        return "Customer info: First Name: " + firstName + "  Last Name: " + lastName + "  Email: " + email;
    }

    // Generate custom hashcode for different class objects
    @Override
    public int hashCode() {
       return firstName.hashCode() * email.hashCode();
    }

    // Return true if two objects have the same hashes
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return customer.hashCode() == this.hashCode();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
