package exceptions;

public class StorageCountLimitException extends Exception{
    public StorageCountLimitException(String message) {
        super("Directory file count exceded");
    }
}
