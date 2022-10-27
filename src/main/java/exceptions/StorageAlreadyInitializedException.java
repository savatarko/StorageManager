package exceptions;

public class StorageAlreadyInitializedException extends Exception{
    public StorageAlreadyInitializedException(String message) {
        super("The file " + message + " is already a storage.");
    }
}
