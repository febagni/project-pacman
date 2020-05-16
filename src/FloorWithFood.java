import java.awt.Color;
import java.awt.Graphics;

public class FloorWithFood extends MapObject {

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
		FloorWithFood floorWithFood = new FloorWithFood();
		floorWithFood.setX(x);
		floorWithFood.setY(y);
		floorWithFood.setID(MapID.FloorWithFood);
		return floorWithFood;
	}
	
	public void render(Graphics graphic) {
		graphic.setColor(Color.white);
		graphic.fillRect(squareSize*x, squareSize*y, squareSize, squareSize);
	}

	@Override
	public void tick() {
		//In construction
	}
}
