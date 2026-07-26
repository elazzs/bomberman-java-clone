package bomberman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.security.PublicKey;

import javax.imageio.ImageTranscoder;
import javax.swing.JPanel;

import entity.Ballom;
import entity.Bomb;
import entity.Entity;
import entity.Player;
import objects.SuperObjects;
import tile.TileManager;

public class Mypanel extends JPanel implements Runnable{
	
	final int originaltilesize=16;
	final int scale =3;
	public final int tilesize= originaltilesize*scale;
	public final int maxscreencolumn= 16;
	public final int maxscreenrow= 13;
	public final int screenwidth= tilesize * maxscreencolumn;
	public final int screenheight = tilesize* maxscreenrow;
	
	
	//map size
	public final int maxMapCol = 33;
	public final int maxMapRow = 13;
	public final int mapWidth= tilesize * maxMapCol;
	public final int mapHeight= tilesize * maxMapRow;
	
	
	int FPS=60;
	
	public TileManager tileM = new TileManager(this);
	Keys key = new Keys();
	Thread gameThread;
	public CollisionCheck coCheck = new CollisionCheck(this); 
	AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this,key);
	public Bomb bomb = new Bomb(this, key);
	public SuperObjects[] obj= new SuperObjects[10];
	public Entity[] monster= new Entity[20];
	
	
	public Mypanel() {
		
		this.setPreferredSize(new Dimension(screenwidth,screenheight));
		this.setBackground(new Color(31,139,0));
		this.setDoubleBuffered(true);
		
		this.addKeyListener(key);
		this.setFocusable(true);
		
	}
	
	public void setUpGame() {

		aSetter.setObjects();
		aSetter.setMonster();
	}
	
	public void startGameThread() {
		
		gameThread= new Thread(this);
		gameThread.start();
	}

//	@Override
//	public void run() {
//		
//		double draw= 1000000000/FPS;
//		double nextDrawTime= System.nanoTime()+ draw;
//		
//		while(gameThread!=null) {
//			
//			update();
//			
//			repaint();
//			
//			
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime = remainingTime/1000000;
//				
//				if(remainingTime<0) {
//					remainingTime =0;
//				}
//				
//				Thread.sleep((long) remainingTime);
//				
//				nextDrawTime += draw;
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
//			
//		}
//		
//		
//	}
	
	
	
	public void run(){
		
		double drawInterval=1000000000/FPS;
		double delta =0;
		long lastTime= System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/ drawInterval;
			
			lastTime = currentTime;
			if(delta>=1) {
				update();
				repaint();
				delta--;
			}
		}
	}
	
	public void update() {
		
		player.update();
		bomb.update();
		
		for(int i=0;i< monster.length;i++) {
			if(monster[i] != null) {
				monster[i].update();
			}
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2= (Graphics2D)g;
		
		
		for(int i=0; i<obj.length;i++) {
			if(obj[i] !=null) {
				obj[i].draw(g2, this);
			}
			
		}
		tileM.draw(g2);
		bomb.draw(g2);
		
		for(int i=0;i< monster.length;i++) {
			if(monster[i] != null) {
				monster[i].draw(g2);
			}
		}
		
		player.draw(g2);
		
		g2.dispose();
		
	}

	
	
}
