package com.frontanilla.axolotl;

import com.badlogic.gdx.Game;
import com.frontanilla.axolotl.screens.splash.SplashInitializer;

public class ViscachaGame extends Game {

    @Override
    public void create() {
        new SplashInitializer().initialize(this);
    }
}