package de.geometricol.Tile;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import de.geometricol.Handlers.AssetLoader;

public class TileStone extends Tile {

	public TileStone(Vector2 position, float width, float height) {
		super(position, width, height);
		texture = AssetLoader.stone;
		collidable = true;
		this.bounds = new Rectangle(position.x + 0.5f, position.y, width + 0.5f, height);
		
	
	}

}
