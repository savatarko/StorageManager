package local;

import exceptions.FileNotFoundException;
import spec.Configuration;
import spec.MyFile;
import spec.StorageManager;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalDrive extends StorageManager
{

    public static void main(String[] args) {
        LocalDrive ld=new LocalDrive();
        Configuration config=new Configuration(123,"txt",50);
        ld.CreateStorage(config,"C:/Users/user/Desktop/asdefgh/");
        //System.out.println(ld.storageLocation);
        ld.CreateDirectory("","leale");
        ld.CreateDirectory("","leale2");
        System.out.println(ld.Locate("doc.docx"));


    }

    @Override
    public void CreateStorage(Configuration configuration, String path) {


        this.storageLocation=path;
        this.currentconfig=configuration;

        try{
            File f=new File(path);
            f.mkdir();
            java.io.File file = new java.io.File(path + "/config.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(configuration.toString());
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void LoadStorage(String path) {

    }

    @Override
    public void CreateDirectory(String path, String name) {
       try {

           File f=new File(storageLocation + path);
           if(!f.exists()){
               throw new FileNotFoundException(storageLocation + path);
           }

           f=new File(storageLocation + path + name);
           f.mkdir();

       } catch(Exception e){
           e.printStackTrace();
       }


    }

    @Override
    public void StoreFile(String path, MyFile file) {
      try {



      } catch (Exception e){
          e.printStackTrace();
      }

    }

    @Override
    public void DeleteFromStorage(String path) {


       try{
           File f=new File(path);

          if(!f.exists()){
              throw new FileNotFoundException(path);
          }

          f.delete();

       } catch (Exception e) {
           e.printStackTrace();
       }


    }

    @Override
    public void MoveFile(String oldPath, String newPath) {
       try{
           File f=new File(oldPath);
           f.renameTo(new File(newPath));
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void DownloadFile(String sourcePath, String targetPath) {
        try{
            File f=new File(sourcePath);
            f.renameTo(new File(targetPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Rename(String path, String newName) {

        File f=new File(path);
        f.renameTo(new File(f.getParent() + "/" + newName));


    }

    @Override
    public List<MyFile> GetFiles(String path) {
        List<MyFile> out=new ArrayList<>();
        try {
            File f=new File(path);
            List<File> files= List.of(f.listFiles());

            for(File i: files){
               MyFile myf=new MyFile(i);
               out.add(myf);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return out;
    }

    @Override
    public List<MyFile> GetAllFiles(String path) {
        return null;
    }

    @Override
    public List<MyFile> GetAllSubFiles(String path) {
        return null;
    }

    @Override
    public List<MyFile> GetFilesType(String path, String extension) {

        List<MyFile> out=new ArrayList<>();
        List<String> ext=new ArrayList<>();
        ext.addAll(Arrays.stream(extension.split(",")).toList());
        try {
            File f=new File(path);
            List<File> files= List.of(f.listFiles());

            for(File i: files){
                String[] s;
                if(!i.isDirectory()) {
                    s = i.getName().split("\\.");
                    if(ext.contains(s[1])){
                        MyFile myf=new MyFile(i);
                        out.add(myf);
                    }
                }

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return out;
    }

    @Override
    public List<MyFile> GetFilesNamed(String path, String name) {
        List<MyFile> out=new ArrayList<>();
        try {
            File f=new File(path);
            List<File> files= List.of(f.listFiles());

            for(File i: files){
                MyFile myf=new MyFile(i);

                if(myf.toString().contains(name))
                   out.add(myf);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return out;
    }

    @Override
    public boolean IsContained(String path, List<String> filenames) {

        int rez=0,j=filenames.size();

        try {
            File f=new File(path);
            List<File> files= List.of(f.listFiles());

            for(File i: files){
               if(filenames.contains(i.getName()))
                   rez++;

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return rez==j;
    }

    @Override
    public String Locate(String name) {
        String out=null;
        List<File> files=new ArrayList<>();
       files=ListAllFiles(files,new File(storageLocation));

       for(File f:files){
           if(f.getName().equals(name))
               out=f.getPath();

       }

        return out;
    }

    public List<File> ListAllFiles(List<File> files,File root){
          List<File> subFiles=List.of(root.listFiles());

          for(File f: subFiles){
              if(f.isDirectory()){
                  files=ListAllFiles(files,f);
              }
              else {
                  files.add(f);
              }


          }

        return files;
    }

    @Override
    public List<MyFile> GetFilesTime(String path, String begintime, String endtime) {
        return null;
    }


}
