package com.frontanilla.axolotl.screens.game;

import com.frontanilla.axolotl.ViscachaGame;
import com.frontanilla.axolotl.screens.game.logic.GameLogic;
import com.frontanilla.axolotl.screens.game.stuff.GameStuff;
import com.frontanilla.axolotl.screens.shared.Assets;
import com.frontanilla.axolotl.screens.shared.Screen;
import com.frontanilla.axolotl.screens.shared.input.Input;

public class GameInitializer {

    public void initialize(ViscachaGame game, Assets assets, Screen screen) {
        Input input = new Input();
        GameLogic logic = new GameLogic();
        GameRenderer renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();

        logic.setInput(input);
        logic.setScreen(screen);
        logic.setStuff(stuff);
        renderer.setScreen(screen);
        renderer.setStuff(stuff);
        screen.setLogic(logic);
        screen.setRenderer(renderer);
        stuff.setAssets(assets);

        stuff.initializeStuff();
        logic.initialLogic();

        game.setScreen(screen);
    }
}