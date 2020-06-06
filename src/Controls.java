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
	ScreenID screen;
	
	Controls(PacMan player, ScreenID screen){
		this.player = player;
		this.screen = screen;
	}
	
	/*
	 * @brief Pega o input do teclado e traduz para a direcao do player
	 * 
	 * @param	e	Evento do teclado 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(screen == ScreenID.GAME) {
			if (37 <= key && key <= 40) {	//se key for uma das teclas das setas do teclado
				player.direction = key;
			}
		}
	}
	
	//metodos da interface ainda nao utillizadas vai se fuder	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}	
}


