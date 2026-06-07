package lld2.designPattern.structuralDP.composite.withDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Directory - Composite Component in Composite Pattern
 * 
 * A Directory can contain both Files and other Directories.
 * It maintains a list of child components and can recursively
 * calculate total size and display the entire tree structure.
 */
public class Directory extends FileSystemComponent {
    // List to store child components (Files and Directories)
    private List<FileSystemComponent> contents = new ArrayList<>();

    public Directory(String name) {
        super(name, 0); // Directories don't have a predefined size
    }

    /**
     * Add a component (File or Directory) to this directory
     */
    @Override
    public void add(FileSystemComponent obj) {
        contents.add(obj);
        System.out.println("  ✓ Added " + obj.getName() + " to " + this.name);
    }

    /**
     * Remove a component from this directory
     */
    @Override
    public void remove(FileSystemComponent obj) {
        contents.remove(obj);
        System.out.println("  ✓ Removed " + obj.getName() + " from " + this.name);
    }

    /**
     * Get total size - recursively sum all contents sizes
     * This demonstrates the power of Composite pattern!
     */
    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : contents) {
            totalSize += component.getSize(); // Calls getSize on each child recursively
        }
        return totalSize;
    }

    /**
     * Display directory and all its contents recursively
     */
    @Override
    public void ls(String indent) {
        System.out.println(indent + "📁 " + name + "/");

        // Display all contents with increased indentation
        for (FileSystemComponent component : contents) {
            component.ls(indent + "   ");
        }
    }

    /**
     * Get list of child components
     */
    public List<FileSystemComponent> getChildren() {
        return contents;
    }
}
