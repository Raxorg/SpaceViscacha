package com.frontanilla.axolotl.screens.splash.logic;

import com.frontanilla.axolotl.ViscachaGame;
import com.frontanilla.axolotl.screens.game.GameInitializer;
import com.frontanilla.axolotl.screens.shared.Assets;
import com.frontanilla.axolotl.screens.shared.Screen;

public class TransitionHandler {

    private ViscachaGame game;
    private Assets assets;
    private Screen screen;

    public void transitionToGameScreen() {
        new GameInitializer().initialize(game, assets, screen);
    }

    public void setGame(ViscachaGame game) {
        this.game = game;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}