package bomberman;

import java.awt.MenuComponent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.PublicKey;

public class Keys implements KeyListener {

	public boolean upPressed,downPressed,leftPressed,rightPressed,bombPressed;
	public boolean canbomb=true;
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			upPressed=true;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed=true;
			
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed=true;
			
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed=true;
			
		}
		if(canbomb==true) {
			
		
		if(code == KeyEvent.VK_Z) {
			bombPressed=true;
			
			
		}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			upPressed=false;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed=false;
			
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed=false;
			
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed=false;
			
		}
		if(code == KeyEvent.VK_Z) {
			bombPressed=false;
			
			
		}
		
	}

}
