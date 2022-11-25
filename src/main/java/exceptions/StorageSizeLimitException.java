package exceptions;

public class StorageSizeLimitException extends RuntimeException{
    public StorageSizeLimitException(String message) {
        super("Storage size exceded");
    }
}
