package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import bomberman.Mypanel;

public class Entity {

	Mypanel mp;
	public int mapx,mapy,xkonum,ykonum;
	public int speed;
	
	public BufferedImage up1,up2,up3,left1,left2,left3,right1,right2,right3,down1,down2,down3,die1,die2,die3,die4,die5,die6;
	public BufferedImage[] diee=new BufferedImage[6];
	
	public String direction;
	public BufferedImage bomb1,bomb2,bomb3;
	public boolean bombOn=false;
	public boolean die=false;
	public String name;
	public static int actionLockCounter =0;
	public boolean collision;
	public boolean dieOn=false;
	
	
	public int spriteCounter=0;
	public int spriteNum=1;
	
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX,solidAreaDefaultY;
	public boolean collisionOn=false;
	
	public Entity(Mypanel mp) {
		this.mp=mp;
		
	}
	
	public void update() {
		for(int i=0;i<6;i++) {
			mp.monster[i]= new Ballom(mp); 
			mp.monster[i].update();
		}
	
	}
	
	public void draw(Graphics2D g2) {
		for(int i=0;i<6;i++) {
			mp.monster[i]= new Ballom(mp);
			mp.monster[i].draw(g2);
		}
		
	}
}
