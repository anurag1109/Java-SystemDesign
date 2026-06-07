package lld2.designPattern.behavioralDP.command.remoteCommand;

/**
 * RemoteControl - Invoker (sends commands to execute)
 * The remote control doesn't know what the command does
 * It just executes the command that is assigned to it
 */
public class RemoteControl {
    private Command command;

    /**
     * Assign a command to a button
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Press the button - executes the assigned command
     */
    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned!");
        }
    }
}
