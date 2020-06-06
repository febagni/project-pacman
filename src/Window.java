/*
 * @file Window.java
 * 
 * @brief Janela
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends Canvas {
	
	private JFrame frame;

	private static final long serialVersionUID = 1L;
	
	public Window(int width, int height, String title, Game game) {
		frame = new JFrame(title);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setPreferredSize(new Dimension(width, height)); 
		frame.pack();
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		UserInput controls = new UserInput(game.player,game.screen); //Define os controles do jogo
		frame.add(controls);
		setFocusable(false);
		if(game.screen == ScreenID.GAME) {
			frame.add(game);
		}else if(game.screen == ScreenID.MENU) {
			JPanel myPanel = new JPanel();
			JButton buttonGame = new JButton("Jogo");
			myPanel.add(buttonGame);
			JButton buttonCredits = new JButton("Créditos");
			myPanel.add(buttonCredits);
			myPanel.setBackground(Color.BLACK);
			frame.add(myPanel);
		}
		frame.setVisible(true);
		game.start();
	}
}
