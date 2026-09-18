package com.mindral.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MindralGame extends Game {
    @Override
    public void create() {
        Gdx.gl.glClearColor(0.06f, 0.08f, 0.10f, 1.0f);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
