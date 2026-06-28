package lld2.designPattern.behavioralDP.memento;

/**
 * Demo client for Memento pattern
 */
public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        HistoryCaretaker history = new HistoryCaretaker();

        System.out.println("Initial: " + editor);

        // write and save
        editor.write("Hello");
        history.save(editor.save());
        System.out.println("After write 1: " + editor);

        // append more and save
        editor.write(", world");
        history.save(editor.save());
        System.out.println("After write 2: " + editor);

        // insert at beginning
        editor.setCursor(0);
        editor.write("Say: ");
        history.save(editor.save());
        System.out.println("After insert: " + editor);

        // undo twice
        System.out.println("\nPerforming undo operations:");
        Memento m1 = history.undo();
        if (m1 != null) {
            editor.restore(m1);
            System.out.println("Undo 1: " + editor);
        }
        Memento m2 = history.undo();
        if (m2 != null) {
            editor.restore(m2);
            System.out.println("Undo 2: " + editor);
        }

        // redo
        System.out.println("\nPerforming redo operation:");
        Memento r = history.redo();
        if (r != null) {
            editor.restore(r);
            System.out.println("Redo 1: " + editor);
        }
    }
}
