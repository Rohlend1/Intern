package errors;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException() {
        super("entities.Space with this id doesn't exist");
    }
}
