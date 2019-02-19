import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	void update(String direction) {
		if (direction.equals("left")) {
			x -= speed;
		}

		if (direction.equals("right")) {
			x += speed;
		}

		if (direction.equals("up")) {
			y -= speed;
		}

		if (direction.equals("down")) {
			y += speed;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}
