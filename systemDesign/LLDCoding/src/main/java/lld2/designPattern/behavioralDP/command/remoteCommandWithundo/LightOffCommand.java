package lld2.designPattern.behavioralDP.command.remoteCommandWithundo;

/**
 * LightOffCommand - Concrete Command
 * Encapsulates the request to turn light OFF
 * 
 * This command knows:
 * 1. What to do: turn light OFF
 * 2. Who to do it to: the light object (receiver)
 * 3. How to undo it: turn light ON
 */
public class LightOffCommand implements Command {
    private Light light;

    // Constructor takes the receiver (Light)
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }

    @Override
    public String toString() {
        return "Turn Light OFF";
    }
}
