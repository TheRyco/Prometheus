package de.geometricol.ui;

import de.geometricol.Handlers.AssetLoader;

public class TestButton extends ScreenButton{
	
	public String test = "12345";

	public TestButton(String title, int x, int y) {
	    super(title, x, y);
		textureRegion = AssetLoader.testButton;
		this.width = textureRegion.getRegionWidth();
		this.height = textureRegion.getRegionHeight();
	}

	public TestButton(String title, int x, int y, int width, int height) {
		super(title, x, y, width, height);
		textureRegion = AssetLoader.testButton;
	}
	
	

}
