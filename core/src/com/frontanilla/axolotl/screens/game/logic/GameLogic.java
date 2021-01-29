package com.frontanilla.axolotl.screens.game.logic;

import com.frontanilla.axolotl.screens.game.stuff.GameStuff;
import com.frontanilla.axolotl.screens.shared.Logic;
import com.frontanilla.axolotl.screens.shared.Screen;
import com.frontanilla.axolotl.screens.shared.input.Input;

public class GameLogic extends Logic {

    private final ButtonHandler buttonHandler;
    private final GameInputHandler gameInputHandler;
    private final SpaceshipHandler spaceshipHandler;
    private final StoryHandler storyHandler;

    public GameLogic() {
        buttonHandler = new ButtonHandler();
        gameInputHandler = new GameInputHandler();
        spaceshipHandler = new SpaceshipHandler();
        storyHandler = new StoryHandler();

        gameInputHandler.setLogic(this);
    }

    public void initialLogic() {
        gameInputHandler.configureInput();
        storyHandler.hidePreviousButton();
    }

    @Override
    public void update(float delta) {
        spaceshipHandler.update(delta);
        storyHandler.update(delta);
    }

    // Structure
    public void setInput(Input input) {
        gameInputHandler.setInput(input);
    }

    public void setScreen(Screen screen) {
        gameInputHandler.setScreen(screen);
    }

    public void setStuff(GameStuff stuff) {
        buttonHandler.setStuff(stuff);
        gameInputHandler.setStuff(stuff);
        spaceshipHandler.setStuff(stuff);
        storyHandler.setStuff(stuff);
    }

    // Helpers
    public ButtonHandler getButtonHandler() {
        return buttonHandler;
    }

    public SpaceshipHandler getSpaceshipHandler() {
        return spaceshipHandler;
    }

    public StoryHandler getStoryHandler() {
        return storyHandler;
    }
}