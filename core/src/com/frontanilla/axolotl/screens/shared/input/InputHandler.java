package com.frontanilla.axolotl.screens.shared.input;

public abstract class InputHandler {

    public abstract void touchDown(float x, float y);

    public abstract void touchUp(float x, float y);

    public abstract void keyDown(int keycode);

    public abstract void keyUp(int keycode);
}
