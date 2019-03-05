import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {

	int speed = 5;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();
		y += speed;
		System.out.println(collisionBox.y);
		
		if (y >= 800 || x<=-50 || x>=600) {
			isAlive=false;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 50, 50);
	}
}
