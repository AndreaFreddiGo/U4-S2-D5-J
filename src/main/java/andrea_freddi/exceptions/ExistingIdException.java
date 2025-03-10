package andrea_freddi.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//creo una eccezione personalizzata per l'id già esistente (e uso Logback per la visualizzazione dei log)
public class ExistingIdException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ExistingIdException.class);

    public ExistingIdException(String message) {
        super(message);
        logger.error(message);
    }
}
