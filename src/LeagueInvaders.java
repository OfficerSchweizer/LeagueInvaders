import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	final int WIDTH = 500;
	final int HEIGHT = 800;
	JFrame frame;
	GamePanel gamePanel;

	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}

	void setup() {

		frame.add(gamePanel);
		frame.addKeyListener(gamePanel);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

		gamePanel.startGame();

	}

	public static void main(String[] args) {
		LeagueInvaders leagueInvaders = new LeagueInvaders();
		leagueInvaders.setup();
	}

}
