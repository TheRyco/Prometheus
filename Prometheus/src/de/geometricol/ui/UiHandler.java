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
	public static ScreenButton xButton,leftButton, rightButton, upButton, downButton;

	public static void update(float delta) {
		ScreenButton.update(delta);
		
	}

	public static void render() {
		ScreenButton.render(sB);
		
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
		
		leftButton = new ScreenButton("SB_LEFT", 10, 50, 50, 50, AssetLoader.leftButton);
		leftButton.visible = true;
		rightButton = new ScreenButton("SB_RIGHT", 90, 50, 50, 50, AssetLoader.rightButton);
		rightButton.visible = true;
		upButton = new ScreenButton("SB_UP", 50, 90, 50, 50, AssetLoader.upButton);
		upButton.visible = true;
		downButton = new ScreenButton("SB_DOWN", 50, 10, 50, 50, AssetLoader.downButton);
		downButton.visible = true;
	}

}
