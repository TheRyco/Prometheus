package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.geometricol.ui.UiHandler;

public class GameRenderer {

	public Screen screen;
	public SpriteBatch sB;
	
	private OrthographicCamera cam;

	public GameRenderer(Screen screen, OrthographicCamera cam) {
		this.screen = screen;
		this.cam = cam;
		sB = new SpriteBatch();
		sB.setProjectionMatrix(cam.combined);

	}
	
	
	public void render(float delta){
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		UiHandler.update(delta);
		UiHandler.render(sB);
		
	}

}
