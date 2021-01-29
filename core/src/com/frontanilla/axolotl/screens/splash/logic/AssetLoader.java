package com.frontanilla.axolotl.screens.splash.logic;

import com.frontanilla.axolotl.screens.shared.Assets;

public class AssetLoader {

    private Assets assets;
    private SplashLogic logic;
    // Logic
    private boolean loadingAssets;

    public void queueAssetLoading() {
        assets.queueAssetLoading();
        loadingAssets = true;
    }

    public void update() {
        if (!loadingAssets) {
            return;
        }
        if (assets.loadAssets()) {
            loadingAssets = false;
            assets.initializeAssets();
            logic.getTransitionHandler().transitionToGameScreen();
        }
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public void setLogic(SplashLogic logic) {
        this.logic = logic;
    }
}