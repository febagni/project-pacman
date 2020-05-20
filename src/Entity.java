import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity implements GameObject {
	
	protected int x;
	protected int y;
	protected MapID id;
	protected MapObject[][] map;
	protected int direction;
	protected int frame;
	protected BufferedImage sprite;
	protected final int animationSlowness = 3;
	protected int realX, realY;
	protected int speedX, speedY;
	
	public void setRealX(int x) {realX = x;}
	public void setRealY(int y) {realY = y;}
	public int getRealX() {return realX;}
	public int getRealY() {return realY;}
	public void setMap(MapObject[][] map) {this.map = map;}
	
	@Override
	public int getX() {x = (realX+16)/32; return x;}
	@Override
	public int getY() {y = (realY+16)/32; return y;}
	@Override
	public MapID getID() {return id;}
	@Override
	public void setX(int x) {this.x = x;}
	@Override
	public void setY(int y) {this.y = y;}
	@Override
	public void setID(MapID id) {this.id = id;}
	
	protected boolean canGo(String direction) {
		if (direction == "up") return (map[getX()-1][getY()].getID() != MapID.Wall || realX - getX()*32 > 0);
		else if (direction == "down") return (map[getX()+1][getY()].getID() != MapID.Wall || realX - getX()*32 < 0);
		else if (direction == "left") return (map[getX()][getY()-1].getID() != MapID.Wall || realY - getY()*32 > 0);
		else if (direction == "right") return (map[getX()][getY()+1].getID() != MapID.Wall || realY - getY()*32 < 0);
		else return false;
	}
	
	protected void goUp() {
		
	}
	
	@Override
	public abstract void tick();
	@Override
	public abstract void render(Graphics g);

}
