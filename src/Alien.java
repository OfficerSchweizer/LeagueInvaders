import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {

//	Random random3 = new Random();
//	int direction = random3.nextInt(2);
	Random random2 = new Random();
	int movePattern = random2.nextInt(3);
	Random random = new Random();
	int ySpeed = random.nextInt(4) + 3;
	int xSpeed = 5;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {

		super.update();

		y += (ySpeed / 2);

		if (movePattern == 0) {
			y += ySpeed;
		}

		if (movePattern == 1) {

			x += xSpeed;

			
			if (x > 450 || x < 0) {
				xSpeed = -xSpeed;
			}
		}

		if (movePattern == 2) {
			
			y += (ySpeed*3);

			

		}

		if (y >= 800) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
