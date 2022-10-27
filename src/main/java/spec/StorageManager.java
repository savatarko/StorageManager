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
    public void CreateStorage()
    {
        CreateStorage(defaultconfig);
    }

    public abstract void CreateStorage(Configuration configuration);

    public abstract void CreateDirectory(String path, String command);

    public abstract void StoreFile(String path, File file); //za ovo nisam siguran jos iskr, jel cemo da koristimo file ili nes drugo mozda, ostavi ovo za kasnije

    public abstract void DeleteFromStorage(String path);

    public abstract void MoveFile(String oldPath, String newPath);

    public abstract void DownloadFile(String sourcePath, String targetPath);

    public abstract void Rename(String path, String newName);
    //fje vezane za pretrazivanje

    public abstract List<String> GetFiles(String path);

    public abstract List<String> GetAllFiles(String path);

    public abstract List<String> GetAllSubFiles(String path);

    public abstract List<String> GetFilesType(String path, String extension);

    public abstract List<String> GetFilesContaining(String path, String name);

    public abstract List<String> GetFilesSorted(String path, String sort);

    public abstract List<String> GetFilesFrom(String path, String filter);


    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public StorageManager() {
    }

    public StorageManager(String storageLocation) {
        this.storageLocation = storageLocation;
    }
}
