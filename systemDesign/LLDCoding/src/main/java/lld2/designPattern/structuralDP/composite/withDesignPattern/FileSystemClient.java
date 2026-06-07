package lld2.designPattern.structuralDP.composite.withDesignPattern;

/**
 * FileSystemClient - Demonstrates Composite Design Pattern
 * 
 * Shows how Files and Directories can be treated uniformly
 * in a tree structure using the Composite pattern.
 */
public class FileSystemClient {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     COMPOSITE DESIGN PATTERN - FILE SYSTEM                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        // Create root directory
        Directory root = new Directory("root");

        // Create subdirectories
        Directory documents = new Directory("Documents");
        Directory photos = new Directory("Photos");
        Directory projects = new Directory("Projects");

        System.out.println("→ Creating directory structure...\n");

        // Add subdirectories to root
        root.add(documents);
        root.add(photos);
        root.add(projects);

        System.out.println("\n→ Adding files to Documents...\n");
        // Add files to documents
        documents.add(new File("Resume.pdf", 500));
        documents.add(new File("CoverLetter.docx", 300));

        System.out.println("\n→ Adding files to Photos...\n");
        // Add files to photos
        photos.add(new File("Vacation.jpg", 2500));
        photos.add(new File("Birthday.jpg", 3000));
        photos.add(new File("Family.png", 1500));

        System.out.println("\n→ Adding files and folders to Projects...\n");
        // Create nested structure
        Directory javaProjects = new Directory("JavaProjects");
        projects.add(javaProjects);
        javaProjects.add(new File("Main.java", 50));
        javaProjects.add(new File("Utils.java", 100));

        Directory pythonProjects = new Directory("PythonProjects");
        projects.add(pythonProjects);
        pythonProjects.add(new File("script.py", 75));

        System.out.println("\n" + "=".repeat(60));
        System.out.println("COMPLETE FILE SYSTEM STRUCTURE:");
        System.out.println("=".repeat(60) + "\n");

        // Display entire tree
        root.ls("");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("SIZE CALCULATION:");
        System.out.println("=".repeat(60));

        System.out.println("\n📊 Total size of root: " + root.getSize() + " KB");
        System.out.println("📊 Total size of Documents: " + documents.getSize() + " KB");
        System.out.println("📊 Total size of Photos: " + photos.getSize() + " KB");
        System.out.println("📊 Total size of Projects: " + projects.getSize() + " KB");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("KEY BENEFITS OF COMPOSITE PATTERN:");
        System.out.println("=".repeat(60));
        System.out.println("✓ Treat Files and Directories uniformly");
        System.out.println("✓ Build complex tree structures easily");
        System.out.println("✓ Recursive operations (display, size calculation)");
        System.out.println("✓ Add/remove components at runtime");
        System.out.println("✓ Single Responsibility - each class has one job");
    }
}
