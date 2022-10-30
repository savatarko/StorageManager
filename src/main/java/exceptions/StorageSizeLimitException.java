package exceptions;

public class StorageSizeLimitException extends Exception{
    public StorageSizeLimitException(String message) {
        super("Storage size exceded");
    }
}
