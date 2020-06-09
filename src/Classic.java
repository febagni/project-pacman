
public class Classic implements Map {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map clone() {
		SpritesManager.folder = "Classic/";
		return new Classic();
	}

}
