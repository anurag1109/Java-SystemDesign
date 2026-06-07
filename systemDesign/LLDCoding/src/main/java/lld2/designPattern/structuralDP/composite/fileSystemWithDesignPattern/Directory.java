package lld2.designPattern.structuralDP.composite.fileSystemWithDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private String name;
    private List<FileSystem> contents; // Can contain both Files and Directories

    public Directory(String name) {
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(FileSystem fileSystem) {
        contents.add(fileSystem);
    }

    public void ls(String indent) {
        System.out.println(indent + name + "/");

        // List contents of the directory
        // we don't have to check the type of each object in contents to determine if
        // it's a File or Directory if we are using the Composite design pattern as both
        // File and Directory implement the same interface FileSystem
        for (FileSystem fileSystem : contents) {
            fileSystem.ls(indent + "  ");
        }
    }

}
