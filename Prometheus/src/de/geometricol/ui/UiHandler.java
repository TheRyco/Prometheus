package de.geometricol.ui;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.geometricol.Handlers.AssetLoader;

public class UiHandler {
	
	public static OrthographicCamera cam;
	public static SpriteBatch sB;
	public static BitmapFont font;

	public static float SCREEN_WIDTH;
	public static float SCREEN_HEIGHT;
	public static float GAME_WIDTH;
	public static float GAME_HEIGHT;
	public static float SIZING_FACTOR;

	public static TestButton testButton;
	public static ScreenButton xButton;

	public static void update(float delta) {
		ScreenButton.update(delta);
		if(ScreenButton.buttons.get("SB_X").isClicked) System.out.println("Hit!");
	}

	public static void render() {
		ScreenButton.render(sB);
		sB.begin();
		font.draw(sB, "test", 0, 300);
		sB.end();
	}

	public static void load(float screenWidth, float screenHeight, float gameWidth, float gameHeight, float sizingFactor) {
		cam = new OrthographicCamera();
		SCREEN_WIDTH = screenWidth;
		SCREEN_HEIGHT = screenHeight;
		GAME_WIDTH = gameWidth;
		GAME_HEIGHT = gameHeight;
		SIZING_FACTOR = sizingFactor;
		
		cam.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
		sB = new SpriteBatch();
		sB.setProjectionMatrix(cam.combined);
		font = new BitmapFont();
		

		//if(Gdx.app.getType() == ApplicationType.Desktop) return;
		
		xButton = new ScreenButton("SB_X", SCREEN_WIDTH - 150, 50, 80, 80, AssetLoader.xButton);
		xButton.visible = true;

	}

}
