package de.geometricol.Prometheus;

import com.badlogic.gdx.Game;

import de.geometricol.Handlers.AssetLoader;
import de.geometricol.Screens.GameScreen;


public class PrometheusGame extends Game {
	
	//TODO Font drawing
	//TODO Input on Android
	//TODO Map-loading from file
	//TODO Player Animation
	//TODO Improve ScreenButton Hit detection
	//TODO improve Stone Tile Bounds

	
	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();		
	}
	
	
	
	
}
