package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * this TextureBug class is a copy of TextureCookie class
 */
public class TextureBug {
    Texture textureBug;
    Rectangle rectBugBorder;
    float screenWidth, screenHeight, textureWidth, textureHeight;
    Vector2 vector2BugXY;
    float velocity;

    public TextureBug(){
        textureBug = new Texture(Gdx.files.internal("bug.png"));
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        textureWidth = textureBug.getWidth();
        textureHeight = textureBug.getHeight();

        rectBugBorder = new Rectangle();
        rectBugBorder.x = MathUtils.random(0, screenWidth - textureWidth);
        rectBugBorder.y = MathUtils.random(0, screenHeight - textureHeight);
//        rectBugBorder.width = MathUtils.random(textureWidth / 2, textureWidth * 2);
//        rectBugBorder.height = MathUtils.random(textureHeight / 2, textureHeight * 2);
        rectBugBorder.width = textureWidth;
        rectBugBorder.height = textureHeight;

        vector2BugXY = new Vector2(0, 0);
        velocity = 100f;
        setRandomVector2();
    }

    public void setRandomVector2(){
        vector2BugXY.x = MathUtils.random(-velocity, velocity);
        vector2BugXY.y = MathUtils.random(-velocity, velocity);
    }
}
