
public class WildWest implements Skin {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Skin clone() {
		SpritesManager.folder = "WildWest/";
		return new WildWest();
	}

}
