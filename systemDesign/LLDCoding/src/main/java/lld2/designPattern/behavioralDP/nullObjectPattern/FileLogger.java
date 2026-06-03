package lld2.designPattern.behavioralDP.nullObjectPattern;

/**
 * FileLogger - Real Logger Implementation
 * Logs messages to a file (simulated with console output)
 */
public class FileLogger implements LoggerService {

    @Override
    public void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    @Override
    public void logError(String message) {
        System.out.println("[ERROR] " + message);
    }

    @Override
    public void logWarning(String message) {
        System.out.println("[WARNING] " + message);
    }
}
