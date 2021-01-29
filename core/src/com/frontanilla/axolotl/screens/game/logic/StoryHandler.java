package com.frontanilla.axolotl.screens.game.logic;

import com.frontanilla.axolotl.screens.game.stuff.GameStuff;
import com.frontanilla.axolotl.screens.game.stuff.StoryVisualizer;

import static com.frontanilla.axolotl.screens.shared.Constants.CAMERA_HEIGHT;
import static com.frontanilla.axolotl.screens.shared.Constants.CAMERA_WIDTH;
import static com.frontanilla.axolotl.screens.shared.Constants.STORY_BUTTON_SIZE;
import static com.frontanilla.axolotl.screens.shared.Constants.STORY_TRANSITION_DURATION;

public class StoryHandler {

    private GameStuff stuff;
    // Logic
    private float alpha;
    private boolean fading, fadingIn, next;

    public StoryHandler() {
        alpha = 0f;
    }

    public void nextPart() {
        if (fading) {
            return;
        }
        fading = true;
        fadingIn = true;
        next = true;
    }

    public void previousPart() {
        if (fading) {
            return;
        }
        fading = true;
        fadingIn = true;
        next = false;
    }

    public void update(float delta) {
        if (!fading) {
            return;
        }
        if (fadingIn) {
            alpha = Math.min(alpha + delta / STORY_TRANSITION_DURATION, 1f);
            if (alpha == 1f) {
                changeStory();
                fadingIn = false;
            }
        } else {
            alpha = Math.max(alpha - delta / STORY_TRANSITION_DURATION, 0f);
            if (alpha == 0f) {
                fading = false;
            }
        }
        stuff.getStoryVisualizer().getFader().setColor(0f, 0f, 0f, alpha);
    }

    private void changeStory() {
        StoryVisualizer storyVisualizer = stuff.getStoryVisualizer();
        int storyIndex = storyVisualizer.getStoryParts().indexOf(storyVisualizer.getCurrentStory());
        if (next) {
            if (storyIndex == storyVisualizer.getStoryParts().size() - 1) {
                hideStoryVisualizer();
                return;
            }
            storyVisualizer.setCurrentStory(storyVisualizer.getStoryParts().get(storyIndex + 1));
            showPreviousButton();
        } else {
            if (storyIndex == 0) {
                return;
            }
            storyVisualizer.setCurrentStory(storyVisualizer.getStoryParts().get(storyIndex - 1));
            if (storyIndex - 1 == 0) {
                hidePreviousButton();
            }
        }
    }

    public void hidePreviousButton() {
        stuff.getStoryVisualizer().getPreviousButton().setPosition(-STORY_BUTTON_SIZE, -STORY_BUTTON_SIZE);
    }

    public void showPreviousButton() {
        stuff.getStoryVisualizer().getPreviousButton().setPosition(0f, 0f);
    }

    private void hideStoryVisualizer() {
        StoryVisualizer storyVisualizer = stuff.getStoryVisualizer();
        storyVisualizer.getCurrentStory().setPosition(-CAMERA_WIDTH, -CAMERA_HEIGHT);
        storyVisualizer.getPreviousButton().setPosition(-STORY_BUTTON_SIZE, -STORY_BUTTON_SIZE);
        storyVisualizer.getNextButton().setPosition(-STORY_BUTTON_SIZE, -STORY_BUTTON_SIZE);
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}