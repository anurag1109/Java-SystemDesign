package lld2.designPattern.behavioralDP.command.remoteCommandWithundo;

import java.util.Stack;

/**
 * RemoteControl - Invoker class
 * Executes commands and maintains undo/redo history
 * 
 * Features:
 * 1. execute() - executes a command and stores it in history
 * 2. undo() - reverses the last executed command
 * 3. redo() - re-executes the last undone command
 * 4. getHistory() - shows all executed commands
 */
public class RemoteControl {
    // Stack to store commands for undo
    private Command currentCommand; // Store the current command for reference
    private Stack<Command> undoStack = new Stack<>();

    // Stack to store undone commands for redo
    private Stack<Command> redoStack = new Stack<>();

    /**
     * Execute a command and store it in undo history
     * 
     * @param command The command to execute
     */

    public void setCommand(Command command) {
        this.currentCommand = command;
    }

    public void pressButton() {
        if (currentCommand != null) {
            currentCommand.execute();
            undoStack.push(currentCommand);

            // Clear redo stack when new command is executed
            if (!redoStack.isEmpty()) {
                redoStack.clear();
                System.out.println("  (Redo history cleared)");
            }

        } else {
            System.out.println("No command assigned!");
        }
    }

    // public void execute(Command command) {
    // System.out.println("\n→ Executing: " + command);
    // command.execute();

    // // Add to undo stack
    // undoStack.push(command);

    // // Clear redo stack when new command is executed
    // if (!redoStack.isEmpty()) {
    // redoStack.clear();
    // System.out.println(" (Redo history cleared)");
    // }
    // }

    /**
     * Undo the last executed command
     */
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("\n⚠️  Nothing to undo!");
            return;
        }

        Command command = undoStack.pop();
        System.out.println("\n↶ Undoing: " + command);
        command.undo();

        // Add to redo stack
        redoStack.push(command);
    }

    /**
     * Redo the last undone command
     */
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("\n⚠️  Nothing to redo!");
            return;
        }

        Command command = redoStack.pop();
        System.out.println("\n↷ Redoing: " + command);
        command.execute();

        // Add back to undo stack
        undoStack.push(command);
    }

    /**
     * Show the history of executed commands
     */
    public void showHistory() {
        System.out.println("\n📜 Command History (Undo Stack): " + undoStack.size() + " commands");
        if (undoStack.isEmpty()) {
            System.out.println("   Empty");
        } else {
            int count = 1;
            for (Command cmd : undoStack) {
                System.out.println("   " + count + ". " + cmd);
                count++;
            }
        }
    }

    /**
     * Show the redo history
     */
    public void showRedoHistory() {
        System.out.println("\n📜 Redo History: " + redoStack.size() + " commands");
        if (redoStack.isEmpty()) {
            System.out.println("   Empty");
        } else {
            int count = 1;
            for (Command cmd : redoStack) {
                System.out.println("   " + count + ". " + cmd);
                count++;
            }
        }
    }
}
