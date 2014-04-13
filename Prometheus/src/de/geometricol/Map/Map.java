package de.geometricol.Map;

import java.util.ArrayList;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

import de.geometricol.Handlers.AssetLoader;
import de.geometricol.Tile.Tile;
import de.geometricol.Tile.TileStone;

public class Map {

	public ArrayList<Tile> tiles;
	public int widthInTiles;
	public int heightInTiles;
	public boolean debug;
	public Vector2 spawn;
	public Pixmap pixmap;

	public Map(FileHandle file, Vector2 spawn, boolean debug) {
		this.spawn = spawn;
		this.debug = debug;
		this.tiles = new ArrayList<Tile>();

		loadFromFile(file, false);
	}

	public Map(FileHandle file, boolean debug) {
		this.debug = debug;
		this.tiles = new ArrayList<Tile>();

		loadFromFile(file, true);
	}

	public Map() {
		this.tiles = new ArrayList<Tile>();
	}

	public void render(SpriteBatch sB, ShapeRenderer sR) {
		sB.begin();
		for (Tile tile : tiles) {
			tile.render(sB);
		}
		sB.end();
		if (debug) {
			sR.begin(ShapeType.Line);
			for (Tile tile : tiles) {
				tile.renderBounds(sR, Color.RED);
			}
			sR.end();
		}

	}

	public void loadFromFile(FileHandle file, boolean spawnFromFile) {
		try {
			pixmap = new Pixmap(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int y = 0; y < pixmap.getHeight(); y++) {
			for (int x = 0; x < pixmap.getWidth(); x++) {
				Vector2 pos = new Vector2(x, y);

				if (pixmap.getPixel(x, pixmap.getHeight() - y - 1) == 0xFFFFFFff) {
					spawn = new Vector2(pos);
					tiles.add(new Tile(pos, 1, 1, AssetLoader.grass, true, false));
				}

				if (pixmap.getPixel(x, pixmap.getHeight() - y - 1) == 0x00FF00ff) tiles.add(new Tile(pos, 1, 1, AssetLoader.grass, true, false));

				if (pixmap.getPixel(x, pixmap.getHeight() - y - 1) == 0x404040ff) tiles.add(new TileStone(pos,1,1));
			}
		}

		widthInTiles = pixmap.getWidth();
		heightInTiles = pixmap.getHeight();

	}
}
