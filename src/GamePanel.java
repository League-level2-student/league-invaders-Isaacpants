import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{ 
	Font titleFont;
	Font titleFont2;
	 final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	   Timer frameDraw;
	    
	    
	    public GamePanel() {
	    	 titleFont = new Font("Arial", Font.PLAIN, 48);
	    	 titleFont2 = new Font("Arial", Font.PLAIN, 24);
	    	   frameDraw = new Timer(1000/60,this);
	    	    frameDraw.start();
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
	    void drawGameState(Graphics g) {
	    	g.setColor(Color.BLACK);
	    g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	    }
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
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
			 drawEndState(g);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    System.out.println(currentState);
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("Down");
		}if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("left");
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("right");
		}



	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("action");
		repaint();
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	}
}
