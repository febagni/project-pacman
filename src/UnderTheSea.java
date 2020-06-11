
public class UnderTheSea implements Skin {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Skin clone() {
		SpritesManager.folder = "UnderTheSea/";
		return new UnderTheSea();
	}
}
