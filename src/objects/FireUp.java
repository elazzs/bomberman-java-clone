package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class FireUp extends SuperObjects{
	
	public FireUp()
	{
		
		name="Fire Up";
		
		try {
			image =ImageIO.read(getClass().getResourceAsStream("/objects/fire_up.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
