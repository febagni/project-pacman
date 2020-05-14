

public abstract class MapObject implements GameObject {
	protected int x;
	protected int y;
	char representation;
	protected MapID id;
	
	static final int squareSize = 32;
	
//	MapObject(int x, int y, MapID id){
//		this.x = x;
//		this.y = y;
//		this.id = id;
//		
//	}
	
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
