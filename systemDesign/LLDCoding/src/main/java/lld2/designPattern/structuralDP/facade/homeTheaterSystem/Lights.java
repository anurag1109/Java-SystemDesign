package lld2.designPattern.structuralDP.facade.homeTheaterSystem;

/**
 * Lights - Subsystem Component
 * Represents room lights with brightness control
 * This is one of many complex subsystems in a home theater
 */
public class Lights {
    private boolean isOn = false;
    private int brightness = 0;

    public void turnOn() {
        isOn = true;
        brightness = 100;
        System.out.println("💡 Lights turned ON (Brightness: 100%)");
    }

    public void turnOff() {
        isOn = false;
        brightness = 0;
        System.out.println("💡 Lights turned OFF");
    }

    public void dim(int level) {
        if (isOn) {
            brightness = level;
            System.out.println("💡 Lights dimmed to: " + level + "%");
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public int getBrightness() {
        return brightness;
    }
}
