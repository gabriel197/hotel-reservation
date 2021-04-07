package exceptions;

public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException(String message){
        super(message);
    }

    @Override
    public String toString() {
        return "Customer not found.";
    }


}
