package model;

import java.util.regex.Pattern;

// Customer class
public class Customer {
    private String firstName;
    private String lastName;
    private String email;

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

    // Check if email have the correct pattern
//     public static boolean checkEmail(String email) {
//        boolean isMatching = pattern.matcher(email).matches();
//        try {
//            if (!isMatching) throw new IllegalArgumentException("Invalid email format.");
//        } catch (IllegalArgumentException ex) {
//            System.out.println(ex.getLocalizedMessage());
//        }
//        return isMatching;
//    }

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
