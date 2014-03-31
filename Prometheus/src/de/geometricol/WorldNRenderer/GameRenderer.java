package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import de.geometricol.Handlers.InputHandler;
import de.geometricol.Screens.GameScreen;
import de.geometricol.ui.UiHandler;

public class GameRenderer {

	public GameScreen screen;
	public SpriteBatch sB;
	public ShapeRenderer sR;

	Integer frames = 0;
	float time = 0;
	String lastFrames = "0";

	private OrthographicCamera cam;

	public GameRenderer(GameScreen screen) {
		this.screen = screen;
		cam = new OrthographicCamera();
		cam.setToOrtho(false, screen.GAME_WIDTH, screen.GAME_HEIGHT);
		sB = new SpriteBatch();
		sB.setProjectionMatrix(cam.combined);
		sR = new ShapeRenderer();
		sR.setProjectionMatrix(cam.combined);

	}

	public void updateCam() {
		cam.position.x = screen.world.player.position.x
				+ screen.world.player.width / 2;
		cam.position.y = screen.world.player.position.y
				+ screen.world.player.height / 2;

		cam.update();
		sR.setProjectionMatrix(cam.combined);
		sB.setProjectionMatrix(cam.combined);
	}

	public void render(float delta) {
		updateCam();
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		screen.world.currentMap.render(sB, sR);
		screen.world.player.render(sB, sR);

		UiHandler.update(delta);
		UiHandler.render();

		frames++;
		time += delta;

		if (time >= 1.0f) {
			System.out.println(frames.toString());
			lastFrames = frames.toString();
			frames = 0;
			time = 0;
		}
		UiHandler.sB.begin();
		UiHandler.font.draw(UiHandler.sB, lastFrames, 30, screen.SCREEN_HEIGHT - 30);
		UiHandler.sB.end();

	}

}
