package lld2.designPattern.behavioralDP.memento;

/**
 * Immutable Memento storing the state of the Originator
 */
public final class Memento {
    private final String content;
    private final int cursorPosition;

    public Memento(String content, int cursorPosition) {
        this.content = content;
        this.cursorPosition = cursorPosition;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }
}
