package de.geometricol.WorldNRenderer;

import de.geometricol.Screens.GameScreen;

public class GameWorld {
	public GameScreen screen;
	public Map currentMap;
	
	public EntityPlayer player;

	public GameWorld(GameScreen screen) {
		this.screen = screen;
		currentMap = new MapTest();
		player = new EntityPlayer(screen, this);
		
	}

	public void update(float delta) {
		player.update(delta);
		
	}

}
