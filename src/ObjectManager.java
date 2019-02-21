import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	ObjectManager(Rocketship rocket) {
		rocket = new Rocketship(250, 700, 50, 50);
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
		System.out.println("shoot");
		System.out.println(projectile.x);
	}

	void update(String direction) {
		rocket.update(direction);

		for (int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update();
			System.out.println(i);
			System.out.println(projectiles.get(i));
		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (Projectile projectile : projectiles) {
			projectile.draw(g);
		}
	}

}
