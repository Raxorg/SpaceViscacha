package com.frontanilla.axolotl.screens.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.axolotl.screens.shared.Renderer;
import com.frontanilla.axolotl.screens.shared.Screen;

public class SplashRenderer extends Renderer {

    private Screen screen;
    // Renderer
    private final SpriteBatch spriteBatch;

    public SplashRenderer() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render() {
        // Clear previous frame
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Use camera
        spriteBatch.setProjectionMatrix(screen.getCamera().combined);
        // Render stuff
        spriteBatch.begin();

        spriteBatch.end();
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}