package lld2.designPattern.structuralDP.facade.homeTheaterSystem;

/**
 * Television - Subsystem Component
 * Represents a Television that can be turned on/off and volume controlled
 * This is one of many complex subsystems in a home theater
 */
public class Television {
    private boolean isOn = false;
    private int volume = 0;

    public void turnOn() {
        isOn = true;
        System.out.println("🖥️  Television turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("🖥️  Television turned OFF");
    }

    public void setVolume(int volume) {
        if (isOn) {
            this.volume = volume;
            System.out.println("🔊 TV Volume set to: " + volume);
        }
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return isOn;
    }
}
