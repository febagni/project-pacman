

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JComponent;


public class GameCanvas extends JComponent implements ComponentListener {

	private static final long serialVersionUID = 1L;
	private PacMan game;

	public GameCanvas() {
	}

    public GameCanvas(PacMan game) {
		this.game = game;
		addKeyListener(game);
		requestFocus();
		addComponentListener(this);
    }

	public void setGame(PacMan pacMan) {
		this.game = pacMan;
		addKeyListener(pacMan);
		requestFocus();
		addComponentListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		game.draw((Graphics2D)g);
	}

	@Override
	public void componentResized(ComponentEvent ce) {
		game.resize(ce.getComponent().getWidth(), ce.getComponent().getHeight());	
	}

	@Override
	public void componentMoved(ComponentEvent ce) {
		
	}

	@Override
	public void componentShown(ComponentEvent ce) {
		//game.resize(ce.getComponent().getWidth(), ce.getComponent().getHeight());
	}

	@Override
	public void componentHidden(ComponentEvent ce) {
		
	}

}
