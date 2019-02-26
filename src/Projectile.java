import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	int speed = 10;

	Projectile(int x, int y, int width, int height) {
		super(x+20, y, width, height);

	}

	void update() {
		super.update();
		y -= speed;
		if (y <= 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}

}
