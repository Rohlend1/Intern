package errors;

public class MechanicNotFoundException extends RuntimeException{
    public MechanicNotFoundException() {
        super("entities.Space with this id doesn't exist");
    }
}
