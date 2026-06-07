package lld2.designPattern.behavioralDP.command.remoteCommandWithundo;

/**
 * Command - Interface
 * Defines the contract for all commands
 * 
 * All commands must implement:
 * 1. execute() - to perform the action
 * 2. undo() - to reverse the action
 */
public interface Command {
    /**
     * Execute the command
     */
    void execute();

    /**
     * Undo the command
     */
    void undo();
}
