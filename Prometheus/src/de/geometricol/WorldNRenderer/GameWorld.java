package de.geometricol.WorldNRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import de.geometricol.Entity.EntityPlayer;
import de.geometricol.Handlers.InputHandler;
import de.geometricol.Map.Map;
import de.geometricol.Screens.GameScreen;

public class GameWorld {
	public GameScreen screen;
	public Map currentMap, mapDemo, mapLabyrinth;

	public EntityPlayer player;

	public boolean debug = false;
	
	public enum Maps{
		MapDemo, MapLabyrinth;
	}
	
	
	public GameWorld(GameScreen screen) {
		this.screen = screen;
		
		

		mapDemo = new Map(Gdx.files.internal("data/MapDemo.png"), debug);
		mapLabyrinth = new Map(Gdx.files.internal("data/MapLabyrinth.png"), debug);
		

		currentMap = mapDemo;
		player = new EntityPlayer(screen, this, debug);

	}

	public void update(float delta) {
		if(screen.inputHandler.keys[Keys.NUM_1]) changeMap(Maps.MapDemo);
		if(screen.inputHandler.keys[Keys.NUM_2]) changeMap(Maps.MapLabyrinth);
		
		player.update(delta);

	}
	
	public void changeMap(Maps map){
		
		switch (map){
		case MapDemo:
			currentMap = mapDemo;
			player.position = currentMap.spawn;
			break;
			
		case MapLabyrinth:
			currentMap = mapLabyrinth;
			player.position = currentMap.spawn;
			break;
		}
			
		
	}
	
	

}
