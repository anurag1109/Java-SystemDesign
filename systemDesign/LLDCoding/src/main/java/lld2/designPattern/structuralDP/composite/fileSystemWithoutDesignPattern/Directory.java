package lld2.designPattern.structuralDP.composite.fileSystemWithoutDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private String name;
    private List<Object> contents; // Can contain both Files and Directories

    public Directory(String name) {
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(Object obj) {
        contents.add(obj);
    }

    public void ls() {
        System.out.println("Directory: " + name);

        // List contents of the directory
        // problem: we have to check the type of each object in contents to determine if
        // it's a File or Directory if we are not using the Composite design pattern
        for (Object obj : contents) {
            if (obj instanceof File) {
                ((File) obj).ls();
            } else if (obj instanceof Directory) {
                ((Directory) obj).ls();
            }
        }
    }

}
