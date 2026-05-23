package lld1.SOLID;

import java.util.ArrayList;
import java.util.List;

/**
 * INTERFACE SEGREGATION PRINCIPLE (ISP)
 * 
 * Definition: A client should never be forced to depend on an interface it does not use.
 * Many client-specific interfaces are better than one general-purpose interface.
 * 
 * Key Points:
 * 1. Interfaces should be focused and cohesive
 * 2. Do not create "fat interfaces" (interfaces with too many methods)
 * 3. Break large interfaces into smaller, specific ones
 * 4. Clients should not be forced to implement methods they don't use
 * 5. Segregate interfaces based on client needs
 * 
 * Benefits:
 * - Classes don't depend on methods they don't use
 * - Easier to understand and implement interfaces
 * - Better maintainability and flexibility
 * - Reduces coupling between classes
 * - Makes testing easier
 */

// ============================================================================
// BAD EXAMPLE: Violating Interface Segregation Principle
// ============================================================================

/**
 * This is a "fat interface" that violates ISP
 * It forces all implementations to provide methods they might not need
 * 
 * Problems:
 * 1. A Printer class must implement eat() and sleep() - nonsensical!
 * 2. A Human class might not need print() - still must implement it
 * 3. Hard to understand which methods are relevant for which implementations
 * 4. Changes to one method affects all implementing classes
 */
interface WorkerBad {
    // Methods related to humans
    void eat();

    void sleep();

    void work();

    // Methods related to robots
    void recharge();

    // Methods related to printers
    void print();

    // Methods related to scanners
    void scan();

    // Methods related to fax machines
    void fax();
}

/**
 * Human implementation forced to implement all methods
 * But humans don't print, scan, or fax!
 */
class HumanBad implements WorkerBad {
    private String name;

    public HumanBad(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    @Override
    public void work() {
        System.out.println(name + " is working");
    }

    @Override
    public void recharge() {
        System.out.println("Humans don't recharge!");
        // Forced to implement but doesn't make sense
    }

    @Override
    public void print() {
        System.out.println("Humans can't print!");
        // Forced to implement but doesn't make sense
    }

    @Override
    public void scan() {
        System.out.println("Humans can't scan!");
        // Forced to implement but doesn't make sense
    }

    @Override
    public void fax() {
        System.out.println("Humans can't fax!");
        // Forced to implement but doesn't make sense
    }
}

/**
 * Robot implementation forced to implement all methods
 * But robots don't eat, sleep, or fax!
 */
class RobotBad implements WorkerBad {
    private String id;

    public RobotBad(String id) {
        this.id = id;
    }

    @Override
    public void eat() {
        System.out.println("Robot " + id + " doesn't eat!");
        // Forced to implement but nonsensical
    }

    @Override
    public void sleep() {
        System.out.println("Robot " + id + " doesn't sleep!");
        // Forced to implement but nonsensical
    }

    @Override
    public void work() {
        System.out.println("Robot " + id + " is working");
    }

    @Override
    public void recharge() {
        System.out.println("Robot " + id + " is recharging");
    }

    @Override
    public void print() {
        System.out.println("Robot " + id + " can't print!");
        // Forced to implement but doesn't make sense
    }

    @Override
    public void scan() {
        System.out.println("Robot " + id + " can't scan!");
        // Forced to implement but doesn't make sense
    }

    @Override
    public void fax() {
        System.out.println("Robot " + id + " can't fax!");
        // Forced to implement but doesn't make sense
    }
}

/**
 * MultiFunction Machine implementation forced to implement all methods
 * But it doesn't sleep, eat, or recharge!
 */
class MultiFunctionMachineBad implements WorkerBad {
    private String modelNumber;

    public MultiFunctionMachineBad(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public void eat() {
        System.out.println("Machine doesn't eat!");
    }

    @Override
    public void sleep() {
        System.out.println("Machine doesn't sleep!");
    }

    @Override
    public void work() {
        System.out.println("Machine " + modelNumber + " is working");
    }

    @Override
    public void recharge() {
        System.out.println("Machine doesn't recharge!");
    }

    @Override
    public void print() {
        System.out.println("Machine " + modelNumber + " is printing");
    }

    @Override
    public void scan() {
        System.out.println("Machine " + modelNumber + " is scanning");
    }

    @Override
    public void fax() {
        System.out.println("Machine " + modelNumber + " is faxing");
    }
}

// ============================================================================
// GOOD EXAMPLE: Following Interface Segregation Principle
// ============================================================================

/**
 * Segregated interface: Defines eating behavior
 * Only for entities that actually eat
 */
interface Eater {
    void eat();
}

/**
 * Segregated interface: Defines sleeping behavior
 * Only for entities that actually sleep
 */
interface Sleeper {
    void sleep();
}

/**
 * Segregated interface: Defines working behavior
 * General work capability
 */
interface Worker {
    void work();
}

/**
 * Segregated interface: Defines recharging behavior
 * Only for entities that recharge (robots, machines)
 */
interface Rechargeable {
    void recharge();
}

/**
 * Segregated interface: Defines printing capability
 */
interface Printer {
    void print();
}

/**
 * Segregated interface: Defines scanning capability
 */
interface Scanner {
    void scan();
}

/**
 * Segregated interface: Defines faxing capability
 */
interface Faxer {
    void fax();
}

/**
 * Human implementation: Only implements interfaces it actually needs
 * No forced implementation of irrelevant methods!
 */
class HumanGood implements Worker, Eater, Sleeper {
    private String name;

    public HumanGood(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    @Override
    public void work() {
        System.out.println(name + " is working");
    }
}

/**
 * Robot implementation: Only implements interfaces it actually needs
 * No forced implementation of eat() or sleep()!
 */
class RobotGood implements Worker, Rechargeable {
    private String id;

    public RobotGood(String id) {
        this.id = id;
    }

    @Override
    public void work() {
        System.out.println("Robot " + id + " is working");
    }

    @Override
    public void recharge() {
        System.out.println("Robot " + id + " is recharging its battery");
    }
}

/**
 * MultiFunctionMachine implementation: Only implements interfaces it needs
 * Combines multiple capabilities without forced irrelevant methods
 */
class MultiFunctionMachineGood implements Worker, Printer, Scanner, Faxer, Rechargeable {
    private String modelNumber;

    public MultiFunctionMachineGood(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public void work() {
        System.out.println("Machine " + modelNumber + " is ready to work");
    }

    @Override
    public void print() {
        System.out.println("Machine " + modelNumber + " is printing documents");
    }

    @Override
    public void scan() {
        System.out.println("Machine " + modelNumber + " is scanning documents");
    }

    @Override
    public void fax() {
        System.out.println("Machine " + modelNumber + " is sending fax");
    }

    @Override
    public void recharge() {
        System.out.println("Machine " + modelNumber + " is plugged in");
    }
}

/**
 * Simple Printer implementation: Only implements what it needs
 */
class SimplePrinter implements Printer, Worker, Rechargeable {
    private String id;

    public SimplePrinter(String id) {
        this.id = id;
    }

    @Override
    public void print() {
        System.out.println("Printer " + id + " is printing");
    }

    @Override
    public void work() {
        System.out.println("Printer " + id + " is operating");
    }

    @Override
    public void recharge() {
        System.out.println("Printer " + id + " is warming up");
    }
}

/**
 * Document Scanner implementation: Only implements what it needs
 */
class DocumentScanner implements Scanner, Worker {
    private String id;

    public DocumentScanner(String id) {
        this.id = id;
    }

    @Override
    public void scan() {
        System.out.println("Scanner " + id + " is scanning documents");
    }

    @Override
    public void work() {
        System.out.println("Scanner " + id + " is ready");
    }
}

/**
 * ServiceTechnician: Works with segregated interfaces
 * Can be more selective about what services to call
 */
class ServiceTechnician {
    /**
     * Put entity to sleep (only works with Sleeper instances)
     */
    public void putToSleep(Sleeper entity) {
        entity.sleep();
        System.out.println("Entity is now sleeping");
    }

    /**
     * Recharge entity (only works with Rechargeable instances)
     */
    public void rechargeEntity(Rechargeable entity) {
        entity.recharge();
        System.out.println("Entity has been recharged");
    }

    /**
     * Have entity eat (only works with Eater instances)
     */
    public void feedEntity(Eater entity) {
        entity.eat();
        System.out.println("Entity has been fed");
    }

    /**
     * Print documents (only works with Printer instances)
     */
    public void printDocuments(Printer entity, String documentName) {
        System.out.println("Printing document: " + documentName);
        entity.print();
    }

    /**
     * Scan documents (only works with Scanner instances)
     */
    public void scanDocuments(Scanner entity, String documentName) {
        System.out.println("Scanning document: " + documentName);
        entity.scan();
    }
}

/**
 * OfficeManager: Manages office resources
 * Works with specific segregated interfaces
 */
class OfficeManager {
    private List<Printer> printers = new ArrayList<>();
    private List<Scanner> scanners = new ArrayList<>();
    private List<Worker> workers = new ArrayList<>();

    public void addPrinter(Printer printer) {
        printers.add(printer);
    }

    public void addScanner(Scanner scanner) {
        scanners.add(scanner);
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    /**
     * Start all printers
     * Uses only the Printer interface
     */
    public void startAllPrinters() {
        System.out.println("\n--- Starting All Printers ---");
        for (Printer printer : printers) {
            printer.print();
        }
    }

    /**
     * Start all scanners
     * Uses only the Scanner interface
     */
    public void startAllScanners() {
        System.out.println("\n--- Starting All Scanners ---");
        for (Scanner scanner : scanners) {
            scanner.scan();
        }
    }

    /**
     * Have all workers start work
     * Uses only the Worker interface
     */
    public void startWork() {
        System.out.println("\n--- Starting Work ---");
        for (Worker worker : workers) {
            worker.work();
        }
    }
}

// ============================================================================
// CLIENT: Demonstrating Interface Segregation Principle
// ============================================================================

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Interface Segregation Principle (ISP) ===\n");

        // Demonstrate the Good Example
        System.out.println("--- Creating Different Types of Entities ---\n");

        HumanGood john = new HumanGood("John");
        RobotGood robot = new RobotGood("R2D2");
        MultiFunctionMachineGood officeMachine = new MultiFunctionMachineGood("XP-1000");
        SimplePrinter printer = new SimplePrinter("HP-PrinterX");
        DocumentScanner scanner = new DocumentScanner("Canon-Scanner");

        // Demonstrate segregated interface usage
        System.out.println("--- Using Segregated Interfaces ---\n");

        System.out.println("1. Human behavior:");
        john.eat();
        john.sleep();
        john.work();

        System.out.println("\n2. Robot behavior:");
        robot.work();
        robot.recharge();

        System.out.println("\n3. Multi-function Machine behavior:");
        officeMachine.work();
        officeMachine.print();
        officeMachine.scan();
        officeMachine.fax();
        officeMachine.recharge();

        System.out.println("\n4. Simple Printer behavior:");
        printer.print();
        printer.work();
        printer.recharge();

        System.out.println("\n5. Document Scanner behavior:");
        scanner.scan();
        scanner.work();

        // Demonstrate ServiceTechnician working with segregated interfaces
        System.out.println("\n--- Service Technician Operations ---");
        ServiceTechnician technician = new ServiceTechnician();

        technician.putToSleep(john);
        technician.rechargeEntity(robot);
        technician.feedEntity(john);
        technician.printDocuments(printer, "Report.pdf");
        technician.scanDocuments(scanner, "Scan.pdf");

        // Demonstrate OfficeManager working with segregated interfaces
        System.out.println("\n--- Office Manager Operations ---");
        OfficeManager manager = new OfficeManager();

        manager.addPrinter(printer);
        manager.addPrinter(officeMachine);
        manager.addScanner(scanner);
        manager.addScanner(officeMachine);
        manager.addWorker(john);
        manager.addWorker(robot);
        manager.addWorker(officeMachine);

        manager.startAllPrinters();
        manager.startAllScanners();
        manager.startWork();

        // Demonstrate type-safe operations
        System.out.println("\n--- Type-Safe Operations (No Runtime Casting) ---");

        // This works fine - john implements Eater
        if (john instanceof Eater) {
            ((Eater) john).eat();
        }

        // Robot doesn't implement Eater - we don't force it
        if (robot instanceof Eater) {
            System.out.println("This won't print - robot is not an Eater");
        } else {
            System.out.println("Robot is NOT an Eater - no forced implementation!");
        }

        System.out.println("\n=== Conclusion ===");
        System.out.println("By following ISP:");
        System.out.println("1. Classes only implement interfaces they actually need");
        System.out.println("2. No forced implementation of irrelevant methods");
        System.out.println("3. Interfaces are focused and cohesive");
        System.out.println("4. Code is more maintainable and easier to understand");
        System.out.println("5. Better flexibility when combining capabilities");
        System.out.println("6. Reduced coupling between classes");
    }
}
