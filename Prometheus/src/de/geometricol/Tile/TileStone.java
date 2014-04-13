package de.geometricol.Tile;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import de.geometricol.Handlers.AssetLoader;

public class TileStone extends Tile {

	public TileStone(Vector2 position, float width, float height) {
		super(position, width, height);
		texture = AssetLoader.stone;
		collidable = true;
		bounds = new Rectangle(position.x + 0.125f, position.y + 0.25f, width - 0.1875f, height - 0.45f);
		
	
	}

}
