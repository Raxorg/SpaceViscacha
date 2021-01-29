package com.frontanilla.axolotl.screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Spaceship {

    private final Sprite spaceship;
    private Vector2 speed;

    public Spaceship(Sprite spaceshipSprite) {
        spaceship = new Sprite(spaceshipSprite);
        spaceship.setSize(100f, 100f);
        spaceship.setOriginCenter();
        speed = new Vector2();
    }

    public void draw(SpriteBatch spriteBatch) {
        spaceship.draw(spriteBatch);
    }

    public float getRotation() {
        return spaceship.getRotation();
    }

    public void rotate(float degrees) {
        spaceship.rotate(degrees);
    }

    public float getX() {
        return spaceship.getX();
    }

    public float getY() {
        return spaceship.getY();
    }

    public void setPosition(float x, float y) {
        spaceship.setPosition(x, y);
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }
}