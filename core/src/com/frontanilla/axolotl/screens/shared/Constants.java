package com.frontanilla.axolotl.screens.shared;

import com.badlogic.gdx.Gdx;

public class Constants {

    public static final float RATIO = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
    public static final int CAMERA_HEIGHT = 1000;
    public static final int CAMERA_WIDTH = (int) (CAMERA_HEIGHT * RATIO);
    // Story visualizer
    public static final int STORY_PARTS = 1;
    public static final float STORY_TRANSITION_DURATION = 0.5f;
    public static final int STORY_BUTTON_SIZE = 100;
    // Spaceship
    public static final int SPACESHIP_ROTATION_SPEED = 200;
    public static final int SPACESHIP_ACCELERATION_SPEED = 20;
    public static final int SPACESHIP_MAX_SPEED = 5;
}