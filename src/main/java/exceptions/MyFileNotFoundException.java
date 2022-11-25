package exceptions;

public class MyFileNotFoundException extends RuntimeException{
    public MyFileNotFoundException(String message) {
        super("File on path: " +message + " not found");
    }
}
