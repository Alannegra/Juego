package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    Texture texture;

    Background(){
        texture = new Texture("Space.jpg");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0,0);
    }
}