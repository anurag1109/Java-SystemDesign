package lld2.designPattern.behavioralDP.command.remoteCommandWithundo;

/**
 * LightOnCommand - Concrete Command
 * Encapsulates the request to turn light ON
 * 
 * This command knows:
 * 1. What to do: turn light ON
 * 2. Who to do it to: the light object (receiver)
 * 3. How to undo it: turn light OFF
 */
public class LightOnCommand implements Command {
    private Light light;

    // Constructor takes the receiver (Light)
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

    @Override
    public String toString() {
        return "Turn Light ON";
    }
}
