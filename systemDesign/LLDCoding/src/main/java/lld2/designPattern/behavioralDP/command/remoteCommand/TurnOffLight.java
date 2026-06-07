package lld2.designPattern.behavioralDP.command.remoteCommand;

/**
 * TurnOffLight - Concrete Command
 * This command encapsulates the action of turning off a light
 */
public class TurnOffLight implements Command {
    private Light light;

    public TurnOffLight(Light light) {
        this.light = light;
    }

    /**
     * Execute the command - turn off the light
     */
    @Override
    public void execute() {
        light.turnOff();
    }
}
