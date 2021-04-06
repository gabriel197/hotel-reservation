package model;

import java.util.regex.Pattern;

// Customer class
public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    // Email pattern
    String regEx = "^(.+)@(.+).(.+)$";

    // Compile the pattern
    Pattern pattern = Pattern.compile(regEx);

    public Customer(){}

    // Create new Customer
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (validEmail(email))
        this.email = email;
    }

    // Check if email have the correct pattern
    boolean validEmail(String email) {
        boolean isMatching = pattern.matcher(email).matches();
        if (!isMatching) throw new IllegalArgumentException("Invalid email format.");
        else return true;
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

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return customer.hashCode() == this.hashCode();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
