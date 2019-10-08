import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip rs;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random r = new Random();
//YOU ARE ON 7 in the MODEL MANAGMENT!!!!!!!!!!!!!!!!!
	public ObjectManager(RocketShip rs) {

		this.rs = rs;
	}

	void addProjectile(Projectile p) {

		projectiles.add(p);

	}

	void addAlien() {
		aliens.add(new Alien(r.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
for(Alien a:aliens) {
	a.update();
	if(a.y<LeagueInvaders.HEIGHT) {
		a.isActive=false;
	}
}
for(Projectile p : projectiles) {
	p.update();
	if(p.y<LeagueInvaders.HEIGHT) {
		p.isActive=false;
	}
}
	}

	void draw(Graphics g) {
		
		rs.draw(g);
		for(Alien a:aliens) {
			a.draw(g);
		}
		for(Projectile p : projectiles) {
			p.draw(g);
		}
	}

}
