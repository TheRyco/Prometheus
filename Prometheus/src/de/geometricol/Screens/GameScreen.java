package de.geometricol.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

import de.geometricol.Handlers.InputHandler;
import de.geometricol.WorldNRenderer.GameRenderer;
import de.geometricol.WorldNRenderer.GameWorld;
import de.geometricol.ui.UiHandler;

public class GameScreen implements Screen {
	public OrthographicCamera cam;

	public GameWorld world;
	public GameRenderer renderer;
	public InputHandler inputHandler;

	public final float SCREEN_WIDTH = Gdx.graphics.getWidth();
	public final float SCREEN_HEIGHT = Gdx.graphics.getHeight();

	public final float GAME_WIDTH = 300;
	public final float GAME_HEIGHT = 300 * (SCREEN_HEIGHT / SCREEN_WIDTH);

	public GameScreen() {
		UiHandler.load(SCREEN_WIDTH, SCREEN_HEIGHT, GAME_WIDTH, GAME_HEIGHT);
		System.out.println("SW: " + SCREEN_WIDTH + " SH: " + SCREEN_HEIGHT + " GW: " + GAME_WIDTH + " GH: " + GAME_HEIGHT);
		cam = new OrthographicCamera();
		cam.setToOrtho(true, GAME_WIDTH, GAME_HEIGHT);
		this.world = new GameWorld(this);
		this.renderer = new GameRenderer(this, cam);
		this.inputHandler = new InputHandler();
		Gdx.input.setInputProcessor(inputHandler);

	}

	@Override
	public void render(float delta) {
		renderer.render(delta);
		world.update(delta);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

}
