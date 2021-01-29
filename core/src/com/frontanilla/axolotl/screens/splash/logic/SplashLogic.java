package com.frontanilla.axolotl.screens.splash.logic;

import com.frontanilla.axolotl.ViscachaGame;
import com.frontanilla.axolotl.screens.shared.Assets;
import com.frontanilla.axolotl.screens.shared.Logic;
import com.frontanilla.axolotl.screens.shared.Screen;

public class SplashLogic extends Logic {

    private final AssetLoader assetLoader;
    private final TransitionHandler transitionHandler;

    public SplashLogic() {
        assetLoader = new AssetLoader();
        transitionHandler = new TransitionHandler();

        assetLoader.setLogic(this);
    }

    public void initialLogic() {
        assetLoader.queueAssetLoading();
    }

    @Override
    public void update(float delta) {
        assetLoader.update();
    }

    public void setGame(ViscachaGame game) {
        transitionHandler.setGame(game);
    }

    public void setAssets(Assets assets) {
        assetLoader.setAssets(assets);
        transitionHandler.setAssets(assets);
    }

    public void setScreen(Screen screen) {
        transitionHandler.setScreen(screen);
    }

    public TransitionHandler getTransitionHandler() {
        return transitionHandler;
    }
}