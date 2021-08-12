import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
JFrame jf;
GamePanel gp = new GamePanel();

public static final int HEIGHT =800; 
public static final int WIDTH =500;
public LeagueInvaders() {
	jf = new JFrame();
	
}public static void main(String[] args) {
	LeagueInvaders li = new LeagueInvaders();
	li.setup();
}
	public void setup() {
		jf.addKeyListener(gp);
		jf.add(gp);	
		jf.setSize(WIDTH, HEIGHT);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
