package lld2.designPattern.behavioralDP.nullObjectPattern;

/**
 * NullLogger - Null Object Implementation for Logger
 * This logger does nothing - all logging operations are no-ops
 * Used when logging is disabled or not needed
 */
public class NullLogger implements LoggerService {

    @Override
    public void logInfo(String message) {
        // Does nothing - no-op operation
    }

    @Override
    public void logError(String message) {
        // Does nothing - no-op operation
    }

    @Override
    public void logWarning(String message) {
        // Does nothing - no-op operation
    }
}
