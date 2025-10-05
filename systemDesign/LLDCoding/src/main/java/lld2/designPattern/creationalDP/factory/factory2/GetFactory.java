package lld2.designPattern.creationalDP.factory.factory2;

public class GetFactory {

    // Practical factory method
    public static UIFactory getFactory(SuportedPlatform platform) {
        switch (platform) {
            case ANDROID:
                return new AndroidUIFactory();
            case IOS:
                return new IOSUIFactory();
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

}
