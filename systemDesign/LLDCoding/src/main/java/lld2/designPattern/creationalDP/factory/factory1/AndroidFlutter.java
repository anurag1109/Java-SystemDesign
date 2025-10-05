package lld2.designPattern.creationalDP.factory.factory1;

// to create android flutter app
public class AndroidFlutter extends Flutter {
    public UIFactory getUIFactory() {
        return new AndroidUIFactory();
    }
}
