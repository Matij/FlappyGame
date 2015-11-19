package com.kilobolt.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.kilobolt.gameworld.GameRenderer;
import com.kilobolt.gameworld.GameWorld;
import com.kilobolt.zbHelpers.InputHandler;

/**
 * Created by martafoderaro on 19/11/2015.
 */
public class GameScreen implements Screen {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    private float runTime = 0;

    public GameScreen(){
        Gdx.app.log("GameScreen", "Attached");

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);

        gameWorld = new GameWorld(midPointY);
        gameRenderer = new GameRenderer(gameWorld, (int) gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(gameWorld.getBird()));
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        gameWorld.update(delta);
        gameRenderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {

    }
}
