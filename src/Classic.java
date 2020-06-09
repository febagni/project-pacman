
public class Classic implements Skin {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Skin clone() {
		SpritesManager.folder = "Classic/";
		return new Classic();
	}

}
