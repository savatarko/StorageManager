package spec;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class StorageManager {


    protected static final String configname = new String("config.txt");

    protected String storageLocation = new String("");

    protected Configuration defaultconfig = new Configuration(Long.MAX_VALUE, new ArrayList<>(), 100);
    /**
     *
     * @return 0
     */

    //fje vezane za osnovne operacije

    /**
     * Initializes the storage on given path with default parameters
     * @param path path of the storage
     */
    public void CreateStorage(String path)
    {
        CreateStorage(defaultconfig, path);
    }

    /**
     * Initializes the storage with the provided configuration on given path
     * @param configuration configuration of the storage
     * @param path path of the stoage
     */
    public abstract void CreateStorage(Configuration configuration, String path);

    /**
     * Creates a directory on the given path. Path is given locally from the root directory. You can write the name of the directory as the
     * command, or you can write a bash-like command to make 1 or multiple directories. The method will take your arg as a command if you start with a $
     * Example: CreateDirectory(path, "dir") will make directory "dir" on the given path, meanwhile CreateDirectory(path, "$mkdir s{1..10}") will make 10
     * @param path local path from root where new directory is being made
     * @param command name or command to create new directory
     */
    public abstract void CreateDirectory(String path, String command);

    /**
     * Stores the file in the given path
     * @param path local path from root
     * @param file file that is stored
     */
    public abstract void StoreFile(String path, MyFile file); //za ovo nisam siguran jos iskr, jel cemo da koristimo file ili nes drugo mozda, ostavi ovo za kasnije

    /**
     * Deletes a file from the storage that is in the given path
     * @param path local path from root
     */
    public abstract void DeleteFromStorage(String path);

    /**
     * Moves a file from a path to a new one
     * @param oldPath local path to the file from root
     * @param newPath new path from root
     */
    public abstract void MoveFile(String oldPath, String newPath);

    /**
     * Download a file from the storage to your drive
     * @param sourcePath local path to the file
     * @param targetPath path on your machine where the file will be stored
     */
    public abstract void DownloadFile(String sourcePath, String targetPath);

    /**
     * Renames the file
     * @param path local path to the file
     * @param newName new name of the file
     */
    public abstract void Rename(String path, String newName);
    //fje vezane za pretrazivanje

    public abstract List<MyFile> GetFiles(String path);

    public abstract List<MyFile> GetAllFiles(String path);

    public abstract List<MyFile> GetAllSubFiles(String path);

    public abstract List<MyFile> GetFilesType(String path, String extension);

    public abstract List<MyFile> GetFilesContaining(String path, String name);

    public abstract List<MyFile> GetFilesSorted(String path, String sort);

    public abstract List<MyFile> GetFilesFrom(String path, String filter);


    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public StorageManager() {
    }

    public StorageManager(String storageLocation) {
        this.storageLocation = storageLocation;
    }
}
