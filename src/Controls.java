import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Controls extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	PacMan player;
	
	Controls(PacMan player){
		this.player = player;
	}
		
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (37 <= key && key <= 40) {
			player.direction = key;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
}


