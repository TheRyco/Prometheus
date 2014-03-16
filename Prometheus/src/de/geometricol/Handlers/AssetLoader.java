package de.geometricol.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture buttons;
	public static TextureRegion testButton, xButton;
	
	
	public static void load(){
		
		buttons = new Texture(Gdx.files.internal("data/Buttons.png"));
		buttons.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		testButton = new TextureRegion(buttons, 0, 0, 15, 15);
		testButton.flip(true, false);
		xButton = new TextureRegion(buttons, 16, 0, 32, 32);
		xButton.flip(true, false);
	}
	
	public static void dispose(){
		buttons.dispose();
	}

}
