package de.geometricol.WorldNRenderer;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Map {
	
	public ArrayList<Tile> tiles;
	public int widthInTiles;
	public int heightInTiles;
	public boolean debug = false;
	public Vector2 spawn;
	
	public Map(Texture spriteSheet){
		
	}
	
	public Map(){
		this.tiles = new ArrayList<Tile>();
	}
	
	public void render(SpriteBatch sB, ShapeRenderer sR){  
		sB.begin();
		for(Tile tile : tiles){
			tile.render(sB);
		}
		sB.end();
		if(debug){
			sR.begin(ShapeType.Line);
			for(Tile tile : tiles){
				tile.renderBounds(sR, Color.RED);
			}
			sR.end();
		}
		
	}
	
}
