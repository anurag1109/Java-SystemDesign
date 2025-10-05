package lld2.designPattern.creationalDP.factory.factory2;

import lld2.designPattern.creationalDP.factory.factory2.components.buttons.Button;

public class Client {
    public static void main(String[] args) {

        // we can see to create different ui factory we just need to change the object
        // creation and rest of the code remains same

        // abstract factory pattern
        Flutter app1 = new Flutter(SuportedPlatform.ANDROID);
        // Flutter app = new AndroidFlutter();
        UIFactory factory = app1.getUIFactory();
        // UIFactory factory = app.getUIFactory(SuportedPlatform.ANDROID);
        Button button1 = factory.createButton();
        button1.changeSize();

        // practical factory pattern
        Flutter app2 = new Flutter(SuportedPlatform.IOS);
        UIFactory factory2 = app2.getUIFactoryPractical();
        Button button2 = factory2.createButton();
        button2.changeSize();
    }

}
