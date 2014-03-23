package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.math.Vector2;

public class MapTest extends Map {

	public MapTest() {
		super();
		spawn = new Vector2(1,2);

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				tiles.add(new TileGrass(new Vector2(x, y), 1, 1));
			}
		}
	}

}
