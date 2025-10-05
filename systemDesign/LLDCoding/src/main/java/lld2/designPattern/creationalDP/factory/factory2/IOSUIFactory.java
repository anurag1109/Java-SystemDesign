package lld2.designPattern.creationalDP.factory.factory2;

import lld2.designPattern.creationalDP.factory.factory2.components.buttons.IOSButton;
import lld2.designPattern.creationalDP.factory.factory2.components.menu.IOSMenu;

// concrete factory
public class IOSUIFactory implements UIFactory {

    public IOSButton createButton() {
        return new IOSButton();
    }

    public IOSMenu createMenu() {
        return new IOSMenu();
    }

}
