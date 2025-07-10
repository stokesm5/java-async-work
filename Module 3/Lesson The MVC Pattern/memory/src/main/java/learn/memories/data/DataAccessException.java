package learn.memories.data;

//Checked exception because it extends Exception
public class DataAccessException  extends Exception{

    public DataAccessException(String message){
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
