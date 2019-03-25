import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;
	boolean movingRight;
	boolean movingLeft;
	boolean movingUp;
	boolean movingDown;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	void update(String direction) {
		
		super.update();

		if (direction.equals("left")) {
			movingLeft = true;
		}

		if (direction.equals("right")) {
			movingRight = true;
		}

		if (direction.equals("up")) {
			movingUp = true;
		}

		if (direction.equals("down")) {
			movingDown = true;
		}

		if (direction.equals("stopLeft")) {
			movingLeft = false;
		}

		if (direction.equals("stopRight")) {
			movingRight = false;
		}

		if (direction.equals("stopUp")) {
			movingUp = false;
		}

		if (direction.equals("stopDown")) {
			movingDown = false;
		}
	}

	void update() {
		
		if (movingLeft) {
			x -= speed;
		}
		if (movingRight) {
			x += speed;
		}
		if (movingUp) {
			y -= speed;
		}
		if (movingDown) {
			y += speed;
		}
		
		
		if (x < 0) {
			x = 0;
		}
		if (x > 450) {
			x = 450;
		}
		if (y > 750) {
			y = 750;
		}
		if (y < 0) {
			y = 0;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}

}
