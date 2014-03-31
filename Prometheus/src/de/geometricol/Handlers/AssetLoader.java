package de.geometricol.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture buttons,platzhalter,grass,player,stone;
	public static TextureRegion testButton, xButton, upButton, downButton, leftButton, rightButton;

	public static void load() {

		buttons = new Texture(Gdx.files.internal("data/Buttons.png"));
		buttons.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		platzhalter = new Texture(Gdx.files.internal("data/Textures/Platzhalter_Tile.png"));
		grass = new Texture(Gdx.files.internal("data/Textures/Grass.png"));
		stone = new Texture(Gdx.files.internal("data/Textures/Stone.png"));
		player = new Texture(Gdx.files.internal("data/Textures/Player.png"));
		
		testButton = new TextureRegion(buttons, 0, 0, 15, 15);
		xButton = new TextureRegion(buttons, 16, 0, 32, 32);
		leftButton = new TextureRegion(buttons, 48, 0, 31, 31);
		rightButton = new TextureRegion(buttons, 80, 0, 31, 31);
		upButton = new TextureRegion(buttons, 143, 0, 31, 31);
		downButton = new TextureRegion(buttons, 111, 0, 31, 31);
		
	}

	public static void dispose() {
		buttons.dispose();
	}

}
