package com.frontanilla.axolotl.screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.axolotl.screens.shared.Assets;

public class GameStuff {

    private Assets assets;
    // Stuff
    private StoryVisualizer storyVisualizer;
    private DelayedRemovalArray<Sprite> backgroundNebulas;
    private Spaceship spaceship;
    private DelayedRemovalArray<Sprite> foregroundNebulas;

    public void initializeStuff() {
        storyVisualizer = new StoryVisualizer(assets);
        backgroundNebulas = new DelayedRemovalArray<>();
        spaceship = new Spaceship(assets.getSpaceship());
        foregroundNebulas = new DelayedRemovalArray<>();
    }

    public StoryVisualizer getStoryVisualizer() {
        return storyVisualizer;
    }

    public DelayedRemovalArray<Sprite> getBackgroundNebulas() {
        return backgroundNebulas;
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public DelayedRemovalArray<Sprite> getForegroundNebulas() {
        return foregroundNebulas;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }
}