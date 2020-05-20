import java.awt.Color;
import java.awt.Graphics;

public class Wall extends MapObject {

	@Override
	public MapID getID() {
		return id;
	}

	@Override
	public void setID(MapID id) {
		this.id = id;
	}

	@Override
	MapObject cloneMapObject(int x, int y) {
		Wall wall = new Wall();
		wall.setX(x);
		wall.setY(y);
		wall.setID(MapID.Wall);
		return wall;
	}
	
	public void render(Graphics graphic) {
		
		
//		graphic.setColor(Color.black);
//		graphic.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
		ImageImporter image = new ImageImporter("PacManWall.png");
		image.paintComponent(graphic, x*squareSize, y*squareSize);
	}

	@Override
	public void tick() {
		//In construction
	}

	
}
