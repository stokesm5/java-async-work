package learn.exception;

// Unchecked Exception
public class RequiredStringException extends RuntimeException{

    public RequiredStringException(String message) {
        super(message);
    }
}
