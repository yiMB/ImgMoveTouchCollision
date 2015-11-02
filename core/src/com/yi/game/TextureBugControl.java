package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

/**
 * this TextureBugControl class is a copy of TextureCookieControl class
 */
public class TextureBugControl {
    Array<TextureBug> arrTextureBugs;

    public TextureBugControl(){
        arrTextureBugs = new Array<TextureBug>();
    }

    public void addTextureBug(){
        TextureBug textureBug = new TextureBug();
        arrTextureBugs.add(textureBug);
    }

    public void addNTextureBug(int n){
        while(n > 0){
            addTextureBug();
            n--;
        }
    }

    public void update(){
        for(int i=0; i < arrTextureBugs.size; i++){
            if(arrTextureBugs.get(i).rectBugBorder.x <= 0){
                arrTextureBugs.get(i).vector2BugXY.x = -arrTextureBugs.get(i).vector2BugXY.x;
            }
            if(arrTextureBugs.get(i).rectBugBorder.x + arrTextureBugs.get(i).textureWidth >= arrTextureBugs.get(i).screenWidth){
                arrTextureBugs.get(i).vector2BugXY.x = -arrTextureBugs.get(i).vector2BugXY.x;
            }
            if(arrTextureBugs.get(i).rectBugBorder.y <= 0){
                arrTextureBugs.get(i).vector2BugXY.y = -arrTextureBugs.get(i).vector2BugXY.y;
            }
            if(arrTextureBugs.get(i).rectBugBorder.y + arrTextureBugs.get(i).textureHeight >= arrTextureBugs.get(i).screenHeight){
                arrTextureBugs.get(i).vector2BugXY.y = -arrTextureBugs.get(i).vector2BugXY.y;
            }
            arrTextureBugs.get(i).rectBugBorder.x += arrTextureBugs.get(i).vector2BugXY.x * Gdx.graphics.getDeltaTime();
            arrTextureBugs.get(i).rectBugBorder.y += arrTextureBugs.get(i).vector2BugXY.y * Gdx.graphics.getDeltaTime();
        }
    }
}
