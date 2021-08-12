import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteRepo {
	public static BufferedImage bullet1;
	public static BufferedImage bullet2;

	public void start() {
		if(GamePanel.projectileNum==0) {
		bullet1 = loadImage("bullet.png");
		}else if(GamePanel.projectileNum==1) {
		bullet2 = loadImage("upgrade.png");
		}
		
	}

	BufferedImage loadImage(String imageFile) {

		// if (needImage) {
		try {

			return ImageIO.read(this.getClass().getResourceAsStream(imageFile));

		} catch (Exception e) {
			return null;
		}

		// }
	}

}
