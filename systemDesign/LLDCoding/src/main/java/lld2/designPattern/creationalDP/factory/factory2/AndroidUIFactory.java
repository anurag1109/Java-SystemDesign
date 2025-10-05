package lld2.designPattern.creationalDP.factory.factory2;

import lld2.designPattern.creationalDP.factory.factory2.components.buttons.AndroidButton;
import lld2.designPattern.creationalDP.factory.factory2.components.menu.AndroidMenu;

// concrete factory
public class AndroidUIFactory implements UIFactory {
    @Override
    public AndroidButton createButton() {
        return new AndroidButton();
    }

    @Override
    public AndroidMenu createMenu() {
        return new AndroidMenu();
    }

}
