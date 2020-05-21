import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ghost extends Entity {
	
	public Ghost (int realX, int realY) {
		this.realX = realX;
		this.realY = realY;
		try {
			sprite = ImageIO.read(new File("sprites/RedBlinky.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.direction = KeyEvent.VK_LEFT;
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics graphic) {
		graphic.drawImage(sprite.getSubimage((frame/(2*animationSlowness))*30, (direction - 37)*30, 28, 28)
				, realY+2, realX+2, null);
	}

}
