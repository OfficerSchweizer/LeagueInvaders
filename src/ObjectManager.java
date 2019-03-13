import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class ObjectManager {

	int score = 0;
	long enemyTimer = System.currentTimeMillis();
	int enemySpawnTime = 1500;
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public ArrayList<Alien> aliens = new ArrayList<Alien>();

	ObjectManager(Rocketship rocket) {
		rocket = new Rocketship(250, 700, 50, 50);
	}

	int getScore() {
		return score;
	}

	void checkCollision() {

		for (Projectile projectile : projectiles) {
			for (Alien alien : aliens) {
				if (projectile.collisionBox.intersects(alien.collisionBox)) {
					alien.isAlive = false;
					projectile.isAlive = false;
					score++;
				}
			}
		}
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);

	}

	void addAlien(Alien alien) {
		aliens.add(alien);
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(aliens.get(i));
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(projectiles.get(i));
			}
		}
	}

	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien((new Random().nextInt(350) + 50), 0, 50, 50));
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

		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);

		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);

		}

	}

}
