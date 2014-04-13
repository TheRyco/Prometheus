package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.Gdx;

import de.geometricol.Entity.EntityPlayer;
import de.geometricol.Map.Map;
import de.geometricol.Screens.GameScreen;

public class GameWorld {
	public GameScreen screen;
	public Map currentMap, mapDemo;

	public EntityPlayer player;

	public boolean debug = false;
	
	public GameWorld(GameScreen screen) {
		this.screen = screen;

		mapDemo = new Map(Gdx.files.internal("data/MapDemo.png"), debug);

		currentMap = mapDemo;
		player = new EntityPlayer(screen, this, debug);

	}

	public void update(float delta) {
		player.update(delta);

	}

}
