import java.awt.Graphics;

public abstract class PacManDecorator extends PacMan {

	PacMan player;
	
	PacManDecorator(PacMan player) {
		this.player = player;
	}
	
	@Override
	public GameObject clone() {
		return null;
	}

	@Override
	public void tick() {
		player.tick();
	}
	
	public void render(Graphics g) {
		player.render(g);
	}
}
