package de.geometricol.ui;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.geometricol.Handlers.AssetLoader;

public class UiHandler {

	public static int SCREEN_WIDTH;
	public static int SCREEN_HEIGHT;
	public static int GAME_WIDTH;
	public static int GAME_HEIGHT;

	public static TestButton testButton;
	public static ScreenButton xButton, xButton2, xButton3, xButton4;

	public static void update(float delta) {
		ScreenButton.update(delta);
	}

	public static void render(SpriteBatch sB) {
		ScreenButton.render(sB);
	}

	public static void load(float screenWidth, float screenHeight, float gameWidth, float gameHeight) {
		SCREEN_WIDTH = (int) screenWidth;
		SCREEN_HEIGHT = (int) screenHeight;
		GAME_WIDTH = (int) gameWidth;
		GAME_HEIGHT = (int) gameHeight;

		xButton = new ScreenButton("SB_X", GAME_WIDTH - 65, GAME_HEIGHT - 50, 60, 60, AssetLoader.xButton);

	}

}
