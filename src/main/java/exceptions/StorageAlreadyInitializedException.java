package exceptions;

public class StorageAlreadyInitializedException extends RuntimeException{
    public StorageAlreadyInitializedException(String message) {
        super("The file " + message + " is already a storage.");
    }
}
