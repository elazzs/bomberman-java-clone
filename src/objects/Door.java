package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

import bomberman.AssetSetter;

public class Door extends SuperObjects{
	
	public Door()
	{
		
		name="Door";
		
		try {
			image =ImageIO.read(getClass().getResourceAsStream("/objects/kapı.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
