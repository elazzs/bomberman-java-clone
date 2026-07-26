package bomberman;


import java.awt.image.MultiPixelPackedSampleModel;
import java.nio.channels.NoConnectionPendingException;
import java.security.PublicKey;

import entity.Entity;

public class CollisionCheck {
	
	Mypanel mp;
	
	public CollisionCheck(Mypanel mp) {
		
		this.mp=mp;
	}
	public void checkTile(Entity entity) {
		
		int entityLeftMapx = entity.mapx + (entity.solidArea.x-1);
		int entityRightMapx = entity.mapx + (entity.solidArea.x-1) + (entity.solidArea.width-2);
		int entityTopMapy = entity.mapy + (entity.solidArea.y-1);
		int entityBottomMapy = entity.mapy + (entity.solidArea.y-1) + (entity.solidArea.height-2);
		
		
		int entityLeftCol = entityLeftMapx/mp.tilesize;
		int entityRightCol= entityRightMapx/mp.tilesize;
		int entityTopRow= entityTopMapy/mp.tilesize;
		int entityBottonRow= entityBottomMapy/mp.tilesize;
		
		
		
		int tileNum1,tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow= (entityTopMapy - entity.speed)/mp.tilesize;
			tileNum1= mp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2= mp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(mp.tileM.tiles[tileNum1].collision == true || mp.tileM.tiles[tileNum2].collision==true) {
				
				entity.collisionOn= true;
			}
			break;
		case "down":
			entityBottonRow= (entityBottomMapy - entity.speed)/mp.tilesize;
			tileNum1= mp.tileM.mapTileNum[entityLeftCol][entityBottonRow];
			tileNum2= mp.tileM.mapTileNum[entityRightCol][entityBottonRow];
			if(mp.tileM.tiles[tileNum1].collision == true || mp.tileM.tiles[tileNum2].collision==true) {
				
				entity.collisionOn= true;
			}
			break;	
		case "left":
			entityLeftCol= (entityLeftMapx - entity.speed)/mp.tilesize;
			tileNum1= mp.tileM.mapTileNum[entityLeftCol][entityBottonRow];
			tileNum2= mp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			if(mp.tileM.tiles[tileNum1].collision == true || mp.tileM.tiles[tileNum2].collision==true) {
				
				entity.collisionOn= true;
			}
			break;	
		case "right":
			entityRightCol= (entityRightMapx - entity.speed)/mp.tilesize;
			tileNum1= mp.tileM.mapTileNum[entityRightCol][entityBottonRow];
			tileNum2= mp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(mp.tileM.tiles[tileNum1].collision == true || mp.tileM.tiles[tileNum2].collision==true) {
				
				entity.collisionOn= true;
			}
			break;	
		}
			
	}
	public int checkObjects(Entity entity, boolean player ) {
		
		int index=999;
		
		for(int i=0;i<mp.obj.length;i++) {
			
			if(mp.obj[i] != null) {
				
				//oyuncunun pozisyonu
				entity.solidArea.x=entity.mapx + entity.solidArea.x;
				entity.solidArea.y=entity.mapy + entity.solidArea.y;
				
				//objenin pozisyonu
				mp.obj[i].solidArea.x=mp.obj[i].mapx +mp.obj[i].solidArea.x;
				mp.obj[i].solidArea.y=mp.obj[i].mapy +mp.obj[i].solidArea.y;
				
				switch (entity.direction) {
				case "up": 
					entity.solidArea.y-= entity.speed;
					if(entity.solidArea.intersects(mp.obj[i].solidArea)) {
						if(mp.obj[i].collision == true) {
							entity.collisionOn= true;
						}
						
						if(player == true) index=i;
					}
					break;
				case "down":
					entity.solidArea.y+= entity.speed;
					if(entity.solidArea.intersects(mp.obj[i].solidArea)) {
						if(mp.obj[i].collision == true) {
							entity.collisionOn= true;
						}
						
						if(player == true) index=i;
					}
					break;
				case "left":
					entity.solidArea.x-= entity.speed;
					if(entity.solidArea.intersects(mp.obj[i].solidArea)) {
						if(mp.obj[i].collision == true) {
							entity.collisionOn= true;
						}
						
						if(player == true) index=i;
					}
					break;
				case "right":
					entity.solidArea.y+= entity.speed;
					if(entity.solidArea.intersects(mp.obj[i].solidArea)) {
						if(mp.obj[i].collision == true) {
							entity.collisionOn= true;
						}
						
						if(player == true) index=i;
					}
					break;
				}
				entity.solidArea.x= entity.solidAreaDefaultX;
				entity.solidArea.y= entity.solidAreaDefaultY;
				mp.obj[i].solidArea.x=mp.obj[i].solidAreaDefaultX;
				mp.obj[i].solidArea.y=mp.obj[i].solidAreaDefaultY;
				
			}
			
		}
			
		
		return index;
	}
public int checkMonsters(Entity entity, boolean player ) {
		
		int index=999;
		
		for(int i=0;i<mp.monster.length;i++) {
			
			if(mp.monster[i] != null) {
				
				//oyuncunun pozisyonu
				entity.solidArea.x=entity.mapx + entity.solidArea.x;
				entity.solidArea.y=entity.mapy + entity.solidArea.y;
				
				//canavarın pozisyonu
				mp.monster[i].solidArea.x=mp.monster[i].mapx +mp.monster[i].solidArea.x;
				mp.monster[i].solidArea.y=mp.monster[i].mapy +mp.monster[i].solidArea.y;
				
				switch (entity.direction) {
				case "up": 
					entity.solidArea.y-= entity.speed;
					if(entity.solidArea.intersects(mp.monster[i].solidArea)) {
						if(mp.monster[i].collision == true) {
							entity.collisionOn= true;
						}
						
						if(player == true) index=i;
					}
					break;
				case "down":
					entity.solidArea.y+= entity.speed;
					if(entity.solidArea.intersects(mp.monster[i].solidArea)) {
						if(mp.monster[i].collision == true) {
							entity.collisionOn= true;
						}
						
						if(player == true) index=i;
					}
					break;
				case "left":
					entity.solidArea.x-= entity.speed;
					if(entity.solidArea.intersects(mp.monster[i].solidArea)) {
						if(mp.monster[i].collision == true) {
							entity.collisionOn= true;
						}
						
						if(player == true) index=i;
					}
					break;
				case "right":
					entity.solidArea.y+= entity.speed;
					if(entity.solidArea.intersects(mp.monster[i].solidArea)) {
						if(mp.monster[i].collision == true) {
							entity.collisionOn= true;
						}
						
						if(player == true) index=i;
					}
					break;
				} 
				entity.solidArea.x= entity.solidAreaDefaultX;
				entity.solidArea.y= entity.solidAreaDefaultY;
				mp.monster[i].solidArea.x=mp.monster[i].solidAreaDefaultX;
				mp.monster[i].solidArea.y=mp.monster[i].solidAreaDefaultY;
				
			}
			
		}
			
		
		return index;
	}
	
	
	

}
