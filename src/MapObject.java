
public abstract class MapObject implements GameObject {
	private int x;
	private int y;
	
	MapObject(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
}
