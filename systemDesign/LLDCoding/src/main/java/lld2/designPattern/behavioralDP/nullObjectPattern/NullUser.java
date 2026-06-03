package lld2.designPattern.behavioralDP.nullObjectPattern;

/**
 * NullUser - Null Object Implementation
 * This user does nothing - all operations are no-ops
 * This eliminates the need for null checks throughout the code
 */
public class NullUser implements UserService {

    @Override
    public void login() {
        // Does nothing - no-op operation
    }

    @Override
    public void logout() {
        // Does nothing - no-op operation
    }

    @Override
    public void sendEmail(String message) {
        // Does nothing - no-op operation
    }

    @Override
    public String getUsername() {
        return "NULL_USER";
    }
}
