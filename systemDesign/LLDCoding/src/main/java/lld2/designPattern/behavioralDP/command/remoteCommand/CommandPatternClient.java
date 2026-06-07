package lld2.designPattern.behavioralDP.command.remoteCommand;

/**
 * CommandPatternClient - Demonstrates the Command Design Pattern
 * Shows how to control devices using remote control with different commands
 */
public class CommandPatternClient {
    public static void main(String[] args) {
        System.out.println("========== COMMAND DESIGN PATTERN - REMOTE CONTROL ==========\n");

        // ======== Create Devices (Receivers) ========
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // ======== Create Commands ========
        Command turnOnLight1 = new TurnOnLight(livingRoomLight);
        Command turnOffLight1 = new TurnOffLight(livingRoomLight);
        Command turnOnLight2 = new TurnOnLight(kitchenLight);
        Command turnOffLight2 = new TurnOffLight(kitchenLight);

        // ======== Create Remote (Invoker) ========
        RemoteControl remote = new RemoteControl();

        System.out.println("--- Test 1: Turn on Living Room Light ---");
        remote.setCommand(turnOnLight1);
        remote.pressButton();
        System.out.println();

        System.out.println("--- Test 2: Turn off Living Room Light ---");
        remote.setCommand(turnOffLight1);
        remote.pressButton();
        System.out.println();

        System.out.println("--- Test 3: Turn on Kitchen Light ---");
        remote.setCommand(turnOnLight2);
        remote.pressButton();
        System.out.println();

        System.out.println("--- Test 4: Turn off Kitchen Light ---");
        remote.setCommand(turnOffLight2);
        remote.pressButton();
        System.out.println();

        System.out.println("========== END OF DEMO =========");
        System.out.println();

        System.out.println("\n========== BENEFITS OF COMMAND PATTERN ==========");
        System.out.println("✓ Decouples sender (Remote) from receiver (Devices)");
        System.out.println("✓ Easy to add new commands without modifying remote");
        System.out.println("✓ Supports undo/redo operations");
        System.out.println("✓ Can queue commands for later execution");
        System.out.println("✓ Supports logging of commands");
    }
}
