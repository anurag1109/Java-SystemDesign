package lld2.designPattern.behavioralDP.counterMemento;

/**
 * SimpleMemento - A simple snapshot of Counter state
 *
 * This is the MEMENTO: It stores just the value we care about
 * It's immutable (can't be changed after creation)
 */
public final class SimpleMemento {
    private final int value;

    public SimpleMemento(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Memento(value=" + value + ")";
    }
}
