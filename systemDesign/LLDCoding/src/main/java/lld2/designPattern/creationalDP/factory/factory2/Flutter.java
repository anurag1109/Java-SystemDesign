package lld2.designPattern.creationalDP.factory.factory2;

public class Flutter {

    SuportedPlatform platform;

    public Flutter(SuportedPlatform platform) {
        this.platform = platform;
    }

    // common methods
    public void setTheme() {
        System.out.println("Flutter theme set");
    }

    public void setRefreshRate() {
        System.out.println("Flutter refresh rate set");
    }

    // to connect with factory methods
    // Abstract factory method
    public UIFactory getUIFactory() {
        switch (platform) {
            case ANDROID:
                return new AndroidUIFactory();
            case IOS:
                return new IOSUIFactory();
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
        // but this is violation of open closed principle as every time we add new
        // platform we need to modify this method=>
        // here comes practical factory design pattern
        // in that dp we just make separate abstract class which returns the factory
        // object based on parameter passed and that class is caleed from here only

    };

    // practical factory method
    public UIFactory getUIFactoryPractical() {
        return GetFactory.getFactory(platform);
    }

};
