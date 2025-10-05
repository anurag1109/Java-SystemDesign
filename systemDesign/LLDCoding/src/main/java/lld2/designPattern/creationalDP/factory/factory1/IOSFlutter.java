package lld2.designPattern.creationalDP.factory.factory1;

// to create ios flutter app
public class IOSFlutter extends Flutter {
    public UIFactory getUIFactory() {
        return new IOSUIFactory();
    }

}
