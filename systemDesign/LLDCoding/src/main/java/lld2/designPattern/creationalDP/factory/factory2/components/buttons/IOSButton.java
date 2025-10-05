package lld2.designPattern.creationalDP.factory.factory2.components.buttons;

public class IOSButton implements Button {
    @Override
    public void changeSize() {
        System.out.println("iOS button size changed");
    }

}