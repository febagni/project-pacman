
public class DeepSpace implements Skin {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Skin clone() {
		SpritesManager.folder = "DeepSpace/";
		return new DeepSpace();
	}

}
