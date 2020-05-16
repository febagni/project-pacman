

public abstract class MapObject implements GameObject {
	
	static final int squareSize = 32;
	protected int x;
	protected int y;
	protected MapID id;
	
	abstract MapObject cloneMapObject(int x, int y);
	
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
}
