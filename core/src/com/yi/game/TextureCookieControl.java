package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

/**
 * this class is the create an array of images, each image has its own movement data,
 * when each image reach the edge of the screen id change to random direction and speed
 */
public class TextureCookieControl {
    Array<TextureCookie> arrTextureCookies;

    public TextureCookieControl(){
        arrTextureCookies = new Array<TextureCookie>();
    }

    public void addTextureCookie(){
        TextureCookie textureCookie = new TextureCookie();
        arrTextureCookies.add(textureCookie);
    }

    public void addNTextureCookie(int n){
        while(n > 0){
            addTextureCookie();
            n--;
        }
    }

    /**
     * update,
     * when each image reach the edge of the screen id change to random direction and speed
     */
    public void update(){
        for(int i=0; i < arrTextureCookies.size; i++){
            if(arrTextureCookies.get(i).rectCookieBorder.x <= 0){
//                arrTextureCookies.get(i).setRandomVector2();
                arrTextureCookies.get(i).vector2CookieXY.x = -arrTextureCookies.get(i).vector2CookieXY.x;
            }
            if(arrTextureCookies.get(i).rectCookieBorder.x + arrTextureCookies.get(i).textureWidth >= arrTextureCookies.get(i).screenWidth){
//                arrTextureCookies.get(i).setRandomVector2();
                arrTextureCookies.get(i).vector2CookieXY.x = -arrTextureCookies.get(i).vector2CookieXY.x;
            }
            if(arrTextureCookies.get(i).rectCookieBorder.y <= 0){
//                arrTextureCookies.get(i).setRandomVector2();
                arrTextureCookies.get(i).vector2CookieXY.y = -arrTextureCookies.get(i).vector2CookieXY.y;
            }
            if(arrTextureCookies.get(i).rectCookieBorder.y + arrTextureCookies.get(i).textureHeight >= arrTextureCookies.get(i).screenHeight){
//                arrTextureCookies.get(i).setRandomVector2();
                arrTextureCookies.get(i).vector2CookieXY.y = -arrTextureCookies.get(i).vector2CookieXY.y;
            }
            arrTextureCookies.get(i).rectCookieBorder.x += arrTextureCookies.get(i).vector2CookieXY.x * Gdx.graphics.getDeltaTime();
            arrTextureCookies.get(i).rectCookieBorder.y += arrTextureCookies.get(i).vector2CookieXY.y * Gdx.graphics.getDeltaTime();
        }
    }
}

