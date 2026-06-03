package lld2.designPattern.behavioralDP.nullObjectPattern;

/**
 * LoggerService Interface
 * Defines the contract for logging implementations
 */
public interface LoggerService {
    void logInfo(String message);

    void logError(String message);

    void logWarning(String message);
}
