package exceptions;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(String message) {
        super("File on path: " +message + "not found");
    }
}
