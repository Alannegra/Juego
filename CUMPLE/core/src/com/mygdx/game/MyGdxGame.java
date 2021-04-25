package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

// http://millionthvector.blogspot.com/p/free-sprites.html

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	Background background;
	J1 j1;
	J2 j2;

	Attack attack;
	Walk walk;
	@Override
	public void create() {
		attack = new Attack();
		walk = new Walk();


		batch = new SpriteBatch();
		background = new Background();
		j1 = new J1();
		j2 = new J2();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		j1.update();
		j2.update();


		batch.begin();
		background.render(batch);

		attack.render(batch);
		walk.render(batch);

		j1.render(batch);
		j2.render(batch);
		j1.animation(batch);
		j2.animation(batch);


		batch.end();
	}
}