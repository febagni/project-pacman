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
	protected int xLength, yLength;
	
	public void setRealX(int x) {realX = x;}
	public void setRealY(int y) {realY = y;}
	public int getRealX() {return realX;}
	public int getRealY() {return realY;}
	public void setMap(MapObject[][] map) {
		this.map = map;
		xLength = map.length;
		yLength = map[0].length;
	}
	
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
		if (direction == "up") {
			if (isOnEdge()) {
				return (map[yLength-1][getY()].getID() != MapID.Wall || realX - getX()*32 > 0);
			}
			return (map[getX()-1][getY()].getID() != MapID.Wall || realX - getX()*32 > 0);
		}
		else if (direction == "down") {
			if (isOnEdge()) {
				return (map[0][getY()].getID() != MapID.Wall || realX - getX()*32 < 0);
			}
			return (map[getX()+1][getY()].getID() != MapID.Wall || realX - getX()*32 < 0);
		}
		else if (direction == "left"){
			if (isOnEdge()) {
				return (map[getX()][xLength -1].getID() != MapID.Wall || realY - getY()*32 > 0);
			}
			return (map[getX()][getY()-1].getID() != MapID.Wall || realY - getY()*32 > 0);
		}
		else if (direction == "right") {
			if (isOnEdge()) {
				return (map[getX()][0].getID() != MapID.Wall || realY - getY()*32 < 0);
			}
			return (map[getX()][getY()+1].getID() != MapID.Wall || realY - getY()*32 < 0);
		}
		else return false;
	}
	
	protected boolean isOnEdge() {
		if (speedX != 0) {	//está no eixo x
			if (getX() == yLength -1 || getX() == 0) {
				return true;
			} 
			return false;
		} else if (speedY != 0 ){
			if (getY() == xLength -1 || getY() == 0) {
				return true;
			} 
			return false;
		}
		return false;
		
	}
	
	
	protected void goUp() {
		
	}
	
	@Override
	public abstract void tick();
	@Override
	public abstract void render(Graphics g);

}
