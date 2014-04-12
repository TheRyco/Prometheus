package de.geometricol.Entity;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import de.geometricol.Handlers.AssetLoader;
import de.geometricol.Screens.GameScreen;
import de.geometricol.WorldNRenderer.GameWorld;
import de.geometricol.WorldNRenderer.Map;
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

	public Tile tUL, tUM, tUR, tLU, tLM, tLD, tDL, tDM, tDR, tRU, tRM, tRD;

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

		if ((tUL != null) && (tLU != null) && (tDL != null) && (tRU != null)) {
			sR.begin(ShapeType.Line);
			tUL.renderBounds(sR, Color.ORANGE);
			tUM.renderBounds(sR, Color.ORANGE);
			tUR.renderBounds(sR, Color.ORANGE);
			tLU.renderBounds(sR, Color.ORANGE);
			tLM.renderBounds(sR, Color.ORANGE);
			tLD.renderBounds(sR, Color.ORANGE);
			tDL.renderBounds(sR, Color.ORANGE);
			tDM.renderBounds(sR, Color.ORANGE);
			tDR.renderBounds(sR, Color.ORANGE);
			tRU.renderBounds(sR, Color.ORANGE);
			tRM.renderBounds(sR, Color.ORANGE);
			tRD.renderBounds(sR, Color.ORANGE);
			sR.end();
		}
	}

	public void update(float delta) {
		super.update(delta);
		playerState = PlayerState.IDLE;

		if (screen.inputHandler.keys[Input.Keys.LEFT] || screen.inputHandler.keys[Input.Keys.A] || UiHandler.leftButton.isClicked) playerState = PlayerState.WALKING_LEFT;
		if (screen.inputHandler.keys[Input.Keys.RIGHT] || screen.inputHandler.keys[Input.Keys.D] || UiHandler.rightButton.isClicked) playerState = PlayerState.WALKING_RIGHT;
		if (screen.inputHandler.keys[Input.Keys.UP] || screen.inputHandler.keys[Input.Keys.W] || UiHandler.upButton.isClicked) playerState = PlayerState.WALKING_UP;
		if (screen.inputHandler.keys[Input.Keys.DOWN] || screen.inputHandler.keys[Input.Keys.S] || UiHandler.downButton.isClicked) playerState = PlayerState.WALKING_DOWN;

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
		Map currentMap = world.currentMap;

		Vector2 lU, lM, lD;
		lU = new Vector2(Math.round(position.x) - 1, Math.round(position.y) + 1);
		lM = new Vector2(Math.round(position.x) - 1, Math.round(position.y));
		lD = new Vector2(Math.round(position.x) - 1, Math.round(position.y) - 1);

		tLU = currentMap.tiles.get((int) (lU.x + (lU.y * currentMap.widthInTiles)-1));
		tLM = currentMap.tiles.get((int) (lM.x + (lM.y * currentMap.widthInTiles)-1));
		tLD = currentMap.tiles.get((int) (lD.x + (lD.y * currentMap.widthInTiles)-1));

		if (tLU.collidable) {
			if (tLU.bounds.overlaps(bounds)) return true;
		}
		if (tLM.collidable) {
			if (tLM.bounds.overlaps(bounds)) return true;
		}
		if (tLD.collidable) {
			if (tLD.bounds.overlaps(bounds)) return true;
		}

		return false;
	}

	public boolean collidesRight() {
		Map currentMap = world.currentMap;

		Vector2 rU, rM, rD;
		rU = new Vector2(Math.round(position.x) + 1, Math.round(position.y) + 1);
		rM = new Vector2(Math.round(position.x) + 1, Math.round(position.y));
		rD = new Vector2(Math.round(position.x) + 1, Math.round(position.y) - 1);

		tRU = currentMap.tiles.get((int) (rU.x + rU.y * currentMap.widthInTiles)-1);
		tRM = currentMap.tiles.get((int) (rM.x + rM.y * currentMap.widthInTiles)-1);
		tRD = currentMap.tiles.get((int) (rD.x + rD.y * currentMap.widthInTiles)-1);

		if (tRU.collidable) {
			if (tRU.bounds.overlaps(bounds)) return true;
		}
		if (tRM.collidable) {
			if (tRM.bounds.overlaps(bounds)) return true;
		}
		if (tRD.collidable) {
			if (tRD.bounds.overlaps(bounds)) return true;
		}

		return false;
	}

	public boolean collidesUp() {
		Map currentMap = world.currentMap;

		Vector2 uL, uM, uR;
		uL = new Vector2(Math.round(position.x) - 1, Math.round(position.y) + 1);
		uM = new Vector2(Math.round(position.x), Math.round(position.y) + 1);
		uR = new Vector2(Math.round(position.x) + 1, Math.round(position.y) + 1);

		tUL = currentMap.tiles.get((int) (uL.x + uL.y * currentMap.widthInTiles)-1);
		tUM = currentMap.tiles.get((int) (uM.x + uM.y * currentMap.widthInTiles)-1);
		tUR = currentMap.tiles.get((int) (uR.x + uR.y * currentMap.widthInTiles)-1);

		if (tUL.collidable) {
			if (tUL.bounds.overlaps(bounds)) return true;
		}
		if (tUM.collidable) {
			if (tUM.bounds.overlaps(bounds)) return true;
		}
		if (tUR.collidable) {
			if (tUR.bounds.overlaps(bounds)) return true;
		}

		return false;
	}

	public boolean collidesDown() {
		Map currentMap = world.currentMap;

		Vector2 dL, dM, dR;
		dL = new Vector2(Math.round(position.x) - 1, Math.round(position.y) - 1);
		dM = new Vector2(Math.round(position.x), Math.round(position.y) - 1);
		dR = new Vector2(Math.round(position.x) + 1, Math.round(position.y) - 1);

		tDL = currentMap.tiles.get((int) (dL.x + dL.y * currentMap.widthInTiles)-1);
		tDM = currentMap.tiles.get((int) (dM.x + dM.y * currentMap.widthInTiles)-1);
		tDR = currentMap.tiles.get((int) (dR.x + dR.y * currentMap.widthInTiles)-1);

		if (tDL.collidable) {
			if (tDL.bounds.overlaps(bounds)) return true;
		}
		if (tDM.collidable) {
			if (tDM.bounds.overlaps(bounds)) return true;
		}
		if (tDR.collidable) {
			if (tDR.bounds.overlaps(bounds)) return true;
		}

		return false;
	}

}
