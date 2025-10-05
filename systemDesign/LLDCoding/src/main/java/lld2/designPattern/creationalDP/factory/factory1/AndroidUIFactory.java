package lld2.designPattern.creationalDP.factory.factory1;

import lld2.designPattern.creationalDP.factory.factory1.components.buttons.AndroidButton;
import lld2.designPattern.creationalDP.factory.factory1.components.buttons.Button;
import lld2.designPattern.creationalDP.factory.factory1.components.menu.AndroidMenu;
import lld2.designPattern.creationalDP.factory.factory1.components.menu.Menu;

// concrete factory
public class AndroidUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }

}
