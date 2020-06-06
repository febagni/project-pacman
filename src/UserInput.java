/*
 * @file UserInput.java
 * 
 * @brief Classe com utils para os inputs do teclado do player
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class UserInput extends JPanel {

	private static final long serialVersionUID = 1L;
	PacMan player;
	
	public UserInput(PacMan player, ScreenID screen) {
		KeyListener listener = new Controls(player, screen);
		addKeyListener(listener);
		setFocusable(true);
		this.player = player;
	}
}