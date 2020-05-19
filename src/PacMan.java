import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class PacMan implements GameObject{

	protected int x;
	protected int y;
	protected int delX;
	protected int delY;
	protected MapID id;
	protected MapObject[][] map;
	protected int direction;
	protected int frame;
	
	PacMan(){
		this.direction = KeyEvent.VK_LEFT;
	}

	public int getX() {return x;}
	public int getY() {return y;}
//	public int getMapX() {return (x/32);}
//	public int getMapY() {return (y/32);}
	public MapID getID() {return id;}

	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setID(MapID id) {this.id = id;}

	public void setMap(MapObject[][] map) {this.map = map;}
	
	void moviment() {
		
//		if (map[getMapX()][getMapY()].getID() == MapID.FloorWithFood) {
//			map[getMapX()][getMapY()].setID(MapID.Floor); 
//		}
//		
////		//colocar o lance do frame depois
////		frame++;
////		if (frame>5) {
////			frame = 0;
////		}
//
//		if (this.direction == KeyEvent.VK_DOWN) {
//			if (map[getMapX()+1][getMapY()].getID() != MapID.Wall)
//				setX(getX() + 1);
//		}
//		if (this.direction == KeyEvent.VK_LEFT) {
//			if (map[getMapX()][getMapY()-1].getID() != MapID.Wall)
//				setY(getY() - 1);
//		}
//		if (direction == KeyEvent.VK_UP) {
//			if (map[getMapX()-1][getMapY()].getID() != MapID.Wall)
//				setX(getX() - 1);
//		}
//		if (direction == KeyEvent.VK_RIGHT) {
//			if (map[getMapX()][getMapY()+1].getID() != MapID.Wall)
//				setY(getY() + 1);
//		}
//		
		if (map[getX()][getY()].getID() == MapID.FloorWithFood) {
			map[getX()][getY()].setID(MapID.Floor); 
		}
		
//		//colocar o lance do frame depois
//		frame++;
//		if (frame>5) {
//			frame = 0;
//		}
		if (direction == KeyEvent.VK_UP) {
			if (map[getX()-1][getY()].getID() != MapID.Wall) {
				if (delX%squareSize == 0 && delX !=0) {
					setX(getX() -1);
					delX = 0;
				}
			delX -= step;
			delY=0;
			}
		}
		if (this.direction == KeyEvent.VK_DOWN) {
			if (map[getX()+1][getY()].getID() != MapID.Wall) {
				if (delX%squareSize == 0 && delX!=0) {
					setX(getX() + 1);
					delX = 0;
				}
			delX += step;
			delY=0;
			}
		}
		if (this.direction == KeyEvent.VK_LEFT) {
			if (map[getX()][getY()-1].getID() != MapID.Wall) {
				if (delY%squareSize == 0 && delY!=0) {
					setY(getY() - 1);
					delY = 0;
				}
			delY -= step;
			delX=0;
			}
			
		}
		
		if (direction == KeyEvent.VK_RIGHT) {
			if (map[getX()][getY()+1].getID() != MapID.Wall) {
				if (delY%squareSize == 0 && delY!=0) {
					setY(getY() +1);
					delY = 0;
				}
			delY += step;
			delX=0;
			}
		}	
	}

	public void tick() {
		moviment();
	}

	public void render(Graphics graphic) {
		
		//Colocar a animacao
		graphic.setColor(Color.yellow);
//		graphic.fillRect(y, x, 32, 32);
		graphic.fillRect(y*squareSize+delY+2, x*squareSize+delX+2, squareSize-4, squareSize-4);
	}
}
