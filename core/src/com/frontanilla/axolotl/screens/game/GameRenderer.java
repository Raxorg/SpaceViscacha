package com.frontanilla.axolotl.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.axolotl.screens.game.stuff.GameStuff;
import com.frontanilla.axolotl.screens.shared.Renderer;
import com.frontanilla.axolotl.screens.shared.Screen;

public class GameRenderer extends Renderer {

    private Screen screen;
    private GameStuff stuff;
    // Renderers
    private final SpriteBatch spriteBatch;

    public GameRenderer() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render() {
        // Clear previous frame
        Gdx.gl.glClearColor(0, 0, 0.25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Use camera
        spriteBatch.setProjectionMatrix(screen.getCamera().combined);
        // Render stuff
        spriteBatch.begin();
        for (int i = 0; i < stuff.getBackgroundNebulas().size; i++) {
            stuff.getBackgroundNebulas().get(i).draw(spriteBatch);
        }
        stuff.getSpaceship().draw(spriteBatch);
        for (int i = 0; i < stuff.getForegroundNebulas().size; i++) {
            stuff.getForegroundNebulas().get(i).draw(spriteBatch);
        }
        stuff.getStoryVisualizer().draw(spriteBatch);
        spriteBatch.end();
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}