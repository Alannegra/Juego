package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class J1 {
    Texture texture;
    float x, y, w, h;
    List<Bullet> bullets;

    int f;

    Animation animation;
    float tiempo;
    TextureRegion[] regionsMovimiento;
    Texture imagen;
    TextureRegion frameActual;
    Attack attack;

    J1(){

        Attack attack = new Attack();

        texture =  new Texture("Alien.png");
        x = 100;
        y = 200;
        w = 100;
        h = 100;
        bullets = new ArrayList<>();
        f = 1;

        imagen = new Texture("Cuca.png");


        TextureRegion [][] tmp = TextureRegion.split(imagen, imagen.getWidth()/8, imagen.getHeight());

        regionsMovimiento = new TextureRegion[8];


        for (int i = 0; i < 8; i++) regionsMovimiento[i] = tmp[0][i];
        animation = new Animation(1/5f,regionsMovimiento);
        tiempo = 0f;



    }

    void render(SpriteBatch batch){
        tiempo += Gdx.graphics.getDeltaTime();
        frameActual = (TextureRegion) animation.getKeyFrame(tiempo,true);
        //frameActual =  animation.getKeyFrame(tiempo,true);



        if (f == 0) batch.draw(texture, x, y, w, h);
        else if(f == 1) batch.draw(frameActual, x, y, w, h);

        for (Bullet bala: bullets) {
            bala.render(batch);
        }
    }

    void animation(SpriteBatch batch){

        if (Gdx.input.isKeyJustPressed(Input.Keys.F )&& f == 1)  f = 0;
        else if (Gdx.input.isKeyJustPressed(Input.Keys.F) && f == 0) f = 1 ;



    }



    void update(){
        for (Bullet bala: bullets) {
            bala.update();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) x += 5;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x -= 5;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y += 5;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y -= 5;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet(x+w/2, y+h));
        }
    }



}
