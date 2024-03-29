import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements ActionListener {
	RocketShip rs;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random r = new Random();
	public static int score = 0;
	int lives = 50;

	public int getScore() {
		return score;
	}public int getLives() {
		return lives;
	}

	public ObjectManager(RocketShip rs) {

		this.rs = rs;
	}

	void addProjectile(Projectile p) {

		projectiles.add(p);

	}

	void addAlien() {
		aliens.add(new Alien(r.nextInt(LeagueInvaders.WIDTH - 50), 0, 50, 50));
	}

	void update() {

		for (Alien a : aliens) {
			a.update();
			if (a.y > LeagueInvaders.HEIGHT) {
				System.out.println(lives);
				lives-=1;
				a.isActive = false;
			}
		}
		for (Projectile p : projectiles) {
			p.update();
			if (p.y < 0) {
				p.isActive = false;
			}
		}
		
//	if(score>=2) {			
//		GamePanel.alienSpawn = new Timer(10000,this);
//		GamePanel.alienSpawn.start();
//		
//		}
		checkCollision();
		purgeObjects();
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (rs.collisionBox.intersects(a.collisionBox)) {
				rs.isActive = false;
				a.isActive = false;
				//System.out.println("HI");
			}
			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					p.isActive = false;
					a.isActive = false;
					score += 1;
				}
			}
		}
	}

	void draw(Graphics g) {

		rs.draw(g);
		for (Alien a : aliens) {
			a.draw(g);
		}
		for (Projectile p : projectiles) {
			p.draw(g);

		}
	}

	void purgeObjects() {
		for (int i = aliens.size() - 1; i >= 0; i--) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);

			}

		}
		for (int i = projectiles.size() - 1; i >= 0; i--) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);

			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();

	}
}
