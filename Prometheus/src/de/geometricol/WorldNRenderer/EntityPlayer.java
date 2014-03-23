package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import de.geometricol.Handlers.AssetLoader;
import de.geometricol.Screens.GameScreen;
import de.geometricol.ui.UiHandler;

public class EntityPlayer extends Entity {

	public enum PlayerState {
		IDLE, WALKING_LEFT, WALKING_RIGHT, WALKING_UP, WALKING_DOWN
	}

	public PlayerState playerState;

	public EntityPlayer(GameScreen screen, GameWorld world) {
		super(screen);
		texture = AssetLoader.player;
		position = world.currentMap.spawn;
		width = 1.0f;
		height = 1.0f;
		bounds = new Rectangle(position.x, position.y, width / 16.0f * 13.0f,
				height / 16.0f * 15.0f);
		speed = 1;
		debug = true;
		shouldDraw = true;

		System.out.println(UiHandler.SIZING_FACTOR);
	}

	public void render(SpriteBatch sB, ShapeRenderer sR) {
		super.render(sB, sR);
	}

	public void update(float delta) {
		super.update(delta);
		playerState = PlayerState.IDLE;
		if (screen.inputHandler.keys[Input.Keys.LEFT] == true)
			playerState = PlayerState.WALKING_LEFT;
		if (screen.inputHandler.keys[Input.Keys.RIGHT] == true)
			playerState = PlayerState.WALKING_RIGHT;
		if (screen.inputHandler.keys[Input.Keys.UP] == true)
			playerState = PlayerState.WALKING_UP;
		if (screen.inputHandler.keys[Input.Keys.DOWN] == true)
			playerState = PlayerState.WALKING_DOWN;

		switch (playerState) {
		case IDLE:

			break;
		case WALKING_LEFT:
			position.x -= speed * delta;
			break;
		case WALKING_RIGHT:
			position.x += speed * delta;
			break;
		case WALKING_UP:
			position.y += speed * delta;
			break;
		case WALKING_DOWN:
			position.y -= speed * delta;
			break;
		}
		bounds.x = position.x;
		bounds.y = position.y;

	}

}
