package lld2.designPattern.creationalDP.factory.factory1.components.buttons;

public class IOSButton implements Button {
    @Override
    public void changeSize() {
        System.out.println("iOS button size changed");
    }

}