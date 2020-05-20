import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PacMan implements GameObject{

	protected int x;
	protected int y;
	protected int delX;
	protected int delY;
	protected MapID id;
	protected MapObject[][] map;
	protected int direction;
	protected int frame;
	protected BufferedImage pacmanImage;
	protected final int animationSlowness = 3;
	
	PacMan(){
		frame = 0;
		try {
			pacmanImage = ImageIO.read(new File("sprites/pacman.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.direction = KeyEvent.VK_LEFT;
	}

	public int getX() {return x;}
	public int getY() {return y;}
	public MapID getID() {return id;}

	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setID(MapID id) {this.id = id;}

	public void setMap(MapObject[][] map) {this.map = map;}
	
	void movement() {
		if (map[getX()][getY()].getID() == MapID.FloorWithFood) {
			map[getX()][getY()].setID(MapID.Floor); 
		}
		frame++;
		if (frame>5*animationSlowness) {
			frame = 0;
		}
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
		movement();
	}

	public void render(Graphics graphic) {
		graphic.drawImage(pacmanImage.getSubimage((frame/(2*animationSlowness))*30, (direction - 37)*30, 28, 28)
				, y*squareSize+delY+2, x*squareSize+delX+2, null);
//		graphic.setColor(Color.yellow);
//		graphic.fillRect(y, x, 32, 32);
//		graphic.fillRect(y*squareSize+delY+2, x*squareSize+delX+2, squareSize-4, squareSize-4);
	}
}
