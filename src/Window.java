import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

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
		UserInput controls = new UserInput(game.player);
		frame.add(controls);
		setFocusable(false);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}
