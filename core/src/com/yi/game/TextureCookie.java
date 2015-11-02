package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * this class represent a single image and its movement data
 */
public class TextureCookie {
    Texture textureCookie;
    /**
     * Rectangle
     * create rectangles of size of texture size on random x y position
     */
    Rectangle rectCookieBorder;
    float screenWidth, screenHeight, textureWidth, textureHeight;
    /**
     * Vector2
     * use for direction and speed by setting x and y
     */
    Vector2 vector2CookieXY;
    float velocity;

    public TextureCookie(){
        textureCookie = new Texture(Gdx.files.internal("cookie.png"));
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        textureWidth = textureCookie.getWidth();
        textureHeight = textureCookie.getHeight();

        rectCookieBorder = new Rectangle();
        rectCookieBorder.x = MathUtils.random(0, screenWidth - textureWidth);
        rectCookieBorder.y = MathUtils.random(0, screenHeight - textureHeight);
//        rectCookieBorder.width = MathUtils.random(textureWidth / 2, textureWidth * 2);
//        rectCookieBorder.height = MathUtils.random(textureHeight / 2, textureHeight * 2);
        rectCookieBorder.width = textureWidth;
        rectCookieBorder.height = textureHeight;

        vector2CookieXY = new Vector2(0, 0);
        velocity = 100f;
        setRandomVector2();
    }

    /**
     * generate a random Vector2 x y
     */
    public void setRandomVector2(){
        vector2CookieXY.x = MathUtils.random(-velocity, velocity);
        vector2CookieXY.y = MathUtils.random(-velocity, velocity);
    }
}
