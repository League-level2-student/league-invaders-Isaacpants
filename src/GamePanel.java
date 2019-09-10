import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	Font titleFont;
	Font titleFont2;
	 final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	   
	    
	    
	    public GamePanel() {
	    	 titleFont = new Font("Arial", Font.PLAIN, 48);
	    	 titleFont2 = new Font("Arial", Font.PLAIN, 24);
		}
		void updateMenuState() {  }
	    void updateGameState() {  }
	    void updateEndState()  {  }
	    void drawMenuState(Graphics g) { 
	    	
	    	g.setColor(Color.BLUE);
	    g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
	    g.setFont(titleFont);
	    g.setColor(Color.YELLOW);
	    g.drawString("LEAGUE INVADERS", 10, 50);
	    g.setFont(titleFont2);
	    g.drawString("Press ENTER to Start",125, 350);
	    g.drawString("Press SPACE for Instructions",90, 550);

	    }
	    void drawGameState(Graphics g) {  }
	    void drawEndState(Graphics g)  {  
	    	
	      	g.setColor(Color.RED);
		    g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
		    g.setFont(titleFont);
		    g.setColor(Color.BLACK);
		    g.drawString("GAME OVER", 100, 150);
		    g.setFont(titleFont2);
		    g.drawString("You Killed "+ " "+" enemies",125, 350);
		    g.drawString("Press ENTER to Restart",115, 550);
	    	
	    }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawEndState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
			drawMenuState(g);
		}
	}
}
