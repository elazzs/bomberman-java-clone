package entity;

import java.awt.Desktop.Action;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import javax.imageio.ImageIO;

import bomberman.Mypanel;

public class Ballom extends Entity {

	public final int screenX;
	public String[] yon = {"up","down","left","right"};
	
	
	public Ballom(Mypanel mp) {
		super(mp);
		screenX = 0;
		name= "Ballom";
		Random random =new Random();
		direction=yon[random.nextInt(4)];
		speed=1;
		collision=true;
		solidArea.x=0;
		solidArea.y=0;
		solidArea.width = 48;
		solidArea.height = 48;
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		
		getImage();
		
	}
	
	public void getImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_right1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_right2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_right3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_left1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_left2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_left3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_left3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/ballom/balon_right3.png"));
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void setAction() {
	
		actionLockCounter++;
		
		
		Random random = new Random();
		
		
		
			int i=random.nextInt(4);
			if(collisionOn==false) {
				int a=random.nextInt(5000);
				if(a==1) {
					direction=yon[i];
				}
			}
			
			else if(!direction.equals(yon[i]) && collisionOn==true) {
				direction=yon[i];
				
			}
			
			
//			if(i<=25) {
//				direction = "up";
//			}
//			if(i>25 && i<=50) {
//				direction = "down";
//			}
//			if(i>50 && i<=75) {
//				direction = "left";
//			}
//			if(i>75 && i<=100) {
//				direction = "right";
//			}
//			
//			actionLockCounter=0;
			
		
		
		
	}
	 public void update() {
		 
		 collisionOn= false;
			mp.coCheck.checkTile(this);
			
			
			
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
					
					
					break;
				case "right":
					mapx += speed;
				
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
			
			setAction();

		}
	 
	 
	 public void draw(Graphics2D g2) {
		
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
			
			
			int screenx = mapx - mp.player.mapx + mp.player.screenX;

				
				if(mapx>screenx  ) {
					g2.drawImage(image, screenx, mapy, mp.tilesize, mp.tilesize, null);
					
				}
				else {
					g2.drawImage(image, mapx, mapy, mp.tilesize, mp.tilesize, null);
				}

	}
		
		 
		 
	 }
	
	


