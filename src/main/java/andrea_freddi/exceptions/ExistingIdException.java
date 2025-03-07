package andrea_freddi.exceptions;

//creo una eccezione personalizzata per l'id già esistente
public class ExistingIdException extends RuntimeException {
    public ExistingIdException(String message) {
        super(message);
    }
}
