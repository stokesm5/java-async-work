package learn.exception;

// Checked Exception
public class NegativeValueException extends Exception{
    public NegativeValueException(String message) {
        super(message);
    }
}
