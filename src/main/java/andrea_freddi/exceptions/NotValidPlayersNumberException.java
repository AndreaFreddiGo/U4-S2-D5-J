package andrea_freddi.exceptions;

//creo una eccezione personalizzata per il numero di giocatori non valido
public class NotValidPlayersNumberException extends RuntimeException {
    public NotValidPlayersNumberException(String message) {
        super(message);
    }
}
