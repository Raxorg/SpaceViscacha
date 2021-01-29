package com.frontanilla.axolotl.screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.axolotl.screens.shared.Assets;
import com.frontanilla.axolotl.screens.shared.gui.ToggleSprite;

import java.util.ArrayList;

import static com.frontanilla.axolotl.screens.shared.Constants.CAMERA_HEIGHT;
import static com.frontanilla.axolotl.screens.shared.Constants.CAMERA_WIDTH;
import static com.frontanilla.axolotl.screens.shared.Constants.STORY_BUTTON_SIZE;
import static com.frontanilla.axolotl.screens.shared.Constants.STORY_PARTS;

public class StoryVisualizer {

    private final ArrayList<Sprite> storyParts;
    private Sprite currentStory;
    private final ToggleSprite previousButton, nextButton;
    private final Sprite fader;

    public StoryVisualizer(Assets assets) {
        storyParts = new ArrayList<>();
        for (int i = 0; i < STORY_PARTS; i++) {
            Sprite storyPart = new Sprite(assets.getTestStory());
            storyPart.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
            storyParts.add(storyPart);
        }
        currentStory = storyParts.get(0);

        previousButton = new ToggleSprite(assets.getPlayButton(), assets.getPlayButton(), Color.WHITE, Color.RED);
        previousButton.setSize(STORY_BUTTON_SIZE, STORY_BUTTON_SIZE);
        previousButton.flip();
        nextButton = new ToggleSprite(assets.getPlayButton(), assets.getPlayButton(), Color.WHITE, Color.RED);
        nextButton.setSize(STORY_BUTTON_SIZE, STORY_BUTTON_SIZE);
        nextButton.setX(CAMERA_WIDTH - STORY_BUTTON_SIZE);

        fader = new Sprite(assets.getPixel());
        fader.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        fader.setColor(Color.CLEAR);
    }

    public void draw(SpriteBatch spriteBatch) {
        currentStory.draw(spriteBatch);
        previousButton.draw(spriteBatch);
        nextButton.draw(spriteBatch);
        fader.draw(spriteBatch);
    }

    public ArrayList<Sprite> getStoryParts() {
        return storyParts;
    }

    public Sprite getCurrentStory() {
        return currentStory;
    }

    public void setCurrentStory(Sprite currentStory) {
        this.currentStory = currentStory;
    }

    public ToggleSprite getPreviousButton() {
        return previousButton;
    }

    public ToggleSprite getNextButton() {
        return nextButton;
    }

    public Sprite getFader() {
        return fader;
    }
}