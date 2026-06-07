package lld2.designPattern.structuralDP.composite.fileSystemWithoutDesignPattern;

public class Client {

    public static void main(String[] args) {
        // Create files
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");

        // Create directories
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        // Build the file system structure
        dir1.add(file1);
        dir1.add(file2);
        dir2.add(file3);
        dir1.add(dir2);

        // List contents of dir1
        System.out.println("Contents of dir1:");
        dir1.ls();

        // List contents of dir2
        System.out.println("\nContents of dir2:");
        dir2.ls();
    }

}
