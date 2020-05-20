import java.awt.Color;
import java.awt.Graphics;

public class FloorWithBoost extends MapObject {

	@Override
	public MapID getID() {
		return id;
	}

	@Override
	public void setID(MapID id) {
		this.id = id;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics graphic) {
		graphic.setColor(Color.black);
		graphic.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
		if(this.id == MapID.FloorWithBoost) {
			graphic.setColor(Color.yellow);
			graphic.fillOval(squareSize*x+10, squareSize*y+10, squareSize-20, squareSize-20);
		}
	}

	@Override
	MapObject cloneMapObject(int x, int y) {
		FloorWithBoost floorWithBoost = new FloorWithBoost();
		floorWithBoost.setX(x);
		floorWithBoost.setY(y);
		floorWithBoost.setID(MapID.FloorWithBoost);
		return floorWithBoost;
	}

}
