package andrea_freddi.exceptions;

//creo una eccezione personalizzata per il prezzo non valido
public class NotValidPriceException extends RuntimeException {
    public NotValidPriceException(String message) {
        super(message);
    }
}
