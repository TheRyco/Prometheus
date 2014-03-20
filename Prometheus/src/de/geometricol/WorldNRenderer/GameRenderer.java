package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.geometricol.Screens.GameScreen;
import de.geometricol.ui.UiHandler;

public class GameRenderer {

	public GameScreen screen;
	public SpriteBatch sB;
	
	private OrthographicCamera cam;

	public GameRenderer(GameScreen screen) {
		this.screen = screen;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, screen.GAME_WIDTH, screen.GAME_HEIGHT);
		sB = new SpriteBatch();
		sB.setProjectionMatrix(cam.combined);

	}
	
	
	public void render(float delta){
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		UiHandler.update(delta);
		UiHandler.render(sB);
		
	}

}
