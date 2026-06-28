package lld2.designPattern.behavioralDP.counterMemento;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleCaretaker - The CARETAKER
 *
 * This manages the collection of Mementos (history).
 * It doesn't care what's inside the Mementos.
 * It just stores and retrieves them when undo/redo is needed.
 */
public class SimpleCaretaker {
    private List<SimpleMemento> history = new ArrayList<>();
    private int currentIndex = -1;

    /**
     * SAVE: Store a new Memento in history
     */
    public void save(SimpleMemento memento) {
        // Remove any forward history (if user did something after undoing)
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }
        history.add(memento);
        currentIndex = history.size() - 1;
        System.out.println("  [CARETAKER] Saved snapshot. Total snapshots: " + history.size());
    }

    /**
     * UNDO: Get the previous Memento from history
     */
    public SimpleMemento undo() {
        if (currentIndex <= 0) {
            System.out.println("  [CARETAKER] Cannot undo - at the beginning!");
            return null;
        }
        currentIndex--;
        System.out.println("  [CARETAKER] Undo performed. Current index: " + currentIndex);
        return history.get(currentIndex);
    }

    /**
     * REDO: Get the next Memento from history
     */
    public SimpleMemento redo() {
        if (currentIndex >= history.size() - 1) {
            System.out.println("  [CARETAKER] Cannot redo - at the end!");
            return null;
        }
        currentIndex++;
        System.out.println("  [CARETAKER] Redo performed. Current index: " + currentIndex);
        return history.get(currentIndex);
    }

    public boolean canUndo() {
        return currentIndex > 0;
    }

    public boolean canRedo() {
        return currentIndex < history.size() - 1;
    }

    @Override
    public String toString() {
        return "Caretaker(snapshots=" + history.size() + ", current=" + currentIndex + ")";
    }
}
