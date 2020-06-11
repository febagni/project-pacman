
public class CovidMarket implements Skin {

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Skin clone() {
		SpritesManager.folder = "CovidMarket/";
		return new CovidMarket();
	}
}
