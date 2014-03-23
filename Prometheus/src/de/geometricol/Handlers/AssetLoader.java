package de.geometricol.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture buttons,platzhalter,grass,player;
	public static TextureRegion testButton, xButton;

	public static void load() {

		buttons = new Texture(Gdx.files.internal("data/Buttons.png"));
		buttons.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		platzhalter = new Texture(Gdx.files.internal("data/Textures/Platzhalter_Tile.png"));
		grass = new Texture(Gdx.files.internal("data/Textures/Grass.png"));
		player = new Texture(Gdx.files.internal("data/Textures/Player.png"));
		
		testButton = new TextureRegion(buttons, 0, 0, 15, 15);
		xButton = new TextureRegion(buttons, 16, 0, 32, 32);
	}

	public static void dispose() {
		buttons.dispose();
	}

}
