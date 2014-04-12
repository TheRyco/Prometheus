package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.math.Vector2;

import de.geometricol.Tile.TileGrass;
import de.geometricol.Tile.TileStone;

public class MapTest extends Map {

	public MapTest() {
		super();
		spawn = new Vector2(1, 1);

		for (int x = -5; x < 3; x++) {
			for (int y = -5; y < 3; y++) {
				tiles.add(new TileGrass(new Vector2(x, y), 1, 1));
			}
		}
		for (int x = -6; x < 4; x++) {
			tiles.add(new TileStone(new Vector2(x, 3), 1, 1));
		}
		for (int y = -6; y < 3; y++) {
			tiles.add(new TileStone(new Vector2(-6, y), 1, 1));
		}
		for (int x = -5; x < 4; x++) {
			tiles.add(new TileStone(new Vector2(x, -6), 1, 1));
		}
		for (int y = -5; y < 3; y++) {
			tiles.add(new TileStone(new Vector2(3, y), 1, 1));
		}
	}
}
