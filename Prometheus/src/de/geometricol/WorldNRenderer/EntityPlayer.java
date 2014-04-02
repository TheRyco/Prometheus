package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import de.geometricol.Handlers.AssetLoader;
import de.geometricol.Screens.GameScreen;
import de.geometricol.ui.UiHandler;

public class EntityPlayer extends Entity {

	public enum PlayerState {
		IDLE, WALKING_LEFT, WALKING_RIGHT, WALKING_UP, WALKING_DOWN
	}

	public PlayerState playerState;

	GameScreen screen;
	GameWorld world;

	public Rectangle leftInter, rightInter, upInter, downInter;

	public EntityPlayer(GameScreen screen, GameWorld world) {
		super(screen);
		this.screen = screen;
		this.world = world;
		texture = AssetLoader.player;
		position = world.currentMap.spawn;
		width = 1.0f;
		height = 1.0f;
		bounds = new Rectangle(position.x, position.y, width / 16.0f * 13.0f, height / 16.0f * 15.0f);
		leftBounds = new Rectangle(position.x - 0.1f, position.y, 0.1f, height / 16.0f * 15.0f);
		rightBounds = new Rectangle(position.x + (width / 16.0f * 13.0f), position.y, 0.1f, height / 16.0f * 15.0f);
		upBounds = new Rectangle(position.x, position.y + height, width / 16.0f * 15.0f, 0.1f);
		downBounds = new Rectangle(position.x, position.y - 0.1f, width / 16.0f * 15.0f, 0.1f);

		leftInter = new Rectangle();
		rightInter = new Rectangle();
		upInter = new Rectangle();
		downInter = new Rectangle();

		speed = 4;
		shouldDraw = true;

	}

	public void render(SpriteBatch sB, ShapeRenderer sR) {
		super.render(sB, sR);

		if (!debug) return;
		sR.begin(ShapeType.Line);
		sR.setColor(Color.YELLOW);
		sR.rect(leftBounds.x, leftBounds.y, leftBounds.width, leftBounds.height);
		sR.rect(rightBounds.x, rightBounds.y, rightBounds.width, rightBounds.height);
		sR.rect(upBounds.x, upBounds.y, upBounds.width / 16.0f * 13.0f, upBounds.height);
		sR.rect(downBounds.x, downBounds.y, downBounds.width / 16.0f * 13.0f, downBounds.height);

		if (leftInter != null) sR.rect(leftInter.x, leftInter.y, leftInter.width, leftInter.height);
		if (rightInter != null) sR.rect(rightInter.x, rightInter.y, rightInter.width, rightInter.height);
		if (upInter != null) sR.rect(upInter.x, upInter.y, upInter.width, upInter.height);
		if (downInter != null) sR.rect(downInter.x, downInter.y, downInter.width, downInter.height);
		sR.end();
	}

	public void update(float delta) {
		super.update(delta);
		playerState = PlayerState.IDLE;

		if (screen.inputHandler.keys[Input.Keys.LEFT] || UiHandler.leftButton.isClicked) playerState = PlayerState.WALKING_LEFT;
		if (screen.inputHandler.keys[Input.Keys.RIGHT] || UiHandler.rightButton.isClicked) playerState = PlayerState.WALKING_RIGHT;
		if (screen.inputHandler.keys[Input.Keys.UP] || UiHandler.upButton.isClicked) playerState = PlayerState.WALKING_UP;
		if (screen.inputHandler.keys[Input.Keys.DOWN] || UiHandler.downButton.isClicked) playerState = PlayerState.WALKING_DOWN;

		switch (playerState) {
		case IDLE:

			break;
		case WALKING_LEFT:
			if (!collides(0)) position.x -= speed * delta;
			break;
		case WALKING_RIGHT:
			if (!collides(1)) position.x += speed * delta;
			break;
		case WALKING_UP:
			if (!collides(2)) position.y += speed * delta;
			break;
		case WALKING_DOWN:
			if (!collides(3)) position.y -= speed * delta;
			break;
		}
		bounds.x = position.x;
		bounds.y = position.y;
		leftBounds.x = position.x - 0.1f;
		leftBounds.y = position.y;
		rightBounds.x = position.x + (width / 16.0f * 13.0f);
		rightBounds.y = position.y;
		upBounds.x = position.x;
		upBounds.y = position.y + (height / 16.0f * 15.0f);
		downBounds.x = position.x;
		downBounds.y = position.y - 0.1f;

		//System.out.println(collides(0) + "|" + collides(1) + "|" + collides(2) + "|" + collides(3));

	}

	public boolean collides(int dir) {

		// FIXME Collision detection on right side

		if (dir == 0) {
			for (Tile tile : world.currentMap.tiles) {
				if (tile.collidable) {
					if (Intersector.intersectRectangles(leftBounds, tile.bounds, leftInter)) {
						return true;
					} else leftInter = new Rectangle();
				}
			}
		} else if (dir == 1) {
			for (Tile tile : world.currentMap.tiles) {
				if (tile.collidable) {
					if (Intersector.intersectRectangles(rightBounds, tile.bounds, rightInter)) {
						return true;
					} else rightInter = new Rectangle();
				}
			}
		} else if (dir == 2) {
			for (Tile tile : world.currentMap.tiles) {
				if (tile.collidable) {
					if (Intersector.intersectRectangles(upBounds, tile.bounds, upInter)) {
						return true;
					} else upInter = new Rectangle();
				}
			}
		} else if (dir == 3) {
			for (Tile tile : world.currentMap.tiles) {
				if (tile.collidable) {
					if (Intersector.intersectRectangles(downBounds, tile.bounds, downInter)) {
						return true;
					} else downInter = new Rectangle();
				}
			}
		}

		return false;
	}
}
