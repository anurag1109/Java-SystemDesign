package lld2.designPattern.structuralDP.facade.homeTheaterSystem;

/**
 * Client for Facade Design Pattern
 * 
 * This demonstrates how simple the client code becomes when using Facade
 * Instead of managing complex subsystems, we just call simple methods
 */
public class FacadePatternClient {
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║         FACADE DESIGN PATTERN - HOME THEATER SYSTEM           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        // Create the Facade - this is the only object the client needs to work with!
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        System.out.println("\n━━━━━ WITHOUT FACADE (Complex) ━━━━━");
        System.out.println("// Client had to do this:");
        System.out.println("tv.turnOn();");
        System.out.println("soundSystem.turnOn();");
        System.out.println("soundSystem.enableSurround();");
        System.out.println("soundSystem.setBassLevel(8);");
        System.out.println("lights.dim(30);");
        System.out.println("projector.turnOn();");
        System.out.println("projector.setInput(\"HDMI\");");
        System.out.println("... and many more lines!");

        System.out.println("\n━━━━━ WITH FACADE (Simple) ━━━━━");
        System.out.println("// Now client just calls:");
        System.out.println("homeTheater.watchMovie();");

        // Demonstrate the simplicity
        System.out.println("\n\n═══════════════════════════════════════════════════════════════════");
        System.out.println("SCENARIO 1: Watching a Movie");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        homeTheater.watchMovie();

        // Pause for demonstration
        System.out.println("⏸️  [Movie is playing... Enjoying!]\n");

        // End the movie
        homeTheater.endMovie();

        // Demonstrate another mode
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("SCENARIO 2: Listening to Music");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        homeTheater.listenToMusic();

        System.out.println("🎵 [Music is playing... Relaxing!]\n");

        // Game mode
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("SCENARIO 3: Playing a Video Game");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        homeTheater.playGame();

        System.out.println("🎮 [Game is running... Playing!]\n");

        // Shutdown everything
        System.out.println("\n═══════════════════════════════════════════════════════════════════");
        System.out.println("SCENARIO 4: Shutting Down Everything");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        homeTheater.allOff();

        // Summary
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    BENEFITS OF FACADE PATTERN                 ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║ ✓ Simplifies complex subsystems into single interface         ║");
        System.out.println("║ ✓ Reduces coupling between client and subsystems             ║");
        System.out.println("║ ✓ Easy to understand and use                                  ║");
        System.out.println("║ ✓ Single point of control for related operations             ║");
        System.out.println("║ ✓ Makes code more maintainable                               ║");
        System.out.println("║ ✓ Hides complexity from client                               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
    }
}
