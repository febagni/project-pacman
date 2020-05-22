import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class MapObject implements GameObject {
	
	protected BufferedImage sprite;
	static final int squareSize = 32;
	protected int x;
	protected int y;
	protected MapID id;
	
	abstract MapObject cloneMapObject(int x, int y);
	
	@Override
	public MapID getID() {
		return id;
	}
	
	@Override
	public void setID(MapID id) {
		this.id = id;
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public void render(Graphics graphic) {
		graphic.drawImage(sprite,x*squareSize,y*squareSize,null);
	}
}
