import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage spaceImg;
	public static BufferedImage bulletImg;
	Timer timer;
	Font titleFont;
	Font subtitleFont;
	Font scoreFont;
	Rocketship rocket = new Rocketship(225, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(rocket);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
		timer = new Timer((1000 / 60), this);
		titleFont = new Font("Arial", Font.BOLD, 36);
		subtitleFont = new Font("Arial", Font.PLAIN, 24);

		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		rocket.update();
		objectManager.update();
		objectManager.purgeObjects();
		objectManager.manageEnemies();
		objectManager.checkCollision();
		for (Alien alien : objectManager.aliens) {
			if (alien.collisionBox.intersects(rocket.collisionBox)) {
				rocket.isAlive = false;
			}
		}

		if (!rocket.isAlive) {
			currentState = END_STATE;

		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 600, 800);
		g.setFont(titleFont);
		g.setColor(Color.yellow);
		g.drawString("LEAGUE INVADERS", 75, 100);
		g.setFont(subtitleFont);
		g.setColor(Color.white);
		g.drawString("Press ENTER to start", 130, 400);
		g.drawString("Press SPACE for instructions", 90, 600);

	}

	void drawGameState(Graphics g) {
		g.drawImage(GamePanel.spaceImg, 0, 0, 600, 800, null);
		rocket.draw(g);
		g.setFont(subtitleFont);
		g.setColor(Color.white);
		g.drawString("Score: " + objectManager.score, 0, 24);

		for (int i = 0; i < objectManager.projectiles.size(); i++) {
			objectManager.projectiles.get(i).draw(g);
		}

		for (int i = 0; i < objectManager.aliens.size(); i++) {
			objectManager.aliens.get(i).draw(g);
		}

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 600, 800);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString("GAME OVER", 130, 200);
		g.setFont(subtitleFont);
		g.setColor(Color.white);
		g.drawString("Press ENTER to restart", 120, 600);
	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		}

		if (currentState == GAME_STATE) {
			drawGameState(g);
		}

		if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

		if (currentState == MENU_STATE) {
			updateMenuState();
		}

		if (currentState == GAME_STATE) {
			updateGameState();
		}

		if (currentState == END_STATE) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END_STATE) {
				rocket = new Rocketship(225, 700, 50, 50);
				objectManager = new ObjectManager(rocket);
				System.out.println("asdf");
			}
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.update("left");
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.update("right");
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.update("up");
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.update("down");
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			objectManager.addProjectile(new Projectile(rocket.x, rocket.y, 10, 10));
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.update("stopLeft");
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.update("stopRight");
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.update("stopUp");
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.update("stopDown");
		}
	}

}
