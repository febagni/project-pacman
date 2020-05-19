import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Window extends Canvas {
	
	private Point lastPoint;
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
		frame.setResizable(false);
		UserInput controls = new UserInput(game.player);
		frame.add(controls);
		setFocusable(false);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		lastPoint = frame.getLocationOnScreen();
	}
	
	public boolean panelMoved() {
		boolean moved = false;
		if (lastPoint == frame.getLocationOnScreen()) {
			moved = true;
		}
		return moved;
	}
}
