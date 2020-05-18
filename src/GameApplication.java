

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameApplication {

	public static void start(final PacMan pacMan) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame(pacMan.getTitle());
				frame.setSize(pacMan.getWidth(), pacMan.getHeight());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GameCanvas canvas = new GameCanvas();
				canvas.setGame(pacMan);
				frame.add(canvas);
				frame.setVisible(true);
				canvas.requestFocus();
				new GameLoop(pacMan, canvas).start();
			}
		});
	}
}
