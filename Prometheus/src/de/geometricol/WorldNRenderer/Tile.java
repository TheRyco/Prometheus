package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Tile {

	public Texture texture;
	
	public Vector2 position;
	public float width;
	public float height;
	
	public Rectangle bounds;
	public boolean collidable;

	public Tile(Vector2 position, float width, float height) {
		this.position = position;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(position.x, position.y, width, height);
	}
	
	public void render(SpriteBatch sB){
		sB.draw(texture,position.x, position.y, width, height);
	}
	
	public void renderBounds(ShapeRenderer sR, Color color){
		sR.setColor(color);
		sR.rect(bounds.x, bounds.y, bounds.x + bounds.width, bounds.y + bounds.height);
	}

}
