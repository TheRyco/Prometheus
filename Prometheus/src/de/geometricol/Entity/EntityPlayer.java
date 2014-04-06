package de.geometricol.Entity;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import de.geometricol.Handlers.AssetLoader;
import de.geometricol.Screens.GameScreen;
import de.geometricol.WorldNRenderer.GameWorld;
import de.geometricol.WorldNRenderer.Tile;
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

		sR.setColor(Color.BLACK);
		sR.rect(leftInter.x, leftInter.y, leftInter.width, leftInter.height);
		sR.rect(rightInter.x, rightInter.y, rightInter.width, rightInter.height);
		sR.rect(upInter.x, upInter.y, upInter.width, upInter.height);
		sR.rect(downInter.x, downInter.y, downInter.width, downInter.height);

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
			if (!collidesLeft()) {
				position.x -= speed * delta;

			}
			break;
		case WALKING_RIGHT:
			if (!collidesRight()) {
				position.x += speed * delta;

			}
			break;
		case WALKING_UP:
			if (!collidesUp()) {
				position.y += speed * delta;

			}
			break;
		case WALKING_DOWN:
			if (!collidesDown()) {
				position.y -= speed * delta;

			}
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

	}

	public boolean collidesLeft() {

		

		return false;
	}

	public boolean collidesRight() {

		

		return false;
	}

	public boolean collidesUp() {

		

		return false;
	}

	public boolean collidesDown() {

		

		return false;
	}

}
