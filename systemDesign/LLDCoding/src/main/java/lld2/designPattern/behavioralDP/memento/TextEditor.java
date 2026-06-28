package lld2.designPattern.behavioralDP.memento;

/**
 * Originator in the Memento pattern. Represents a simple text editor.
 */
public class TextEditor {
    private String content;
    private int cursorPosition;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
    }

    public void write(String text) {
        // append text at cursor
        String before = content.substring(0, cursorPosition);
        String after = content.substring(cursorPosition);
        content = before + text + after;
        cursorPosition = before.length() + text.length();
    }

    public void setCursor(int position) {
        if (position < 0)
            position = 0;
        if (position > content.length())
            position = content.length();
        this.cursorPosition = position;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public Memento save() {
        return new Memento(content, cursorPosition);
    }

    public void restore(Memento m) {
        if (m == null)
            return;
        this.content = m.getContent();
        this.cursorPosition = m.getCursorPosition();
    }

    @Override
    public String toString() {
        return "TextEditor{content='" + content + "', cursor=" + cursorPosition + "}";
    }
}
