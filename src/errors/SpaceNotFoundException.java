package errors;

public class SpaceNotFoundException extends RuntimeException{
    public SpaceNotFoundException() {
        super("entities.Space with this id doesn't exist");
    }
}
