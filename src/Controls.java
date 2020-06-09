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
 * @date 05/2020
 * 
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Controls extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	PacMan player;
	GameObject go;
	SpriteFactory spriteFactory = new SpriteFactory();
	
	Controls(PacMan player){
		this.player = player;
	}
	
	/*
	 * @brief Pega o input do teclado e traduz para a direcao do player
	 * 
	 * @param	e	Evento do teclado 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (37 <= key && key <= 40) {	//se key for uma das teclas das setas do teclado
			player.direction = key;
		}
		if (key == KeyEvent.VK_1) {
			spriteFactory.create("Classic");
		
			System.out.print("1, what a classic");
		}
		if (key == KeyEvent.VK_2) {
			spriteFactory.create("DeepSpace");
			System.out.print("2, i need some space");
		}
		if (key == KeyEvent.VK_3) {
			spriteFactory.create("WildWest");
			System.out.print("3, yeehaa parnter");
		}
	}
	
	//metodos da interface ainda nao utillizadas 
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}	
}


