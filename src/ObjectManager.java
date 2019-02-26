import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class ObjectManager {

	long enemyTimer = 0;
	int enemySpawnTime = 5000;
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	ObjectManager(Rocketship rocket) {
		rocket = new Rocketship(250, 700, 50, 50);
	}

	void checkCollision() {
		for (Alien alien : aliens) {
			if (rocket.collisionBox.intersects(alien.collisionBox)) {
				rocket.isAlive = false;
			}
		}
		
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
		System.out.println("shoot");

	}

	void addAlien(Alien alien) {
		aliens.add(alien);
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isAlive = false) {
				aliens.remove(aliens.get(i));
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isAlive = false) {
				projectiles.remove(projectiles.get(i));
			}
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(600), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void update() {

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();

			if (projectiles.get(i).y <= 0) {
				projectiles.remove(projectiles.get(i));
			}
		}

		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			System.out.println("alien updating");
		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
			System.out.println("drew");
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

	}

}
