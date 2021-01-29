package com.frontanilla.axolotl.screens.splash;

import com.frontanilla.axolotl.ViscachaGame;
import com.frontanilla.axolotl.screens.shared.Assets;
import com.frontanilla.axolotl.screens.shared.Screen;
import com.frontanilla.axolotl.screens.splash.logic.SplashLogic;

public class SplashInitializer {

    public void initialize(ViscachaGame game) {
        Assets assets = new Assets();
        SplashLogic logic = new SplashLogic();
        SplashRenderer renderer = new SplashRenderer();
        Screen screen = new Screen();

        logic.setGame(game);
        logic.setAssets(assets);
        logic.setScreen(screen);
        renderer.setScreen(screen);
        screen.setLogic(logic);
        screen.setRenderer(renderer);

        logic.initialLogic();
        game.setScreen(screen);
    }
}