import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{ 
	Font titleFont;
	Font titleFont2;
	 final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	    public static BufferedImage image;
	  
	   RocketShip rs = new RocketShip(250,700,50,50);
	   Timer frameDraw;
	    ObjectManager om = new ObjectManager(rs);
	    
	    public GamePanel() {
	    	 titleFont = new Font("Arial", Font.PLAIN, 48);
	    	 titleFont2 = new Font("Arial", Font.PLAIN, 24);
	    	   frameDraw = new Timer(1000/60,this);
	    	    frameDraw.start();
		}
		void updateMenuState() {  }
	    void updateGameState() { 
	    	
	    	om.update();
	    	
	    }
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
	    	  try {
				image = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	    
	    	  g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
	    	  om.draw(g);
	    }
	    void drawEndState(Graphics g)  {  
	    	g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
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
		}
		    if (e.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			    if(rs.y>=14) {
			    rs.up();
			    }
			}if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    System.out.println("Down");
			    if(rs.y<725) {
				    rs.down();
				    }
			}if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    System.out.println("left");
			    if(rs.x>20) {
				    rs.left();
				    }
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			    System.out.println("right");
			    if(rs.x<450) {
				    rs.right();
				    }
			}
		}



	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		  //  System.out.println(currentState);
		 //   if (currentState == END) {
		   //     currentState = MENU;
		  //  } else {
		  //      currentState++;
		   // }
	//	}   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    if(rs.y>=14) {
		    rs.up();
		    }
		}if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("Down");
		    if(rs.y<725) {
			    rs.down();
			    }
		}if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("left");
		    if(rs.x>20) {
			    rs.left();
			    }
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("right");
		    if(rs.x<450) {
			    rs.right();
			    }
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
