package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import bomberman.Keys;
import bomberman.Mypanel;

public class Bomb extends Entity{
	
	Mypanel mp;
	Keys key;
	long time;
	
	public int mapx,mapy; 
	int tileNum1,tileNum2,tileNum3,tileNum4;
	int range=1;
	
	BufferedImage bimage = null;
	
public Bomb(Mypanel mp, Keys key) {
		super(mp);
		this.mp = mp;
		this.key = key;
		
		
		
		
		getBombImage();
	
	}
	

public void getBombImage() {
	
	
	
	try {
		
		bomb1= ImageIO.read(getClass().getResourceAsStream("/objects/dbomb1.png"));
		bomb2= ImageIO.read(getClass().getResourceAsStream("/objects/dbomb2.png"));
		bomb3= ImageIO.read(getClass().getResourceAsStream("/objects/dbomb3.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public void update() {
	if(key.bombPressed == true) {
		bombOn=true;
		
		int x= mp.player.mapx/48;
		int xkalan=mp.player.mapx%48;
		int y= mp.player.mapy/48;
		int ykalan=mp.player.mapy%48;
		if(xkalan<=24) {
			mp.bomb.mapx=x*48;
		}
		else {
			mp.bomb.mapx=(x+1)*48;
		}
		
		if(ykalan<=24) {
			mp.bomb.mapy=y*48;
		}
		else {
			mp.bomb.mapy=(y+1)*48;
		}
		
		
		
	}
	
	if(bombOn == true) {
		
	
		
		
		spriteCounter++;
		if(spriteCounter>8) {
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
		
		explosion();
		
	}
}

public void explosion() {
	if(key.bombPressed == true) {
		
		time= System.currentTimeMillis();
		key.canbomb = false;
		
	}
	
	long lastTime= System.currentTimeMillis();
	long gecen =lastTime-time; 
	int col=mp.bomb.mapx/mp.tilesize;
	int row=mp.bomb.mapy/mp.tilesize;
	int[] monstercol= new int[10];
	int[] monsterrow= new int[10];
	for(int i=0;i< mp.monster.length;i++) {
		if(mp.monster[i] != null) {
			monstercol[i]=mp.monster[i].mapx/mp.tilesize;
			monsterrow[i]=mp.monster[i].mapx/mp.tilesize;
		}
	}
	
	
	
	if(gecen>3000) {
		
		
		if(mp.tileM.mapTileNum[col+1][row]==2) {
			mp.tileM.mapTileNum[col+1][row]=3;
		}
		if(mp.tileM.mapTileNum[col-1][row]==2) {
			mp.tileM.mapTileNum[col-1][row]=3;
		}
		if(mp.tileM.mapTileNum[col][row+1]==2) {
			mp.tileM.mapTileNum[col][row+1]=3;
		}
		if(mp.tileM.mapTileNum[col][row-1]==2) {
			mp.tileM.mapTileNum[col][row-1]=3;
		}
		
		for(int i=0;i< mp.monster.length;i++) {
			if(mp.monster[i] != null) {
				monstercol[i]=mp.monster[i].mapx/mp.tilesize;
				monsterrow[i]=mp.monster[i].mapx/mp.tilesize;
				
				if(col+1 ==monstercol[i] &&row==monsterrow[i]) {
					mp.monster[i]=null;
				}
				if(col-1 ==monstercol[i] &&row==monsterrow[i]) {
					mp.monster[i]=null;
				}
				if(col ==monstercol[i] &&row+1==monsterrow[i]) {
					mp.monster[i]=null;
				}
				if(col ==monstercol[i] &&row-1==monsterrow[i]) {
					mp.monster[i]=null;
				}
			}
		}
		
		
		
	
	}
	
}


	
public void draw(Graphics2D g2) {
	
	
	if(key.bombPressed == true) {
		
		time= System.currentTimeMillis();
		key.canbomb = false;
		
	}
	
	long lastTime= System.currentTimeMillis();
	long gecen =lastTime-time;
	
		
	
	if(bombOn==true && gecen<3000) {
		
		if(spriteNum==1) {
			bimage =bomb1;
		}
		if(spriteNum==2) {
			bimage =bomb2;
		}
		if(spriteNum==3) {
			bimage =bomb3;
		}
		
		int screenx = mapx - mp.player.mapx + mp.player.screenX;
		if(mapx>screenx ) {
			g2.drawImage(bimage, screenx, mapy, mp.tilesize,mp.tilesize, null);
		}
		
		else {
			g2.drawImage(bimage, mapx, mapy, mp.tilesize,mp.tilesize, null);
		}
		
		
		
		
		
	}
	if(gecen>3000) {
//		tileNum1 =mp.tileM.mapTileNum[bombkonumx+mp.tilesize][bombkonumy];
//		
//		if(tileNum1==0 ||tileNum1==2) {
//			
//			g2.drawImage(bimage, bombkonumx+mp.tilesize, bombkonumy, mp.tilesize, mp.tilesize, null);
//		}
		
		
		bombOn=false;
		key.canbomb=true;
	}
	
	}
	

}

