package lld2.designPattern.behavioralDP.command.remoteCommandWithundo;

/**
 * Light - Receiver class
 * The actual object that performs the work
 * 
 * In the Command pattern, the receiver is the object that knows
 * how to perform the actual work (turn on/off)
 */
public class Light {
    private boolean isOn = false;

    // Turn the light on
    public void on() {
        if (!isOn) {
            System.out.println("💡 Light is now ON");
            isOn = true;
        } else {
            System.out.println("💡 Light is already ON");
        }
    }

    // Turn the light off
    public void off() {
        if (isOn) {
            System.out.println("🌑 Light is now OFF");
            isOn = false;
        } else {
            System.out.println("🌑 Light is already OFF");
        }
    }

    // Get current state
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Light is " + (isOn ? "ON" : "OFF");
    }
}
