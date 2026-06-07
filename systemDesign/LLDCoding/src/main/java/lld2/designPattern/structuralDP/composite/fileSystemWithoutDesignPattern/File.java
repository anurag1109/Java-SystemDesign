package lld2.designPattern.structuralDP.composite.fileSystemWithoutDesignPattern;

public class File {

    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void ls() {
        System.out.println("File: " + name);
    }

}
