package de.geometricol.Tile;

import com.badlogic.gdx.math.Vector2;

import de.geometricol.Handlers.AssetLoader;

public class TileTest extends Tile {

	public TileTest(Vector2 position, float width, float height) {
		super(position, width, height);
		texture = AssetLoader.platzhalter;
	}

}
