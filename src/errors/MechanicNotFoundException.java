package errors;

public class MechanicNotFoundException extends RuntimeException{
    public MechanicNotFoundException() {
        super("Mechanic with this id doesn't exist");
    }
}
