package errors;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException() {
        super("Order with this id doesn't exist");
    }
}
