package com.frontanilla.axolotl.screens.game.logic;

import com.frontanilla.axolotl.screens.game.stuff.GameStuff;

public class ButtonHandler {

    private GameStuff stuff;

    public void deselectButtons() {
        stuff.getStoryVisualizer().getPreviousButton().useSprite1();
        stuff.getStoryVisualizer().getNextButton().useSprite1();
    }

    public void hideStoryButtons() {

    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}