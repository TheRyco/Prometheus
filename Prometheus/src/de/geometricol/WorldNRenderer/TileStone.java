package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.math.Vector2;

import de.geometricol.Handlers.AssetLoader;

public class TileStone extends Tile {

	public TileStone(Vector2 position, float width, float height) {
		super(position, width, height);
		texture = AssetLoader.stone;
		collidable = true;
		
	
	}

}
