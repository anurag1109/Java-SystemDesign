package lld2.designPattern.behavioralDP.command.remoteCommandWithundo;

/**
 * CommandPatternWithUndoClient - Demonstrates Command Pattern with Undo/Redo
 * 
 * Shows how to:
 * 1. Execute commands
 * 2. Undo commands
 * 3. Redo commands
 * 4. View command history
 */
public class CommandPatternWithUndoClient {
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("   Command Design Pattern with Undo/Redo Functionality");
        System.out.println("============================================================");

        // Create the receiver (Light)
        Light light = new Light();

        // Create commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create the invoker (RemoteControl)
        RemoteControl remote = new RemoteControl();

        // ===== Test 1: Basic Execute =====
        System.out.println("\n▶ Test 1: Execute Commands");
        System.out.println("---");
        remote.setCommand(lightOn);
        remote.pressButton();
        remote.setCommand(lightOff);
        remote.pressButton();
        remote.setCommand(lightOn);
        remote.pressButton();
        remote.showHistory();

        // ===== Test 2: Undo =====
        System.out.println("\n\n▶ Test 2: Undo Last Command");
        System.out.println("---");
        remote.undo();
        remote.showHistory();
        remote.showRedoHistory();

        // ===== Test 3: Undo Multiple =====
        System.out.println("\n\n▶ Test 3: Undo Multiple Commands");
        System.out.println("---");
        remote.undo();
        remote.undo();
        remote.showHistory();
        remote.showRedoHistory();

        // ===== Test 4: Redo =====
        System.out.println("\n\n▶ Test 4: Redo Commands");
        System.out.println("---");
        remote.redo();
        remote.showHistory();
        remote.showRedoHistory();

        // ===== Test 5: Redo All =====
        System.out.println("\n\n▶ Test 5: Redo All");
        System.out.println("---");
        remote.redo();
        remote.redo();
        remote.showHistory();
        remote.showRedoHistory();

        // ===== Test 6: Execute New Command (Clears Redo) =====
        System.out.println("\n\n▶ Test 6: Execute New Command (Clears Redo Stack)");
        System.out.println("---");
        remote.setCommand(lightOff);
        remote.pressButton();
        remote.showHistory();
        remote.showRedoHistory();

        // ===== Test 7: Undo When Empty =====
        System.out.println("\n\n▶ Test 7: Undo When Empty");
        System.out.println("---");
        remote.undo();
        remote.undo();
        remote.undo();
        remote.undo();

        // ===== Test 8: Redo When Empty =====
        System.out.println("\n\n▶ Test 8: Redo When Empty");
        System.out.println("---");
        remote.redo();
        remote.redo();

        System.out.println("\n\n============================================================");
        System.out.println("   Key Concepts Demonstrated:");
        System.out.println("   ✓ Command Encapsulation");
        System.out.println("   ✓ Undo Functionality");
        System.out.println("   ✓ Redo Functionality");
        System.out.println("   ✓ Command History");
        System.out.println("============================================================\n");
    }
}
