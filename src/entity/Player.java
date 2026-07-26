package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import bomberman.Keys;
import bomberman.Mypanel;

public class Player extends Entity {
	
	
	Keys key;
	
	public final int screenX;

		

	
	
	
	public Player(Mypanel mp, Keys key) {
		
		super(mp);
		
		this.key = key;
		
		screenX =mp.screenwidth/2;
		die=true;
		solidArea =new Rectangle(16,20,24,20); //x,y,width,height
		
		
		
		
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		setDefaultValues();
		getPlayerImage();
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/up3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/Adsız.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/B2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/B3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));
			diee[0] = ImageIO.read(getClass().getResourceAsStream("/player/die1.png"));
			diee[1] = ImageIO.read(getClass().getResourceAsStream("/player/die2.png"));
			diee[2] = ImageIO.read(getClass().getResourceAsStream("/player/die3.png"));
			diee[3] = ImageIO.read(getClass().getResourceAsStream("/player/die4.png"));
			diee[4] = ImageIO.read(getClass().getResourceAsStream("/player/die5.png"));
			diee[5] = ImageIO.read(getClass().getResourceAsStream("/player/die6.png"));
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void setDefaultValues() {
		
		mapx= mp.tilesize*1;
		mapy= mp.tilesize*1;
		speed= 2 ;
		
		direction="down";
	}
	
	public void update() {
		
		if(key.upPressed == true ||key.downPressed == true || 
				key.leftPressed == true || key.rightPressed == true ) {
			

			if(key.upPressed == true) {
				direction="up";
				
				 
			}
			else if(key.downPressed == true) {
				direction="down";
				
				
			}
			else if(key.leftPressed == true) {
				direction="left";
				
				
			}
			else if(key.rightPressed == true) {
				direction="right";
				
				
			}
			
			
			collisionOn= false;
			mp.coCheck.checkTile(this);
			int objIndex=mp.coCheck.checkObjects(this, true);
			pickUpObject(objIndex);
			int monsterIndex=mp.coCheck.checkMonsters(this, true);
			die(monsterIndex);
			
			if(collisionOn==false) {
				
				switch(direction) {
				case "up":
					mapy -= speed;
					break;
				case "down":
					mapy += speed;
					break;
				
				case "left":
					mapx -= speed;
					
					if(mapx<screenX ) {
					xkonum=mapx;
					}
					break;
				case "right":
					mapx += speed;
					if(mapx<screenX ) {
						xkonum=mapx;
					
					}
					break;
				
				
				}
				
			}
			
			
			spriteCounter++;
			if(spriteCounter>4) {
				if(spriteNum==1) {
					spriteNum=2;
				}				
				else if(spriteNum==2) {
					spriteNum=3;
				}
				else if(spriteNum==3) {
					spriteNum=1;
				}
				
				
			spriteCounter=0;
			}
			
			
		}
		
		
	}
	
	public void pickUpObject(int i) {
		if(i!=999 && i!=0) {
			mp.obj[i] = null;
		}
	}
	public void die(int i) {
		if(i!=999 && i!=0) {
			dieOn=true;
		}
	}

	
	
	public void draw(Graphics2D g2) {
//		
//		g2.setColor(Color.blue);
//		g2.fillRect(x, y, mp.tilesize, mp.tilesize);
//		
		
		BufferedImage image = null;
		
		
		
		
		switch (direction) {
		case "up":
			if(spriteNum==1) {
				image =up1;
			}
			if(spriteNum==2) {
				image =up2;
			}
			if(spriteNum==3) {
				image =up3;
			}
			
			break;
		case "down": 
			if(spriteNum==1) {
				image =down1;
			}
			if(spriteNum==2) {
				image =down2;
			}
			if(spriteNum==3) {
				image =down3;
			}
			
			
			break;
		case "left": 
			if(spriteNum==1) {
				image =left1;
			}
			if(spriteNum==2) {
				image =left2;
			}
			if(spriteNum==3) {
				image =left3;
			}
			
			break;
		case "right": 
			if(spriteNum==1) {
				image =right1;
			}
			if(spriteNum==2) {
				image =right2;
			}
			if(spriteNum==3) {
				image =right3;
			}
			
			break;	
				
	
		}
		
		
		if(mapx>screenX ) {
			g2.drawImage(image, screenX, mapy, mp.tilesize, mp.tilesize, null);
			
		}
		else {
			g2.drawImage(image, mapx, mapy, mp.tilesize, mp.tilesize, null);
		}
		
		
		if(dieOn==true) {
			
			for(int j=0;j<6;j++) {
				
				if(spriteNum==1) {
					image =diee[1];
				}
				if(spriteNum==2) {
					image =diee[3];
				}
				if(spriteNum==3) {
					image =diee[5];
				}
				
				if(mapx>screenX ) { 
					g2.drawImage(image, screenX, mapy, mp.tilesize, mp.tilesize, null);
					
				}
				else {
					g2.drawImage(image, mapx, mapy, mp.tilesize, mp.tilesize, null);
				}
				
				}

			
		}
		
		
	}
}
