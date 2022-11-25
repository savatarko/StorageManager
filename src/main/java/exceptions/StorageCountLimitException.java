package exceptions;

public class StorageCountLimitException extends RuntimeException{
    public StorageCountLimitException(String message) {
        super("Directory file count exceded");
    }
}
