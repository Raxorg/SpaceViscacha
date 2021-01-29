package com.frontanilla.axolotl.screens.game.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.frontanilla.axolotl.screens.game.stuff.GameStuff;
import com.frontanilla.axolotl.screens.game.stuff.Spaceship;

import static com.frontanilla.axolotl.screens.shared.Constants.SPACESHIP_ACCELERATION_SPEED;
import static com.frontanilla.axolotl.screens.shared.Constants.SPACESHIP_MAX_SPEED;
import static com.frontanilla.axolotl.screens.shared.Constants.SPACESHIP_ROTATION_SPEED;

public class SpaceshipHandler {

    private GameStuff stuff;
    // Logic
    private float rotationSpeed;
    private float acceleration;
    private float decelerationProgress;
    private Vector2 startingDeceleratingSpeed;

    public SpaceshipHandler() {
        startingDeceleratingSpeed = new Vector2();
    }

    public void turnKeyPressed(boolean right) {
        rotationSpeed += SPACESHIP_ROTATION_SPEED * (right ? -1 : 1);
    }

    public void turnKeyReleased(boolean right) {
        rotationSpeed -= SPACESHIP_ROTATION_SPEED * (right ? -1 : 1);
    }

    public void accelerationKeyPressed(boolean forward) {
        acceleration += SPACESHIP_ACCELERATION_SPEED * (forward ? -1 : 1);
        if (acceleration == 0f) {
            decelerationProgress = 0f;
            startingDeceleratingSpeed = stuff.getSpaceship().getSpeed();
        }
    }

    public void accelerationKeyReleased(boolean forward) {
        acceleration -= SPACESHIP_ACCELERATION_SPEED * (forward ? -1 : 1);
        if (acceleration == 0f) {
            decelerationProgress = 0f;
            startingDeceleratingSpeed = stuff.getSpaceship().getSpeed();
        }
    }

    public void update(float delta) {
        Spaceship spaceship = stuff.getSpaceship();
        spaceship.rotate(rotationSpeed * delta);
        calculateSpeed(spaceship, delta);
    }

    private void calculateSpeed(Spaceship spaceship, float delta) {
        Vector2 speed = spaceship.getSpeed();
        speed.x += (MathUtils.cosDeg(spaceship.getRotation() - 90)) * acceleration * delta;
        speed.x = MathUtils.clamp(speed.x, -SPACESHIP_MAX_SPEED, SPACESHIP_MAX_SPEED);
        speed.y += (MathUtils.sinDeg(spaceship.getRotation() - 90)) * acceleration * delta;
        speed.y = MathUtils.clamp(speed.y, -SPACESHIP_MAX_SPEED, SPACESHIP_MAX_SPEED);

        if (acceleration == 0f) {
            decelerationProgress = Math.min(decelerationProgress + delta / 1.5f, 1f);
            spaceship.setSpeed(startingDeceleratingSpeed.cpy().lerp(new Vector2(), decelerationProgress));
        }

        float newX = spaceship.getX() + speed.x;
        float newY = spaceship.getY() + speed.y;
        spaceship.setPosition(newX, newY);
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}