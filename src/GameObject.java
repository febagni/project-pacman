import java.awt.Graphics;

public interface GameObject {
	
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public MapID getID();
	public void setID(MapID id);
	public void tick();
	public void render(Graphics g);
	
}
