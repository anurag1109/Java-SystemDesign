package lld2.designPattern.structuralDP.composite.withDesignPattern;

/**
 * FileSystemComponent - Abstract Component for Composite Pattern
 * 
 * This is the common interface for both File and Directory.
 * It defines operations that can be performed on both leaf (File) and
 * composite (Directory) objects.
 * 
 * Key Concept: Both File and Directory implement the same interface,
 * allowing them to be treated uniformly in a tree structure.
 */
public abstract class FileSystemComponent {
    protected String name;
    protected int size; // in KB

    public FileSystemComponent(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Get the name of this component
     */
    public String getName() {
        return name;
    }

    /**
     * Get the total size (for files, it's the file size;
     * for directories, it's the sum of all contents)
     */
    public abstract int getSize();

    /**
     * Display the component (with proper indentation for hierarchy)
     */
    public abstract void ls(String indent);

    /**
     * Add a component (only Directory implements this meaningfully)
     */
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add to this component");
    }

    /**
     * Remove a component (only Directory implements this meaningfully)
     */
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove from this component");
    }
}
