import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	RocketShip rs;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random r = new Random();
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
	}void purgeObjects(){
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isActive==false) {
				aliens.remove(i);
				
			}	
			
		}for (int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isActive==false) {
				projectiles.remove(i);
				
			}
		
	}

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
		System.out.println("hi");
	}
}