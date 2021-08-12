import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RocketShip extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	boolean UP = false;
	boolean RIGHT = false;
	boolean LEFT = false;
	boolean DOWN = false;

	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
			loadImage("rocket.png");
		}

	}

	void update() {
		super.update();
		if (UP) {
			up();

		}
		if (RIGHT) {
			right();
		}
		if (LEFT) {
			left();
		}
		if (DOWN) {
			down();
		}
	}

	void draw(Graphics g) {
		// g.setColor(Color.BLUE);
		// g.fillRect(x, y, width, height);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public void right() {

		if (x < 450) {
			x += speed;
		}
	}

	public void up() {

		if (y >= 14) {
			y -= speed;
		}
	}

	public void down() {

		if (y < 725) {
			y += speed;
		}
	}

	public void left() {

		if (x > 20) {
			x -= speed;
		}
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public Projectile getProjectile() {
		if (ObjectManager.score >= 100) {
			if (GamePanel.projectileNum == 0) {
				return new Projectile(x + width / 2, y, 20, 20);
			} else {
				return new Projectile(x + width / 2, y, 10, 10);
			}
		}
		return new Projectile(x + width / 2, y, 10, 10);
	}

}