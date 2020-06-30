/*
 * @file Controls.java
 * 
 * @brief Implements methods to receive controls via keyboard
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Controls extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	private Game game;											//This object has a game that receives its controls
	private PacMan player;										//This object act direct with a player
	private SpriteFactory spriteFactory = new SpriteFactory();	//This object has a spritefactory to change the game's look and feel
	
	Controls(Game game){
		this.game = game;
		this.player = game.player;
	}
	
	void setPlayer(PacMan player) {this.player = player;}
	
	/*
	 * @brief Pega o input do teclado e traduz para a direcao do player
	 * 
	 * @param e Evento do teclado 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (37 <= key && key <= 40) {	//Arrow keys
			player.direction = key;
		}
		if (key == KeyEvent.VK_1) { //Sets to the classic look
			setLookAndFeel("Classic");
		}
		if (key == KeyEvent.VK_2) { //Sets to the DeepSpace look
			setLookAndFeel("DeepSpace");
		}
		if (key == KeyEvent.VK_3) { //Sets to the WildWest look
			setLookAndFeel("WildWest");
		}
		if (key == KeyEvent.VK_4) {  //Sets to the UnderTheSea look
			setLookAndFeel("UnderTheSea");
		}
		if (key == KeyEvent.VK_5) { //Sets to the CovidMarket look
			setLookAndFeel("CovidMarket");
		}
		if (key == KeyEvent.VK_P) { //Pause game
			if(!game.gotAllPoints()) {
				game.pause();
			}
		}
		if (key == KeyEvent.VK_N) { //Next Level
			if(game.gotAllPoints() && game.isPaused()) {
				game.nextLevel();
				setPlayer(game.player);
				game.setPause(false);
				game.setRestart(false);
			}
		}
		if (key == KeyEvent.VK_M) { //Next Level
			game.mute();
		}
		if (key == KeyEvent.VK_Z) {
			game.easterEgg();
		}
		if (key == KeyEvent.VK_R) { //Reset Game
			if(game.gotAllPoints() || game.isPaused()) {
				game.reset();
				setPlayer(game.player);
				game.setPause(false);
				game.setRestart(false);
			}
		}
		if (key == KeyEvent.VK_E) { //Exit game
			if(game.gotAllPoints() || game.isPaused()) {
				System.exit(-1);
			}
		}
	}

	/*
	 * @brief Sets the look and feel, updating sprites and audio
	 */
	void setLookAndFeel(String lookName) {
		spriteFactory.create(lookName);
		game.setSkin();
		game.updateAudio();
	}
	
	//Non untilized interface methods
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}	
}


