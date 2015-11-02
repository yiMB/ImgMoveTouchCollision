package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * collision detection
 *
 * this simple game will generate 9 bugs and 9 cookies in random location,
 * and moving random direction.
 *
 * when either cookie, bug, or finger touch location collide cookie and or bug will disappear,
 * when all bug and cookie disappear, all game will reset again.
 */
public class ImgMoveTouchCollision extends ApplicationAdapter {
	SpriteBatch batch;
	TextureCookieControl textureCookieControl;
	TextureBugControl textureBugControl;

	@Override
	public void create () {
		batch = new SpriteBatch();
		textureCookieControl = new TextureCookieControl();
		// add 9 cookie into array
		textureCookieControl.addNTextureCookie(9);
		textureBugControl = new TextureBugControl();
		// add 9 bug into array
		textureBugControl.addNTextureBug(9);
	}

	@Override
	public void dispose() {
		batch.dispose();
		// we created 9 cookie image into the array, so we need to dispose all 9, same for bug
		for(int i=0; i < textureCookieControl.arrTextureCookies.size; i++){
			textureCookieControl.arrTextureCookies.get(i).textureCookie.dispose();
		}
		for(int i=0; i < textureBugControl.arrTextureBugs.size; i++){
			textureBugControl.arrTextureBugs.get(i).textureBug.dispose();
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		// the 2 outer for loops draw all cookies and bugs
		// each outer for loop check when finger touch bug or cookie, bug or cookie disappear
		// the last for outer loop use nested inner for loop to check when cookie and bug collide, both disappear
		//
		// 2 method used to check for collision,
		//		current_rectangle.overlaps(another_rectangle)
		//		current_rectangle.contains(x, y)
		for(TextureCookie textureCookie : textureCookieControl.arrTextureCookies){
			batch.draw(textureCookie.textureCookie, textureCookie.rectCookieBorder.x, textureCookie.rectCookieBorder.y,
					textureCookie.rectCookieBorder.width, textureCookie.rectCookieBorder.height);
			if(textureCookie.rectCookieBorder.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
				textureCookieControl.arrTextureCookies.removeValue(textureCookie, true);
			}
//			if(textureCookie.rectCookieBorder.overlaps(new Rectangle(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 64, 64))) {
//				textureCookieControl.arrTextureCookies.removeValue(textureCookie, true);
//			}
		}
		for(TextureBug textureBug : textureBugControl.arrTextureBugs){
			batch.draw(textureBug.textureBug, textureBug.rectBugBorder.x, textureBug.rectBugBorder.y,
					textureBug.rectBugBorder.width, textureBug.rectBugBorder.height);
			for(TextureCookie textureCookie : textureCookieControl.arrTextureCookies){
				if(textureCookie.rectCookieBorder.overlaps(textureBug.rectBugBorder)){
					textureCookieControl.arrTextureCookies.removeValue(textureCookie, true);
					textureBugControl.arrTextureBugs.removeValue(textureBug, true);
				}
			}
			if(textureBug.rectBugBorder.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
				textureBugControl.arrTextureBugs.removeValue(textureBug, true);
			}
//			if(textureBug.rectBugBorder.overlaps(new Rectangle(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 64, 64))) {
//				textureBugControl.arrTextureBugs.removeValue(textureBug, true);
//			}
		}

		batch.end();
		System.out.println("mytab textureCookieControl.arrTextureCookies:" + textureCookieControl.arrTextureCookies.size);
		System.out.println("mytab textureBugControl.arrTextureBugs:" + textureBugControl.arrTextureBugs.size);
		// when no more cookie and bug reset game
		if(textureCookieControl.arrTextureCookies.size == 0 && textureBugControl.arrTextureBugs.size == 0){
			resetGame();
		}
		textureCookieControl.update();
		textureBugControl.update();
	}

	/**
	 * remove all cookie and bug from both array,
	 * add image back to both array again
	 */
	public void resetGame(){
		textureCookieControl.arrTextureCookies.clear();
		textureCookieControl.addNTextureCookie(9);
		textureBugControl.arrTextureBugs.clear();
		textureBugControl.addNTextureBug(9);
	}
}
