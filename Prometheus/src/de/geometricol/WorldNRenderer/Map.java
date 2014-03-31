package de.geometricol.WorldNRenderer;

import java.util.ArrayList;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
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
	public Pixmap pixmap;
	
	public Map(FileHandle file, Vector2 spawn, boolean debug){
		this.spawn = spawn;
		this.debug = debug;
		this.tiles = new ArrayList<Tile>();
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
	
	public void loadFromFile(FileHandle file){
		try{
		pixmap = new Pixmap(file);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int y = 0; y < pixmap.getWidth(); y++){
			for(int x = 0; x < pixmap.getHeight(); x++){
				If()
			}
		}
		
	}
	
}
