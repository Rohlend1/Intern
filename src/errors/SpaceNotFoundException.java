package errors;

public class SpaceNotFoundException extends RuntimeException{
    public SpaceNotFoundException() {
        super("Space with this id doesn't exist");
    }
}
