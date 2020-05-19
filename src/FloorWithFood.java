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
		graphic.setColor(Color.gray);
		graphic.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
		if(this.id == MapID.FloorWithFood) {
			graphic.setColor(Color.white);
			graphic.fillRect(squareSize*x+8, squareSize*y+8, squareSize-16, squareSize-16);
		}
		
//		ImageImporter image;
//		if(this.id == MapID.FloorWithFood)
//			image= new ImageImporter("PacManFloorWithFood.png");
//		else
//			image = new ImageImporter("PacManFloor.png");
//		image.paintComponent(graphic, x*squareSize, y*squareSize);
	
	}

	@Override
	public void tick() {
		//In construction
	}
}
