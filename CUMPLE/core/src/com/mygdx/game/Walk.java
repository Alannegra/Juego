package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Walk {

    float x,y,w,h;
    int n;

    Animation animation;
    float tiempo;
    TextureRegion[] regionsMovimiento;
    Texture imagen;
    TextureRegion frameActual;

    Walk(){
        x = 100;
        y= 300;
        h= 100;
        w=100;
        n= 5;

        imagen = new Texture("horror walk.png");

        TextureRegion [][] tmp = TextureRegion.split(imagen, imagen.getWidth()/n, imagen.getHeight());

        regionsMovimiento = new TextureRegion[n];
        for (int i = 0; i < n; i++) regionsMovimiento[i] = tmp[0][i];
        animation = new Animation(1/5f,regionsMovimiento);
        tiempo = 0f;

    }


    void render(SpriteBatch batch){
        tiempo += Gdx.graphics.getDeltaTime();
        frameActual = (TextureRegion) animation.getKeyFrame(tiempo,true);


        batch.draw(frameActual, x, y, w, h);





    }

}
