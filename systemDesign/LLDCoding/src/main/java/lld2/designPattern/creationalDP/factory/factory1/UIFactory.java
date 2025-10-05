package lld2.designPattern.creationalDP.factory.factory1;

import lld2.designPattern.creationalDP.factory.factory1.components.buttons.Button;
import lld2.designPattern.creationalDP.factory.factory1.components.menu.Menu;

// factory interface
public interface UIFactory {

    Button createButton();

    Menu createMenu();
}
