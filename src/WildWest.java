
public class WildWest implements Map {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map clone() {
		SpritesManager.folder = "WildWest/";
		return new WildWest();
	}

}
