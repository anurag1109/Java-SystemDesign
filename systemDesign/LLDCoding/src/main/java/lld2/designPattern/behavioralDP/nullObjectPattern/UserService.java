package lld2.designPattern.behavioralDP.nullObjectPattern;

/**
 * UserService Interface
 * Defines the contract for all user implementations
 */
public interface UserService {
    void login();

    void logout();

    void sendEmail(String message);

    String getUsername();
}
