package com.frontanilla.axolotl.screens.game.logic;

import com.frontanilla.axolotl.screens.game.stuff.GameStuff;

public class NebulaHandler {

    private GameStuff stuff;

    public void update(float delta) {
        moveNebulas();
        checkNebulasVisibility();
    }

    private void moveNebulas() {

    }

    private void checkNebulasVisibility() {

    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}