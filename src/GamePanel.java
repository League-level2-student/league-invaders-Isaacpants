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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Font titleFont;
	Font titleFont2;
	Font scoreTitle;
	public static int projectileNum = 0;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	public static BufferedImage image;

	RocketShip rs = new RocketShip(250, 700, 50, 50);
	Timer frameDraw;
	Timer alienSpawn;
	ObjectManager om = new ObjectManager(rs);

	JLabel jl = new JLabel();

	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titleFont2 = new Font("Arial", Font.PLAIN, 24);
		scoreTitle = new Font("Arial", Font.PLAIN, 25);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	void startGame() {

//			    if(om.score >= 2) {
//			    	alienSpawn = new Timer(1000 , om);
//				    alienSpawn.start();	
//				    
//			    }
//			    else {
		alienSpawn = new Timer(1000, om);
		alienSpawn.start();

		// }
	}

	void updateMenuState() {
	}

	void updateGameState() {
		rs.update();
		om.update();
		
		if(om.getLives()<=0) {
			currentState = END;
		}
		if (om.getScore() % 10 == 0) {
			int num = om.score * 10;
			if (num < 1000) {
				alienSpawn.setDelay(1000 - (om.score * 10));
			}

		}
		if (rs.isActive == false) {
			currentState = END;
		}

	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 10, 50);
		g.setFont(titleFont2);
		g.drawString("Press ENTER to Start", 125, 350);
		g.drawString("Press SPACE for Instructions", 90, 550);

	}

	void drawGameState(Graphics g) {
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);

		g.setFont(scoreTitle);
		g.setColor(Color.WHITE);
		g.drawString("score = " + om.getScore(), 0, 750);
		g.setFont(scoreTitle);
		g.setColor(Color.WHITE);
		g.drawString("lives = " + om.getLives(), 350, 750);
		om.draw(g);
	}

	void drawEndState(Graphics g) {

		g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 150);
		g.setFont(titleFont2);
		g.drawString("You Killed " + om.getScore() + " enemies", 125, 350);
		g.drawString("Press ENTER to Restart", 115, 550);

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
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
		
		if (e.getKeyCode() == KeyEvent.VK_0) {
		System.out.println("works");
		projectileNum = 0;
		}
	if (e.getKeyCode() == KeyEvent.VK_1) {
	System.out.println("works");
	projectileNum=1;
	}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println(currentState);
			if (currentState == END) {
				rs = new RocketShip(250, 700, 50, 50);
				om = new ObjectManager(rs);
			}
			if (currentState == END) {
				currentState = MENU;
				alienSpawn.stop();
			} else if (currentState == END) {

			} else {
				currentState++;
				startGame();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rs.UP = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			rs.DOWN = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.LEFT = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.RIGHT = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME) {
			om.addProjectile(rs.getProjectile());
			om.addProjectile(rs.getProjectile());
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rs.UP = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			rs.DOWN = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.LEFT = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.RIGHT = false;

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		repaint();
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();

		} else if (currentState == END) {
			updateEndState();
		}
	}
}
