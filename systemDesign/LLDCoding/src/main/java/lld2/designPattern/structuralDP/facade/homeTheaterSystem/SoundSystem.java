package lld2.designPattern.structuralDP.facade.homeTheaterSystem;

/**
 * SoundSystem - Subsystem Component
 * Represents a sound system with various audio settings
 * This is one of many complex subsystems in a home theater
 */
public class SoundSystem {
    private boolean isOn = false;
    private int bassLevel = 0;

    public void turnOn() {
        isOn = true;
        System.out.println("🔊 Sound System turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("🔊 Sound System turned OFF");
    }

    public void setBassLevel(int level) {
        if (isOn) {
            this.bassLevel = level;
            System.out.println("🎵 Bass level set to: " + level);
        }
    }

    public void enableSurround() {
        if (isOn) {
            System.out.println("🎵 Surround sound ENABLED");
        }
    }

    public boolean isOn() {
        return isOn;
    }
}
