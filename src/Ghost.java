import java.awt.Color;
import java.awt.Graphics;

public class Ghost extends Entity {
	
	public Ghost (int realX, int realY) {
		this.realX = realX;
		this.realY = realY;
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics graphic) {
		graphic.setColor(Color.red);
		graphic.fillOval(realY, realX, squareSize, squareSize);
	}

}
