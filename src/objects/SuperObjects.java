package objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import bomberman.Mypanel;

public class SuperObjects {
	
	public BufferedImage image;
	public String name;
	public boolean collision=false;
	public int mapx,mapy;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	
	public int solidAreaDefaultX=0;
	public int solidAreaDefaultY=0;
	
	public void draw(Graphics2D g2,Mypanel mp) {
		
		int screenx = mapx - mp.player.mapx + mp.player.screenX;
		if(mapx>screenx ) {
			g2.drawImage(image, screenx, mapy, mp.tilesize,mp.tilesize, null);
		}
		
		else {
			g2.drawImage(image, mapx, mapy, mp.tilesize,mp.tilesize, null);
		}

		
	}

}
