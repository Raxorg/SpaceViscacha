package com.frontanilla.axolotl.screens.game.logic;

import com.badlogic.gdx.Input.Keys;
import com.frontanilla.axolotl.screens.game.stuff.GameStuff;
import com.frontanilla.axolotl.screens.shared.Screen;
import com.frontanilla.axolotl.screens.shared.input.Input;
import com.frontanilla.axolotl.screens.shared.input.InputHandler;

public class GameInputHandler extends InputHandler {

    private Input input;
    private GameLogic logic;
    private Screen screen;
    private GameStuff stuff;

    public void configureInput() {
        input.setInputHandler(this);
        input.setCamera(screen.getCamera());
        input.setEnabled(true);
    }

    @Override
    public void touchDown(float x, float y) {
        if (stuff.getStoryVisualizer().getPreviousButton().contains(x, y)) {
            stuff.getStoryVisualizer().getPreviousButton().useSprite2();
            return;
        }
        if (stuff.getStoryVisualizer().getNextButton().contains(x, y)) {
            stuff.getStoryVisualizer().getNextButton().useSprite2();
        }
    }

    @Override
    public void touchUp(float x, float y) {
        logic.getButtonHandler().deselectButtons();
        if (stuff.getStoryVisualizer().getPreviousButton().contains(x, y)) {
            logic.getStoryHandler().previousPart();
            return;
        }
        if (stuff.getStoryVisualizer().getNextButton().contains(x, y)) {
            logic.getStoryHandler().nextPart();
        }
    }

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case Keys.D:
                logic.getSpaceshipHandler().turnKeyPressed(true);
                break;
            case Keys.A:
                logic.getSpaceshipHandler().turnKeyPressed(false);
                break;
            case Keys.W:
                logic.getSpaceshipHandler().accelerationKeyPressed(true);
                break;
            case Keys.S:
                logic.getSpaceshipHandler().accelerationKeyPressed(false);
        }
    }

    @Override
    public void keyUp(int keycode) {
        switch (keycode) {
            case Keys.D:
                logic.getSpaceshipHandler().turnKeyReleased(true);
                break;
            case Keys.A:
                logic.getSpaceshipHandler().turnKeyReleased(false);
                break;
            case Keys.W:
                logic.getSpaceshipHandler().accelerationKeyReleased(true);
                break;
            case Keys.S:
                logic.getSpaceshipHandler().accelerationKeyReleased(false);
        }
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}