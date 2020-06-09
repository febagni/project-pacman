
public class DeepSpace implements Map {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map clone() {
		SpritesManager.folder = "DeepSpace/";
		return new DeepSpace();
	}

}
