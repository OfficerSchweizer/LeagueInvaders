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
	GamePanel gamePanel;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
		timer = new Timer((1000 / 60), this);
		gamePanel = new GamePanel();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 36);
	}

	void startGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		rocket.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("LEAGUE INVADERS", 400, 100);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to start", 400, 400);
		g.drawString("Press SPACE for instructions", 400, 600);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		rocket.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		}

		if (currentState == GAME_STATE) {
			drawMenuState(g);
		}

		if (currentState == END_STATE) {
			drawMenuState(g);
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

		if (e.getKeyCode() == e.VK_LEFT) {
			rocket.update("left");
			
		}
		
		if (e.getKeyCode() == e.VK_RIGHT) {
			rocket.update("right");
		}
		
		if (e.getKeyCode() == e.VK_UP) {
			rocket.update("up");
		}
		
		if (e.getKeyCode() == e.VK_DOWN) {
			rocket.update("down");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
