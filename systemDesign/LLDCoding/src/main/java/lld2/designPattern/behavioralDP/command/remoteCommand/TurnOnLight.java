package lld2.designPattern.behavioralDP.command.remoteCommand;

/**
 * TurnOnLight - Concrete Command
 * This command encapsulates the action of turning on a light
 */
public class TurnOnLight implements Command {
    private Light light;

    public TurnOnLight(Light light) {
        this.light = light;
    }

    /**
     * Execute the command - turn on the light
     */
    @Override
    public void execute() {
        light.turnOn();
    }
}
