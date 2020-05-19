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
	protected int realX, realY;
	protected int lastDirection;
	
	public PacMan(){
		frame = 0;
		try {
			pacmanImage = ImageIO.read(new File("sprites/pacman.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.direction = KeyEvent.VK_LEFT;
		lastDirection = direction;
	}
	public void setRealX(int x) {realX = x;}
	public void setRealY(int y) {realY = y;}
	public int getRealX() {return realX;}
	public int getRealY() {return realY;}
	public int getX() {x = (realX+16)/32; return x;}
	public int getY() {y = (realY+16)/32; return y;}
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
		
		switch (direction) {
			case KeyEvent.VK_UP:
				if(realY - getY()*32 != 0 )
					break;
				if (map[getX()-1][getY()].getID() != MapID.Wall || realX - getX()*32 > 0) {
					realX -= step;
				}
				break;
			case KeyEvent.VK_DOWN:
				if(realY - getY()*32 != 0 )
					break;
				if (map[getX()+1][getY()].getID() != MapID.Wall || realX - getX()*32 < 0) {
					realX += step;
				}
				break;
			case KeyEvent.VK_LEFT:
				if(realX - getX()*32 != 0 )
					break;
				if (map[getX()][getY()-1].getID() != MapID.Wall || realY - getY()*32 > 0) {
					realY -= step;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(realX - getX()*32 != 0 )
					break;
				if (map[getX()][getY()+1].getID() != MapID.Wall || realY - getY()*32 < 0) {
					realY += step;
				}
				break;
		}
		lastDirection = direction;
	}

	public void tick() {
		movement();
	}

	public void render(Graphics graphic) {
		graphic.drawImage(pacmanImage.getSubimage((frame/(2*animationSlowness))*30, (direction - 37)*30, 28, 28)
				, realY, realX, null);
	}
}
