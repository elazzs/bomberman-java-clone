package bomberman;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		Myframe window = new Myframe();
        Mypanel myPanel = new Mypanel();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.add(myPanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        myPanel.setUpGame();
        myPanel.startGameThread();
		
	}

}
