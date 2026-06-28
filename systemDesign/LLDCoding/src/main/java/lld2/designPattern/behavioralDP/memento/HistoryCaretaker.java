package lld2.designPattern.behavioralDP.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Caretaker that keeps a history of Mementos and supports undo/redo
 */
public class HistoryCaretaker {
    private final List<Memento> history = new ArrayList<>();
    private int current = -1;

    public void save(Memento m) {
        // discard any forward history
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }
        history.add(m);
        current = history.size() - 1;
    }

    public boolean canUndo() {
        return current > 0;
    }

    public boolean canRedo() {
        return current < history.size() - 1;
    }

    public Memento undo() {
        if (!canUndo())
            return null;
        current--;
        return history.get(current);
    }

    public Memento redo() {
        if (!canRedo())
            return null;
        current++;
        return history.get(current);
    }

    public int getCurrentIndex() {
        return current;
    }

    public List<Memento> all() {
        return new ArrayList<>(history);
    }
}
