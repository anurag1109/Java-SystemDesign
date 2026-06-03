package lld2.designPattern.structuralDP.facade.homeTheaterSystem;

/**
 * Projector - Subsystem Component
 * Represents a projector with various settings
 * This is one of many complex subsystems in a home theater
 */
public class Projector {
    private boolean isOn = false;
    private String input = "";

    public void turnOn() {
        isOn = true;
        System.out.println("📽️  Projector turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("📽️  Projector turned OFF");
    }

    public void setInput(String source) {
        if (isOn) {
            input = source;
            System.out.println("📽️  Projector input set to: " + source);
        }
    }

    public void adjustResolution(String resolution) {
        if (isOn) {
            System.out.println("📽️  Projector resolution set to: " + resolution);
        }
    }

    public boolean isOn() {
        return isOn;
    }
}
