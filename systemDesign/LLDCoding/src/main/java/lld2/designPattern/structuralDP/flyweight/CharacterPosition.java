package lld2.designPattern.structuralDP.flyweight;

/**
 * CharacterPosition - Stores extrinsic state (position)
 * 
 * Intrinsic state (shared): Character object (value, font, size, color)
 * Extrinsic state (unique): Position (row, column) where character appears
 * 
 * This separation allows sharing of character objects while maintaining
 * different positions for each occurrence
 */
public class CharacterPosition {
    private Character character; // Intrinsic state (shared)
    private int row; // Extrinsic state (unique)
    private int column; // Extrinsic state (unique)

    public CharacterPosition(Character character, int row, int column) {
        this.character = character;
        this.row = row;
        this.column = column;
    }

    public Character getCharacter() {
        return character;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void display() {
        character.display(row, column);
    }
}
