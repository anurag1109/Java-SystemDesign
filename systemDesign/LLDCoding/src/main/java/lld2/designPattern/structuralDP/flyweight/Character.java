package lld2.designPattern.structuralDP.flyweight;

/**
 * Character - Flyweight class
 * Represents a single character in the word processor
 * 
 * This is the shared (intrinsic) state - same for all instances
 * Example: Character 'A' always has font Arial, size 12
 */
public class Character {
    private char value;
    private String font;
    private int size;
    private String color;

    public Character(char value, String font, int size, String color) {
        this.value = value;
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public char getValue() {
        return value;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return value + "";
    }

    public void display(int row, int column) {
        System.out.println("Character '" + value + "' at (" + row + ", " + column +
                ") - Font: " + font + ", Size: " + size + ", Color: " + color);
    }
}
