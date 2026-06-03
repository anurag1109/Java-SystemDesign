package lld2.designPattern.structuralDP.facade.homeTheaterSystem;

/**
 * HomeTheaterFacade - Facade Class
 * 
 * This class simplifies the complex home theater system by providing
 * a unified interface with simple methods like watchMovie() and endMovie()
 * 
 * Instead of clients controlling each component individually:
 * - Don't do this: tv.turnOn(); soundSystem.turnOn(); lights.dim(30);
 * projector.turnOn();
 * - Do this: homeTheater.watchMovie();
 * 
 * Benefits:
 * ✓ Simplifies complex subsystems
 * ✓ Reduces coupling between client and subsystem components
 * ✓ Easy to use and maintain
 * ✓ Single point of control
 */
public class HomeTheaterFacade {
    // Complex subsystems
    private Television tv;
    private SoundSystem soundSystem;
    private Lights lights;
    private Projector projector;

    /**
     * Constructor - Initialize all subsystems
     */
    public HomeTheaterFacade() {
        this.tv = new Television();
        this.soundSystem = new SoundSystem();
        this.lights = new Lights();
        this.projector = new Projector();
    }

    /**
     * Simplified method: Watch a movie
     * Coordinates all subsystems with one simple call
     * 
     * Internally does:
     * - Turn on projector
     * - Turn on TV
     * - Turn on sound system with surround sound
     * - Dim the lights
     */
    public void watchMovie() {
        System.out.println("\n========== STARTING MOVIE MODE ==========");

        // Step 1: Turn on projector
        projector.turnOn();
        projector.setInput("HDMI");
        projector.adjustResolution("1080p");

        // Step 2: Turn on TV
        tv.turnOn();
        tv.setVolume(20);

        // Step 3: Setup sound system
        soundSystem.turnOn();
        soundSystem.enableSurround();
        soundSystem.setBassLevel(8);

        // Step 4: Dim lights for better viewing
        lights.dim(30);

        System.out.println("✅ Movie mode activated! Enjoy your movie!\n");
    }

    /**
     * Simplified method: End movie
     * Coordinates all subsystems to return to normal state
     * 
     * Internally does:
     * - Turn off all devices
     * - Turn on lights to full brightness
     */
    public void endMovie() {
        System.out.println("\n========== ENDING MOVIE MODE ==========");

        // Turn off all devices
        projector.turnOff();
        tv.turnOff();
        soundSystem.turnOff();

        // Turn on lights
        lights.turnOn();

        System.out.println("✅ Movie mode deactivated! Goodbye!\n");
    }

    /**
     * Simplified method: Listen to music
     * Coordinates subsystems for music listening
     * 
     * Internally does:
     * - Turn off projector and TV
     * - Turn on sound system with high bass
     * - Keep lights on at full brightness
     */
    public void listenToMusic() {
        System.out.println("\n========== STARTING MUSIC MODE ==========");

        // Turn on sound system with good bass
        soundSystem.turnOn();
        soundSystem.setBassLevel(10);
        soundSystem.enableSurround();

        // Keep lights at full brightness
        lights.turnOn();

        // TV can be on or off (music mode doesn't require projector)
        tv.turnOn();
        tv.setVolume(25);

        System.out.println("✅ Music mode activated! Enjoy the music!\n");
    }

    /**
     * Simplified method: All off
     * Turn off everything
     */
    public void allOff() {
        System.out.println("\n========== SHUTTING DOWN ALL SYSTEMS ==========");
        projector.turnOff();
        tv.turnOff();
        soundSystem.turnOff();
        lights.turnOff();
        System.out.println("✅ All systems shut down!\n");
    }

    /**
     * Simplified method: Game mode
     * Setup for gaming
     */
    public void playGame() {
        System.out.println("\n========== STARTING GAME MODE ==========");

        projector.turnOn();
        projector.setInput("HDMI");

        tv.turnOn();
        tv.setVolume(20);

        soundSystem.turnOn();
        soundSystem.setBassLevel(9);

        lights.dim(50);

        System.out.println("✅ Game mode activated! Let's play!\n");
    }
}
