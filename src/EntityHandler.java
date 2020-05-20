import java.awt.Graphics;
import java.util.ArrayList;

public class EntityHandler {
	
	ArrayList<Ghost> ghosts;
	PacMan player;
	
	EntityHandler(ArrayList<Ghost> ghosts, PacMan player) {
		this.ghosts = ghosts;
		this.player = player;
	}
	
	public void tick() {
		for(Ghost ghost : ghosts) {
			ghost.tick();
		}
		player.tick();
	}
	
	public void render(Graphics graphics) {
		for(Ghost ghost : ghosts) {
			ghost.render(graphics);
		}
		player.render(graphics);
	}
}
