package lld2.designPattern.structuralDP.composite.fileSystemWithDesignPattern;

public class File implements FileSystem {

    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void ls(String indent) {
        System.out.println(indent + name);
    }

}
