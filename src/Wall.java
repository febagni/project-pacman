
public class Wall extends MapObject {

	Wall(int x, int y, MapID id) {
		super(x, y, id);
	}

	@Override
	public MapID getID() {
		return id;
	}

	@Override
	public void setID(MapID id) {
		this.id = id;
		
	}

	
}
