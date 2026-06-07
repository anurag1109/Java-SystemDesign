package lld2.designPattern.behavioralDP.command.remoteCommand;

/**
 * Command Interface - Defines the contract for all commands
 * Each command will have an execute() method
 */
public interface Command {
    /**
     * Execute the command
     * Each concrete command will implement this method
     */
    void execute();
}
