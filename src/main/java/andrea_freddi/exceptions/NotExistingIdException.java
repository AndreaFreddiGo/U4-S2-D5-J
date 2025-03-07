package andrea_freddi.exceptions;

public class NotExistingIdException extends RuntimeException {
    public NotExistingIdException(String message) {
        super(message);
    }
}
