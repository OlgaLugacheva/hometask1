package hometask1;

/**
 * Created by Olga on 12.02.2017.
 */
public class SymbolException extends Exception {

    public SymbolException() {
    }

    public SymbolException(String message) {
        super(message);
    }

    public SymbolException(Throwable cause) {
        super(cause);
    }

    public SymbolException(String message, Throwable cause) {
        super(message, cause);
    }

    public SymbolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message);
    }
}
