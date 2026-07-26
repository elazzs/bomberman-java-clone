package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.security.PublicKey;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;

import bomberman.Mypanel;

public class TileManager {

	Mypanel mp;
	public Tiles[] tiles;
	public int mapTileNum[][];

	
	public TileManager(Mypanel mp) {
		this.mp =mp;
		tiles = new Tiles[10];
		
		mapTileNum = new int[mp.maxMapCol][mp.maxMapRow];
		
		getTileImage();
		makeMap();
//		loadMap();
	}
	
	public void getTileImage() {
		
		
		try {
			
			tiles[0]= new Tiles();
			tiles[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/yesil.png"));
			
			
			tiles[1]= new Tiles();
			tiles[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tas.png"));
			tiles[1].collision=true;
			
			tiles[2]= new Tiles();
			tiles[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/duvar.png"));
			tiles[2].collision=true;
			
			tiles[3]= new Tiles();
			tiles[3].image=null;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void makeMap() {
		
	

		    mapTileNum = new int[mp.maxMapCol][mp.maxMapRow];

		    Random rand = new Random();
		    for (int j = 0; j < mp.maxMapCol; j++) {
		        for (int i = 0; i < mp.maxMapRow; i++) {
		            if (j == 0 || j == mp.maxMapCol - 1 || i == 0 || i == mp.maxMapRow - 1) {
		                mapTileNum[j][i] = 1;
		            } else {
		                mapTileNum[j][i] = 0;
		            }
		        }
		    }

		    for (int j = 1; j < mp.maxMapCol - 1; j++) {
		        for (int i = 1; i < mp.maxMapRow - 1; i++) {
		            if (j % 2 == 0 && i % 2 == 0) {
		                mapTileNum[j][i] = 1;
		            }
		        }
		    }

		    int wallPlaced = 0;
		    while (wallPlaced < 60) {
		        int y = rand.nextInt(mp.maxMapCol - 2) + 1;
		        int x = rand.nextInt(mp.maxMapRow - 2) + 1;
		        if (mapTileNum[y][x] == 0) {
		            mapTileNum[y][x] = 2;
		            wallPlaced++;
		        }
		        
		        mapTileNum[1][1] = 0;
		        mapTileNum[1][2] = 0;
		        mapTileNum[2][1] = 0;
		        
		    }
		

	      
//	        
//	        try {
//	        	
//	        	 BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\elifs\\OneDrive\\Desktop\\map99.txt"));
//	        	
//	            for (int i = 0; i < mp.maxMapRow; i++) {
//	                for (int j = 0; j < mp.maxMapCol; j++) {
//	                    writer.write(mapTileNum[j][i] + " ");
//	                }
//	                writer.newLine();
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
	    
	        
	        
		
		
	}
	
//	public void loadMap() {
//		
//		try {
//			
//			InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
//			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//			
//			
//			
//			int col = 0;
//			int row = 0;
//			
//			while(col<mp.maxMapCol && row<mp.maxMapRow) {
//				
//				String line = reader.readLine();
//				
//				while(col<mp.maxMapCol) {
//					String numbers[] = line.split(" ");
//					
//					int num =Integer.parseInt(numbers[col]);
//					
//					mapTileNum[col][row]= num;
//					col++;
//				}
//				
// 			if(col==mp.maxMapCol) {
//					col=0;
//					row++;
//					
//				}
//				
//				
//			}
//			
//			reader.close();
//		} catch (Exception e) {
//		
//		}
//		
//		
//	}
	public void draw(Graphics2D g2) {
		
		int mapCol = 0;
		int mapRow = 0;
		
		while(mapCol<mp.maxMapCol && mapRow <mp.maxMapRow) {
			
			int tileNum= mapTileNum[mapCol][mapRow];
			
			int mapx= mapCol*mp.tilesize;
			int mapy= mapRow*mp.tilesize;
			
			int screenx = mapx - mp.player.mapx + mp.player.screenX;
			if(mapx>screenx ) {
				g2.drawImage(tiles[tileNum].image, screenx, mapy, mp.tilesize,mp.tilesize, null);
			}
			
			else {
				g2.drawImage(tiles[tileNum].image, mapx, mapy, mp.tilesize,mp.tilesize, null);
			}
			
			mapCol++;
			 
			if(mapCol == mp.maxMapCol) {
				mapCol=0;
				mapRow++;
				
			}
			
		}
		
	}
	
	
}
