package lld2.designPattern.behavioralDP.counterMemento;

/**
 * SimpleCounter - The ORIGINATOR
 *
 * This object has state that we want to save and restore.
 * It can create a Memento (snapshot) of its current state.
 * It can restore itself from a Memento.
 */
public class SimpleCounter {
    private int value;

    public SimpleCounter() {
        this.value = 0;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }

    /**
     * SAVE: Create a snapshot (Memento) of current state
     */
    public SimpleMemento saveState() {
        System.out.println("  [SAVE] Creating snapshot of value: " + value);
        return new SimpleMemento(value);
    }

    /**
     * RESTORE: Go back to a previous state using a Memento
     */
    public void restoreState(SimpleMemento memento) {
        if (memento == null) {
            System.out.println("  [RESTORE] No memento to restore!");
            return;
        }
        this.value = memento.getValue();
        System.out.println("  [RESTORE] Restored to value: " + value);
    }

    @Override
    public String toString() {
        return "Counter(value=" + value + ")";
    }
}
