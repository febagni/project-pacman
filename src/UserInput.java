import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class UserInput extends JPanel {

	private static final long serialVersionUID = 1L;
	PacMan player;
	
	public UserInput(PacMan player) {
		KeyListener listener = new Controls(player);
		
		//colocaremos aqui mais controles diferentes
		
		addKeyListener(listener);
		setFocusable(true);
		this.player = player;
	}


}