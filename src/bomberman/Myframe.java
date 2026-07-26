package bomberman;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Myframe extends JFrame {
	
	public Myframe() {
		
		ImageIcon logo= new ImageIcon("download.jpeg");
		
		this.setIconImage(logo.getImage());
		this.getContentPane().setBackground(Color.black);
		
		this.setSize(500,500);
		this.setTitle("Bomberman");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		

}
}
