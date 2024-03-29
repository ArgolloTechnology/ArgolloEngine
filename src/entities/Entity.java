package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import components.Component;
import main.Main;
import world.World;

public class Entity {
	public float x, y;
	public List<Component> components = new ArrayList<>();
	public BufferedImage sprite;
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
		Main.entities.add(this);
	}
	public void Update() {
		if (components != null) {
			for (var c : components) {
				c.Update();
			} 
		}
	}
	public void SetPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void Render(Graphics g){
		g.setColor(Color.white);
		if(sprite != null)g.drawImage(sprite, (int)x, (int)y,(int)(sprite.getWidth()),(int)(sprite.getHeight()), null);
		else g.fillRect((int)x, (int)y, World.TILE_SIZE, World.TILE_SIZE);
		if (components != null) {
			for (var c : components) {
				c.Render(g);
			} 
		}	
	}
}
