package lld2.designPattern.creationalDP.factory.factory2;

import lld2.designPattern.creationalDP.factory.factory2.components.buttons.Button;
import lld2.designPattern.creationalDP.factory.factory2.components.menu.Menu;

// factory interface
public interface UIFactory {

    Button createButton();

    Menu createMenu();
}
