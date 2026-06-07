package lld2.designPattern.behavioralDP.command.remoteCommand;

/**
 * Light - Receiver (the object that performs the actual work)
 * The light knows how to turn on and off
 */
public class Light {
    private String location;
    private boolean isOn;

    public Light(String location) {
        this.location = location;
        this.isOn = false;
    }

    /**
     * Turn on the light
     */
    public void turnOn() {
        this.isOn = true;
        System.out.println("💡 " + location + " Light is now ON");
    }

    /**
     * Turn off the light
     */
    public void turnOff() {
        this.isOn = false;
        System.out.println("⚫ " + location + " Light is now OFF");
    }

    public boolean isOn() {
        return isOn;
    }

    public String getLocation() {
        return location;
    }
}
