package lld2.designPattern.creationalDP.factory.factory1;

import lld2.designPattern.creationalDP.factory.factory1.components.buttons.Button;

public class Client {
    public static void main(String[] args) {

        // to create android flutter app
        AndroidFlutter androidFlutter = new AndroidFlutter();
        UIFactory androidUIFactory = androidFlutter.getUIFactory();
        androidUIFactory.createButton().changeSize();
        androidUIFactory.createMenu().changeMenu();

        // to create ios flutter app
        IOSFlutter iosFlutter = new IOSFlutter();
        UIFactory iosUIFactory = iosFlutter.getUIFactory();
        iosUIFactory.createButton().changeSize();
        iosUIFactory.createMenu().changeMenu();

        // we can see to create different ui factory we just need to change the object
        // creation and rest of the code remains same

        Flutter app = new IOSFlutter();
        // Flutter app = new AndroidFlutter();
        UIFactory factory = app.getUIFactory();
        Button button = factory.createButton();
        button.changeSize();
    }

}
