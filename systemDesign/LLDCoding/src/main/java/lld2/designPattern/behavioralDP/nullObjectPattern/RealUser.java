package lld2.designPattern.behavioralDP.nullObjectPattern;

/**
 * RealUser - Concrete User Implementation
 * This is the actual user with real functionality
 */
public class RealUser implements UserService {
    private String username;
    private boolean isLoggedIn;

    public RealUser(String username) {
        this.username = username;
        this.isLoggedIn = false;
    }

    @Override
    public void login() {
        System.out.println("✓ User '" + username + "' logged in successfully");
        this.isLoggedIn = true;
    }

    @Override
    public void logout() {
        System.out.println("✓ User '" + username + "' logged out");
        this.isLoggedIn = false;
    }

    @Override
    public void sendEmail(String message) {
        if (isLoggedIn) {
            System.out.println("📧 Email sent to " + username + ": " + message);
        } else {
            System.out.println("✗ Cannot send email - user not logged in");
        }
    }

    @Override
    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
