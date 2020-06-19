/*
 * @file Controls.java
 * 
 * @brief Implementa métodos para lidar com o controle do pacman no teclado
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
	
	private Game game;
	private PacMan player;
	private SpriteFactory spriteFactory = new SpriteFactory();
	
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
		if (37 <= key && key <= 40) {	//se key for uma das teclas das setas do teclado
			player.direction = key;
		}
		if (key == KeyEvent.VK_1) {
			spriteFactory.create("Classic");
			game.setSkin();
		}
		if (key == KeyEvent.VK_2) {
			spriteFactory.create("DeepSpace");
			game.setSkin();
		}
		if (key == KeyEvent.VK_3) {
			spriteFactory.create("WildWest");
			game.setSkin();
		}
		if (key == KeyEvent.VK_4) {
			spriteFactory.create("UnderTheSea");
			game.setSkin();
		}
		if (key == KeyEvent.VK_5) {
			spriteFactory.create("CovidMarket");
			game.setSkin();
		}
		if (key == KeyEvent.VK_P) {
			if(!game.gotAllPoints()) {
				game.paused = !game.paused;	
			}
		}
		if (key == KeyEvent.VK_N) { //Next Level
			if(game.gotAllPoints() && game.paused) {
				game.nextLevel();
				setPlayer(game.player);
				game.paused = false;
			}
		}
		if (key == KeyEvent.VK_R) { //Reset Game
			if(game.gotAllPoints() && game.paused) {
				game.reset();
				setPlayer(game.player);
				game.paused = false;
			}
		}
	}
	
	//metodos da interface nao utillizadas 
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}	
}


