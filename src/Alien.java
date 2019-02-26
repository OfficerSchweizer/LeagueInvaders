import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	int speed = 2;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();
		y += speed;
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 50, 50);
	}
}
