package de.geometricol.Prometheus;

import com.badlogic.gdx.Game;

import de.geometricol.Handlers.AssetLoader;
import de.geometricol.Screens.GameScreen;


public class PrometheusGame extends Game {

	
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
