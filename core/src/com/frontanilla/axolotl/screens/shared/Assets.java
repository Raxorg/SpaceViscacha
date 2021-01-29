package com.frontanilla.axolotl.screens.shared;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {

    private final AssetManager assetManager;
    // Sprites
    private Sprite pixel;
    private Sprite testStory, playButton;
    private Sprite spaceship, star, nebula1;

    public Assets() {
        assetManager = new AssetManager();
    }

    public void queueAssetLoading() {
        assetManager.load("images/pixel.png", Texture.class);
        assetManager.load("images/testStory.png", Texture.class);
        assetManager.load("images/playButton.png", Texture.class);
        assetManager.load("images/game/spaceship.png", Texture.class);
        assetManager.load("images/star.png", Texture.class);
        assetManager.load("images/game/nebula1.png", Texture.class);
    }

    public boolean loadAssets() {
        return assetManager.update();
    }

    public void initializeAssets() {
        pixel = new Sprite(assetManager.get("images/pixel.png", Texture.class));
        testStory = new Sprite(assetManager.get("images/testStory.png", Texture.class));
        playButton = new Sprite(assetManager.get("images/playButton.png", Texture.class));
        spaceship = new Sprite(assetManager.get("images/game/spaceship.png", Texture.class));
        star = new Sprite(assetManager.get("images/star.png", Texture.class));
        spaceship = new Sprite(assetManager.get("images/game/nebula1.png", Texture.class));
    }

    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getTestStory() {
        return testStory;
    }

    public Sprite getPlayButton() {
        return playButton;
    }

    public Sprite getSpaceship() {
        return spaceship;
    }

    public Sprite getStar() {
        return star;
    }

    public Sprite getNebula1() {
        return nebula1;
    }
}