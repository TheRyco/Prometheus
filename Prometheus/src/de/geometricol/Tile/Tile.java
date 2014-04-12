package de.geometricol.Tile;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tile {

	public Texture texture;
	public boolean visible = true;

	public Vector2 position;
	public float width;
	public float height;

	public Rectangle bounds;
	public boolean collidable = false;
	
	public Tile(Vector2 position, float width, float height, Texture texture, boolean visible, boolean collidable) {
		this.position = position;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(position.x, position.y, width, height);
		
		this.texture = texture;
		this.visible = visible;
		this.collidable = collidable;
	}
	


	public Tile(Vector2 position, float width, float height) {
		this.position = position;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(position.x, position.y, width, height);
	}

	public void render(SpriteBatch sB) {
		if (texture != null && visible) sB.draw(texture, position.x, position.y, width, height);
	}

	public void renderBounds(ShapeRenderer sR, Color color) {
		sR.setColor(color);
		sR.rect(bounds.x, bounds.y, bounds.width, bounds.height);
	}

}
