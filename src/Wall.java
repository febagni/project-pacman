
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends MapObject {
	
	public Wall() {
		try {
			sprite = ImageIO.read(new File("sprites/PacManWall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	MapObject cloneMapObject(int x, int y) {
		Wall wall = new Wall();
		wall.setX(x);
		wall.setY(y);
		wall.setID(MapID.Wall);
		return wall;
	}
	
	@Override
	public void tick() {
		//In construction
	}
}
