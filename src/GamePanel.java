import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	Font titleFont;
	Font subtitleFont;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(rocket);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
		timer = new Timer((1000 / 60), this);
		titleFont = new Font("Arial", Font.BOLD, 36);
		subtitleFont = new Font("Arial", Font.PLAIN, 24);
	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.update(" ");
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 800);
		objectManager.draw(g);

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

		if (e.getKeyCode() == e.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}

		if (e.getKeyCode() == e.VK_SPACE) {	
			objectManager.addProjectile(new Projectile(rocket.x, rocket.y, 10, 10));
		}

		if (e.getKeyCode() == e.VK_LEFT) {
			objectManager.update("left");
		}

		if (e.getKeyCode() == e.VK_RIGHT) {
			objectManager.update("right");
		}

		if (e.getKeyCode() == e.VK_UP) {
			objectManager.update("up");
		}

		if (e.getKeyCode() == e.VK_DOWN) {
			objectManager.update("down");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
