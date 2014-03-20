package de.geometricol.ui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.geometricol.Handlers.AssetLoader;

public class UiHandler {

	public static float SCREEN_WIDTH;
	public static float SCREEN_HEIGHT;
	public static float GAME_WIDTH;
	public static float GAME_HEIGHT;
	public static float SIZING_FACTOR;

	public static TestButton testButton;
	public static ScreenButton xButton, xButton2, xButton3, xButton4;

	public static void update(float delta) {
		ScreenButton.update(delta);
	}

	public static void render(SpriteBatch sB) {
		ScreenButton.render(sB);
	}

	public static void load(float screenWidth, float screenHeight, float gameWidth, float gameHeight, float sizingFactor) {
		SCREEN_WIDTH = screenWidth;
		SCREEN_HEIGHT = screenHeight;
		GAME_WIDTH = gameWidth;
		GAME_HEIGHT = gameHeight;
		SIZING_FACTOR = sizingFactor;

		xButton = new ScreenButton("SB_X", GAME_WIDTH - 3, 1.2f, 1.2f, 1.2f, AssetLoader.xButton);
		xButton.visible = true;

	}

}
