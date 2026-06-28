package lld2.designPattern.behavioralDP.counterMemento;

/**
 * SimpleClientDemo - Demonstrates the SIMPLE Memento Pattern
 *
 * This is a beginner-friendly example using a simple Counter.
 *
 * The pattern has 3 parts:
 * 1. ORIGINATOR (SimpleCounter): The object we want to save/restore
 * 2. MEMENTO (SimpleMemento): A snapshot of the state
 * 3. CARETAKER (SimpleCaretaker): Manages the snapshots (undo/redo)
 */
public class SimpleClientDemo {
    public static void main(String[] args) {
        System.out.println("=== SIMPLE MEMENTO PATTERN DEMO ===\n");

        // Create originator and caretaker
        SimpleCounter counter = new SimpleCounter();
        SimpleCaretaker caretaker = new SimpleCaretaker();

        System.out.println("Step 1: Create counter at 0");
        System.out.println("Counter: " + counter);
        System.out.println();

        // Increment and save
        System.out.println("Step 2: Increment and save");
        counter.increment();
        System.out.println("Counter: " + counter);
        caretaker.save(counter.saveState());
        System.out.println();

        // Increment again and save
        System.out.println("Step 3: Increment again and save");
        counter.increment();
        System.out.println("Counter: " + counter);
        caretaker.save(counter.saveState());
        System.out.println();

        // Increment more and save
        System.out.println("Step 4: Increment more and save");
        counter.increment();
        counter.increment();
        System.out.println("Counter: " + counter);
        caretaker.save(counter.saveState());
        System.out.println();

        // Try to increment but then undo
        System.out.println("Step 5: Try to add 10 more, then undo");
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        System.out.println("Counter after 10 increments: " + counter);
        System.out.println();

        System.out.println("Step 6: UNDO - Go back to previous state");
        SimpleMemento memento1 = caretaker.undo();
        counter.restoreState(memento1);
        System.out.println("Counter after undo: " + counter);
        System.out.println();

        System.out.println("Step 7: UNDO again");
        SimpleMemento memento2 = caretaker.undo();
        counter.restoreState(memento2);
        System.out.println("Counter after 2nd undo: " + counter);
        System.out.println();

        System.out.println("Step 8: REDO - Go forward");
        SimpleMemento memento3 = caretaker.redo();
        counter.restoreState(memento3);
        System.out.println("Counter after redo: " + counter);
        System.out.println();

        System.out.println("✓ Memento pattern allows us to SAVE and RESTORE state!\n");
    }
}
