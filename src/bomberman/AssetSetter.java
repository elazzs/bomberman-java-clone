package bomberman;

import java.util.Random;

import entity.Ballom;
import objects.Door;
import objects.FireUp;
import objects.SuperObjects;

public class AssetSetter {
	
	Mypanel mp;
	
	public AssetSetter(Mypanel mp) {
		this.mp=mp;
		
	
	}
	
	public void setObjects() {
		Random rand = new Random();
		int x=0,y=0;
		
		mp.obj[0]= new Door();
		while(true) {
			
			x=rand.nextInt(33);
			y=rand.nextInt(13);
			
			mp.obj[0].mapx=x*mp.tilesize;
			mp.obj[0].mapy=y*mp.tilesize;
			
			if(mp.tileM.mapTileNum[x][y]==2) {
				System.out.println("Kapı konum: "+"x: "+x+" y: "+y);
				break;
			}
		}
		
		
	
		mp.obj[1]= new FireUp();
		while(true) {
			int a=0,b=0;
			a=rand.nextInt(33);
			b=rand.nextInt(13);
			
			mp.obj[1].mapx=a*mp.tilesize;
			mp.obj[1].mapy=b*mp.tilesize;
			
			if(mp.tileM.mapTileNum[a][b]==2 && (a!=x && b!=y)) {
				System.out.println("Fire up konum: "+"x: "+a+" y: "+b);
				break;
			}
			
		}
		
	
		
	}
	
	public void setMonster() {
		
		
		
				
		Random rand = new Random();
		int x=0,y=0;
		for(int i=0;i<6;i++) {
			
		
		mp.monster[i]= new Ballom(mp);
		while(true) {
			
			x=rand.nextInt(33);
			y=rand.nextInt(13);
			
			mp.monster[i].mapx=x*mp.tilesize;
			mp.monster[i].mapy=y*mp.tilesize;
			
			if(mp.tileM.mapTileNum[x][y]==0) {
				
				break;
			}
					
		}
		}

	

	}
}
