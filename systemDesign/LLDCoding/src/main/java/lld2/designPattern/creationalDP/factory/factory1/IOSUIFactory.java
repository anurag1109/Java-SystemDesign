package lld2.designPattern.creationalDP.factory.factory1;

import lld2.designPattern.creationalDP.factory.factory1.components.buttons.Button;
import lld2.designPattern.creationalDP.factory.factory1.components.buttons.IOSButton;
import lld2.designPattern.creationalDP.factory.factory1.components.menu.IOSMenu;
import lld2.designPattern.creationalDP.factory.factory1.components.menu.Menu;

// concrete factory
public class IOSUIFactory implements UIFactory {

    public Button createButton() {
        return new IOSButton();
    }

    public Menu createMenu() {
        return new IOSMenu();
    }

}
