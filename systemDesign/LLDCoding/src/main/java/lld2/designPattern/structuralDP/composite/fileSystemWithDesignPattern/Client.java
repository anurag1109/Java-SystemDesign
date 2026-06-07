package lld2.designPattern.structuralDP.composite.fileSystemWithDesignPattern;

public class Client {

    public static void main(String[] args) {
        // Create files
        File myResume = new File("myResume.pdf");
        File vacation = new File("vacation.jpg  ");
        File beach = new File("beach.jpg");

        // Create directories
        Directory root = new Directory("root");
        Directory photos = new Directory("photos");
        Directory resume = new Directory("resume");

        // Build the file system structure
        root.add(photos);
        root.add(resume);

        photos.add(vacation);
        photos.add(beach);
        resume.add(myResume);

        // List contents of root
        System.out.println("Contents of root:");
        root.ls("");

    }

}
