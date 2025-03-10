package andrea_freddi.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// creo una eccezione per tutti gli errori di inserimento dei dati (e uso Logback per la visualizzazione dei log)
public class NotExistingIdException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(NotExistingIdException.class);

    public NotExistingIdException(String message) {
        super(message);
        logger.error(message);
    }
}
