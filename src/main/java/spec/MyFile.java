package spec;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

@Getter
@Setter

public class MyFile {
    private File file;
    private String type;
    private String createtime;
    private String modtime;
    private String size;

    public MyFile(File file, String type) {
        this.file = file;
        this.type = type;
        Path path = Paths.get(file.getAbsolutePath().toString().replaceAll("\\\\", "/"));
        try {
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            createtime = attrs.creationTime().toString();
            modtime = attrs.lastModifiedTime().toString();
            size = Long.toString(attrs.size());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            createtime = "0";
            modtime = "0";
            size = "0";
        }
    }

    public MyFile(File file, String type, String createtime, String modtime, String size) {
        this.file = file;
        this.type = type;
        this.createtime = createtime;
        this.modtime = modtime;
        this.size = size;
    }
}


