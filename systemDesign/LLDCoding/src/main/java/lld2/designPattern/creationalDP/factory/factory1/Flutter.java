package lld2.designPattern.creationalDP.factory.factory1;

public abstract class Flutter {

    // common methods
    public void setTheme() {
        System.out.println("Flutter theme set");
    }

    public void setRefreshRate() {
        System.out.println("Flutter refresh rate set");
    }

    // to connect with factory methods
    public abstract UIFactory getUIFactory();
}
