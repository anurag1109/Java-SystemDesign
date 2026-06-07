package lld2.designPattern.structuralDP.composite.withDesignPattern;

/**
 * File - Leaf Component in Composite Pattern
 * 
 * A File is a leaf node in the tree structure.
 * It cannot contain other components (no add/remove).
 * It represents the end of the hierarchy.
 */
public class File extends FileSystemComponent {

    public File(String name, int size) {
        super(name, size);
    }

    /**
     * Get size - for a file, it's just its own size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Display the file with indentation to show hierarchy
     */
    @Override
    public void ls(String indent) {
        System.out.println(indent + "📄 " + name + " (" + size + " KB)");
    }

    /**
     * Cannot add to a file - it's a leaf
     */
    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add to a file!");
    }

    /**
     * Cannot remove from a file - it's a leaf
     */
    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a file!");
    }
}
