import java.awt.Graphics;

public abstract class GameObjectDecorator implements GameObject {

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
	}

	@Override
	public MapID getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setID(MapID id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSpritePath(String spritePath) {
		// TODO Auto-generated method stub
	}

	@Override
	public GameObject clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSprite() {
		// TODO Auto-generated method stub
	}

}
