import java.awt.Graphics;

public class Floor extends MapObject {

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
		Floor floor = new Floor();
		floor.setX(x);
		floor.setY(y);
		floor.setID(MapID.Floor);
		return floor;
	}

	@Override
	public void tick() {
		//In construction
	}

	@Override
	public void render(Graphics graphic) {
//		graphic.setColor(Color.gray);
//		graphic.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
		ImageImporter image = new ImageImporter("sprites/PacManFloor.png");
		image.paintComponent(graphic, x*squareSize, y*squareSize);
	}
}
