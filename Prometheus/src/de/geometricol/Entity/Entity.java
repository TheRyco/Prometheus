package de.geometricol.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import de.geometricol.Screens.GameScreen;

public abstract class Entity {

	public boolean debug = false;

	public boolean shouldDraw = true;

	public Vector2 position;
	public float width;
	public float height;
	public float speed;
	public Rectangle bounds;
	public Rectangle leftBounds;
	public Rectangle rightBounds;
	public Rectangle upBounds;
	public Rectangle downBounds;
	public Texture texture;

	public GameScreen screen;

	public Entity(GameScreen screen) {
		this.screen = screen;

	}

	public void render(SpriteBatch sB, ShapeRenderer sR) {
		if (debug) {
			sR.begin(ShapeType.Line);
			sR.setColor(Color.BLUE);
			sR.rect(bounds.x, bounds.y, bounds.width, bounds.height);
			sR.setColor(Color.YELLOW);
			sR.end();
		}

		if (shouldDraw) {
			sB.begin();
			sB.enableBlending();
			sB.draw(texture, position.x, position.y, width, height);
			sB.end();
		}

	}

	public void update(float delta) {
	}

}
