package spec;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

public abstract class StorageManager {


    protected static final String configname = new String("config.txt");

    protected String storageLocation = new String("");

    protected Configuration defaultconfig = new Configuration(Long.MAX_VALUE, new ArrayList<>(), 100);

    protected Configuration currentconfig;
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


    public abstract void LoadStorage(String path);

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

    public abstract List<MyFile> GetFilesNamed(String path, String name);

    public abstract boolean IsContained(String path, List<String> filenames);

    public abstract String Locate(String name);

    public abstract List<MyFile> GetFilesTime(String path, String begintime, String endtime);

    public List<MyFile> GetFilesTime(String path, String begintime)
    {
        return GetFilesTime(path, begintime, LocalDateTime.now().toString());
    }

    /**
     * Sort the list of files with arguments
     * regex for sorting:
     * name-> by file name
     * creation -> by file creation
     * modification -> by file modification
     * use asc for ascending or desc for descending, if you don't define the order, the default order is ascending
     * if you want to use multiple parameters for sorting (in case of a equals), split them with a coma
     * @param files list of files to be sorted
     * @param sort parameters for sorting
     * @return sorted list of files
     */
    public List<MyFile> SortResult(List<MyFile> files, String sort)
    {
        return null;
    }

    /**
     * Filter the result to contain only info you need about the file
     * Possible parameters:
     * name -> name of the file
     * path -> path to the file
     * createtime -> when was the file created
     * type -> type of file (extension)
     * modtime -> when was the file last modified
     * size -> size of the file
     * Split parameters with a coma
     * @param files list of files
     * @param filter parameters that you need
     * @return list that contains strings that have all the info requested
     */
    public List<String> FilterResult(List<MyFile> files, String filter)
    {
        List<String> output = new ArrayList<>();
        Map<String, List<String>> result = new HashMap<>();
        for(var i : files)
        {
            result.get("name").add(i.getFile().getName());
            result.get("path").add(i.getFile().getPath());
            result.get("createtime").add(i.getCreatetime());
            result.get("type").add(i.getType());
            result.get("modtime").add(i.getModtime());
            result.get("size").add(i.getSize());
        }

        String[] split = filter.split(",");
        for(int i = 0;i<files.size();i++)
        {
            String temp = "";
            for(var j : split)
            {
                temp = temp.concat(result.get(j).get(i) + " ");
            }
            if(temp.length() > 0)
            {
                temp = temp.substring(0, temp.length() - 1);
                output.add(temp);
            }
        }
        return output;
    }
}
